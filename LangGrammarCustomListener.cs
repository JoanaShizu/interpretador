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
    private Dictionary<string, Dictionary<string, object>> _structInstances = new Dictionary<string, Dictionary<string, object>>();

    // Todos os arrays serão armazenados aqui; cada elemento é um ReturnValue
    private readonly Dictionary<string, List<ReturnValue>> _arrays = new Dictionary<string, List<ReturnValue>>();// Para armazenar arrays
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
                throw new Exception($"Struct '{structName}' já foi declarada.");
            }   

            var fields = new Dictionary<string, string>();
            foreach (var member in context.structMember()){
                string type = member.tipo().GetText();
                string name = member.VAR().GetText();
                // Verificar se é array
                if (member.CO() != null)
                {
                    string sizeText = member.NUM()?.GetText() ?? member.CONSTANT()?.GetText();
                    int size = int.Parse(sizeText);
                    type += $"[{size}]"; // Ex: "char[50]"
                }
                fields[name] = type;
            }
            _structs[structName] = fields;
            Console.WriteLine($"Struct '{structName}' declarada com sucesso.");
        }catch(Exception ex){
            Console.WriteLine($"Erro ao declarar struct: {ex.Message}");
        }
    }

    public override void ExitStructAccess(LangGrammarParser.StructAccessContext context){
        try
        {
            string structName = context.VAR(0).GetText();
            string memberName = context.VAR(1).GetText();

            // Verifica se a struct foi instanciada
            if (!_structInstances.ContainsKey(structName))
            {
                throw new Exception($"Instância '{structName}' não foi declarada.");
            }

            var structInstance = _structInstances[structName];

            // Verifica se o membro existe na struct
            if (!structInstance.ContainsKey(memberName))
            {
                throw new Exception($"Membro '{memberName}' não existe na struct '{structName}'.");
            }

            // Avalia a expressão atribuída ao membro
            if (context.expression() != null)
            {
                var value = EvaluateExpression(context.expression());
                structInstance[memberName] = value.Value;

                Console.WriteLine($"Membro '{structName}.{memberName}' atualizado para {value.Value}");
            }
            else
            {
                var value = structInstance[memberName];
                Console.WriteLine($"Valor de '{structName}.{memberName}': {value}");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao acessar struct: {ex.Message}");
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

    public override void ExitAtrib(LangGrammarParser.AtribContext context)
    {
        try{
            string varName = context.VAR().GetText();
            if(context.tipo().GetText().StartsWith("struct") ==  true){
                string structType = context.tipo().GetText().Split(' ')[1];
                if(_structs.ContainsKey(structType)){
                    var instance = new Dictionary<string, object>();
                    foreach(var member in _structs[structType]){
                        instance[member.Key] = GetDefaultValue(member.Value);
                    }
                    _structInstances[varName] = instance;
                    //Instância de struct 'structType' criada com sucesso.
                    Console.WriteLine($"\nInstance of struct '{structType}' created successfully.");
                }
            }
            
            // Se a variável ainda não foi declarada, inicialize-a com um valor padrão (aqui, escolhemos int 0)
            if (!_variables.ContainsKey(varName))
            {
                _variables[varName] = new ReturnValue { Type = "int", Value = 0 };
                //Variável 'varName' inicializada com valor padrão 0
                Console.WriteLine($"\nVariable '{varName}' initialized with default value 0");
            }

            if (context.expression() != null)
            {
                var value = EvaluateExpression(context.expression());
                _variables[varName] = value;
                //Variável 'varName' atualizada com valor value
                Console.WriteLine($"\nVariable '{varName}' updated with value {value.Value}");
            }
        }
        catch (Exception ex)
        {
            //Erro ao processar atribuição: ex.Message
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Error processing assignment: {ex.Message}");
        }
    }

    private object GetDefaultValue(string type){
        if(type.Contains("[")) return new List<ReturnValue>();
        return type switch{
            "int" => 0,
            "float" => 0.0,
            "char" => '\0',
            //Erro: Tipo 'type' não reconhecido.
            _ => throw new Exception($"\nType '{type}' was not recognized.")
        };
    }

        // Exemplo de suporte para imprimir valores no array
    public override void ExitOutput(LangGrammarParser.OutputContext context)
    {
        try
        {
            string format = context.STR().GetText().Trim('"').Replace("\\n", "\n").Replace("\\t", "\t");
            List<ReturnValue> arguments = new List<ReturnValue>();

            foreach (var expr in context.expression())
            {
                string exprText = expr.GetText(); 

                if (exprText.Contains("."))
                {
                    string[] parts = exprText.Split('.');
                    string structName = parts[0];
                    string memberName = parts[1];

                    if (_structInstances.TryGetValue(structName, out var instance))
                    {
                        if (instance.TryGetValue(memberName, out var value)) // Corrigido nome de "instace" para "instance"
                        {
                            arguments.Add(new ReturnValue { Type = value.GetType().Name.ToLower(), Value = value });
                            continue;
                        }
                    }
                }
                arguments.Add(EvaluateExpression(expr));
            }

            foreach (var arrayAccess in context.arrayAccess())
            {
                string arrayName = arrayAccess.VAR().GetText();
                int index = EvaluateExpression(arrayAccess.expression()).Value as int? ?? 0;
                if (_arrays.ContainsKey(arrayName))
                {
                    // Supondo que o array continue sendo de int; para arrays de outros tipos, a abordagem deverá ser similar
                    arguments.Add(new ReturnValue { Type = "int", Value = _arrays[arrayName][index] });
                }
                else
                {
                    //Erro: Array 'arrayName' não declarado.
                    throw new Exception($"\n[ERROR] Line {context.Start.Line}: Array '{arrayName}' not declared.");
                }
            }

            // Exemplo simples: substitua %d, %f, %c de acordo com a ordem dos argumentos
            int idx = 0;
            while ((format.Contains("%d") || format.Contains("%f") || format.Contains("%c")) && idx < arguments.Count)
            {
                string placeholder = "";
                if (format.Contains("%d")) placeholder = "%d";
                else if (format.Contains("%f")) placeholder = "%f";
                else if (format.Contains("%c")) placeholder = "%c";

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
                format = ReplaceFirst(format, placeholder, valueStr);
                idx++;
            }
            Console.Write(format);
        }
        catch (Exception ex)
        {
            // Erro ao processar saída: ex.Message
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Error processing output, {ex.Message}");
        }
    }


    public override void ExitInput(LangGrammarParser.InputContext context)
    {
        try
        {
            string format = context.FORMAT().GetText();
            string varName = context.VAR().GetText();

            if (!_variables.ContainsKey(varName))
            {
                //Erro: Variável 'varName' não declarada.
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Variable '{varName}' not declared.");
            }

            string input = Console.ReadLine();

            if (format == "\"%d\"")
            {
                if (int.TryParse(input, out int intValue))
                {
                    _variables[varName] = new ReturnValue { Type = "int", Value = intValue };
                }
                else
                {
                    //Erro: Entrada inválida para o formato format: input
                    throw new Exception($"\n[ERROR] Line {context.Start.Line}: Invalid input for format {format}: {input}");
                }
            }
            else if (format == "\"%f\"")
            {
                if (double.TryParse(input, NumberStyles.Float, CultureInfo.InvariantCulture, out double doubleValue))
                {
                    _variables[varName] = new ReturnValue { Type = "float", Value = doubleValue };
                }
                else
                {
                    //Erro: Entrada inválida para o formato format: input
                    throw new Exception($"\n[ERROR] Line {context.Start.Line}: Invalid input for format {format}: {input}");
                }
            }
            else if (format == "\"%c\"")
            {
                if (!string.IsNullOrEmpty(input))
                {
                    _variables[varName] = new ReturnValue { Type = "char", Value = input[0] };
                }
                else
                {
                    //Erro: Entrada inválida para o formato format: input
                    throw new Exception($"\n[ERROR] Line {context.Start.Line}: Invalid input for format {format}: {input}");
                }
            }
            else
            {
                //Erro: Formato desconhecido: format
                Console.WriteLine($"\n[WARNING] Line {context.Start.Line}: Unknown format {format}");
            }
            //Variável 'varName' atualizada para valor _variables[varName]
            Console.WriteLine($"\nVariable {varName} value updated to {_variables[varName].Value}");
        }
        catch (Exception ex)
        {
            //Erro ao processar scanf: ex.Message
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Error processing scanf, {ex.Message}");
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
            //Erro ao processar if-else-if: ex.Message
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Error processing if-else-if {ex.Message}");
        }
    }

    public override void ExitSwitchCase(LangGrammarParser.SwitchCaseContext context)
    {
        try
        {
            string switchVarName = context.VAR().GetText();
            if (!_variables.ContainsKey(switchVarName))
            {
                //Erro: Variável 'switchVarName' não foi inicializada.
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Variable '{switchVarName}' was not initialized.");
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
                //Erro: Tipo inválido para switch-case switchVar.Type
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Tipo inválido para switch-case {switchVar.Type}");
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
            //Erro ao processar switch-case: ex.Message
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Error processing switch-case {ex.Message}");
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
            //Erro: Linha não reconhecida.
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Unrecognized line.");
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
            //Erro ao processar while: ex.Message
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Error processing while {ex.Message}");
        }
    }

    public override void ExitForLoop(LangGrammarParser.ForLoopContext context)
    {
        try
        {
            // Impede recursões no mesmo loop
            if (_insideForLoop)
            {
                //Erro: Tentativa de recursão no mesmo contexto de for.
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Attempt to recurse in the same context as for.");
            }

            _insideForLoop = true;

            // Inicializa a variável do loop
            if (context.atrib(0) != null)
            {
                ExecuteInitialization(context.atrib(0));
                string initVarName = context.atrib(0).VAR().GetText();
                Console.WriteLine($"[DEBUG] Variável '{initVarName}' inicializada com valor {_variables[initVarName]}");
            }

            // Executa o loop enquanto a condição for verdadeira
            while (EvaluateCondition(context.exprbloco()))
            {
                string loopVarName = context.atrib(0).VAR().GetText();
                Console.WriteLine($"[DEBUG] Avaliando variável '{loopVarName}' com valor {_variables[loopVarName]}");

                // Executa o corpo do bloco do `for`
                ExecuteBlock(context.bloco());

                // Incrementa a variável do loop
                if (context.atrib(1) != null)
                {
                    ExecuteIncrement(context.atrib(1));
                    Console.WriteLine($"[DEBUG] Variável '{context.atrib(1).VAR().GetText()}' incrementada para valor {_variables[context.atrib(1).VAR().GetText()]}");
                }
            }

            _insideForLoop = false; // Libera o controle do loop
        }
        catch (Exception ex)
        {
            //Erro ao processar for: ex.Message
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Error processing for {ex.Message}");
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
                    Console.WriteLine($"Variável '{variable.Key}' = {variable.Value}");
                }

            } while (LogConditionResult(EvaluateCondition(context.exprbloco()))); // Avalia a condição do `while`
        }
        catch (Exception ex)
        {
            //Erro ao processar do-while: ex.Message
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Error processing do-while: {ex.Message}");
        }
    }

    // Suporte para declaração e inicialização de arrays
    public override void ExitArrayDecl(LangGrammarParser.ArrayDeclContext context)
    {
        try
        {
            string arrayName = context.VAR().GetText();
            int arraySize = int.Parse(context.NUM().GetText());
            
            // Obter o tipo do array da regra "tipo"
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

    // Inicializa o array com os valores fornecidos, se houver
            var elementos = context.elementosArray();
            if (elementos != null)
            {
                // Supondo que a regra de elementosArray seja: 
                // elementosArray: expression (COMMA expression)*;
                var exprs = elementos.expression();
                for (int i = 0; i < exprs.Length && i < arraySize; i++)
                {
                    _arrays[arrayName][i] = EvaluateExpression(exprs[i]);
                }
            }
            Console.WriteLine($"Array '{arrayName}' inicializado com valores: {string.Join(", ", _arrays[arrayName].Select(e => e.Value))}");
        }
        catch (Exception ex)
        {
            //Erro ao declarar array: ex.Message
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Error declaring array {ex.Message}");
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
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Array index must be numeric."); //Erro: Índice do array deve ser numérico.
            
            if (!_arrays.ContainsKey(arrayName))
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Array '{arrayName}' not declared."); //Erro: Array 'arrayName' não declarado.
            
            if (index < 0 || index >= _arrays[arrayName].Count)
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Index  {index} out of array bounds '{arrayName}'."); //Erro: Índice index fora dos limites do array 'arrayName'.
            
            Console.WriteLine($"[DEBUG] Valor acessado: {arrayName}[{index}] = {_arrays[arrayName][index].Value}");
        }
        catch(Exception ex) {
            //Erro ao acessar array: ex.Message
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}:  Error accessing array {ex.Message}");
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
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Array index must be numeric."); //Erro: Índice do array deve ser numérico.
            
            // Avalia o novo valor
            ReturnValue newValue = EvaluateExpression(context.expression(1));
            
            if (!_arrays.ContainsKey(arrayName))
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Array '{arrayName}' not declared."); //Erro: Array 'arrayName' não declarado.
            
            if (index < 0 || index >= _arrays[arrayName].Count)
                throw new Exception($"[ERROR] Line {context.Start.Line}: Index  {index} out of array bounds '{arrayName}'."); //Erro: Índice index fora dos limites do array 'arrayName'.
            
            _arrays[arrayName][index] = newValue;
            Console.WriteLine($"Array '{arrayName}' atualizado: {arrayName}[{index}] = {newValue.Value}");
        }
        catch(Exception ex) {
            //Erro ao atualizar array: ex.Message
            Console.WriteLine($"[ERROR] Line {context.Start.Line}: Error updating array {ex.Message}");
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
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Array index must be numeric.");

            if (!_arrays.ContainsKey(arrayName))
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Array '{arrayName}' not declared."); //Erro: Array 'arrayName' não declarado.
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
                throw new NotSupportedException($"\n[ERROR] Line {context.Start.Line}: Arithmetic operator '{op}' not supported."); //Erro: Operador aritmético 'op' não suportado.
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
                    throw new Exception($"\n[ERROR] Line {context.Start.Line}: Modulo operation only supported for integers."); //Erro: Operação módulo somente suportada para inteiros.
                value = new ReturnValue { Type = "int", Value = (int)value.Value % (int)nextValue.Value };
            }
            else
            {
                //Erro: Operador 'op' não suportado.
                throw new NotSupportedException($"\n[ERROR] Line {context.Start.Line}: Operator '{op}' not supported.");
            }
        }
        return value;
    }

    // Método EvaluateFator – trata de literais, variáveis e expressões entre parênteses
    private ReturnValue EvaluateFator(LangGrammarParser.FatorContext context)
    {
        // Caso haja operador NOT (negação)
        if (context.NOT() != null)
        {
            ReturnValue value = EvaluateFator(context.fator());
            if (value.Type == "int")
                return new ReturnValue { Type = "int", Value = ((int)value.Value == 0 ? 1 : 0) };
            else if (value.Type == "float")
                return new ReturnValue { Type = "int", Value = ((double)value.Value == 0.0 ? 1 : 0) };
            else
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: NOT operation not supported for type '{value.Type}'"); //Erro: Operação NOT não suportada para tipo value.Type.
        }

        // Se for uma expressão entre parênteses
        if (context.expression() != null)
        {
            return EvaluateExpression(context.expression());
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

        // Se for um literal char (supondo que o token seja gerado e contenha aspas simples, ex.: 'a')
        if (context.CHARLIT() != null)
        {
            string charText = context.CHARLIT().GetText();
            if (charText.Length >= 3)
            {
                // Se precisar tratar sequências de escape, implemente aqui.
                char c = charText[1];
                return new ReturnValue { Type = "char", Value = c };
            }
            else
            {
                throw new Exception("Literal char inválido.");
            }
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
            else if (_variables.ContainsKey(varName)){
                return _variables[varName];
            }
            else{
                //Erro: Variável ou constante 'varName' não declarada.
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Variable or constant '{varName}' not declared.");
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

        throw new Exception($"\n[ERROR] Line {context.Start.Line}: Invalid factor.");
    }


    // Exemplo dos métodos auxiliares para operações aritméticas:
    private ReturnValue Add(ReturnValue a, ReturnValue b)
    {
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
        //Erro: Operação de adição não suportada entre tipos a.Type e b.Type.
        throw new Exception($"\n[ERROR] Line {context.Start.Line}: Addition operation not supported between types {a.Type} e {b.Type}.");
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
        throw new Exception($"\n[ERROR] Line {context.Start.Line}: Subtraction operation not supported between types {a.Type} e {b.Type}.");
    }


// Exemplo de implementação de funções auxiliares para multiplicação e divisão:
    private ReturnValue Multiply(ReturnValue a, ReturnValue b){
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
                        _ => throw new NotSupportedException($"\n[ERROR] Line {context.Start.Line}: Relational operator '{op}' not supported") //Erro: Operador relacional 'op' não suportado.
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
                        _ => throw new NotSupportedException($"\n[ERROR] Line {context.Start.Line}: Relational operator '{op}' not supported for strings.") //Erro: Operador relacional 'op' não suportado para strings.
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
                        _ => throw new NotSupportedException($"\n[ERROR] Line {context.Start.Line}: Relational operator '{op}' not supported for char.") //Erro: Operador relacional 'op' não suportado para char.
                    };
                }
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Incompatible types for comparison {leftValue.Type} and {rightValue.Type}"); //Erro: Tipos incompatíveis para comparação leftValue.Type e rightValue.Type.
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
                    default:       throw new Exception($"\n[ERROR] Line {contect.Start.Line}: Invalid type for conditional evaluation {leftValue.Type}"); //Erro: Tipo inválido para avaliação condicional: leftValue.Type.
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
                default:       throw new Exception($"\n[ERROR] Line {context.Start.Line}: Invalid type for conditional evaluation: {eval.Type}"); //Erro: Tipo inválido para avaliação condicional: eval.Type.
            }
        }
        
        throw new Exception($"\n[ERROR] Line {context.Start.Line}: Invalid or unrecognized condition.");
    }


    private int EvaluateConditionAsInt(LangGrammarParser.ExprblocoContext context)
    {
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


    private void ExecuteInitialization(LangGrammarParser.AtribContext context)
    {
        if (context != null)
        {
            string varName = context.VAR().GetText();
            if (!_variables.ContainsKey(varName))
            {
                var value = EvaluateExpression(context.expression());
                _variables[varName] = value;
                Console.WriteLine($"[DEBUG] Variável '{varName}' inicializada com o valor {value}");
            }
        }
    }

    private void ExecuteIncrement(LangGrammarParser.AtribContext context)
    {
        if (context != null)
        {
            string varName = context.VAR().GetText();
            if (_variables.ContainsKey(varName))
            {
                var value = EvaluateExpression(context.expression());
                _variables[varName] = value;
            }
            else
            {
                //Erro: Variável 'varName' não inicializada antes do incremento.
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Variable '{varName}' not initialized before increment.");
            }
        }
    }


    private string ReplaceFirst(string text, string search, string replace)
    {
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
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Erro processing gets {ex.Message}");
        }
    }

    public override void ExitPutsStmt(LangGrammarParser.PutsStmtContext context){
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
                //Erro: Variável 'varName' não declarada.
                throw new Exception($"\n[ERROR] Line {context.Start.Line}: Variable '{varName}' not declared.");
            }
        }
        catch (Exception ex)
        {
            //Erro ao processar puts: ex.Message
            Console.WriteLine($"\n[ERROR] Line {context.Start.Line}: Error processing puts {ex.Message}");
        }
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

}
