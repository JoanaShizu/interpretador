
using System;
using System.Globalization;
using System.Collections.Generic;
using System.Linq;

public class LangGrammarCustomListener : LangGrammarBaseListener{

    private Dictionary<string, ReturnValue> _variables = new Dictionary<string, ReturnValue>();

    private bool _insideForLoop = false; // Controle do contexto do `for`
    private Dictionary<string, string> defines = new Dictionary<string, string>();
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

    private Dictionary<string, string> _activeUnionMember = new Dictionary<string, string>();


    class FunctionInfo
    {
        public string ReturnType { get; set; } = string.Empty;
        public string Name { get; set; } = string.Empty;
        public List<(string Type, string Name)> Parameters { get; set; } = new List<(string, string)>();
        public LangGrammarParser.BlocoFunctionContext Body { get; set; } = null!;
    }
public class ReturnValue {
    public string Type { get; set; } = "";  // ou "int", conforme sua convenção
    public object Value { get; set; } = 0;   // ou outro valor padrão
    public bool Initialized { get; set; } = false; 
}




    public override void ExitStructDecl(LangGrammarParser.StructDeclContext context){
        try{
            string structName = context.VAR().GetText();
            if(_structs.ContainsKey(structName)){
                throw new Exception($"Struct '{structName}' já foi declarada.");
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
            Console.WriteLine($"Erro ao declarar struct: {ex.Message}");
        }
    }

    /// <summary>
    /// Atualiza (através de atribuição) um membro de uma instância de struct.
    /// Esse método é chamado quando a regra 'structAccess' é finalizada.
    /// </summary>
public override void ExitStructAccess(LangGrammarParser.StructAccessContext context)
{
    try
    {
        string varName = context.VAR(0).GetText();
        string fieldName = context.VAR(1).GetText();

        // Primeiro, verifica se a variável está declarada em _variables (structs)
        if (_variables.ContainsKey(varName))
        {
            var varValue = _variables[varName];
            if (!varValue.Type.StartsWith("struct"))
                throw new Exception($"Variável '{varName}' não é do tipo struct.");
            var instance = (Dictionary<string, ReturnValue>)varValue.Value;
            if (!instance.ContainsKey(fieldName))
                throw new Exception($"Campo '{fieldName}' não existe na struct '{varName}'.");
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
                throw new Exception($"Tipo da union para '{varName}' não foi identificado.");
            string unionType = _unionInstanceTypes[varName];
            if (!_unions[unionType].ContainsKey(fieldName))
                throw new Exception($"Campo '{fieldName}' não existe na union '{unionType}'.");
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
            throw new Exception($"Instância '{varName}' não foi declarada.");
        }
    }
    catch (Exception ex)
    {
        Console.WriteLine($"Erro ao acessar struct/union: {ex.Message}");
    }
}

    // --- Novo método: Declaração/Instanciação de uma struct ---
    // Supondo que sua gramática possua uma regra 'structInstDecl'
    public override void ExitStructInstDecl(LangGrammarParser.StructInstDeclContext context)
    {
        try
        {
            // Supondo que a sintaxe seja: "struct NomeStruct nomeInstancia = { ... };"
            // Onde o primeiro VAR é o nome do tipo e o segundo VAR é o nome da instância.
            string structType = context.VAR(0).GetText();
            string instanceName = context.VAR(1).GetText();

            if (!_structs.ContainsKey(structType))
            {
                throw new Exception($"Struct '{structType}' não foi declarada.");
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
            Console.WriteLine($"Erro ao declarar instância de struct: {ex.Message}");
        }
    }

// --- Novo método auxiliar para acesso a membros de struct em expressões ---
// Exemplo de método auxiliar para acessar membros de struct em expressões
private ReturnValue EvaluateStructAccess(LangGrammarParser.StructAccessContext context)
{
    string varName = context.VAR(0).GetText();
    string fieldName = context.VAR(1).GetText();

    if (!_variables.ContainsKey(varName))
         throw new Exception($"Variável '{varName}' não declarada.");

    var varValue = _variables[varName];
    if (!varValue.Type.StartsWith("struct"))
         throw new Exception($"Variável '{varName}' não é do tipo struct.");

    var instance = (Dictionary<string, ReturnValue>)varValue.Value;
    if (!instance.ContainsKey(fieldName))
         throw new Exception($"Campo '{fieldName}' não existe na struct '{varName}'.");

    return instance[fieldName];
}
public override void ExitUnionDecl(LangGrammarParser.UnionDeclContext context)
{
    try
    {
        string unionName = context.VAR().GetText();
        if (_unions.ContainsKey(unionName))
            throw new Exception($"Union '{unionName}' já foi declarada.");

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
        Console.WriteLine($"Erro ao declarar union: {ex.Message}");
    }
}
public override void ExitUnionAccess(LangGrammarParser.UnionAccessContext context)
{
    try
    {
        string unionInstanceName = context.GetChild(0).GetText();
        string fieldName = context.GetChild(2).GetText();

        if (!_unionInstances.ContainsKey(unionInstanceName))
            throw new Exception($"Instância de union '{unionInstanceName}' não foi declarada.");

        if (!_unionInstanceTypes.ContainsKey(unionInstanceName))
            throw new Exception($"Tipo da union para '{unionInstanceName}' não foi identificado.");

        string unionType = _unionInstanceTypes[unionInstanceName];

        if (!_unions[unionType].ContainsKey(fieldName))
            throw new Exception($"Campo '{fieldName}' não existe na union '{unionType}'.");

        var unionInstance = _unionInstances[unionInstanceName];

        if (context.ChildCount > 4) // Se for uma atribuição
        {
            ReturnValue value = EvaluateExpression(context.expression());
            string expectedType = _unions[unionType][fieldName];

            if (!IsTypeCompatible(value.Type, expectedType))
                throw new Exception($"Tipo incompatível: campo '{fieldName}' espera '{expectedType}' mas foi atribuído '{value.Type}'.");

            // Reseta todos os campos para seus valores padrão
            foreach (var key in unionInstance.Keys.ToList())
            {
                unionInstance[key] = CreateDefaultValue(_unions[unionType][key]);
            }

            // Marca apenas o campo atribuído como inicializado
            value.Initialized = true;
            unionInstance[fieldName] = value;
            // Armazena o campo ativo para esta instância
            _activeUnionMember[unionInstanceName] = fieldName;

            Console.WriteLine($"Campo '{fieldName}' da union '{unionInstanceName}' atualizado para {value.Value}");
        }
        else // Acesso (não atribuição)
        {
            if (_activeUnionMember.TryGetValue(unionInstanceName, out var activeField) && activeField == fieldName)
            {
                Console.WriteLine($"Acesso à union: {unionInstanceName}.{fieldName} = {unionInstance[fieldName].Value}");
            }
            else
            {
                Console.WriteLine($"Erro: Tentativa de acessar um tipo incorreto na union '{unionInstanceName}'!");
            }
        }
    }
    catch (Exception ex)
    {
        Console.WriteLine($"Erro ao acessar union: {ex.Message}");
    }
}
private bool IsTypeCompatible(string actual, string expected)
{
    // Para simplificar, considere que os tipos devem ser iguais.
    // Você pode expandir essa lógica para permitir, por exemplo, atribuição de int para float, se desejado.
    return actual == expected;
}

    //Arrumar o código da definição de bibliotecas
    public override void ExitIncludeDecl(LangGrammarParser.IncludeDeclContext context){
       try{
               string libName = context.LIB().GetText().Trim('<', '>', '"');
               string path;

               if(context.LIB().GetText().StartsWith("<")){
                    path = Path.Combine("Ferramentas", $"{libName}.h");
               }
               else{
                    path = Path.Combine("Ferramentas", libName);
               }
               if(File.Exists(path)){
                    string[] lines = File.ReadAllLines(path);
                    Console.WriteLine($"[INCLUDE] Biblioteca '{libName}' carregada com sucesso:");

                    foreach(string l in lines){
                        Console.WriteLine($"[INCLUDE] {l}");
                    }
                    Console.WriteLine($"Biblioteca '{libName}' incluida com sucesso");
               }
               else{
                    Console.WriteLine($"Erro: Biblioteca '{libName}' não foi possivel encontrar");        
               }
        } catch (Exception ex) {
            Console.WriteLine($"Erro ao processar #include: {ex.Message}");
        }
    }

    //Arrumar o define 
    public override void ExitDefineDecl(LangGrammarParser.DefineDeclContext context){
        try{
            string defineName = context.VAR().GetText();
            string expr = context.expression() != null ? context.expression().GetText() : null;
            
            if(!defines.ContainsKey(defineName)){
                defines[defineName] = expr;
                Console.WriteLine($"Define adicionado: {defineName} = {expr}");

            }
            else{
                Console.WriteLine($"Aviso: O define '{defineName}' já foi declarado.");

            }
        }catch(Exception ex){
            Console.WriteLine($"Error: have a problem to process define: {ex.Message}");
        }

    }
    //A declaração funciona corretamente 
public override void ExitFunctionDecl(LangGrammarParser.FunctionDeclContext context)
{
    try
    {
        // Obtém o tipo de retorno e o nome da função
        string returnType = context.tipo().GetText().Trim();
        string functionName = context.VAR().GetText().Trim();
        
        // Extrai os parâmetros (supondo que a regra 'parametros' contenha uma lista de "tipo VAR" separados por vírgula)
        var parameters = new List<(string Type, string Name)>();
        if (context.parametros() != null)
        {
            var paramCtx = context.parametros();
            for (int i = 0; i < paramCtx.ChildCount; i += 3)
            {
                string paramType = paramCtx.GetChild(i).GetText().Trim();
                string paramName = paramCtx.GetChild(i + 1).GetText().Trim();
                parameters.Add((paramType, paramName));
            }
        }
        
        // Obtém o corpo da função (supõe que esteja na regra 'blocoFunction')
        var body = context.blocoFunction();
        
        // Cria o objeto FunctionInfo
        FunctionInfo funcInfo = new FunctionInfo
        {
            ReturnType = returnType,
            Name = functionName,
            Parameters = parameters,
            Body = body
        };

        if (functions.ContainsKey(functionName))
            throw new Exception($"A função '{functionName}' já foi declarada.");

        functions[functionName] = funcInfo;
        Console.WriteLine($"Função '{functionName}' declarada com sucesso.");
    }
    catch (Exception ex)
    {
        Console.WriteLine($"Erro ao declarar função: {ex.Message}");
    }
}

public override void ExitFunctionCall(LangGrammarParser.FunctionCallContext context)
{
    try
    {
        string functionName = context.VAR().GetText().Trim();
        if (!functions.ContainsKey(functionName))
            throw new Exception($"Função '{functionName}' não foi declarada.");
        FunctionInfo funcInfo = functions[functionName];
        var oldVariables = new Dictionary<string, ReturnValue>(_variables);
        _variables.Clear();

        // Associa os argumentos aos parâmetros e realiza a conversão para o tipo esperado
        var argCtxList = context.argumentos()?.expression();
        if (funcInfo.Parameters.Count > 0 && argCtxList != null)
        {
            for (int i = 0; i < funcInfo.Parameters.Count; i++)
            {
                string paramName = funcInfo.Parameters[i].Name;
                string expectedType = funcInfo.Parameters[i].Type;
                ReturnValue argValue = EvaluateExpression(argCtxList[i]);
                argValue = ConvertValueToType(argValue, expectedType);
                argValue.Initialized = true;
                _variables[paramName] = argValue;
            }
        }

        _lastReturnValue = ExecuteFunctionBlock(funcInfo.Body, funcInfo);
        _variables = oldVariables;
        Console.WriteLine($"Função '{functionName}' chamada com sucesso. Retorno: {_lastReturnValue.Value}");
    }
    catch (Exception ex)
    {
        Console.WriteLine($"Erro ao processar chamada de função: {ex.Message}");
    }
}
private ReturnValue EvaluateFunctionCallFromArguments(string functionName, List<LangGrammarParser.ExpressionContext> args)
{
    // Se for função built-in, trate-a separadamente.
    if (functionName == "atoi" || functionName == "atof")
    {
        // Se nenhum argumento foi passado, retorne um valor padrão
        if (args.Count == 0)
        {
            if (functionName == "atoi")
                return new ReturnValue { Type = "int", Value = 0, Initialized = true };
            else // atof
                return new ReturnValue { Type = "float", Value = 0.0, Initialized = true };
        }
        
        List<ReturnValue> evaluatedArgs = new List<ReturnValue>();
        foreach (var expr in args)
        {
            evaluatedArgs.Add(EvaluateExpression(expr));
        }
        return EvaluateBuiltInFunction(functionName, evaluatedArgs);
    }
    
    // Processo normal para funções declaradas:
    var evaluatedArgsNormal = new List<ReturnValue>();
    foreach (var expr in args)
    {
        evaluatedArgsNormal.Add(EvaluateExpression(expr));
    }
    
    var oldVariables = new Dictionary<string, ReturnValue>(_variables);
    var newEnv = new Dictionary<string, ReturnValue>(oldVariables);
    
    if (!functions.ContainsKey(functionName))
        throw new Exception($"Função '{functionName}' não foi declarada.");
    
    FunctionInfo funcInfo = functions[functionName];
    for (int i = 0; i < funcInfo.Parameters.Count; i++)
    {
        string paramName = funcInfo.Parameters[i].Name;
        string expectedType = funcInfo.Parameters[i].Type;
        if (i < evaluatedArgsNormal.Count)
        {
            evaluatedArgsNormal[i] = ConvertValueToType(evaluatedArgsNormal[i], expectedType);
            evaluatedArgsNormal[i].Initialized = true;
            newEnv[paramName] = evaluatedArgsNormal[i];
        }
        else
        {
            newEnv[paramName] = CreateDefaultValue(funcInfo.Parameters[i].Type);
        }
    }
    _variables = newEnv;
    ReturnValue ret = ExecuteFunctionBlock(funcInfo.Body, funcInfo);
    _variables = oldVariables;
    return ret;
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

public override void ExitAtrib(LangGrammarParser.AtribContext context)
{
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
                    throw new Exception($"Struct '{structType}' não foi declarada.");
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
                        throw new Exception("Inicializador inválido para struct. Use a sintaxe { ... }.");
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
                    throw new Exception($"Union '{unionType}' não foi declarada.");

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
                    Console.WriteLine($"Erro: Tipo incompatível: variável '{varName}' espera '{typeText}', mas o valor é do tipo '{value.Type}'.");
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
            // Atribuição sem declaração de tipo (ex.: "x = expressão;")
            string varName = context.VAR().GetText();
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
                    value = ConvertValueToType(value, declaredType);
                    value.Initialized = true;
                    _variables[varName] = value;
                    Console.WriteLine($"Variável '{varName}' atualizada com valor {value.Value}");
                }
            }
        }
    }
    catch (Exception ex)
    {
        Console.WriteLine($"Erro ao processar atribuição: {ex.Message}");
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
                throw new Exception("Tipo de argumento não suportado no printf.");
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
        Console.WriteLine($"Erro ao processar output: {ex.Message}");
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
        throw new Exception("Índice do array deve ser numérico.");

    if (!_arrays.ContainsKey(arrayName))
        throw new Exception($"Array '{arrayName}' não declarado.");

    if (index < 0 || index >= _arrays[arrayName].Count)
        throw new Exception($"Índice {index} fora dos limites do array '{arrayName}'.");

    return _arrays[arrayName][index];
}

private ReturnValue EvaluateStructFieldAccess(LangGrammarParser.StructFieldAccessContext context)
{
    // Supondo que a regra structFieldAccess seja: VAR DOT VAR
    string varName = context.GetChild(0).GetText();
    string fieldName = context.GetChild(2).GetText(); // O filho 1 é o token DOT

    if (!_variables.ContainsKey(varName))
         throw new Exception($"Variável '{varName}' não declarada.");

    var varValue = _variables[varName];
    // Aceitamos tanto se o tipo começar com "struct" quanto com "union"
    if (!varValue.Type.StartsWith("struct") && !varValue.Type.StartsWith("union"))
         throw new Exception($"Variável '{varName}' não é do tipo struct ou union.");

    var instance = (Dictionary<string, ReturnValue>)varValue.Value;
    if (!instance.ContainsKey(fieldName))
         throw new Exception($"Campo '{fieldName}' não existe na variável '{varName}'.");
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
            throw new Exception($"Variável '{varName}' não declarada.");

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
                throw new Exception($"Entrada inválida para o formato {format}: {input}");
        }
        else if (format == "\"%f\"")
        {
            if (double.TryParse(input, NumberStyles.Float, CultureInfo.InvariantCulture, out double doubleValue))
            {
                _variables[varName].Value = doubleValue;
                _variables[varName].Initialized = true;
            }
            else
                throw new Exception($"Entrada inválida para o formato {format}: {input}");
        }
        else if (format == "\"%c\"")
        {
            if (!string.IsNullOrEmpty(input))
            {
                _variables[varName].Value = input[0];
                _variables[varName].Initialized = true;
            }
            else
                throw new Exception($"Entrada inválida para o formato {format}: {input}");
        }
        else if (format == "\"%s\"")
        {
            _variables[varName].Value = input;
            _variables[varName].Initialized = true;
        }
        else
        {
            Console.WriteLine($"Formato desconhecido: {format}");
        }

