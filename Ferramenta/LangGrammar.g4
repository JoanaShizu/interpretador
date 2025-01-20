grammar LangGrammar;

// Regras principais
program : include* mainFunction EOF;

include : '#include' '<' LIBRARY_NAME '>';

mainFunction : 'int' 'main' '(' (')' | 'void') ')' block;

block : '{' (statement | declaration)* returnStatement '}';

statement : PRINT_FUNCTION '(' STRING ')' ';'
          | expression ';';

expression : expression ('+' | '-' | '*' | '/' | '%' | '==' | '!=' | '>' | '<' | '>=' | '<=' | '&&' | '||' | '!' ) expression
           | ID '=' expression        // Atribuição de valor a variável
           | INT_LITERAL
           | FLOAT_LITERAL
           | CHAR_LITERAL
           | ID;  // Para acessar variáveis

declaration : type ID ('=' expression)? ('[' INT_LITERAL ']')? ';';  // Declaração de variáveis ou arrays

type : 'int' | 'float' | 'char'; // Tipos de variáveis

returnStatement : 'return' expression ';'; // O return agora pode ser uma expressão

// Tokens
LIBRARY_NAME : 'stdio.h' | 'math.h' | 'stdlib.h' | 'string.h'; // Adicione mais bibliotecas se necessário
PRINT_FUNCTION : 'printf';
STRING : '"' .*? '"';
INT_LITERAL : [0-9]+;
FLOAT_LITERAL : [0-9]+ '.' [0-9]+;
CHAR_LITERAL : '\'' [a-zA-Z] '\'';
ID : [a-zA-Z_][a-zA-Z_0-9]*;
WS : [ \t\r\n]+ -> skip;
