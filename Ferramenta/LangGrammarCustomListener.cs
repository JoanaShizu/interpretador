public class LangGrammarCustomListener : LangGrammarBaseListener{
    private Dictionary<string, object> _variables = new Dictionary<string, object>();
    
    private bool _insideForLoop = false; // Controle do contexto do `for`
    private Dictionary<string, string> defines = new Dictionary<string, string>();
    private Dictionary<string, FunctionInfo> functions = new Dictionary<string, FunctionInfo>();
    private Stack<int> _returnStack = new Stack<int>();
    private int _lastReturnValue;
    private Dictionary<string, Dictionary<string, string>> _structs = new Dictionary<string, Dictionary<string, string>>();
    private Dictionary<string, Dictionary<string, object>> _structInstances = new Dictionary<string, Dictionary<string, object>>();
    //private readonly Dictionary<string, List<int>> _arrays = new Dictionary<string, List<int>>(); // Para armazenar arrays
    private Dictionary<string, List<int>> _arrays = new();

public LangGrammarCustomListener()
{
    _variables = new Dictionary<string, object>();
}
    class FunctionInfo
    {
        public string ReturnType { get; set; } = string.Empty;
        public string Name { get; set; } = string.Empty;
        public List<(string Type, string Name)> Parameters { get; set; } = new List<(string, string)>();
        public LangGrammarParser.BlocoFunctionContext Body { get; set; } = null!;
    }
        public class ReturnValue {
        public string Type { get; set; } // Tipo do retorno (int, float, char, etc.)
        public object Value { get; set; } // Valor genérico
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

     public override void ExitStructAccess(LangGrammarParser.StructAccessContext context)
    {
        try
        {
            string structName = context.VAR(0).GetText();
            string memberName = context.VAR(1).GetText();

            if (!_structInstances.ContainsKey(structName))
            {
                throw new Exception($"Instância '{structName}' não foi declarada.");
            }

            var structInstance = _structInstances[structName];
            if (!structInstance.ContainsKey(memberName))
            {
                throw new Exception($"Membro '{memberName}' não existe na struct '{structName}'.");
            }

            int value = EvaluateExpression(context.expression());
            structInstance[memberName] = value;

            Console.WriteLine($"Membro '{memberName}' da struct '{structName}' atualizado para {value}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao acessar struct: {ex.Message}");
        }
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
    public override void ExitFunctionDecl(LangGrammarParser.FunctionDeclContext context){
        try
        {
            // Obter tipo de retorno e nome da função
            string returnType = context.tipo().GetText();
            string functionName = context.VAR().GetText();
            
            var parameters = new List<(string Type, string Name)>();
            if(context.parametros() != null){
                var param = context.parametros();
                for(int i = 0; i < param.ChildCount; i+=3){
                    string type = param.GetChild(i).GetText();
                    string name = param.GetChild(i+1).GetText();
                    parameters.Add((type, name));
                }
            }

            var functionInfo = new FunctionInfo{
                ReturnType = returnType,
                Name = functionName,
                Parameters = parameters,
                Body = context.blocoFunction()
            };

            if(functions.ContainsKey(functionName)){
                throw new Exception($"A função '{functionName}' já foi declarada.");
            }

            functions[functionName] = functionInfo;
            Console.WriteLine($"Função '{functionName}' declarada com sucesso.");

        }catch(Exception ex){
            Console.WriteLine($"Erro ao declarar a função: {ex.Message}");

        }
    }
    //Arrumar a chamada de função (não funciona corretamente )
    public override void ExitFunctionCall(LangGrammarParser.FunctionCallContext context)
    {
        try
        {
            string functionName = context.VAR().GetText();

            if (!functions.ContainsKey(functionName))
            {
                throw new Exception($"Função '{functionName}' não foi declarada.");
            }

            var functionInfo = functions[functionName];

            // Clona o dicionário com valores como object
            var previousVariables = _variables.ToDictionary(kv => kv.Key, kv => kv.Value);

            _variables.Clear();

            var expressions = context.children.OfType<LangGrammarParser.ExpressionContext>().ToList();
            for (int i = 0; i < functionInfo.Parameters.Count; i++)
            {
                string paramName = functionInfo.Parameters[i].Name;
                int paramValue = EvaluateExpression(expressions[i]); // Certifique-se de que EvaluateExpression retorna um int
                _variables[paramName] = paramValue; // Armazena como object
            }

            _lastReturnValue = ExecuteFunctionBlock(functionInfo.Body, functionInfo);

            // Restaura os valores do dicionário original
            _variables = previousVariables;

            Console.WriteLine($"Função '{functionName}' chamada com sucesso. Retorno: {_lastReturnValue}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao processar chamada de função: {ex.Message}");
        }
    }


    public override void ExitAtrib(LangGrammarParser.AtribContext context)
    {
        try
        {
            string varName = context.VAR().GetText(); // Nome da variável
            string tipo = context.tipo().GetText(); // Tipo da variável
            var expr = context.expression(); // Expressão de inicialização (opcional)

            // Inicializa o dicionário de variáveis
            _variables ??= new Dictionary<string, object>();

            if (tipo == "int")
            {
                // Inicializa uma variável inteira
                if (expr != null)
                {
                    _variables[varName] = EvaluateExpression(expr); // Atribui o valor inicial
                }
                else
                {
                    _variables[varName] = 0; // Valor padrão
                }
            }
            else if (tipo == "float")
            {
                // Inicializa uma variável float
                if (expr != null)
                {
                    _variables[varName] = Convert.ToSingle(EvaluateExpression(expr));
                }
                else
                {
                    _variables[varName] = 0.0f; // Valor padrão
                }
            }
            else if (tipo == "char")
            {
                // Inicializa uma variável char
                if (expr != null)
                {
                    string charValue = EvaluateExpression(expr).ToString();
                    if (charValue.Length == 1)
                    {
                        _variables[varName] = charValue[0];
                    }
                    else
                    {
                        throw new Exception($"Erro: Valor '{charValue}' não é um caractere válido.");
                    }
                }
                else
                {
                    _variables[varName] = '\0'; // Valor padrão
                }
            }
            else
            {
                throw new Exception($"Erro: Tipo '{tipo}' não é suportado.");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao declarar variável: {ex.Message}");
        }
    }
    // Substitui apenas a primeira ocorrência de um placeholder
    private string ReplaceFirst(string text, string search, string replace)
    {
        int pos = text.IndexOf(search);
        if (pos < 0)
            return text;
        return text.Substring(0, pos) + replace + text.Substring(pos + search.Length);
    }

    public override void ExitOutput(LangGrammarParser.OutputContext context)
    {
        try
        {
            // Obtém a string formatada
            string format = context.STR().GetText().Trim('"').Replace("\\n", "\n").Replace("\\t", "\t");
            List<string> arguments = new List<string>();

            // Processa as expressões fornecidas
            foreach (var expr in context.expression())
            {
                arguments.Add(EvaluateExpression(expr).ToString());
            }

            // Processa acessos a arrays
            foreach (var arrayAccess in context.arrayAccess())
            {
                string arrayName = arrayAccess.VAR().GetText();
                int index = EvaluateExpression(arrayAccess.expression());

                if (_arrays.ContainsKey(arrayName))
                {
                    var array = _arrays[arrayName];
                    if (index >= 0 && index < array.Count)
                    {
                        arguments.Add(array[index].ToString());
                    }
                    else
                    {
                        throw new IndexOutOfRangeException($"Índice '{index}' fora dos limites do array '{arrayName}'.");
                    }
                }
                else
                {
                    throw new Exception($"Array '{arrayName}' não declarado.");
                }
            }

            // Substitui os placeholders na ordem correta
            string output = format;
            int idx = 0;
            while (output.Contains("%") && idx < arguments.Count)
            {
                string placeholder = FindNextPlaceholder(output);
                if (placeholder == "%d" || placeholder == "%f" || placeholder == "%c" || placeholder == "%s")
                {
                    output = ReplaceFirst(output, placeholder, arguments[idx]);
                    idx++;
                }
                else
                {
                    throw new Exception($"Placeholder '{placeholder}' não suportado.");
                }
            }

            // Verifica se ainda existem placeholders não substituídos
            if (output.Contains("%"))
            {
                throw new Exception("Número insuficiente de argumentos para preencher todos os placeholders.");
            }

            // Imprime a saída
            Console.Write(output);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao processar output: {ex.Message}");
        }
    }

    // Encontra o próximo placeholder na string formatada
    private string FindNextPlaceholder(string format)
    {
        int minIndex = int.MaxValue;
        string nextPlaceholder = "";

        string[] placeholders = { "%d", "%f", "%c", "%s" };
        foreach (var placeholder in placeholders)
        {
            int index = format.IndexOf(placeholder);
            if (index != -1 && index < minIndex)
            {
                minIndex = index;
                nextPlaceholder = placeholder;
            }
        }

        return nextPlaceholder;
    }


    public override void ExitInput(LangGrammarParser.InputContext context)
    {
        try
        {
            string format = context.FORMAT().GetText().Trim('"');
            string varName = context.VAR().GetText();

            // Inicializa o dicionário de variáveis, se necessário
            _variables ??= new Dictionary<string, object>();

            // Não exibe mensagem extra, pois o printf já foi processado
            string? input = Console.ReadLine()?.Trim();

            if (format == "%d")
            {
                if (int.TryParse(input, out int intValue))
                {
                    _variables[varName] = intValue; // Armazena o valor como inteiro
                }
                else
                {
                    throw new Exception($"Entrada inválida para o formato {format}. Esperava-se um número inteiro.");
                }
            }
            else if (format == "%s")
            {
                _variables[varName] = input ?? string.Empty; // Armazena como string
            }
            else
            {
                throw new Exception($"Formato '{format}' não suportado.");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro durante a execução do input: {ex.Message}");
        }
    }

    public override void ExitGetsStmt(LangGrammarParser.GetsStmtContext context)
    {
        try
        {
            string varName = context.VAR().GetText();

            // Inicializa o dicionário de variáveis, se necessário
            _variables ??= new Dictionary<string, object>();

            // O printf anterior já deve exibir "Digite uma string:"
            string input = Console.ReadLine() ?? string.Empty;

            // Limita o tamanho da string para simular gets
            if (input.Length > 256)
            {
                input = input.Substring(0, 256);
            }

            _variables[varName] = input;
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro durante a execução do gets: {ex.Message}");
        }
    }

    public override void ExitPutsStmt(LangGrammarParser.PutsStmtContext context)
    {
        try
        {
            string varName = context.VAR().GetText();

            // Inicializa o dicionário de variáveis, se necessário
            _variables ??= new Dictionary<string, object>();

            if (_variables.TryGetValue(varName, out object? value))
            {
                Console.WriteLine(value?.ToString() ?? string.Empty);
            }
            else
            {
                throw new Exception($"Variável '{varName}' não foi inicializada.");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro durante a execução do puts: {ex.Message}");
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

            // Converte explicitamente o valor para `int`
            if (!(_variables[switchVarName] is int switchValue))
            {
                throw new Exception($"O valor da variável '{switchVarName}' não é um inteiro.");
            }

            bool caseMatched = false;

            // Itera sobre os blocos `case`
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

            // Se nenhum `case` foi correspondente, executa o bloco `default`
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
                Console.WriteLine("[DEBUG] Condição verdadeira. Executando corpo do while.");

                // Executa o bloco do corpo do `while`
                ExecuteBlock(context.bloco());

                // Reavalia a condição após cada iteração
                if (!EvaluateCondition(context.exprbloco()))
                {
                    Console.WriteLine("[DEBUG] Condição falsa. Saindo do loop while.");
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
            Console.WriteLine("Iniciando loop for.");

            // Inicializa a variável do loop
            ExecuteInitialization(context.atrib(0));
            string initVarName = context.atrib(0).VAR().GetText();
            Console.WriteLine($"[DEBUG] Variável '{initVarName}' inicializada com valor {_variables[initVarName]}");

            // Executa o loop enquanto a condição for verdadeira
            while (EvaluateCondition(context.exprbloco()))
            {
                Console.WriteLine($"[DEBUG] Avaliando variável '{initVarName}' com valor {_variables[initVarName]}");

                // Executa o corpo do bloco do `for`
                ExecuteBlock(context.bloco());

                // Incrementa a variável do loop
                if (context.atrib(1) != null)
                {
                    ExecuteIncrement(context.atrib(1));
                    Console.WriteLine($"[DEBUG] Variável '{context.atrib(1).VAR().GetText()}' incrementada para valor {_variables[context.atrib(1).VAR().GetText()]}");
                }
            }

            Console.WriteLine("Saindo do loop for.");
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
            Console.WriteLine("Iniciando loop do-while.");

            do
            {
                Console.WriteLine("[DEBUG] Executando corpo do do-while.");

                // Executa o bloco do `do`
                ExecuteBlock(context.bloco());

                // Mostra o estado atual de todas as variáveis
                Console.WriteLine("Estado das variáveis após execução do bloco:");
                foreach (var variable in _variables)
                {
                    Console.WriteLine($"[DEBUG] Variável '{variable.Key}' = {variable.Value}");
                }
            }
            while (EvaluateCondition(context.exprbloco())); // Avalia a condição do `while`

            Console.WriteLine("Saindo do loop do-while.");
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
            int arraySize = int.Parse(context.NUM().GetText());

            // Verifica se o tamanho do array é válido
            if (arraySize <= 0)
            {
                throw new Exception($"Erro: O tamanho do array '{arrayName}' deve ser maior que zero.");
            }

            // Verifica se o array já foi declarado
            if (_arrays.ContainsKey(arrayName))
            {
                throw new Exception($"Erro: Array '{arrayName}' já declarado.");
            }

            // Inicializa o array com valores padrão (0)
            List<int> array = new List<int>();
            for (int i = 0; i < arraySize; i++)
            {
                array.Add(0); // Adiciona valores padrão (0)
            }

            _arrays[arrayName] = array;

            Console.WriteLine($"Array '{arrayName}' declarado com tamanho {arraySize}.");

            // Verifica se há valores iniciais fornecidos
            var expressions = context.children.OfType<LangGrammarParser.ExpressionContext>().ToList();
            if (expressions.Count > arraySize)
            {
                throw new Exception($"Erro: Número de valores iniciais excede o tamanho do array '{arrayName}'.");
            }

            // Preenche o array com os valores fornecidos
            for (int i = 0; i < expressions.Count; i++)
            {
                array[i] = EvaluateExpression(expressions[i]);
            }

            Console.WriteLine($"Array '{arrayName}' inicializado com valores: {string.Join(", ", array)}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao declarar array '{context.VAR().GetText()}': {ex.Message}");
        }
    }


    // Suporte para acessar valores no array
     public override void ExitArrayAccess(LangGrammarParser.ArrayAccessContext context)
    {
        try
        {
            string arrayName = context.VAR().GetText();
            int index = EvaluateExpression(context.expression());

            if (_arrays.ContainsKey(arrayName))
            {
                if (index >= 0 && index < _arrays[arrayName].Count)
                {
                    Console.WriteLine($"[DEBUG] Valor acessado: {arrayName}[{index}] = {_arrays[arrayName][index]}");
                }
                else
                {
                    throw new Exception($"Índice '{index}' fora dos limites do array '{arrayName}'.");
                }
            }
            else
            {
                throw new Exception($"Array '{arrayName}' não declarado.");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao acessar array: {ex.Message}");
        }
    }

    // Suporte para atualizar valores no array
    public override void ExitArrayUpdate(LangGrammarParser.ArrayUpdateContext context)
    {
        try
        {
            string arrayName = context.VAR().GetText();
            int index = EvaluateExpression(context.expression(0));
            int newValue = EvaluateExpression(context.expression(1));

            if (_arrays.ContainsKey(arrayName))
            {
                if (index >= 0 && index < _arrays[arrayName].Count)
                {
                    _arrays[arrayName][index] = newValue;
                    Console.WriteLine($"Array '{arrayName}' atualizado: {arrayName}[{index}] = {newValue}");
                }
                else
                {
                    throw new Exception($"Índice '{index}' fora dos limites do array '{arrayName}'.");
                }
            }
            else
            {
                throw new Exception($"Array '{arrayName}' não declarado.");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao atualizar array: {ex.Message}");
        }
    }
    // Método auxiliar para logar o resultado da condição
    private bool LogConditionResult(bool condition)
    {
        Console.WriteLine($"Resultado da condição do-while: {condition}");
        return condition;
    }

    private int EvaluateExpression(LangGrammarParser.ExpressionContext context)
    {
        try
        {
            // Se for acesso a array
            if (context.arrayAccess() != null)
            {
                string arrayName = context.arrayAccess().VAR().GetText();
                int index = EvaluateExpression(context.arrayAccess().expression());

                if (_arrays.ContainsKey(arrayName))
                {
                    var array = _arrays[arrayName];

                    if (index >= 0 && index < array.Count) // Verifica limites do array
                    {
                        return array[index];
                    }
                    throw new IndexOutOfRangeException($"Índice '{index}' fora dos limites do array '{arrayName}'.");
                }
                throw new Exception($"Array '{arrayName}' não declarado.");
            }

            // Se for expressão aritmética com `terminais`
            int value = EvaluateTerminais(context.terminais(0)); // Primeiro terminal
            for (int i = 1; i < context.terminais().Length; i++)
            {
                string op = context.GetChild(2 * i - 1).GetText(); // Operador: '+' ou '-'
                int nextValue = EvaluateTerminais(context.terminais(i)); // Próximo terminal

                value = op switch
                {
                    "+" => value + nextValue,
                    "-" => value - nextValue,
                    _ => throw new NotSupportedException($"Operador aritmético '{op}' não suportado.")
                };
            }

            return value;
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao avaliar expressão: {ex.Message}");
            throw;
        }
    }


    private int EvaluateTerminais(LangGrammarParser.TerminaisContext context)
    {
        try
        {
            if (context.fator() == null || context.fator().Length == 0)
            {
                throw new Exception("Nenhum fator encontrado na expressão.");
            }

            // Avalia o primeiro fator
            int value = EvaluateFator(context.fator(0));

            // Itera pelos fatores subsequentes e aplica os operadores
            for (int i = 1; i < context.fator().Length; i++)
            {
                string op = context.GetChild(2 * i - 1).GetText(); // Operador: '*', '/', '%'
                int nextValue = EvaluateFator(context.fator(i));

                value = op switch
                {
                    "*" => value * nextValue,
                    "/" => nextValue != 0
                        ? value / nextValue
                        : throw new Exception($"Divisão por zero ao avaliar '{value} / {nextValue}'."),
                    "%" => nextValue != 0
                        ? value % nextValue
                        : throw new Exception($"Divisão por zero ao avaliar '{value} % {nextValue}'."),
                    _ => throw new NotSupportedException($"Operador '{op}' não suportado.")
                };
            }

            return value;
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao avaliar terminais: {ex.Message}");
            throw;
        }
    }

    private int EvaluateFator(LangGrammarParser.FatorContext context)
    {
        try
        {
            if (context.NUM() != null) // Verifica se é um número
            {
                return int.Parse(context.NUM().GetText());
            }

            if (context.VAR() != null) // Verifica se é uma variável
            {
                string varName = context.VAR().GetText();
                if (_variables.TryGetValue(varName, out object? value) && value is int intValue)
                {
                    return intValue;
                }
                throw new Exception($"Variável '{varName}' não foi inicializada.");
            }

            throw new Exception($"Fator inválido: {context.GetText()}.");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao avaliar fator: {ex.Message}");
            throw;
        }
    }



    private bool EvaluateCondition(LangGrammarParser.ExprblocoContext context)
    {
        try
        {
            if (context == null)
            {
                Console.WriteLine("[DEBUG] Condição nula recebida. Retornando false.");
                return false;
            }

            // Parênteses: Avalia a subexpressão entre parênteses
            if (context is LangGrammarParser.ParentesisExpressionContext parentesisCtx)
            {
                Console.WriteLine("[DEBUG] Avaliando expressão entre parênteses.");
                return EvaluateCondition(parentesisCtx.exprbloco());
            }

            // Negação: Avalia a subexpressão e inverte o resultado
            if (context is LangGrammarParser.NotExpressionContext notCtx)
            {
                Console.WriteLine("[DEBUG] Avaliando expressão negada.");
                return !EvaluateCondition(notCtx.exprbloco());
            }

            // Operador lógico '&&'
            if (context is LangGrammarParser.AndExpressionContext andCtx)
            {
                Console.WriteLine("[DEBUG] Avaliando expressão lógica AND.");
                return EvaluateCondition(andCtx.exprbloco(0)) && EvaluateCondition(andCtx.exprbloco(1));
            }

            // Operador lógico '||'
            if (context is LangGrammarParser.OrExpressionContext orCtx)
            {
                Console.WriteLine("[DEBUG] Avaliando expressão lógica OR.");
                return EvaluateCondition(orCtx.exprbloco(0)) || EvaluateCondition(orCtx.exprbloco(1));
            }

            // Operador relacional
            if (context is LangGrammarParser.RelationalExpressionContext relCtx)
            {
                Console.WriteLine("[DEBUG] Avaliando expressão relacional.");
                int left = EvaluateExpressionSafe(relCtx.expression(0));
                if (relCtx.RELOP() != null)
                {
                    int right = EvaluateExpressionSafe(relCtx.expression(1));
                    string op = relCtx.RELOP().GetText();

                    // Avalia a expressão relacional e retorna como booleano
                    return op switch
                    {
                        "==" => left == right,
                        "!=" => left != right,
                        ">" => left > right,
                        "<" => left < right,
                        ">=" => left >= right,
                        "<=" => left <= right,
                        _ => throw new NotSupportedException($"Operador relacional '{op}' não suportado.")
                    };
                }

                // Se não houver operador relacional, verifica se a expressão é verdadeira
                Console.WriteLine("[DEBUG] Avaliando expressão relacional sem operador. Verificando se é diferente de zero.");
                return left != 0;
            }

            // Caso nenhum contexto seja reconhecido
            throw new Exception($"[DEBUG] Condição inválida recebida: {context.GetText()}.");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Erro ao avaliar condição: {ex.Message}");
            return false; // Retorna falso em caso de erro para evitar loops infinitos
        }
    }

    // Método auxiliar para capturar erros no EvaluateExpression
    private int EvaluateExpressionSafe(LangGrammarParser.ExpressionContext context)
    {
        try
        {
            return EvaluateExpression(context);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"[ERROR] Erro ao avaliar expressão: {ex.Message}");
            return 0; // Retorna 0 em caso de erro
        }
    }
    private void ProcessarLinha(LangGrammarParser.LinhasContext linha)
    {
        if (linha.atrib() != null)
        {
            ExitAtrib(linha.atrib());
        }
        else if (linha.output() != null)
        {
            ExitOutput(linha.output());
        }
        else
        {
            Console.WriteLine("Linha não reconhecida.");
        }
    }


    private void ExecuteBlock(LangGrammarParser.BlocoContext context)
    {
        foreach (var linha in context.linhas())
        {
            ExecuteLinha(linha);
        }
    }
    
    private int ExecuteFunctionBlock(LangGrammarParser.BlocoFunctionContext context, FunctionInfo functionInfo) {
        foreach (var linha in context.linhas()) {
            if(linha.returnStmt() != null){
                if(functionInfo.ReturnType == "void"){
                    throw new Exception($"Função '{functionInfo.Name}' é do tipo void e não pode retornar valores.");                
                }
                int returnValue = EvaluateExpression(linha.returnStmt().expression());
                return returnValue;
            }
            ExecuteLinha(linha);
        }
        if (functionInfo.ReturnType != "void"){
            throw new Exception($"Função '{functionInfo.Name}' deve retornar um valor do tipo {functionInfo.ReturnType}.");
        }
        return 0;
    }

    private void ExecuteInitialization(LangGrammarParser.AtribContext context)
    {
        if (context != null)
        {
            string varName = context.VAR().GetText();
            if (!_variables.ContainsKey(varName))
            {
                int value = EvaluateExpression(context.expression());
                _variables[varName] = value;
                Console.WriteLine($"[DEBUG] Variável '{varName}' inicializada com o valor {value}");
            }
        }
    }


    private void InitializeStructInstance(string structName, string instanceName){
        if(!_structs.ContainsKey(structName)){
            throw new Exception($"Struct '{structName}' não foi declarada.");
        }

        var structFields = new Dictionary<string, object>();
        foreach(var field in _structs[structName]){
            structFields[field.Key] = null;
        }

        _structInstances[instanceName] = structFields;
        Console.WriteLine($"Instância da struct '{structName}' criada: {instanceName}");

    }

    private void ExecuteIncrement(LangGrammarParser.AtribContext context)
    {
        if (context != null)
        {
            string varName = context.VAR().GetText();
            if (_variables.ContainsKey(varName))
            {
                int value = EvaluateExpression(context.expression());
                _variables[varName] = value;
            }
            else
            {
                throw new Exception($"Variável '{varName}' não inicializada antes do incremento.");
            }
        }
    }


}