        Console.WriteLine($"{varName} value updated to {_variables[varName].Value}");
    }
    catch (Exception ex)
    {
        Console.WriteLine($"Error processing scanf: {ex.Message}");
    }
}


public override void ExitDecisionFunc(LangGrammarParser.DecisionFuncContext context)
{
    try
    {
        int numCondicoes = context.exprbloco().Length;
        // Percorre as condições do if e dos else if
        for (int i = 0; i < numCondicoes; i++)
        {
            bool condicao = EvaluateCondition(context.exprbloco(i));
            if (condicao)
            {
                if (i == 0)
                    Console.WriteLine("Executando bloco 'if'");
                else
                    Console.WriteLine($"Executando bloco 'else if' (condição {i})");

                ExecuteBlock(context.bloco(i));
                return; // Sai imediatamente ao encontrar a primeira condição verdadeira
            }
        }

        // Se houver bloco 'else' (normalmente o último bloco)
        if (context.bloco().Length > numCondicoes)
        {
            Console.WriteLine("Executando bloco 'else'");
            ExecuteBlock(context.bloco(context.bloco().Length - 1));
        }
    }
    catch (Exception ex)
    {
        Console.WriteLine($"Erro ao processar if-else-if: {ex.Message}");
    }
}


public override void ExitSwitchCase(LangGrammarParser.SwitchCaseContext context)
{
    try
    {
        string switchVarName = context.VAR().GetText();
        if (!_variables.ContainsKey(switchVarName))
        {
            throw new Exception($"Variável '{switchVarName}' não foi inicializada.");
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
            throw new Exception($"Tipo inválido para switch-case: {switchVar.Type}");
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
        Console.WriteLine($"Erro ao processar switch-case: {ex.Message}");
    }
}


    private void ExecuteLinha(LangGrammarParser.LinhasContext linha)
    {
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
            Console.WriteLine($"Erro ao processar while: {ex.Message}");
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
        Console.WriteLine($"Erro ao processar for: {ex.Message}");
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
            Console.WriteLine($"Erro ao processar do-while: {ex.Message}");
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
        Console.WriteLine($"Erro ao declarar array: {ex.Message}");
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
            throw new Exception("Índice do array deve ser numérico.");
        
        if (!_arrays.ContainsKey(arrayName))
            throw new Exception($"Array '{arrayName}' não declarado.");
        
        if (index < 0 || index >= _arrays[arrayName].Count)
            throw new Exception($"Índice {index} fora dos limites do array '{arrayName}'.");
        
        Console.WriteLine($"[DEBUG] Valor acessado: {arrayName}[{index}] = {_arrays[arrayName][index].Value}");
    }
    catch(Exception ex) {
        Console.WriteLine($"Erro ao acessar array: {ex.Message}");
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
            throw new Exception("Índice do array deve ser numérico.");
        
        // Avalia o novo valor
        ReturnValue newValue = EvaluateExpression(context.expression(1));
        
        if (!_arrays.ContainsKey(arrayName))
            throw new Exception($"Array '{arrayName}' não declarado.");
        
        if (index < 0 || index >= _arrays[arrayName].Count)
            throw new Exception($"Índice {index} fora dos limites do array '{arrayName}'.");
        
        _arrays[arrayName][index] = newValue;
        Console.WriteLine($"Array '{arrayName}' atualizado: {arrayName}[{index}] = {newValue.Value}");
    }
    catch(Exception ex) {
        Console.WriteLine($"Erro ao atualizar array: {ex.Message}");
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
            throw new Exception("Índice do array deve ser numérico.");

        if (!_arrays.ContainsKey(arrayName))
            throw new Exception($"Array '{arrayName}' não declarado.");
        return _arrays[arrayName][index];
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
            throw new NotSupportedException($"Operador aritmético '{op}' não suportado.");
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
                throw new Exception("Operação módulo somente suportada para inteiros.");
            value = new ReturnValue { Type = "int", Value = (int)value.Value % (int)nextValue.Value };
        }
        else
        {
            throw new NotSupportedException($"Operador '{op}' não suportado.");
        }
    }
    return value;
}

