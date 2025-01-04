public class LangGrammarCustomListener : LangGrammarBaseListener
{
    private readonly Dictionary<string, int> _variables = new Dictionary<string, int>();
    private bool _insideForLoop = false; // Controle do contexto do `for`

    public override void ExitAtrib(LangGrammarParser.AtribContext context)
    {
        try
        {
            string varName = context.VAR().GetText();
            int value = EvaluateExpression(context.expression());

            if (_variables.ContainsKey(varName))
            {
                _variables[varName] = value;
                Console.WriteLine($"Variável '{varName}' atualizada com o valor {value}");
            }
            else
            {
                _variables[varName] = value;
                Console.WriteLine($"Variável '{varName}' inicializada com o valor {value}");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao processar atribuição: {ex.Message}");
        }
    }

    public override void ExitOutput(LangGrammarParser.OutputContext context)
    {
        try
        {
            // Obtém a string formatada e remove as aspas
            string format = context.STR().GetText().Trim('"');
            
            // Substitui os caracteres de escape
            format = format.Replace("\\n", "\n").Replace("\\t", "\t");

            List<int> arguments = new List<int>();

            // Processa os argumentos
            foreach (var expr in context.expression())
            {
                arguments.Add(EvaluateExpression(expr));
            }

            // Substitui os placeholders %d pelos valores
            int index = 0;
            string output = format;
            while (output.Contains("%d") && index < arguments.Count)
            {
                output = output.ReplaceFirst("%d", arguments[index].ToString());
                index++;
            }

            // Exibe o resultado formatado
            Console.Write(output); // Utiliza Write em vez de WriteLine para respeitar \n
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao processar printf: {ex.Message}");
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
                        Console.WriteLine("Executando bloco 'if'");
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
            _insideForLoop = true;

            if (context.atrib(0) != null)
            {
                ExecuteInitialization(context.atrib(0));
            }

            while (EvaluateCondition(context.exprbloco()))
            {
                ExecuteBlock(context.bloco());

                if (context.atrib(1) != null)
                {
                    ExecuteIncrement(context.atrib(1));
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
                    Console.WriteLine($"Variável '{variable.Key}' = {variable.Value}");
                }

            } while (LogConditionResult(EvaluateCondition(context.exprbloco()))); // Avalia a condição do `while`
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao processar do-while: {ex.Message}");
        }
    }

    // Método auxiliar para logar o resultado da condição
    private bool LogConditionResult(bool condition)
    {
        Console.WriteLine($"Resultado da condição do-while: {condition}");
        return condition;
    }

// Método auxiliar para logar o resultado da condição

    private int EvaluateExpression(LangGrammarParser.ExpressionContext context)
    {
        int value = EvaluateTerminais(context.terminais(0));
        for (int i = 1; i < context.terminais().Length; i++)
        {
            string op = context.GetChild(2 * i - 1).GetText();
            int nextValue = EvaluateTerminais(context.terminais(i));

            value = op switch
            {
                "+" => value + nextValue,
                "-" => value - nextValue,
                _ => throw new NotSupportedException($"Operador '{op}' não suportado")
            };
        }
        return value;
    }

    private int EvaluateTerminais(LangGrammarParser.TerminaisContext context)
    {
        int value = EvaluateFator(context.fator(0));
        for (int i = 1; i < context.fator().Length; i++)
        {
            string op = context.GetChild(2 * i - 1).GetText();
            int nextValue = EvaluateFator(context.fator(i));

            value = op switch
            {
                "*" => value * nextValue,
                "/" => nextValue != 0 ? value / nextValue : throw new Exception("Divisão por zero."),
                "%" => value % nextValue,
                _ => throw new NotSupportedException($"Operador '{op}' não suportado")
            };
        }
        return value;
    }

    private int EvaluateFator(LangGrammarParser.FatorContext context)
    {
        if (context.NUM() != null)
        {
            return int.Parse(context.NUM().GetText());
        }

        if (context.VAR() != null)
        {
            string varName = context.VAR().GetText();
            if (_variables.TryGetValue(varName, out int value))
            {
                return value;
            }
            throw new Exception($"Variável '{varName}' não declarada.");
        }

        if (context.expression() != null)
        {
            return EvaluateExpression(context.expression());
        }

        throw new Exception("Fator inválido.");
    }

    private bool EvaluateCondition(LangGrammarParser.ExprblocoContext context)
    {
        if (context == null) return false;

        int left = EvaluateExpression(context.expression(0));
        if (context.RELOP() != null)
        {
            int right = EvaluateExpression(context.expression(1));
            string op = context.RELOP().GetText();
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

        return left != 0; // Se não houver operador, verifica se a expressão é verdadeira
    }

private void ExecuteBlock(LangGrammarParser.BlocoContext context)
{
    foreach (var linha in context.linhas())
    {
        ExecuteLinha(linha);
    }
}

    private void ExecuteInitialization(LangGrammarParser.AtribContext context)
    {
        if (context != null)
        {
            try
            {
                string varName = context.VAR().GetText();
                int value = EvaluateExpression(context.expression());
                _variables[varName] = value;
                Console.WriteLine($"Variável '{varName}' inicializada com o valor {value}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Erro ao processar inicialização: {ex.Message}");
            }
        }
    }

    private void ExecuteIncrement(LangGrammarParser.AtribContext context)
    {
        if (context != null)
        {
            try
            {
                string varName = context.VAR().GetText();
                int value = EvaluateExpression(context.expression());
                _variables[varName] = value;
                Console.WriteLine($"Variável '{varName}' incrementada para o valor {value}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Erro ao processar incremento: {ex.Message}");
            }
        }
    }
}
