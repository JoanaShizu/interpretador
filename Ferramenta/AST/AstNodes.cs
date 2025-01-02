using System;
using System.Collections.Generic;

namespace Ferramenta.AST
{
    // Interface para o visitante (Visitor Pattern)
    public interface IAstVisitor
    {
        void Visit(VariableDeclarationNode node);
        void Visit(ExpressionNode node);
        void Visit(MultipleExpressionNode node);
        void Visit(PrintNode node);
        void Visit(LiteralNode node);
        void Visit(IdentifierNode node);

    }

    // Nó para valores literais
    public class LiteralNode : AstNode
    {
        public string Value { get; set; }

        public LiteralNode(string value)
        {
            Value = value;
        }

        public override void Accept(IAstVisitor visitor) => visitor.Visit(this);
    }

    // Nó para identificadores (variáveis, por exemplo)
    public class IdentifierNode : AstNode
    {
        public string Name { get; set; }

        public IdentifierNode(string name)
        {
            Name = name;
        }

        public override void Accept(IAstVisitor visitor) => visitor.Visit(this);
    }


    // Classe base para os nós da AST
    public abstract class AstNode
    {
        public abstract void Accept(IAstVisitor visitor);
    }

    // Declaração de variáveis
    public class VariableDeclarationNode : AstNode
    {
        public string Type { get; set; }
        public string Name { get; set; }
        public AstNode? InitialValue { get; set; }

        public VariableDeclarationNode(string type, string name, AstNode? initialValue = null)
        {
            Type = type;
            Name = name;
            InitialValue = initialValue;
        }

        public override void Accept(IAstVisitor visitor) => visitor.Visit(this);
    }

    // Nó para expressões
    public class ExpressionNode : AstNode
    {
        public string Operator { get; set; }
        public AstNode Left { get; set; }
        public AstNode Right { get; set; }

        public ExpressionNode(string op, AstNode left, AstNode right)
        {
            Operator = op;
            Left = left;
            Right = right;
        }

        public override void Accept(IAstVisitor visitor) => visitor.Visit(this);
    }

    // Nó para múltiplas expressões
    public class MultipleExpressionNode : AstNode
    {
        public List<AstNode> Expressions { get; set; }

        public MultipleExpressionNode(List<AstNode> expressions)
        {
            Expressions = expressions;
        }

        public override void Accept(IAstVisitor visitor) => visitor.Visit(this);
    }

    // Nó para o comando printf
    public class PrintNode : AstNode
    {
        public string Format { get; set; }
        public List<AstNode> Arguments { get; set; }

        public PrintNode(string format, List<AstNode> arguments)
        {
            Format = format;
            Arguments = arguments;
        }

        public override void Accept(IAstVisitor visitor) => visitor.Visit(this);
    }
}
