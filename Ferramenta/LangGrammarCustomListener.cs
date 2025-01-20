using System;
using System.Collections.Generic;

public class LangGrammarCustomListener : LangGrammarBaseListener
{
    private bool foundStdio = false;  // Para garantir que 'stdio.h' foi incluído
    private bool foundMain = false;   // Para garantir que a função 'main' foi encontrada
    private bool mainHasReturn = false; // Para garantir que a função 'main' tenha um return
    private bool mainHasStatements = false; // Para garantir que a função 'main' tenha pelo menos uma instrução

    private readonly HashSet<string> allowedLibraries = new HashSet<string>
    {
        "stdio.h",
        "math.h",
        "stdlib.h",
        "string.h"
    };

    // Verificar #include
    public override void EnterInclude(LangGrammarParser.IncludeContext context)
    {
        string library = context.LIBRARY_NAME().GetText();
        if (library == "stdio.h")
        {
            foundStdio = true;  // Marca que 'stdio.h' foi incluído
            Console.WriteLine($"Biblioteca incluída: {library}");
        }
        else if (!allowedLibraries.Contains(library))
        {
            Console.WriteLine($"Erro: Biblioteca inválida '{library}'");
        }
        else
        {
            Console.WriteLine($"Biblioteca incluída: {library}");
        }
    }

    // Verificar função main
    public override void EnterMainFunction(LangGrammarParser.MainFunctionContext context)
    {
        foundMain = true;  // Marca que a função main foi encontrada
        Console.WriteLine("Entrando na função principal...");
    }

    // Verificar declarações dentro de main
    public override void EnterStatement(LangGrammarParser.StatementContext context)
    {
        if (foundMain)
        {
            mainHasStatements = true;  // Marca que pelo menos uma instrução foi encontrada dentro de main
            Console.WriteLine($"Executando declaração: {context.GetText()}");
        }
    }

    // Verificar retorno na função main
    public override void EnterReturnStatement(LangGrammarParser.ReturnStatementContext context)
    {
        if (foundMain)
        {
            mainHasReturn = true;  // Marca que a função main tem um return
            Console.WriteLine($"Retornando: {context.GetText()}");
        }
    }

    // Verificação final após a análise do código
    public override void ExitProgram(LangGrammarParser.ProgramContext context)
    {
        if (!foundStdio)
        {
            Console.WriteLine("Erro: 'stdio.h' é obrigatório.");
        }

        if (!foundMain)
        {
            Console.WriteLine("Erro: A função 'main' não foi encontrada.");
        }

        if (!mainHasStatements)
        {
            Console.WriteLine("Erro: A função 'main' não contém nenhuma instrução.");
        }

        if (!mainHasReturn)
        {
            Console.WriteLine("Erro: A função 'main' deve terminar com um 'return'.");
        }

        // Caso não haja erros, significa que o código está estruturado corretamente
        if (foundStdio && foundMain && mainHasStatements && mainHasReturn)
        {
            Console.WriteLine("Código estruturado corretamente.");
        }
    }
}
