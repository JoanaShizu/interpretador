using System;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

class Program
{
    static void Main(string[] args)
    {
        // Código fonte a ser analisado (adicione seu código aqui)
        string code = @"
            int main(void) {
                
                printf(""Resultado: %d"", 8);
            }
        ";

        try
        {
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
