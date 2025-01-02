using System.Linq; // Para o método Select
using Ferramenta.AST;

namespace Ferramenta.AST
{
    public class AstBuilderVisitor : LangGrammarBaseVisitor<AstNode>
    {
        public override AstNode VisitInitialization(LangGrammarParser.InitializationContext context)
        {
            var type = context.TYPE().GetText();
            var name = context.VAR().GetText();
            var value = context.expression() != null ? Visit(context.expression()) : null;
            return new VariableDeclarationNode(type, name, value);
        }

        public override AstNode VisitExpression(LangGrammarParser.ExpressionContext context)
        {
            if (context.term() != null && context.term().Length > 1) // Caso com múltiplos termos
            {
                var expressions = new List<AstNode>();
                foreach (var term in context.term())
                {
                    expressions.Add(Visit(term)); // Visita cada termo individualmente
                }
                return new MultipleExpressionNode(expressions);
            }
            else if (context.term() != null && context.term().Length == 1) // Caso com um único termo
            {
                return Visit(context.term(0)) ?? throw new Exception("Termo não pode ser nulo");
            }
            return null; // Retorno nulo em caso de erro
        }

        public override AstNode VisitOutput(LangGrammarParser.OutputContext context)
        {
            var format = context.STRING().GetText();
            var arguments = context.expression() != null
                ? context.expression().Select(expr => Visit(expr)).ToList()
                : new List<AstNode>();
            return new PrintNode(format, arguments);
        }

        public override AstNode VisitTerm(LangGrammarParser.TermContext context)
        {
            if (context.NUM() != null)
            {
                return new LiteralNode(context.NUM().GetText());
            }
            else if (context.VAR() != null)
            {
                return new IdentifierNode(context.VAR().GetText());
            }
            else if (context.STRING() != null)
            {
                return new LiteralNode(context.STRING().GetText());
            }
            else
            {
                // Adicione suporte para outros tipos de termos, se necessário
                return null;
            }
        }
    }
}
