using System;
using System.IO;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

class Program
{
    static void Main(string[] args)
    {
        // Verifica se o arquivo foi passado como argumento
        if (args.Length != 1)
        {
            Console.WriteLine("Uso: ferramenta.exe codigo_fonte.c");
            return;
        }

        string filePath = args[0];

        // Verifica se o arquivo existe
        if (!File.Exists(filePath))
        {
            Console.WriteLine($"Erro: O arquivo '{filePath}' não foi encontrado.");
            return;
        }

        try
        {
            // Lê o conteúdo do arquivo
            string code = File.ReadAllText(filePath);

            // Cria o Lexer para gerar os tokens
            var inputStream = new AntlrInputStream(code);
            var lexer = new LangGrammarLexer(inputStream);

            // Exibe os tokens gerados pelo Lexer
            Console.WriteLine("Tokens:");
            var tokens = new CommonTokenStream(lexer);
            tokens.Fill();
            foreach (var token in tokens.GetTokens())
            {
                Console.WriteLine($"Texto: {token.Text}, Tipo: {lexer.Vocabulary.GetSymbolicName(token.Type)}");
            }
            Console.WriteLine();

            // Cria o Parser para gerar a árvore sintática
            var parser = new LangGrammarParser(tokens);
            var tree = parser.programa();

            // Exibe a árvore sintática no console
            Console.WriteLine("Árvore Sintática:");
            Console.WriteLine(tree.ToStringTree(parser));
            Console.WriteLine();

            // Usa o Listener personalizado para interpretar o código
            var listener = new LangGrammarCustomListener();
            ParseTreeWalker.Default.Walk(listener, tree);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro durante a execução: {ex.Message}");
        }
    }
}