// Método EvaluateFator – trata de literais, variáveis e expressões entre parênteses
private ReturnValue EvaluateFator(LangGrammarParser.FatorContext context)
{
    // Se houver operador NOT (negação)
    if (context.NOT() != null)
    {
        ReturnValue value = EvaluateFator(context.fator());
        if (value.Type == "int")
            return new ReturnValue { Type = "int", Value = ((int)value.Value == 0 ? 1 : 0) };
        else if (value.Type == "float")
            return new ReturnValue { Type = "int", Value = ((double)value.Value == 0.0 ? 1 : 0) };
        else
            throw new Exception("Operação NOT não suportada para tipo " + value.Type);
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
            throw new Exception("Índice do array deve ser numérico.");

        if (!_arrays.ContainsKey(arrayName))
            throw new Exception($"Array '{arrayName}' não declarado.");
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
            throw new Exception($"Variável '{varName}' não declarada.");

        var varValue = _variables[varName];

        // Aceita tanto se o tipo começar com "struct" quanto com "union"
        if (!varValue.Type.StartsWith("struct") && !varValue.Type.StartsWith("union"))
            throw new Exception($"Variável '{varName}' não é do tipo struct ou union.");

        var instance = (Dictionary<string, ReturnValue>)varValue.Value;
        if (!instance.ContainsKey(fieldName))
            throw new Exception($"Campo '{fieldName}' não existe na variável '{varName}'.");
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
                Value = double.Parse(numText, CultureInfo.InvariantCulture),
                Initialized = true 
            };
        }
        else
        {
            return new ReturnValue 
            { 
                Type = "int", 
                Value = int.Parse(numText),
                Initialized = true 
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
        if (_variables.ContainsKey(varName))
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
        throw new Exception($"Variável '{varName}' não declarada.");
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

    throw new Exception("Fator inválido.");
}

private ReturnValue EvaluateFunctionCallFromFator(LangGrammarParser.FatorContext context)
{
    // Obtém o nome da função (primeiro token VAR)
    string functionName = context.VAR().GetText().Trim();

    // Tenta obter o contexto de argumentos
    List<LangGrammarParser.ExpressionContext> args = new List<LangGrammarParser.ExpressionContext>();
    var argsContext = context.GetRuleContext<LangGrammarParser.ArgumentosContext>(0);
    if (argsContext != null)
    {
        args = argsContext.expression().ToList();
    }
    else
    {
        // Se não houver ArgumentosContext e houver pelo menos 3 filhos, tenta extrair manualmente o argumento
        if (context.ChildCount >= 3)
        {
            var possibleArg = context.GetChild(2);
            if (possibleArg is LangGrammarParser.ExpressionContext exprCtx)
                args.Add(exprCtx);
            // Caso contrário, a lista permanece vazia
        }
    }
    
    return EvaluateFunctionCallFromArguments(functionName, args);
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
private bool EvaluateCondition(LangGrammarParser.ExprblocoContext context)
{
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
                    _ => throw new NotSupportedException($"Operador relacional '{op}' não suportado")
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
                    _ => throw new NotSupportedException($"Operador relacional '{op}' não suportado para strings.")
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
                    _ => throw new NotSupportedException($"Operador relacional '{op}' não suportado para char.")
                };
            }
            throw new Exception($"Tipos incompatíveis para comparação: {leftValue.Type} e {rightValue.Type}");
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
                default:       throw new Exception("Tipo inválido para avaliação condicional: " + leftValue.Type);
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
            default:       throw new Exception("Tipo inválido para avaliação condicional: " + eval.Type);
        }
    }
    
    throw new Exception("Condição inválida ou não reconhecida.");
}


    private int EvaluateConditionAsInt(LangGrammarParser.ExprblocoContext context)
    {
        return EvaluateCondition(context) ? 1 : 0;
    }

    private void ExecuteBlock(LangGrammarParser.BlocoContext context)
    {
        foreach (var linha in context.linhas())
        {
            ExecuteLinha(linha);
        }
    }
    
