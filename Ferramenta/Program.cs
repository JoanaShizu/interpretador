using System;
using System.IO;
using Antlr4.Runtime;
using Ferramenta.AST; // Certifique-se de usar o namespace correto para a AST

namespace Ferramenta
{
    public partial class Program // Adicione "partial" se necessário
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Digite o caminho do arquivo de entrada:");
            string filePath = Console.ReadLine();

            if (File.Exists(filePath))
            {
                var input = File.ReadAllText(filePath);
                var inputStream = new AntlrInputStream(input);
                var lexer = new LangGrammarLexer(inputStream);
                var tokenStream = new CommonTokenStream(lexer);
                var parser = new LangGrammarParser(tokenStream);

                // Parse Tree
                var parseTree = parser.program();

                // AST
                var visitor = new AstBuilderVisitor();
                var ast = visitor.Visit(parseTree);

                Console.WriteLine("AST construída com sucesso!");
                Console.WriteLine(ast); // Certifique-se de que há um método ToString() implementado para exibir a AST
            }
            else
            {
                Console.WriteLine("Arquivo não encontrado.");
            }
        }
    }
}
