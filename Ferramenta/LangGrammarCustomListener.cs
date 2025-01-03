using System;
using System.Collections.Generic;

public class LangGrammarCustomListener : LangGrammarBaseListener
{
    private readonly Dictionary<string, int> _variables = new Dictionary<string, int>();

    // Processa atribuições de variáveis
    public override void ExitAtrib(LangGrammarParser.AtribContext context)
    {
        try
        {
            string varName = context.VAR().GetText(); // Nome da variável
            int value = EvaluateExpression(context.expression()); // Avalia a expressão
            _variables[varName] = value; // Armazena na tabela de símbolos
            Console.WriteLine($"Variável '{varName}' inicializada com o valor {value}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao processar atribuição: {ex.Message}");
        }
    }

    // Processa chamadas de saída (ex.: printf)
    public override void ExitOut(LangGrammarParser.OutContext context)
    {
        try
        {
            // Obtém a string de formato (ex.: "Resultado: %d")
            string format = context.STR().GetText().Trim('"');
            List<string> arguments = new List<string>();

            // Processa cada argumento da função printf
            foreach (var expr in context.expression())
            {
                arguments.Add(EvaluateExpression(expr).ToString());
            }

            // Substitui os placeholders (%d) na string de formato pelos valores dos argumentos
            string output = format;
            foreach (var arg in arguments)
            {
                output = output.ReplaceFirst("%d", arg);
            }

            // Imprime a saída formatada
            Console.WriteLine(output);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao processar saída: {ex.Message}");
        }
    }

    // Avalia expressões aritméticas
    private int EvaluateExpression(LangGrammarParser.ExpressionContext context)
    {
        // Avalia o primeiro terminal
        int value = EvaluateTerminais(context.terminais(0));

        // Itera pelos operadores e terminais subsequentes
        for (int i = 1; i < context.terminais().Length; i++)
        {
            string op = context.GetChild(2 * i - 1).GetText(); // Operador (+ ou -)
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

    // Avalia terminais
    private int EvaluateTerminais(LangGrammarParser.TerminaisContext context)
    {
        int value = EvaluateFator(context.fator(0)); // Primeiro fator

        // Itera pelos operadores e fatores subsequentes
        for (int i = 1; i < context.fator().Length; i++)
        {
            string op = context.GetChild(2 * i - 1).GetText(); // Operador (* ou /)
            int nextValue = EvaluateFator(context.fator(i));

            value = op switch
            {
                "*" => value * nextValue,
                "/" => nextValue != 0 ? value / nextValue : throw new Exception("Divisão por zero."),
                _ => throw new NotSupportedException($"Operador '{op}' não suportado")
            };
        }

        return value;
    }

    // Avalia fator
    private int EvaluateFator(LangGrammarParser.FatorContext context)
    {
        if (context.NUM() != null) // Caso seja um número
        {
            return int.Parse(context.NUM().GetText());
        }

        if (context.VAR() != null) // Caso seja uma variável
        {
            string varName = context.VAR().GetText();
            if (_variables.TryGetValue(varName, out int value))
            {
                return value;
            }
            throw new Exception($"Variável '{varName}' não declarada.");
        }

        if (context.expression() != null) // Subexpressão entre parênteses
        {
            return EvaluateExpression(context.expression());
        }

        throw new Exception("Fator inválido.");
    }
}

// Método auxiliar para substituir apenas o primeiro %d
public static class StringExtensions
{
    public static string ReplaceFirst(this string text, string search, string replace)
    {
        int pos = text.IndexOf(search);
        if (pos < 0) return text;
        return text.Substring(0, pos) + replace + text.Substring(pos + search.Length);
    }
}