private ReturnValue ExecuteFunctionBlock(LangGrammarParser.BlocoFunctionContext context, FunctionInfo functionInfo)
{
    foreach (var linha in context.linhas())
    {
        if (linha.returnStmt() != null)
        {
            if (functionInfo.ReturnType == "void")
            {
                throw new Exception($"Função '{functionInfo.Name}' é do tipo void e não pode retornar valores.");                
            }
            // Armazena o resultado da expressão em um ReturnValue
            ReturnValue exprValue = EvaluateExpression(linha.returnStmt().expression());
            int returnValue;

            // Aqui você pode tratar a conversão conforme o tipo esperado.
            if (exprValue.Type == "int")
            {
                returnValue = (int)exprValue.Value;
            }
            else if (exprValue.Type == "float")
            {
                // Exemplo de conversão: se a função espera int, converte de float para int.
                returnValue = (int)(double)exprValue.Value;
            }
            else
            {
                throw new Exception($"Tipo de retorno não suportado: {exprValue.Type}");
            }
            
            // Retorna o resultado encapsulado em um ReturnValue
            return new ReturnValue { Type = "int", Value = returnValue };
        }
        ExecuteLinha(linha);
    }
    if (functionInfo.ReturnType != "void")
    {
        throw new Exception($"Função '{functionInfo.Name}' deve retornar um valor do tipo {functionInfo.ReturnType}.");
    }
    return new ReturnValue { Type = "int", Value = 0 };
}


    private void ExecuteInitialization(LangGrammarParser.AtribContext context)
    {
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



private ReturnValue EvaluateStructLiteral(LangGrammarParser.StructLiteralContext context, Dictionary<string, string> fieldDefinitions)
{
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


    private void ExecuteIncrement(LangGrammarParser.AtribContext context)
    {
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
                throw new Exception($"Variável '{varName}' não inicializada antes do incremento.");
            }
        }
    }



    private string ReplaceFirst(string text, string search, string replace)
    {
        int pos = text.IndexOf(search);
        if (pos < 0) return text;
        return text.Substring(0, pos) + replace + text.Substring(pos + search.Length);
    }


public override void ExitGetsStmt(LangGrammarParser.GetsStmtContext context)
{
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
        Console.WriteLine($"Erro ao processar gets: {ex.Message}");
    }
}

public override void ExitPutsStmt(LangGrammarParser.PutsStmtContext context)
{
    try
    {
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
            throw new Exception($"Variável '{varName}' não declarada.");
        }
    }
    catch (Exception ex)
    {
        Console.WriteLine($"Erro ao processar puts: {ex.Message}");
    }
}
private ReturnValue ConvertValueToType(ReturnValue value, string targetType)
{
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
            throw new Exception("Valor int fora do intervalo para char.");
        return new ReturnValue { Type = "char", Value = (char)intVal, Initialized = value.Initialized };
    }

    throw new Exception($"Conversão inválida: não é possível converter de {value.Type} para {targetType}.");
}

}
