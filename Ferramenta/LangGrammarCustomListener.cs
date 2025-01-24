public class LangGrammarCustomListener : LangGrammarBaseListener{
    private Dictionary<string, int> _variables = new Dictionary<string, int>();
    private bool _insideForLoop = false; // Controle do contexto do `for`
    private Dictionary<string, string> defines = new Dictionary<string, string>();
    private Dictionary<string, FunctionInfo> functions = new Dictionary<string, FunctionInfo>();
    private Stack<int> _returnStack = new Stack<int>();
    private int _lastReturnValue;
    private Dictionary<string, Dictionary<string, string>> _structs = new Dictionary<string, Dictionary<string, string>>();
    private Dictionary<string, Dictionary<string, object>> _structInstances = new Dictionary<string, Dictionary<string, object>>();
    private readonly Dictionary<string, List<int>> _arrays = new Dictionary<string, List<int>>(); // Para armazenar arrays

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
            var previousVariables = new Dictionary<string, int>(_variables);

            _variables.Clear();

            var expressions = context.children.OfType<LangGrammarParser.ExpressionContext>().ToList();
            for (int i = 0; i < functionInfo.Parameters.Count; i++)
            {
                string paramName = functionInfo.Parameters[i].Name;
                int paramValue = EvaluateExpression(expressions[i]);
                _variables[paramName] = paramValue;
            }

            _lastReturnValue = ExecuteFunctionBlock(functionInfo.Body, functionInfo);
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
            string varName = context.VAR().GetText();

            if (!_variables.ContainsKey(varName))
            {
                _variables[varName] = 0; // Inicializa com 0
                Console.WriteLine($"Variável '{varName}' inicializada com valor padrão 0");
            }

            if (context.expression() != null)
            {
                int value = EvaluateExpression(context.expression());
                _variables[varName] = value;
                Console.WriteLine($"Variável '{varName}' atualizada com valor {value}");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao processar atribuição: {ex.Message}");
        }
    }

    // Exemplo de suporte para imprimir valores no array
    public override void ExitOutput(LangGrammarParser.OutputContext context)
    {
        try
        {
            string format = context.STR().GetText().Trim('"').Replace("\\n", "\n").Replace("\\t", "\t");
            List<string> arguments = new List<string>();

            // Lida com expressões e acessos a arrays
            foreach (var expr in context.expression())
            {
                arguments.Add(EvaluateExpression(expr).ToString());
            }

            foreach (var arrayAccess in context.arrayAccess())
            {
                string arrayName = arrayAccess.VAR().GetText();
                int index = EvaluateExpression(arrayAccess.expression());

                if (_arrays.ContainsKey(arrayName))
                {
                    arguments.Add(_arrays[arrayName][index].ToString());
                }
                else
                {
                    throw new Exception($"Array '{arrayName}' não declarado.");
                }
            }

            // Substitui os placeholders %d na string de formato
            int idx = 0;
            string output = format;
            while (output.Contains("%d") && idx < arguments.Count)
            {
                output = output.ReplaceFirst("%d", arguments[idx]);
                idx++;
            }

            Console.Write(output);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao processar output: {ex.Message}");
        }
    }

    public override void ExitInput(LangGrammarParser.InputContext context){
        try{
            string format = context.FORMAT().GetText();
            string varName = context.VAR().GetText();

            if (!_variables.ContainsKey(varName)){
                throw new Exception($"Variável '{varName}' não declarada.");
                //_variables[varName] = 0; // Inicializa com 0 se não existir
            }

            //Console.Write($"Digite o valor para {varName}: ");
            string input = Console.ReadLine();

            // Tratar formato de entrada
        if (format == "\"%d\""){
            if (int.TryParse(input, out int intValue)) {
                _variables[varName] = intValue;
            }else{
                throw new Exception($"Entrada inválida para o formato {format}: {input}");
            }
        }
        else{
            Console.WriteLine($"Formato desconhecido: {format}");
        }

            Console.WriteLine($"{varName} value updated to {_variables[varName]}");
        }catch (Exception ex){
            Console.WriteLine($"Error processing scanf: {ex.Message}");
            Console.WriteLine(ex.StackTrace);
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

            int switchValue = _variables[switchVarName];
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
            // Impede recursões no mesmo loop
            if (_insideForLoop)
            {
                throw new Exception("Tentativa de recursão no mesmo contexto de for.");
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
                    Console.WriteLine($"Variável '{variable.Key}' = {variable.Value}");
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
            int arraySize = int.Parse(context.NUM().GetText());

            if (!_arrays.ContainsKey(arrayName))
            {
                _arrays[arrayName] = new List<int>(new int[arraySize]);
                Console.WriteLine($"Array '{arrayName}' declarado com tamanho {arraySize}");
            }

            var expressions = context.children.OfType<LangGrammarParser.ExpressionContext>().ToList();
            for (int i = 0; i < expressions.Count; i++)
            {
                _arrays[arrayName][i] = EvaluateExpression(expressions[i]);
            }
            Console.WriteLine($"Array '{arrayName}' inicializado com valores: {string.Join(", ", _arrays[arrayName])}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao declarar array: {ex.Message}");
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
        // Se for acesso a array
        if (context.arrayAccess() != null)
        {
            string arrayName = context.arrayAccess().VAR().GetText();
            int index = EvaluateExpression(context.arrayAccess().expression());
            if (_arrays.ContainsKey(arrayName))
            {
                return _arrays[arrayName][index];
            }
            throw new Exception($"Array '{arrayName}' não declarado.");
        }

        // Se for expressão aritmética com `terminais`
        int value = EvaluateTerminais(context.terminais(0));
        for (int i = 1; i < context.terminais().Length; i++)
        {
            string op = context.GetChild(2 * i - 1).GetText(); // Operador: '+' ou '-'
            int nextValue = EvaluateTerminais(context.terminais(i));

            value = op switch
            {
                "+" => value + nextValue,
                "-" => value - nextValue,
                _ => throw new NotSupportedException($"Operador aritmético '{op}' não suportado.")
            };
        }

        return value;
    }


    private int EvaluateTerminais(LangGrammarParser.TerminaisContext context)
    {
        int value = EvaluateFator(context.fator(0));
        for (int i = 1; i < context.fator().Length; i++)
        {
            string op = context.GetChild(2 * i - 1).GetText(); // Operador: '*', '/', '%'
            int nextValue = EvaluateFator(context.fator(i));

            value = op switch
            {
                "*" => value * nextValue,
                "/" => nextValue != 0 ? value / nextValue : throw new Exception("Divisão por zero."),
                "%" => value % nextValue,
                _ => throw new NotSupportedException($"Operador '{op}' não suportado.")
            };
        }
        return value;
    }

    private int EvaluateFator(LangGrammarParser.FatorContext context)
    {
        // Negação lógica
        if (context.NOT() != null)
        {
            int value = EvaluateFator(context.fator());
            return value == 0 ? 1 : 0;
        }

        // Expressões entre parênteses
        if (context.expression() != null)
        {
            return EvaluateExpression(context.expression());
        }

        // Avaliação de um número
        if (context.NUM() != null)
        {
            return int.Parse(context.NUM().GetText());
        }

        // Avaliação de uma variável
        if (context.VAR() != null)
        {
            string varName = context.VAR().GetText();
            if (_variables.ContainsKey(varName))
            {
                return _variables[varName];
            }
            throw new Exception($"Variável '{varName}' não declarada.");
        }

        // Caso nenhum dos casos seja válido
        throw new Exception("Fator inválido.");
    }

    private bool EvaluateCondition(LangGrammarParser.ExprblocoContext context)
    {
        if (context == null) return false;

        // Parênteses: Avalia a subexpressão entre parênteses
        if (context is LangGrammarParser.ParentesisExpressionContext parentesisCtx)
        {
            return EvaluateCondition(parentesisCtx.exprbloco());
        }

        // Negação: Avalia a subexpressão e inverte o resultado
        if (context is LangGrammarParser.NotExpressionContext notCtx)
        {
            return !EvaluateCondition(notCtx.exprbloco());
        }

        // Operador lógico '&&'
        if (context is LangGrammarParser.AndExpressionContext andCtx)
        {
            return EvaluateCondition(andCtx.exprbloco(0)) && EvaluateCondition(andCtx.exprbloco(1));
        }

        // Operador lógico '||'
        if (context is LangGrammarParser.OrExpressionContext orCtx)
        {
            return EvaluateCondition(orCtx.exprbloco(0)) || EvaluateCondition(orCtx.exprbloco(1));
        }

        // Operador relacional
        if (context is LangGrammarParser.RelationalExpressionContext relCtx)
        {
            int left = EvaluateExpression(relCtx.expression(0));
            if (relCtx.RELOP() != null)
            {
                int right = EvaluateExpression(relCtx.expression(1));
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
                    _ => throw new NotSupportedException($"Operador relacional '{op}' não suportado")
                };
            }

            // Se não houver operador relacional, verifica se a expressão é verdadeira
            return left != 0;
        }

        throw new Exception("Condição inválida.");
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


    private string ReplaceFirst(string text, string search, string replace)
    {
        int pos = text.IndexOf(search);
        if (pos < 0) return text;
        return text.Substring(0, pos) + replace + text.Substring(pos + search.Length);
    }

}
