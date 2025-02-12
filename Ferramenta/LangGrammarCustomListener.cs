
using System;
using System.Globalization;
using System.Collections.Generic;
using System.Linq;

public class LangGrammarCustomListener : LangGrammarBaseListener{

    private Dictionary<string, ReturnValue> _variables = new Dictionary<string, ReturnValue>();

    private bool _insideForLoop = false; // Controle do contexto do `for`
    private Dictionary<string, FunctionInfo> functions = new Dictionary<string, FunctionInfo>();
    private Stack<int> _returnStack = new Stack<int>();
    private ReturnValue _lastReturnValue = new ReturnValue { Type = "int", Value = 0 };

    private Dictionary<string, Dictionary<string, string>> _structs = new Dictionary<string, Dictionary<string, string>>();
    // Alterado para armazenar ReturnValue (em vez de object) para consistência
    private Dictionary<string, Dictionary<string, ReturnValue>> _structInstances = new Dictionary<string, Dictionary<string, ReturnValue>>();
    // Todos os arrays serão armazenados aqui; cada elemento é um ReturnValue
    private readonly Dictionary<string, List<ReturnValue>> _arrays = new Dictionary<string, List<ReturnValue>>();

    // Definições de unions: a mesma estrutura que usamos para structs.
    private Dictionary<string, Dictionary<string, string>> _unions = new Dictionary<string, Dictionary<string, string>>();
    // Instâncias de unions: armazena cada variável instanciada de union.
    private Dictionary<string, Dictionary<string, ReturnValue>> _unionInstances = new Dictionary<string, Dictionary<string, ReturnValue>>();
    // Armazena o tipo (nome) da union associada a uma instância, para verificação semântica.
    private Dictionary<string, string> _unionInstanceTypes = new Dictionary<string, string>();

    private Dictionary<string, ReturnValue> _simpleVars = new Dictionary<string, ReturnValue>();

    private readonly List<string> includes = new();
    private Dictionary<string, object> defines = new Dictionary<string, object>();
    private Dictionary<string, string> members = new Dictionary<string, string>();


    class FunctionInfo{
        public string ReturnType { get; set; } = string.Empty;
        public string Name { get; set; } = string.Empty;
        public List<(string Type, string Name)> Parameters { get; set; } = new List<(string, string)>();
        public LangGrammarParser.FunctionblockContext Body { get; set; } = null!;
    }
    public class ReturnValue {
        public string Type { get; set; } = "";  // ou "int", conforme sua convenção
        public object Value { get; set; } = 0;   // ou outro valor padrão
        public bool Initialized { get; set; } = false; 
    }

    public override void EnterIncludeDecl(LangGrammarParser.IncludeDeclContext context) {
        try {
            string libName = context.BIB().GetText();

            if (string.IsNullOrWhiteSpace(libName)) {
                //($"[ERRO] Linha {context.Start.Line}: Nome de biblioteca inválido ou vazio.");
                Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Invalid or empty library name.");
                return;
            }

            if (includes.Contains(libName)) {
                //$"[AVISO] Linha {context.Start.Line}: A biblioteca '{libName}' já foi incluída anteriormente."
                Console.WriteLine($"\n[WARNING] Line {context.Start.Line}: Library '{libName}' has already been included previously.");
                return;
            }

            includes.Add(libName);
            //Biblioteca incluida
            Console.WriteLine($"\nLibrary included: {libName}");
        } catch (Exception ex) {
            //$"[ERRO] Linha {context.Start.Line}: Falha ao incluir biblioteca. {ex.Message}"
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Failed to include library. {ex.Message}");
        }
    }
    public override void EnterDefineDecl(LangGrammarParser.DefineDeclContext context) {
        try {
            string varName = context.VAR().GetText();
            object value;

            if (defines.ContainsKey(varName)) {
                //$"[ERRO] Linha {context.Start.Line}: A constante '{varName}' já foi definida anteriormente.");
                Console.WriteLine($"\n[ERRO] Line {context.Start.Line}: The constant '{varName}'  has already been defined previously.");
                return;
            }

            if (context.NUM() != null) {
                if (!int.TryParse(context.NUM().GetText(), out int intValue)) {
                    //$"[ERRO] Linha {context.Start.Line}: Valor numérico inválido para '{varName}'."
                    Console.WriteLine($"\n[ERRO] Line {context.Start.Line}: Invalid numeric value for '{varName}'.");
                    return;
                }
                value = intValue;
            } else if (context.CONSTANT() != null) {
                if (!float.TryParse(context.CONSTANT().GetText(), NumberStyles.Float, CultureInfo.InvariantCulture, out float floatValue)) {
                    //($"[ERRO] Linha {context.Start.Line}: Valor de ponto flutuante inválido para '{varName}'.");
                    Console.WriteLine($"\n[ERRO] Line {context.Start.Line}: Invalid floating point value for '{varName}'.");
                    return;
                }
                value = floatValue;
            } else if (context.CHARLIT() != null) {
                string charLit = context.CHARLIT().GetText();
                if (charLit.Length != 3 || charLit[0] != '\'' || charLit[2] != '\'') {
                    // Erro linha: caractere inválida para varName
                    Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Invalid character for '{varName}'.");
                    return;
                }
                value = charLit[1];
            } else {
                //Erro linha tipo de constante não reconhecido pra varName
                Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Unrecognized constant type for '{varName}'.");
                return;
            }

            defines[varName] = value;
            //Constante definida
            Console.WriteLine($"\nDefined constant: {varName} = {value} ({value.GetType().Name})");
        } catch (Exception ex) {
            //Erro linha falha ao definir constante 
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Failed to set constant. {ex.Message}");
        }
    }
    public override void ExitStructDecl(LangGrammarParser.StructDeclContext context){
        try{
            string structName = context.VAR().GetText();
            if(_structs.ContainsKey(structName)){
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Struct '{structName}' já foi declarada.");
            }   

            var fields = new Dictionary<string, string>();
            foreach(var member in context.structMember()){
                string type = member.tipo().GetText();
                string name = member.VAR().GetText();
                fields[name] = type;
            }
            _structs[structName] = fields;
            Console.WriteLine($"Struct '{structName}' declarada com sucesso.");
        }catch(Exception ex){
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao declarar struct: {ex.Message}");
        }
    }

