using System;
using System.IO;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

class Program
{
    public static void Main(string[] args)
    {
        // Verifica se o arquivo "inicio.c" existe
        string filePath = "inicio.c";
        if (!File.Exists(filePath))
        {
            Console.WriteLine($"Erro: O arquivo {filePath} não foi encontrado.");
            return;
        }

        try
        {
            // Lê o conteúdo do arquivo
            string input = File.ReadAllText(filePath);

            // Configurações do ANTLR
            AntlrInputStream inputStream = new AntlrInputStream(input);
            LangGrammarLexer lexer = new LangGrammarLexer(inputStream);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            LangGrammarParser parser = new LangGrammarParser(tokenStream);

            // Processa a entrada e aplica o Listener
            var tree = parser.program();
            LangGrammarCustomListener listener = new LangGrammarCustomListener();
            ParseTreeWalker.Default.Walk(listener, tree);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro ao processar o arquivo: {ex.Message}");
        }
    }
}
