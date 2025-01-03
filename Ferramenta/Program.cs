using System;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

class Program
{
    static void Main(string[] args)
    {
        try
        {
            // Código fonte a ser analisado
            string code = @"
                int main(void) {
                    int x = 5 + 3;
                    printf(""Resultado: %d"", x);
                }
            ";

            // Crie o Lexer
            var inputStream = new AntlrInputStream(code);
            var lexer = new LangGrammarLexer(inputStream);

            // Exiba os tokens gerados pelo Lexer
            Console.WriteLine("Tokens:");
            var tokens = new CommonTokenStream(lexer);
            tokens.Fill();
            foreach (var token in tokens.GetTokens())
            {
                Console.WriteLine($"Texto: {token.Text}, Tipo: {lexer.Vocabulary.GetSymbolicName(token.Type)}");
            }
            Console.WriteLine();

            // Crie o Parser
            var parser = new LangGrammarParser(tokens);

            // Gere a árvore sintática
            var tree = parser.programa();

            // Exiba a árvore sintática (opcional)
            Console.WriteLine("Árvore Sintática:");
            Console.WriteLine(tree.ToStringTree(parser));
            Console.WriteLine();

            // Use o Listener personalizado para interpretar o código
            var listener = new LangGrammarCustomListener();
            ParseTreeWalker.Default.Walk(listener, tree);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Erro durante a execução: {ex.Message}");
        }
    }
}