    /// <summary>
    /// Atualiza (através de atribuição) um membro de uma instância de struct.
    /// Esse método é chamado quando a regra 'structAccess' é finalizada.
    /// </summary>
    public override void ExitStructAccess(LangGrammarParser.StructAccessContext context){
        try{
            string varName = context.VAR(0).GetText();
            string fieldName = context.VAR(1).GetText();

            // Primeiro, verifica se a variável está declarada em _variables (structs)
            if (_variables.ContainsKey(varName))
            {
                var varValue = _variables[varName];
                if (!varValue.Type.StartsWith("struct"))
                    throw new Exception($"[WARNING] Linha {context.Start.Line}: Variável '{varName}' não é do tipo struct.");
                var instance = (Dictionary<string, ReturnValue>)varValue.Value;
                if (!instance.ContainsKey(fieldName))
                    throw new Exception($"[ERROR] Linha {context.Start.Line}: Campo '{fieldName}' não existe na struct '{varName}'.");
                if (context.expression() != null)
                {
                    var value = EvaluateExpression(context.expression());
                    instance[fieldName] = value;
                    Console.WriteLine($"Membro '{fieldName}' da struct '{varName}' atualizado para {value.Value}");
                }
                else
                {
                    Console.WriteLine($"Acesso à struct: {varName}.{fieldName} = {instance[fieldName].Value}");
                }
            }
            // Se não estiver em _variables, verifica em _unionInstances (unions)
            else if (_unionInstances.ContainsKey(varName))
            {
                if (!_unionInstanceTypes.ContainsKey(varName))
                    throw new Exception($"[ERROR] Linha {context.Start.Line}: Tipo da union para '{varName}' não foi identificado.");
                string unionType = _unionInstanceTypes[varName];
                if (!_unions[unionType].ContainsKey(fieldName))
                    throw new Exception($"[ERROR] Linha {context.Start.Line}: Campo '{fieldName}' não existe na union '{unionType}'.");
                var unionInstance = _unionInstances[varName];
                if (context.expression() != null)
                {
                    var value = EvaluateExpression(context.expression());
                    // Opcional: redefinir os demais campos para seus valores padrão
                    foreach (var key in unionInstance.Keys.ToList())
                    {
                        unionInstance[key] = CreateDefaultValue(_unions[unionType][key]);
                    }
                    unionInstance[fieldName] = value;
                    Console.WriteLine($"Campo '{fieldName}' da union '{varName}' atualizado para {value.Value}");
                }
                else
                {
                    Console.WriteLine($"Acesso à union: {varName}.{fieldName} = {unionInstance[fieldName].Value}");
                }
            }
            else
            {
                throw new Exception($"[ERROR] Linha {context.Start.Line}: Instância '{varName}' não foi declarada.");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao acessar struct/union: {ex.Message}");
        }
    }

    // --- Novo método: Declaração/Instanciação de uma struct ---
    // Supondo que sua gramática possua uma regra 'structInstDecl'
    public override void ExitStructInstDecl(LangGrammarParser.StructInstDeclContext context){
        try{
            // Supondo que a sintaxe seja: "struct NomeStruct nomeInstancia = { ... };"
            // Onde o primeiro VAR é o nome do tipo e o segundo VAR é o nome da instância.
            string structType = context.VAR(0).GetText();
            string instanceName = context.VAR(1).GetText();

            if (!_structs.ContainsKey(structType))
            {
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Struct '{structType}' não foi declarada.");
            }
            var fieldDefs = _structs[structType];

            // Cria a instância com valores padrão para cada campo
            var instance = new Dictionary<string, ReturnValue>();
            foreach (var field in fieldDefs)
            {
                string fieldName = field.Key;
                string fieldType = field.Value;
                ReturnValue defaultValue;
                switch (fieldType)
                {
                    case "int":
                        defaultValue = new ReturnValue { Type = "int", Value = 0 };
                        break;
                    case "float":
                        defaultValue = new ReturnValue { Type = "float", Value = 0.0 };
                        break;
                    case "char":
                        defaultValue = new ReturnValue { Type = "char", Value = '\0' };
                        break;
                    case "string":
                        defaultValue = new ReturnValue { Type = "string", Value = "" };
                        break;
                    default:
                        defaultValue = new ReturnValue { Type = fieldType, Value = null };
                        break;
                }
                instance[fieldName] = defaultValue;
            }

            // Se houver uma lista de inicializadores (struct literal), atualiza os campos conforme a ordem
            if (context.structLiteral() != null)
            {
                var exprs = context.structLiteral().expression();
                int i = 0;
                foreach (var fieldName in fieldDefs.Keys)
                {
                    if (i < exprs.Length)
                    {
                        instance[fieldName] = EvaluateExpression(exprs[i]);
                        i++;
                    }
                    else
                    {
                        break;
                    }
                }
            }

            _structInstances[instanceName] = instance;
            Console.WriteLine($"Instância da struct '{structType}' criada com nome '{instanceName}'.");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao declarar instância de struct: {ex.Message}");
        }
    }

    public override void ExitFunctionDecl(LangGrammarParser.FunctionDeclContext context){
        if (context == null)
        {
            //Contexto da declaração de função é nulo    
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Function declaration context is null.");
            return;
        }

        string functionName = context.VAR().GetText();
        string returnType = context.tipo().GetText();
        
        if (functions.ContainsKey(functionName))
        {
            //Erro: A função 'functionName' já foi declarada anteriormente.
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Function '{functionName}' has already been declared previously.");
        }
        else
        {
            var parameters = new List<(string Type, string Name)>();
            if (context.parametros() != null)
            {
                var param = context.parametros();
                for (int i = 0; i < param.tipo().Length; i++)
                {
                    string type = param.tipo(i).GetText();
                    string name = param.VAR(i).GetText();
                    parameters.Add((type, name));
                }
            }

            var functionInfo = new FunctionInfo
            {
                ReturnType = returnType,
                Name = functionName,
                Parameters = parameters,
                Body = context.functionblock()
            };

            functions[functionName] = functionInfo;
            //Função 'functionName' declarada com sucesso.
            Console.WriteLine($"\nFunction '{functionName}' declared successfully.");
        }
    }

    public override void ExitCallFunction(LangGrammarParser.CallFunctionContext context){
        try
        {
            string functionName = context.VAR().GetText();

            if (!functions.ContainsKey(functionName))
            {
                //Erro: Função 'functionName' não declarada.
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Function '{functionName}' not declared.");
            }

            var functionInfo = functions[functionName];
            var arguments = context.expression();

            if (functionInfo.Parameters.Count != arguments.Length)
            {
                //Erro: Função 'functionName' chamada com número incorreto de argumentos.
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Function '{functionName}' called with incorrect number of arguments.");
            }

            var previousVariables = new Dictionary<string, ReturnValue>(_variables);
            _variables.Clear();

            for (int i = 0; i < functionInfo.Parameters.Count; i++)
            {
                string paramName = functionInfo.Parameters[i].Name;
                ReturnValue argValue = EvaluateExpression(arguments[i]);
                _variables[paramName] = argValue;
            }

            ReturnValue returnValue = ExecuteFunctionBlock(functionInfo.Body, functionInfo);
            _variables = previousVariables;
            //Função 'functionName' chamada com sucesso. Retorno: returnValue
            Console.WriteLine($"\nFunction '{functionName}' called successfully. Returns:: {returnValue.Value}");
        }
        catch (Exception ex)
        {
            //Erro ao chamar função: ex.Message
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Error processing function call {ex.Message}");
        }
    }
    // --- Novo método auxiliar para acesso a membros de struct em expressões ---
    // Exemplo de método auxiliar para acessar membros de struct em expressões
    private ReturnValue EvaluateStructAccess(LangGrammarParser.StructAccessContext context)
    {
        string varName = context.VAR(0).GetText();
        string fieldName = context.VAR(1).GetText();

        if (!_variables.ContainsKey(varName))
            throw new Exception($"[ERROR] Linha {context.Start.Line}: Variável '{varName}' não declarada.");

        var varValue = _variables[varName];
        if (!varValue.Type.StartsWith("struct"))
            throw new Exception($"[WARNING] Linha {context.Start.Line}: Variável '{varName}' não é do tipo struct.");

        var instance = (Dictionary<string, ReturnValue>)varValue.Value;
        if (!instance.ContainsKey(fieldName))
            throw new Exception($"[ERROR] Linha {context.Start.Line}: Campo '{fieldName}' não existe na struct '{varName}'.");

        return instance[fieldName];
    }
    public override void ExitUnionDecl(LangGrammarParser.UnionDeclContext context)
    {
        try
        {
            string unionName = context.VAR().GetText();
            if (_unions.ContainsKey(unionName))
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Union '{unionName}' já foi declarada.");

            var fields = new Dictionary<string, string>();

            // Como unionFields é definido como uma repetição de ((INT | FLOAT | CHAR | DOUBLE | VOID) VAR ';'),
            // precisamos iterar sobre seus elementos.
            // Supondo que a gramática gere contextos para cada declaração, podemos usar:
            foreach (var child in context.unionFields().children)
            {
                // Uma abordagem simples: se a gramática não tem uma regra específica para cada campo (ex.: unionField),
                // podemos obter os tokens VAR e os tokens de tipo. 
                // Aqui, para simplificar, vamos supor que os campos estão ordenados e que cada campo é composto por:
                // [Tipo] [VAR] ';'
                // Se houver vários nós, você pode filtrar os nós do tipo TerminalNode e extrair os textos.
            }
            // Uma alternativa mais simples: obtenha todos os tokens VAR da unionFields
            var varTokens = context.unionFields().GetTokens(LangGrammarParser.VAR);
            // Obtenha também os tokens dos tipos (INT, FLOAT, etc.). Suponha que eles venham em ordem.
            var typeTokens = context.unionFields().GetTokens(LangGrammarParser.INT)
                            .Concat(context.unionFields().GetTokens(LangGrammarParser.FLOAT))
                            .Concat(context.unionFields().GetTokens(LangGrammarParser.CHAR))
                            .Concat(context.unionFields().GetTokens(LangGrammarParser.DOUBLE))
                            .Concat(context.unionFields().GetTokens(LangGrammarParser.VOID))
                            .ToList();
            // Se a ordem for consistente (cada campo: [tipo] [nome] ';'),
            // podemos iterar sobre os tokens de nome e associar com o tipo correspondente.
            // OBSERVAÇÃO: Em uma implementação real, é recomendável definir uma regra separada para cada campo (ex.: unionField)
            // para facilitar essa iteração.
            // Aqui, usaremos uma abordagem simplificada:
            int fieldCount = varTokens.Count();
            for (int i = 0; i < fieldCount; i++)
            {
                // Para cada campo, o tipo correspondente está na mesma ordem (supondo que o número de tokens de tipo seja igual)
                // Essa abordagem pode precisar de ajustes conforme sua gramática.
                string fieldName = varTokens[i].GetText();
                string fieldType = typeTokens[i].GetText();
                fields[fieldName] = fieldType;
            }

            _unions[unionName] = fields;
            Console.WriteLine($"Union '{unionName}' declarada com sucesso.");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao declarar union: {ex.Message}");
        }
    }
    public override void ExitUnionAccess(LangGrammarParser.UnionAccessContext context)
    {
        try
        {
            string unionInstanceName = context.GetChild(0).GetText();
            string fieldName = context.GetChild(2).GetText();
            if (!_unionInstances.ContainsKey(unionInstanceName))
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Instância de union '{unionInstanceName}' não foi declarada.");
            if (!_unionInstanceTypes.ContainsKey(unionInstanceName))
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Tipo da union para '{unionInstanceName}' não foi identificado.");
            string unionType = _unionInstanceTypes[unionInstanceName];
            if (!_unions[unionType].ContainsKey(fieldName))
                throw new Exception($"[ERROR] Linha {context.Start.Line}: Campo '{fieldName}' não existe na union '{unionType}'.");
            var unionInstance = _unionInstances[unionInstanceName];
            if (context.ChildCount > 4)
            {
                ReturnValue value = EvaluateExpression(context.expression());
                string expectedType = _unions[unionType][fieldName];
                if (!IsTypeCompatible(value.Type, expectedType))
                    throw new Exception($"[WARNING] Linha {context.Start.Line}: Tipo incompatível: campo '{fieldName}' espera '{expectedType}' mas foi atribuído '{value.Type}'.");
                // Conversão para o tipo esperado
                value = ConvertValueToType(value, expectedType);
                foreach (var key in unionInstance.Keys.ToList())
                {
                    unionInstance[key] = CreateDefaultValue(_unions[unionType][key]);
                }
                unionInstance[fieldName] = value;
                Console.WriteLine($"Campo '{fieldName}' da union '{unionInstanceName}' atualizado para {value.Value}");
            }
            else
            {
                ReturnValue result = unionInstance[fieldName];
                Console.WriteLine($"Acesso à union: {unionInstanceName}.{fieldName} = {result.Value}");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao acessar union: {ex.Message}");
        }
    }

    private bool IsTypeCompatible(string actual, string expected)
    {
        // Para simplificar, considere que os tipos devem ser iguais.
        // Você pode expandir essa lógica para permitir, por exemplo, atribuição de int para float, se desejado.
        return actual == expected;
    }

    private ReturnValue EvaluateBuiltInFunction(string functionName, List<ReturnValue> args)
    {
        if (functionName == "atoi")
        {
            if (args.Count < 1)
                throw new Exception("atoi espera 1 argumento.");
            if (args[0].Type != "string")
                throw new Exception("atoi espera argumento do tipo string.");
            int result;
            if (!int.TryParse((string)args[0].Value, out result))
                result = 0;
            return new ReturnValue { Type = "int", Value = result, Initialized = true };
        }
        else if (functionName == "atof")
        {
            if (args.Count < 1)
                throw new Exception("atof espera 1 argumento.");
            if (args[0].Type != "string")
                throw new Exception("atof espera argumento do tipo string.");
            double result;
            if (!double.TryParse((string)args[0].Value, NumberStyles.Float, CultureInfo.InvariantCulture, out result))
                result = 0.0;
            return new ReturnValue { Type = "float", Value = result, Initialized = true };
        }
        else
        {
            throw new Exception($"Função built-in '{functionName}' não definida.");
        }
    }

    public override void ExitAtrib(LangGrammarParser.AtribContext context){
        try
        {
            if (context.tipo() != null)
            {
                string typeText = context.tipo().GetText().Trim(); // Ex.: "int", "float", "char", "struct Aluno", etc.
                string varName = context.VAR().GetText();

                // --- Tratamento para Structs ---
                if (typeText.StartsWith("struct"))
                {
                    string structType = context.tipo().GetChild(1).GetText().Trim();
                    if (!_structs.ContainsKey(structType))
                        throw new Exception($"[WARNING] Linha {context.Start.Line}: Struct '{structType}' não foi declarada.");
                    var fieldDefs = _structs[structType];
                    var instance = new Dictionary<string, ReturnValue>();
                    foreach (var field in fieldDefs)
                    {
                        instance[field.Key] = CreateDefaultValue(field.Value);
                    }
                    if (context.expression() != null)
                    {
                        var expr = context.expression();
                        var structLit = expr.GetRuleContext<LangGrammarParser.StructLiteralContext>(0);
                        if (structLit != null)
                        {
                            ReturnValue sv = EvaluateStructLiteral(structLit, fieldDefs);
                            instance = (Dictionary<string, ReturnValue>)sv.Value;
                        }
                        else
                        {
                            throw new Exception("[ERROR] Inicializador inválido para struct. Use a sintaxe { ... }.");
                        }
                    }
                    _variables[varName] = new ReturnValue { Type = $"struct {structType}", Value = instance, Initialized = true };
                    Console.WriteLine($"Variável struct '{varName}' do tipo '{structType}' inicializada com sucesso.");
                    return;
                }
                // --- Tratamento para Unions ---
                else if (typeText.StartsWith("union"))
                {
                    string unionType = context.tipo().GetChild(1).GetText().Trim();
                    if (!_unions.ContainsKey(unionType))
                        throw new Exception($"[WARNING] Linha {context.Start.Line}: Union '{unionType}' não foi declarada.");

                    var fieldDefs = _unions[unionType];
                    var instance = new Dictionary<string, ReturnValue>();
                    foreach (var field in fieldDefs)
                    {
                        instance[field.Key] = CreateDefaultValue(field.Value);
                    }
                    _unionInstances[varName] = instance;
                    _unionInstanceTypes[varName] = unionType;
                    // Armazena também a variável no dicionário _variables para que ela seja encontrada em expressões.
                    _variables[varName] = new ReturnValue { Type = $"union {unionType}", Value = instance };
                    Console.WriteLine($"Instância da union '{unionType}' criada com nome '{varName}'.");
                    return;
                }

                // --- Tratamento para Tipos Simples (int, float, char, string) ---
                else
                {
                    // Se não há inicializador, registra com o valor padrão e Initialized = false
                    if (context.expression() == null)
                    {
                        ReturnValue defVal = CreateDefaultValue(typeText);
                        _variables[varName] = new ReturnValue { Type = typeText, Value = defVal.Value, Initialized = false };
                        Console.WriteLine($"Variável '{varName}' declarada sem inicialização. Inicializando com valor padrão {defVal.Value}");
                        return;
                    }
                    // Se há inicializador, avalia a expressão, converte para o tipo esperado e marca como inicializada
                    var value = EvaluateExpression(context.expression());
                    if (!IsTypeCompatible(value.Type, typeText))
                    {
                        Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Tipo incompatível: variável '{varName}' espera '{typeText}', mas o valor é do tipo '{value.Type}'.");
                    }
                    else
                    {
                        value = ConvertValueToType(value, typeText);
                        value.Initialized = true;
                        _variables[varName] = value;
                        Console.WriteLine($"Variável '{varName}' atualizada com valor {value.Value}");
                    }
                    return;
                }
            }
            else
            {
                // Atribuição sem declaração de tipo (ex.: "i = i + 1;")
                string varName = context.VAR().GetText();
                
                // Se a variável não foi inicializada, lança erro
                if (!_variables.ContainsKey(varName))
                    throw new Exception($"Variável '{varName}' não foi inicializada previamente.");

                if (context.expression() != null)
                {
                    var value = EvaluateExpression(context.expression());
                    string declaredType = _variables[varName].Type;

                    if (!IsTypeCompatible(value.Type, declaredType))
                    {
                        Console.WriteLine($"Erro: Tipo incompatível: variável '{varName}' espera '{declaredType}', mas o valor é do tipo '{value.Type}'.");
                    }
                    else
                    {
                        // 🚀 **Correção do problema do `for`:**
                        // Só faz a atualização se já estivermos dentro do loop e não antes!
                        if (_insideForLoop)
                        {
                            value = ConvertValueToType(value, declaredType);
                            value.Initialized = true;
                            _variables[varName] = value;
                            Console.WriteLine($"Variável '{varName}' atualizada com valor {value.Value}");
                        }
                    }
                }
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao processar atribuição: {ex.Message}");
        }
    }
    
    private ReturnValue CreateDefaultValue(string type)
    {
        switch (type)
        {
            case "int":
                return new ReturnValue { Type = "int", Value = 0 };
            case "float":
                return new ReturnValue { Type = "float", Value = 0.0 };
            case "char":
                return new ReturnValue { Type = "char", Value = '\0' };
            case "string":
                return new ReturnValue { Type = "string", Value = "" };
            default:
                return new ReturnValue { Type = type, Value = null };
        }
    }

    // Exemplo de suporte para imprimir valores no array
    public override void ExitOutput(LangGrammarParser.OutputContext context)
    {
        try
        {
            string format = context.STR().GetText().Trim('"')
                            .Replace("\\n", "\n")
                            .Replace("\\t", "\t");
            List<ReturnValue> arguments = new List<ReturnValue>();

            // Em vez de usar context.arg, obtenha os argumentos da regra 'argument'
            var argList = context.GetRuleContexts<LangGrammarParser.ArgumentContext>();
            foreach (var argCtx in argList)
            {
                // Verifica qual alternativa foi usada e avalia o argumento
                // (Os métodos EvaluateExpression, EvaluateConditionAsInt, EvaluateArrayAccess e EvaluateStructFieldAccess
                // devem estar implementados conforme a sua lógica.)
                if (argCtx.expression() != null)
                {
                    arguments.Add(EvaluateExpression(argCtx.expression()));
                }
                else if (argCtx.exprbloco() != null)
                {
                    arguments.Add(new ReturnValue { Type = "int", Value = EvaluateConditionAsInt(argCtx.exprbloco()) });
                }
                else if (argCtx.arrayAccess() != null)
                {
                    arguments.Add(EvaluateArrayAccess(argCtx.arrayAccess()));
                }
                else if (argCtx.structFieldAccess() != null)
                {
                    arguments.Add(EvaluateStructFieldAccess(argCtx.structFieldAccess()));
                }
                else
                {
                    throw new Exception($"[ERROR] Linha {context.Start.Line}: Tipo de argumento não suportado no printf.");
                }
            }

            // Substituição simples dos placeholders (%d, %f, %c, %s)
            int idx = 0;
            while ((format.Contains("%d") || format.Contains("%f") || format.Contains("%c") || format.Contains("%s"))
                && idx < arguments.Count)
            {
                string placeholder = "";
                if (format.Contains("%d"))
                    placeholder = "%d";
                else if (format.Contains("%f"))
                    placeholder = "%f";
                else if (format.Contains("%c"))
                    placeholder = "%c";
                else if (format.Contains("%s"))
                    placeholder = "%s";

                string valueStr = "";
                var arg = arguments[idx];
                if (arg.Type == "int")
                {
                    valueStr = ((int)arg.Value).ToString();
                }
                else if (arg.Type == "float")
                {
                    valueStr = ((double)arg.Value).ToString(CultureInfo.InvariantCulture);
                }
                else if (arg.Type == "char")
                {
                    valueStr = arg.Value.ToString();
                }
                else if (arg.Type == "string")
                {
                    valueStr = (string)arg.Value;
                }
                else
                {
                    valueStr = arg.Value?.ToString() ?? "";
                }
                format = ReplaceFirst(format, placeholder, valueStr);
                idx++;
            }
            Console.Write(format);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao processar output: {ex.Message}");
        }
    }

    private ReturnValue EvaluateArrayAccess(LangGrammarParser.ArrayAccessContext context)
    {
        // Obtém o nome do array e avalia o índice
        string arrayName = context.VAR().GetText();
        ReturnValue indexValue = EvaluateExpression(context.expression());
        int index;
        if (indexValue.Type == "int")
            index = (int)indexValue.Value;
        else if (indexValue.Type == "float")
            index = (int)(double)indexValue.Value;
        else
            throw new Exception($"[WARNING] Linha {context.Start.Line}: Índice do array deve ser numérico.");

        if (!_arrays.ContainsKey(arrayName))
            throw new Exception($"[ERROR] Linha {context.Start.Line}: Array '{arrayName}' não declarado.");

        if (index < 0 || index >= _arrays[arrayName].Count)
            throw new Exception($"[WARNING] Linha {context.Start.Line}: Índice {index} fora dos limites do array '{arrayName}'.");

        return _arrays[arrayName][index];
    }

    private ReturnValue EvaluateStructFieldAccess(LangGrammarParser.StructFieldAccessContext context)
    {
        // Supondo que a regra structFieldAccess seja: VAR DOT VAR
        string varName = context.GetChild(0).GetText();
        string fieldName = context.GetChild(2).GetText(); // O filho 1 é o token DOT

        if (!_variables.ContainsKey(varName))
            throw new Exception($"[WARNING] Linha {context.Start.Line}: Variável '{varName}' não declarada.");

        var varValue = _variables[varName];
        // Aceitamos tanto se o tipo começar com "struct" quanto com "union"
        if (!varValue.Type.StartsWith("struct") && !varValue.Type.StartsWith("union"))
            throw new Exception($"[WARNING] Linha {context.Start.Line}: Variável '{varName}' não é do tipo struct ou union.");

        var instance = (Dictionary<string, ReturnValue>)varValue.Value;
        if (!instance.ContainsKey(fieldName))
            throw new Exception($"[ERROR] Linha {context.Start.Line}: Campo '{fieldName}' não existe na variável '{varName}'.");
        return instance[fieldName];
    }

    public override void ExitInput(LangGrammarParser.InputContext context)
    {
        try
        {
            // Obtém o formato (ex.: "%d") e o nome da variável (ex.: x)
            string format = context.FORMAT().GetText();
            string varName = context.VAR().GetText();

            if (!_variables.ContainsKey(varName))
                throw new Exception($"[ERROR] Linha {context.Start.Line}: Variável '{varName}' não declarada.");

            // Lê a entrada do usuário
            string input = Console.ReadLine() ?? "";

            // Atualiza a variável existente, sem criar um novo objeto
            if (format == "\"%d\"")
            {
                if (int.TryParse(input, out int intValue))
                {
                    _variables[varName].Value = intValue;
                    _variables[varName].Initialized = true;
                }
                else
                    throw new Exception($"[ERROR] Linha {context.Start.Line}: Entrada inválida para o formato {format}: {input}");
            }
            else if (format == "\"%f\"")
            {
                if (double.TryParse(input, NumberStyles.Float, CultureInfo.InvariantCulture, out double doubleValue))
                {
                    _variables[varName].Value = doubleValue;
                    _variables[varName].Initialized = true;
                }
                else
                    throw new Exception($"[ERROR] Linha {context.Start.Line}: Entrada inválida para o formato {format}: {input}");
            }
            else if (format == "\"%c\"")
            {
                if (!string.IsNullOrEmpty(input))
                {
                    _variables[varName].Value = input[0];
                    _variables[varName].Initialized = true;
                }
                else
                    throw new Exception($"[ERROR] Linha {context.Start.Line}: Entrada inválida para o formato {format}: {input}");
            }
            else if (format == "\"%s\"")
            {
                _variables[varName].Value = input;
                _variables[varName].Initialized = true;
            }
            else
            {
                Console.WriteLine($"[WARNING] Linha {context.Start.Line}: Formato desconhecido: {format}");
            }

            Console.WriteLine($"{varName} value updated to {_variables[varName].Value}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Error processing scanf: {ex.Message}");
        }
    }

    public override void ExitDecisionFunc(LangGrammarParser.DecisionFuncContext context)
    {
        try
        {
            // Itera sobre todas as condições
            for (int i = 0; i < context.exprbloco().Length; i++)
            {
                bool condition = EvaluateCondition(context.exprbloco(i));

                if (condition)
                {
                    if (i == 0)
                    {
                        Console.WriteLine("\nExecutando bloco 'if'");
                    }
                    else
                    {
                        Console.WriteLine($"Executando bloco 'else if' (condição {i})");
                    }

                    // Executa o bloco correspondente ao `if` ou `else if`
                    ExecuteBlock(context.bloco(i));
                    return; // Sai após encontrar o primeiro bloco verdadeiro
                }
            }

            // Se nenhuma condição foi verdadeira e há um bloco `else`
            if (context.bloco().Length > context.exprbloco().Length)
            {
                Console.WriteLine("Executando bloco 'else'");
                ExecuteBlock(context.bloco(context.bloco().Length - 1));
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao processar if-else-if: {ex.Message}");
        }
    }

    public override void ExitSwitchCase(LangGrammarParser.SwitchCaseContext context){
        try
        {
            string switchVarName = context.VAR().GetText();
            if (!_variables.ContainsKey(switchVarName))
            {
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Variável '{switchVarName}' não foi inicializada.");
            }

            // Obtenha o ReturnValue e converta para int (ou lance exceção se o tipo não for numérico)
            ReturnValue switchVar = _variables[switchVarName];
            int switchValue;
            if (switchVar.Type == "int")
            {
                switchValue = (int)switchVar.Value;
            }
            else if (switchVar.Type == "float")
            {
                switchValue = (int)(double)switchVar.Value;
            }
            else
            {
                throw new Exception($"[ERROR] Linha {context.Start.Line}: Tipo inválido para switch-case: {switchVar.Type}");
            }

            bool caseMatched = false;

            // Itera sobre os blocos 'case'
            foreach (var caseBlock in context.caseBlock())
            {
                int caseValue = int.Parse(caseBlock.NUM().GetText());

                if (switchValue == caseValue)
                {
                    Console.WriteLine($"Executando bloco 'case {caseValue}'");
                    foreach (var linha in caseBlock.linhas())
                    {
                        ExecuteLinha(linha);
                    }
                    caseMatched = true;
                    break; // Sai após executar o primeiro caso correspondente
                }
            }

            // Se nenhum 'case' foi correspondente, executa o bloco 'default'
            if (!caseMatched && context.defaultBlock() != null)
            {
                Console.WriteLine("Executando bloco 'default'");
                foreach (var linha in context.defaultBlock().linhas())
                {
                    ExecuteLinha(linha);
                }
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao processar switch-case: {ex.Message}");
        }
    }

    private void ExecuteLinha(LangGrammarParser.LinhasContext linha){
        if (linha.atrib() != null)
        {
            ExitAtrib(linha.atrib());
        }
        else if (linha.output() != null)
        {
            ExitOutput(linha.output());
        }
        else if (linha.loopFunc() != null)
        {
            if (linha.loopFunc().whileLoop() != null)
            {
                ExitWhileLoop(linha.loopFunc().whileLoop());
            }
            else if (linha.loopFunc().forLoop() != null)
            {
                ExitForLoop(linha.loopFunc().forLoop());
            }
        }
        else if (linha.decisionFunc() != null)
        {
            ExitDecisionFunc(linha.decisionFunc());
        }
        else
        {
            Console.WriteLine("Linha não reconhecida.");
        }
    }

    public override void ExitWhileLoop(LangGrammarParser.WhileLoopContext context)
    {
        try
        {
            Console.WriteLine("Iniciando loop while.");

            // Enquanto a condição for verdadeira
            while (EvaluateCondition(context.exprbloco()))
            {
                Console.WriteLine("Condição verdadeira. Executando corpo do while.");

                // Executa o bloco do corpo do `while`
                ExecuteBlock(context.bloco());

                // Reavalia a condição após cada iteração
                if (!EvaluateCondition(context.exprbloco()))
                {
                    Console.WriteLine("Condição falsa. Saindo do loop while.");
                    break; // Sai do loop se a condição for falsa
                }
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao processar while: {ex.Message}");
        }
    }

    public override void ExitForLoop(LangGrammarParser.ForLoopContext context)
    {
        try
        {
            if (_insideForLoop)
                throw new Exception("Tentativa de recursão no mesmo contexto de for.");
            _insideForLoop = true;

            // Inicializa a variável do for (se ainda não estiver inicializada)
            if (context.atrib(0) != null)
            {
                string initVarName = context.atrib(0).VAR().GetText();
                ExecuteInitialization(context.atrib(0));
                Console.WriteLine($"[DEBUG] Variável '{initVarName}' inicializada com valor {_variables[initVarName].Value}");
            }

            // Loop: enquanto a condição for verdadeira
            while (EvaluateCondition(context.exprbloco()))
            {
                string loopVarName = context.atrib(0).VAR().GetText();
                Console.WriteLine($"[DEBUG] Avaliando variável '{loopVarName}' com valor {_variables[loopVarName].Value}");
                ExecuteBlock(context.bloco());
                // Se houver incremento, executa-o
                if (context.atrib(1) != null)
                {
                    ExecuteIncrement(context.atrib(1));
                    Console.WriteLine($"[DEBUG] Variável '{context.atrib(1).VAR().GetText()}' incrementada para valor {_variables[context.atrib(1).VAR().GetText()].Value}");
                }
            }

            _insideForLoop = false;
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao processar for: {ex.Message}");
        }
    }

    public override void ExitDoWhileLoop(LangGrammarParser.DoWhileLoopContext context)
    {
        try
        {
            do
            {
                // Exibe o estado da variável no início de cada iteração
                Console.WriteLine("Executando corpo do do-while");

                // Executa o bloco do `do`
                ExecuteBlock(context.bloco());

                // Mostra o estado atual de todas as variáveis
                Console.WriteLine("Estado das variáveis após execução do bloco:");
                foreach (var variable in _variables)
                {
                    Console.WriteLine($"Variável '{variable.Key}' = {variable.Value.Value}");
                }

            } while (LogConditionResult(EvaluateCondition(context.exprbloco()))); // Avalia a condição do `while`
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao processar do-while: {ex.Message}");
        }
    }

    // Suporte para declaração e inicialização de arrays
    public override void ExitArrayDecl(LangGrammarParser.ArrayDeclContext context)
    {
        try
        {
            string arrayName = context.VAR().GetText();
            int arraySize = 0;
            
            // Obtém o contexto da regra auxiliar 'size'
            // (Se você definiu a regra "size : NUM | /* vazio */ ;" na gramática)
            var sizeCtx = context.GetRuleContext<LangGrammarParser.SizeContext>(0);
            if (sizeCtx != null && !string.IsNullOrWhiteSpace(sizeCtx.GetText()))
            {
                arraySize = int.Parse(sizeCtx.GetText());
            }
            else if (context.STR() != null)
            {
                // Se não há tamanho e há literal de string, deduz o tamanho a partir da string
                string strLiteral = context.STR().GetText();
                if (strLiteral.StartsWith("\"") && strLiteral.EndsWith("\""))
                {
                    strLiteral = strLiteral.Substring(1, strLiteral.Length - 2);
                }
                // Tamanho = comprimento da string + 1 (para o caractere nulo)
                arraySize = strLiteral.Length + 1;
            }
            else
            {
                arraySize = 0;
            }
            
            // Obtém o tipo do array (por exemplo, "char")
            string type = context.tipo().GetText();

            // Cria a lista de valores padrão de acordo com o tipo
            var list = new List<ReturnValue>();
            for (int i = 0; i < arraySize; i++)
            {
                switch (type)
                {
                    case "int":
                        list.Add(new ReturnValue { Type = "int", Value = 0 });
                        break;
                    case "float":
                        list.Add(new ReturnValue { Type = "float", Value = 0.0 });
                        break;
                    case "char":
                        list.Add(new ReturnValue { Type = "char", Value = '\0' });
                        break;
                    default:
                        list.Add(new ReturnValue { Type = type, Value = 0 });
                        break;
                }
            }
            _arrays[arrayName] = list;
            Console.WriteLine($"Array '{arrayName}' declarado com tamanho {arraySize} e tipo {type}");

            // Inicializa o array com os valores fornecidos, se houver (caso use elementosArray)
            var elementos = context.elementosArray();
            if (elementos != null)
            {
                var exprs = elementos.expression();
                for (int i = 0; i < exprs.Length && i < arraySize; i++)
                {
                    _arrays[arrayName][i] = EvaluateExpression(exprs[i]);
                }
            }
            // Caso contrário, se houver um literal STR, inicializa o array com os caracteres da string
            else if (context.STR() != null)
            {
                string strLiteral = context.STR().GetText();
                if (strLiteral.StartsWith("\"") && strLiteral.EndsWith("\""))
                {
                    strLiteral = strLiteral.Substring(1, strLiteral.Length - 2);
                }
                var arr = _arrays[arrayName];
                for (int i = 0; i < strLiteral.Length && i < arr.Count; i++)
                {
                    arr[i] = new ReturnValue { Type = "char", Value = strLiteral[i] };
                }
                // Se desejar, garante que a posição logo após o fim da string seja '\0'
                if (strLiteral.Length < arr.Count)
                {
                    arr[strLiteral.Length] = new ReturnValue { Type = "char", Value = '\0' };
                }
            }
            Console.WriteLine($"Array '{arrayName}' inicializado com valores: {string.Join(", ", _arrays[arrayName].Select(e => e.Value))}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao declarar array: {ex.Message}");
        }
    }

    // Suporte para acessar valores no array
    public override void ExitArrayAccess(LangGrammarParser.ArrayAccessContext context)
    {
        try {
            string arrayName = context.VAR().GetText();
            ReturnValue indexValue = EvaluateExpression(context.expression());
            int index;
            if (indexValue.Type == "int")
                index = (int)indexValue.Value;
            else if (indexValue.Type == "float")
                index = (int)(double)indexValue.Value;
            else
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Índice do array deve ser numérico.");
            
            if (!_arrays.ContainsKey(arrayName))
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Array '{arrayName}' não declarado.");
            
            if (index < 0 || index >= _arrays[arrayName].Count)
                throw new Exception($"[ERROR] Linha {context.Start.Line}: Índice {index} fora dos limites do array '{arrayName}'.");
            
            Console.WriteLine($"[DEBUG] Valor acessado: {arrayName}[{index}] = {_arrays[arrayName][index].Value}");
        }
        catch(Exception ex) {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao acessar array: {ex.Message}");
        }
    }

    // Suporte para atualizar valores no array
    public override void ExitArrayUpdate(LangGrammarParser.ArrayUpdateContext context)
    {
        try {
            string arrayName = context.VAR().GetText();
            
            // Avalia o índice
            ReturnValue indexValue = EvaluateExpression(context.expression(0));
            int index;
            if (indexValue.Type == "int")
                index = (int)indexValue.Value;
            else if (indexValue.Type == "float")
                index = (int)(double)indexValue.Value;
            else
                throw new Exception($"[ERROR] Linha {context.Start.Line}: Índice do array deve ser numérico.");
            
            // Avalia o novo valor
            ReturnValue newValue = EvaluateExpression(context.expression(1));
            
            if (!_arrays.ContainsKey(arrayName))
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Array '{arrayName}' não declarado.");
            
            if (index < 0 || index >= _arrays[arrayName].Count)
                throw new Exception($"[ERROR] Linha {context.Start.Line}: Índice {index} fora dos limites do array '{arrayName}'.");
            
            _arrays[arrayName][index] = newValue;
            Console.WriteLine($"Array '{arrayName}' atualizado: {arrayName}[{index}] = {newValue.Value}");
        }
        catch(Exception ex) {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao atualizar array: {ex.Message}");
        }
    }

    // Método auxiliar para logar o resultado da condição
    private bool LogConditionResult(bool condition)
    {
        Console.WriteLine($"Resultado da condição do-while: {condition}");
        return condition;
    }

// Método EvaluateExpression – trata de expressões aritméticas simples (soma e subtração)
    private ReturnValue EvaluateExpression(LangGrammarParser.ExpressionContext context)
    {
        
        // Se for acesso a array, trate-o separadamente (supondo que seus arrays sejam do tipo List<ReturnValue>)
        if (context.arrayAccess() != null)
        {
            string arrayName = context.arrayAccess().VAR().GetText();
            ReturnValue indexValue = EvaluateExpression(context.arrayAccess().expression());
            int index;
            if (indexValue.Type == "int")
                index = (int)indexValue.Value;
            else if (indexValue.Type == "float")
                index = (int)(double)indexValue.Value;
            else
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Índice do array deve ser numérico.");

            if (!_arrays.ContainsKey(arrayName))
                throw new Exception($"[ERROR] Linha {context.Start.Line}: Array '{arrayName}' não declarado.");
            return _arrays[arrayName][index];
        }

        if (context.callFunction() != null){
            return EvaluateCallFunction(context.callFunction());
        }

        // Se não for acesso a array, trata como uma expressão aritmética composta por terminais
        ReturnValue result = EvaluateTerminais(context.terminais(0));
        for (int i = 1; i < context.terminais().Length; i++)
        {
            string op = context.GetChild(2 * i - 1).GetText();
            ReturnValue nextValue = EvaluateTerminais(context.terminais(i));
            if (op == "+")
                result = Add(result, nextValue);      // Implemente Add de forma similar à Multiply/Divide
            else if (op == "-")
                result = Subtract(result, nextValue); // Implemente Subtract de forma similar
            else
                throw new NotSupportedException($"[ERROR] Linha {context.Start.Line}: Operador aritmético '{op}' não suportado.");
        }
        
        return result;
    }

    private ReturnValue EvaluateTerminais(LangGrammarParser.TerminaisContext context)
    {
        ReturnValue value = EvaluateFator(context.fator(0));
        for (int i = 1; i < context.fator().Length; i++)
        {
            string op = context.GetChild(2 * i - 1).GetText();
            ReturnValue nextValue = EvaluateFator(context.fator(i));
            if (op == "*")
            {
                value = Multiply(value, nextValue);
            }
            else if (op == "/")
            {
                value = Divide(value, nextValue);
            }
            else if (op == "%")
            {
                // Supondo que % seja apenas para inteiros
                if (value.Type != "int" || nextValue.Type != "int")
                    throw new Exception($"[WARNNG] Linha {context.Start.Line}: Operação módulo somente suportada para inteiros.");
                value = new ReturnValue { Type = "int", Value = (int)value.Value % (int)nextValue.Value };
            }
            else
            {
                throw new NotSupportedException($"[ERROR] Linha {context.Start.Line}: Operador '{op}' não suportado.");
            }
        }
        return value;
    }

    // Método EvaluateFator – trata de literais, variáveis e expressões entre parênteses
    private ReturnValue EvaluateFator(LangGrammarParser.FatorContext context){
        // Se houver operador NOT (negação)
        if (context.NOT() != null)
        {
            ReturnValue value = EvaluateFator(context.fator());
            if (value.Type == "int")
                return new ReturnValue { Type = "int", Value = ((int)value.Value == 0 ? 1 : 0) };
            else if (value.Type == "float")
                return new ReturnValue { Type = "int", Value = ((double)value.Value == 0.0 ? 1 : 0) };
            else
                throw new Exception($"[ERROR] Linha {context.Start.Line}:Operação NOT não suportada para tipo {value.Type}");
        }

        // Se for uma expressão entre parênteses
        if (context.expression() != null)
        {
            return EvaluateExpression(context.expression());
        }

        // Se for acesso a array
        if (context.arrayAccess() != null)
        {
            string arrayName = context.arrayAccess().VAR().GetText();
            ReturnValue indexValue = EvaluateExpression(context.arrayAccess().expression());
            int index;
            if (indexValue.Type == "int")
                index = (int)indexValue.Value;
            else if (indexValue.Type == "float")
                index = (int)(double)indexValue.Value;
            else
                throw new Exception($"[ERROR] Linha {context.Start.Line}: Índice do array deve ser numérico.");

            if (!_arrays.ContainsKey(arrayName))
                throw new Exception($"[ERROR] Linha {context.Start.Line}: Array '{arrayName}' não declarado.");
            return _arrays[arrayName][index];
        }

        // **Novo caso:** Se for acesso a campo de struct ou union (usando a regra structFieldAccess)
        var sf = context.GetRuleContext<LangGrammarParser.StructFieldAccessContext>(0);
        if (sf != null)
        {
            // Obtém o nome da variável e o nome do campo
            string varName = sf.GetChild(0).GetText();
            string fieldName = sf.GetChild(2).GetText(); // O filho 1 é o token DOT

            if (!_variables.ContainsKey(varName))
                throw new Exception($"[ERROR] Linha {context.Start.Line}: Variável '{varName}' não declarada.");

            var varValue = _variables[varName];

            // Aceita tanto se o tipo começar com "struct" quanto com "union"
            if (!varValue.Type.StartsWith("struct") && !varValue.Type.StartsWith("union"))
                throw new Exception($"[ERROR] Linha {context.Start.Line}: Variável '{varName}' não é do tipo struct ou union.");

            var instance = (Dictionary<string, ReturnValue>)varValue.Value;
            if (!instance.ContainsKey(fieldName))
                throw new Exception($"[ERROR] Linha {context.Start.Line}: Campo '{fieldName}' não existe na variável '{varName}'.");
            return instance[fieldName];
        }

        // Se for um literal numérico
        if (context.NUM() != null)
        {
            string numText = context.NUM().GetText();
            if (numText.Contains("."))
            {
                return new ReturnValue
                {
                    Type = "float",
                    Value = double.Parse(numText, CultureInfo.InvariantCulture)
                };
            }
            else
            {
                return new ReturnValue
                {
                    Type = "int",
                    Value = int.Parse(numText)
                };
            }
        }

        // Se for um literal char
        if (context.CHARLIT() != null)
        {
            string charText = context.CHARLIT().GetText();
            if (charText.Length >= 3)
            {
                char c = charText[1];
                return new ReturnValue { Type = "char", Value = c };
            }
            else
            {
                throw new Exception("Literal char inválido.");
            }
        }

        // Se for um literal de string
        if (context.STR() != null)
        {
            string strLiteral = context.STR().GetText();
            if (strLiteral.StartsWith("\"") && strLiteral.EndsWith("\""))
            {
                strLiteral = strLiteral.Substring(1, strLiteral.Length - 2);
            }
            strLiteral = strLiteral.Replace("\\n", "\n").Replace("\\t", "\t").Replace("\\r", "\r");
            return new ReturnValue { Type = "string", Value = strLiteral };
        }

        // Se for uma variável
        if (context.VAR() != null)
        {
            string varName = context.VAR().GetText();
            if (defines.ContainsKey(varName)){
                object value = defines[varName];

                // Verifique o tipo do valor e ajuste o tipo retornado
                if (value is int){
                    return new ReturnValue { 
                        Type = "int", 
                        Value = value 
                    };
                }
                else if (value is float){
                    return new ReturnValue{ 
                        Type = "float", 
                        Value = Convert.ToDouble(value)
                    };
                }
                else if (value is char){
                    return new ReturnValue { 
                        Type = "char", 
                        Value = value 
                    };
                }
                else{
                    //Erro: Tipo de constante 'varName' não reconhecido.
                    throw new Exception($"\n[ERROR] Line {context.Start.Line}: Constant type '{varName}' not recognized.");
                }
            }
            else if(_variables.ContainsKey(varName))
            {
                return _variables[varName];
            }
            else if (_arrays.ContainsKey(varName))
            {
                // Trata arrays (supondo array de char representando string)
                var arr = _arrays[varName];
                string s = "";
                foreach (var rv in arr)
                {
                    char c = Convert.ToChar(rv.Value);
                    if (c == '\0') break;
                    s += c;
                }
                return new ReturnValue { Type = "string", Value = s };
            }
            else{
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Variável '{varName}' não declarada.");
            }
        }

        if (context.CONSTANT() != null)
        {
            string constText = context.CONSTANT().GetText();
            if (constText.Contains("."))
            {
                return new ReturnValue { Type = "float", Value = double.Parse(constText, CultureInfo.InvariantCulture) };
            }
            else
            {
                return new ReturnValue { Type = "int", Value = int.Parse(constText) };
            }
        }

        throw new Exception($"[ERROR] Linha {context.Start.Line}: Fator inválido.");
    }

// Exemplo dos métodos auxiliares para operações aritméticas:
// Exemplo dos métodos auxiliares para operações aritméticas:
    private ReturnValue Add(ReturnValue a, ReturnValue b)
    {
        // MOD: Se algum dos operandos for string, concatene-os
        if (a.Type == "string" || b.Type == "string")
        {
            return new ReturnValue { Type = "string", Value = a.Value.ToString() + b.Value.ToString() };
        }

        if (a.Type == "float" || b.Type == "float")
        {
            double left = (a.Type == "int" ? Convert.ToDouble(a.Value) : (double)a.Value);
            double right = (b.Type == "int" ? Convert.ToDouble(b.Value) : (double)b.Value);
            return new ReturnValue { Type = "float", Value = left + right };
        }
        else if (a.Type == "int" && b.Type == "int")
        {
            return new ReturnValue { Type = "int", Value = (int)a.Value + (int)b.Value };
        }
        throw new Exception($"Operação de adição não suportada entre os tipos {a.Type} e {b.Type}.");
    }

    private ReturnValue Subtract(ReturnValue a, ReturnValue b)
    {
        if (a.Type == "float" || b.Type == "float")
        {
            double left = (a.Type == "int" ? Convert.ToDouble(a.Value) : (double)a.Value);
            double right = (b.Type == "int" ? Convert.ToDouble(b.Value) : (double)b.Value);
            return new ReturnValue { Type = "float", Value = left - right };
        }
        else if (a.Type == "int" && b.Type == "int")
        {
            return new ReturnValue { Type = "int", Value = (int)a.Value - (int)b.Value };
        }
        throw new Exception($"Operação de subtração não suportada entre os tipos {a.Type} e {b.Type}.");
    }


// Exemplo de implementação de funções auxiliares para multiplicação e divisão:
    private ReturnValue Multiply(ReturnValue a, ReturnValue b)
    {
        // Se ambos forem inteiros, opera em int
        if (a.Type == "int" && b.Type == "int")
            return new ReturnValue { Type = "int", Value = (int)a.Value * (int)b.Value };

        // Caso contrário, opera em float (promovendo int para float se necessário)
        double left = (a.Type == "int" ? Convert.ToDouble(a.Value) : (double)a.Value);
        double right = (b.Type == "int" ? Convert.ToDouble(b.Value) : (double)b.Value);
        return new ReturnValue { Type = "float", Value = left * right };
    }

    private ReturnValue Divide(ReturnValue a, ReturnValue b)
    {
        double left = (a.Type == "int" ? Convert.ToDouble(a.Value) : (double)a.Value);
        double right = (b.Type == "int" ? Convert.ToDouble(b.Value) : (double)b.Value);
        if (right == 0) throw new Exception("Divisão por zero.");
        return new ReturnValue { Type = "float", Value = left / right };
    }
    private bool EvaluateCondition(LangGrammarParser.ExprblocoContext context){
        if (context == null) 
            return false;

        // Caso 1: Expressão entre parênteses
        if (context is LangGrammarParser.ParentesisExpressionContext parenCtx)
        {
            return EvaluateCondition(parenCtx.exprbloco());
        }
        
        // Caso 2: Operador lógico NOT
        if (context is LangGrammarParser.NotExpressionContext notCtx)
        {
            return !EvaluateCondition(notCtx.exprbloco());
        }
        
        // Caso 3: Operador lógico AND
        if (context is LangGrammarParser.AndExpressionContext andCtx)
        {
            return EvaluateCondition(andCtx.exprbloco(0)) && EvaluateCondition(andCtx.exprbloco(1));
        }
        
        // Caso 4: Operador lógico OR
        if (context is LangGrammarParser.OrExpressionContext orCtx)
        {
            return EvaluateCondition(orCtx.exprbloco(0)) || EvaluateCondition(orCtx.exprbloco(1));
        }
        
        // Caso 5: Expressão relacional
        if (context is LangGrammarParser.RelationalExpressionContext relCtx)
        {
            ReturnValue leftValue = EvaluateExpression(relCtx.expression(0));
            if (relCtx.RELOP() != null)
            {
                ReturnValue rightValue = EvaluateExpression(relCtx.expression(1));
                string op = relCtx.RELOP().GetText();

                // Comparação numérica
                if ((leftValue.Type == "int" || leftValue.Type == "float") &&
                    (rightValue.Type == "int" || rightValue.Type == "float"))
                {
                    double left = leftValue.Type == "int" ? Convert.ToDouble(leftValue.Value) : (double)leftValue.Value;
                    double right = rightValue.Type == "int" ? Convert.ToDouble(rightValue.Value) : (double)rightValue.Value;
                    return op switch {
                        "==" => left == right,
                        "!=" => left != right,
                        ">"  => left > right,
                        "<"  => left < right,
                        ">=" => left >= right,
                        "<=" => left <= right,
                        _ => throw new NotSupportedException($"[ERROR] Linha {context.Start.Line}: Operador relacional '{op}' não suportado")
                    };
                }
                // Comparação para strings
                if (leftValue.Type == "string" && rightValue.Type == "string")
                {
                    string left = (string)leftValue.Value;
                    string right = (string)rightValue.Value;
                    return op switch {
                        "==" => left.Equals(right),
                        "!=" => !left.Equals(right),
                        _ => throw new NotSupportedException($"[ERROR] Linha {context.Start.Line}: Operador relacional '{op}' não suportado para strings.")
                    };
                }
                // Comparação para char
                if (leftValue.Type == "char" && rightValue.Type == "char")
                {
                    char left = (char)leftValue.Value;
                    char right = (char)rightValue.Value;
                    return op switch {
                        "==" => left == right,
                        "!=" => left != right,
                        ">"  => left > right,
                        "<"  => left < right,
                        ">=" => left >= right,
                        "<=" => left <= right,
                        _ => throw new NotSupportedException($"[ERROR] Linha {context.Start.Line}: Operador relacional '{op}' não suportado para char.")
                    };
                }
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Tipos incompatíveis para comparação: {leftValue.Type} e {rightValue.Type}");
            }
            else
            {
                // Sem operador relacional, trata o valor como condição
                switch (leftValue.Type)
                {
                    case "int":    return (int)leftValue.Value != 0;
                    case "float":  return (double)leftValue.Value != 0.0;
                    case "string": return !string.IsNullOrEmpty((string)leftValue.Value);
                    case "char":   return (char)leftValue.Value != '\0';
                    default:       throw new Exception($"[ERROR] Linha {context.Start.Line}: Tipo inválido para avaliação condicional: {leftValue.Type}");
                }
            }
        }
        
        // Caso 6: Se o contexto não se enquadra em nenhum dos casos acima,
        // tenta tratar o primeiro filho como uma expressão.
        if (context.ChildCount > 0 && context.GetChild(0) is LangGrammarParser.ExpressionContext exprCtx)
        {
            ReturnValue eval = EvaluateExpression(exprCtx);
            switch(eval.Type)
            {
                case "int":    return (int)eval.Value != 0;
                case "float":  return (double)eval.Value != 0.0;
                case "string": return !string.IsNullOrEmpty((string)eval.Value);
                case "char":   return (char)eval.Value != '\0';
                default:       throw new Exception($"[ERROR] Linha {context.Start.Line}: Tipo inválido para avaliação condicional: {eval.Type}");
            }
        }
        
        throw new Exception("Condição inválida ou não reconhecida.");
    }


    private int EvaluateConditionAsInt(LangGrammarParser.ExprblocoContext context){
        return EvaluateCondition(context) ? 1 : 0;
    }

    private void ExecuteBlock(LangGrammarParser.BlocoContext context){
        foreach (var linha in context.linhas())
        {
            ExecuteLinha(linha);
        }
    }

    private ReturnValue ExecuteFunctionBlock(LangGrammarParser.FunctionblockContext context, FunctionInfo functionInfo){
        foreach (var linha in context.linhas())
        {
            if (linha.returnStmt() != null)
            {
                if (functionInfo.ReturnType == "void")
                {
                    //Erro: Função 'functionInfo.Name' é do tipo void e não pode retornar valores.
                    throw new Exception($"\n[ERROR] Line {context.Start.Line}: Function '{functionInfo.Name}' is of type void and cannot return values.");
                }
                ReturnValue exprValue = EvaluateExpression(linha.returnStmt().expression());
                object returnValue;

                if (functionInfo.ReturnType == "int")
                {
                    returnValue = Convert.ToInt32(exprValue.Value);
                }
                else if (functionInfo.ReturnType == "float")
                {
                    returnValue = Convert.ToDouble(exprValue.Value);
                }
                else if (functionInfo.ReturnType == "char")
                {
                    returnValue = Convert.ToChar(exprValue.Value);
                }
                else
                {
                    throw new Exception($"[ERROR] Line {context.Start.Line}: Unsupported return type {functionInfo.ReturnType}"); //Erro: Tipo de retorno não suportado functionInfo.ReturnType.
                }
                
                return new ReturnValue { Type = functionInfo.ReturnType, Value = returnValue };
            }
            ExecuteLinha(linha);
        }
        if (functionInfo.ReturnType != "void")
        {
            //Erro: Função 'functionInfo.Name' deve retornar um valor do tipo functionInfo.ReturnType.
            throw new Exception($"\n[ERROR] Line {context.Start.Line}: Function '{functionInfo.Name}' must return a value of type {functionInfo.ReturnType}.");
        }
        return new ReturnValue { Type = functionInfo.ReturnType, Value = functionInfo.ReturnType == "int" ? 0 : (object)0.0 };
    }

    private void ExecuteInitialization(LangGrammarParser.AtribContext context){
        if (context != null)
        {
            string varName = context.VAR().GetText();
            // Avalia a expressão de inicialização
            var value = EvaluateExpression(context.expression());
            // Garante que o valor seja marcado como inicializado
            value.Initialized = true;
            _variables[varName] = value;
            Console.WriteLine($"[DEBUG] Variável '{varName}' inicializada com o valor {value.Value}");
        }
    }

    private ReturnValue EvaluateStructLiteral(LangGrammarParser.StructLiteralContext context, Dictionary<string, string> fieldDefinitions){
        // fieldDefinitions: dicionário com os nomes e tipos dos campos na ordem declarada
        var values = new List<ReturnValue>();
        var exprs = context.expression();
        foreach (var expr in exprs)
        {
            values.Add(EvaluateExpression(expr));
        }
        
        // Cria um dicionário para a instância da struct
        var structInstance = new Dictionary<string, ReturnValue>();
        int index = 0;
        foreach (var field in fieldDefinitions)
        {
            if (index < values.Count)
            {
                structInstance[field.Key] = values[index];
            }
            else
            {
                // Se não houver valor para o campo, define um valor padrão (ex.: 0 para int)
                if (field.Value == "int")
                    structInstance[field.Key] = new ReturnValue { Type = "int", Value = 0 };
                else if (field.Value == "float")
                    structInstance[field.Key] = new ReturnValue { Type = "float", Value = 0.0 };
                else if (field.Value == "char")
                    structInstance[field.Key] = new ReturnValue { Type = "char", Value = '\0' };
                else
                    structInstance[field.Key] = new ReturnValue { Type = field.Value, Value = null };
            }
            index++;
        }
        return new ReturnValue { Type = "struct", Value = structInstance };
    }

    private void ExecuteIncrement(LangGrammarParser.AtribContext context){
        if (context != null)
        {
            string varName = context.VAR().GetText();
            if (_variables.ContainsKey(varName))
            {
                // Avalia a expressão de incremento
                var value = EvaluateExpression(context.expression());
                // Marca o valor como inicializado
                value.Initialized = true;
                _variables[varName] = value;
                Console.WriteLine($"[DEBUG] Variável '{varName}' incrementada para valor {value.Value}");
            }
            else
            {
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Variável '{varName}' não inicializada antes do incremento.");
            }
        }
    }

    private string ReplaceFirst(string text, string search, string replace){
        int pos = text.IndexOf(search);
        if (pos < 0) return text;
        return text.Substring(0, pos) + replace + text.Substring(pos + search.Length);
    }

    public override void ExitGetsStmt(LangGrammarParser.GetsStmtContext context){
        try
        {
            // Obtém o nome da variável passada para gets
            string varName = context.VAR().GetText();

            // Lê a linha digitada pelo usuário sem exibir mensagem de prompt
            string input = Console.ReadLine() ?? "";

            // Se a variável foi declarada como array (por exemplo, array de char)
            if (_arrays.ContainsKey(varName))
            {
                var charList = _arrays[varName];
                for (int i = 0; i < charList.Count; i++)
                {
                    if (i < input.Length)
                    {
                        charList[i] = new ReturnValue { Type = "char", Value = input[i] };
                    }
                    else
                    {
                        // Preenche as posições restantes com o caractere nulo
                        charList[i] = new ReturnValue { Type = "char", Value = '\0' };
                    }
                }
                Console.WriteLine($"{varName} value updated.");
            }
            else
            {
                // Caso contrário, trata a variável como string
                _variables[varName] = new ReturnValue { Type = "string", Value = input };
                Console.WriteLine($"{varName} value updated.");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao processar gets: {ex.Message}");
        }
    }

    public override void ExitPutsStmt(LangGrammarParser.PutsStmtContext context){
        try{
            // Obtém o nome da variável passada para puts
            string varName = context.VAR().GetText();

            // Se a variável foi declarada no dicionário de variáveis, imprima seu valor
            if (_variables.ContainsKey(varName))
            {
                var value = _variables[varName].Value;
                Console.WriteLine(value);
            }
            // Caso a variável esteja no dicionário de arrays (por exemplo, um array de char)
            else if (_arrays.ContainsKey(varName))
            {
                var charArray = _arrays[varName];
                // Concatena os caracteres até encontrar um '\0' ou até o final do array
                string result = "";
                foreach (var rv in charArray)
                {
                    char ch = Convert.ToChar(rv.Value);
                    if (ch == '\0') break;
                    result += ch;
                }
                Console.WriteLine(result);
            }
            else
            {
                throw new Exception($"[WARNING] Linha {context.Start.Line}: Variável '{varName}' não declarada.");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Linha {context.Start.Line}: Erro ao processar puts: {ex.Message}");
        }
    }
    private ReturnValue ConvertValueToType(ReturnValue value, string targetType){
        // Se o valor já estiver no tipo esperado, retorna-o sem alteração.
        if (value.Type == targetType)
            return value;

        // Permite conversão de int para float.
        if (targetType == "float" && value.Type == "int")
            return new ReturnValue { Type = "float", Value = (double)(int)value.Value, Initialized = value.Initialized };

        // Converte char para int (usando o código ASCII).
        if (targetType == "int" && value.Type == "char")
            return new ReturnValue { Type = "int", Value = (int)(char)value.Value, Initialized = value.Initialized };

        // Converte int para char (verificando se o valor está dentro do intervalo permitido).
        if (targetType == "char" && value.Type == "int")
        {
            int intVal = (int)value.Value;
            if (intVal < Char.MinValue || intVal > Char.MaxValue)
                throw new Exception("[ERROR] Valor int fora do intervalo para char.");
            return new ReturnValue { Type = "char", Value = (char)intVal, Initialized = value.Initialized };
        }

        throw new Exception($"[ERROR] Conversão inválida: não é possível converter de {value.Type} para {targetType}.");
    }

    private ReturnValue EvaluateCallFunction(LangGrammarParser.CallFunctionContext context){
        string functionName = context.VAR().GetText();
        if (!functions.ContainsKey(functionName))
            throw new Exception($"\n[ERROR] Line {context.Start.Line}: Function '{functionName}' not declared.");

        var functionInfo = functions[functionName];
        var args = context.expression().Select(EvaluateExpression).ToList();

        // Cria escopo local
        var previousVars = new Dictionary<string, ReturnValue>(_variables);
        _variables.Clear();

        // Mapeia parâmetros
        for (int i = 0; i < functionInfo.Parameters.Count; i++)
        {
            _variables[functionInfo.Parameters[i].Name] = args[i];
        }

        // Executa o corpo
        ReturnValue result = ExecuteFunctionBlock(functionInfo.Body, functionInfo);
        _variables = previousVars; // Restaura escopo

        return result;
    
    }

    public override void EnterComentario(LangGrammarParser.ComentarioContext context)
{
    // Lógica para tratar os comentários de linha ou bloco
    if (context.COMMENTLINE() != null)
    {
        // Ação para comentários de linha
        string comentario = context.COMMENTLINE().GetText();
        Console.WriteLine($"Comentário de linha encontrado: {comentario}");
    }
    else if (context.COMMENTBLOCK() != null)
    {
        // Ação para comentários de bloco
        string comentario = context.COMMENTBLOCK().GetText();
        Console.WriteLine($"Comentário de bloco encontrado: {comentario}");
    }
}

}
