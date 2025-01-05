grammar LangGrammar;

// Regras principais
programa: cabecalho corpo EOF;

cabecalho: (includeDecl | defineDecl | comentario)*;

includeDecl: INCLUDE LIB ';';
defineDecl: DEFINE VAR expression? ';';

corpo: mainFunction (functionDecl | structDecl | unionDecl | comentario)*;

mainFunction: INT MAIN '(' (VOID | ) ')' bloco;

bloco: '{' linhas* '}';

linhas
    : comentario
    | atrib
    | arrayDecl
    | pointerDecl
    | pointerAssign
    | pointerDereference
    | functionCall
    | structAccess
    | unionAccess
    | in
    | output
    | getsStmt
    | putsStmt
    | decisionFunc
    | switchCase
    | loopFunc
    | doWhileLoop
    | casting
    | typeof
    | ternary
    | returnStmt
    ;

// Regras de comentário
comentario: COMMENTLINE | COMMENTBLOCK;

// Declarações de variáveis
atrib: (INT | FLOAT | CHAR | DOUBLE | VOID) VAR ('=' expression)? (';' |) 
     | VAR '=' expression (';' |);

arrayDecl: (INT | FLOAT | CHAR | DOUBLE | VOID) VAR '[' NUM ']' ('=' '{' elementosArray '}')? ';';
elementosArray: expression (',' expression)*;

// Declaração de ponteiros
pointerDecl: (INT | FLOAT | CHAR | DOUBLE | VOID) '*' VAR ';';
pointerAssign: VAR '=' '&' VAR ';';
pointerDereference: '*' VAR '=' expression ';';

// Entrada e saída
in: SCAN '(' FORMAT ',' '&' VAR ')' ';';
output: PRINT '(' STR (',' expression)* ')' ';';

getsStmt: GETS '(' VAR ')' ';';
putsStmt: PUTS '(' VAR ')' ';';

// Declarações de funções
functionDecl: (INT | FLOAT | CHAR | DOUBLE | VOID) VAR '(' parametros? ')' bloco;

functionCall: VAR '(' argumentos? ')' ';';

parametros: (INT | FLOAT | CHAR | DOUBLE | VOID) VAR (',' (INT | FLOAT | CHAR | DOUBLE | VOID) VAR)*;
argumentos: expression (',' expression)*;

// Declaração de estruturas
structDecl: STRUCT VAR '{' structFields '}' ';';
structFields: ((INT | FLOAT | CHAR | DOUBLE | VOID) VAR ';')+;

// Declaração de uniões
unionDecl: UNION VAR '{' unionFields '}' ';';
unionFields: ((INT | FLOAT | CHAR | DOUBLE | VOID) VAR ';')+;

// Acesso a campos de estruturas e uniões
structAccess: VAR '.' VAR ('=' expression)? ';';
unionAccess: VAR '.' VAR ('=' expression)? ';';

// Controle de fluxo
decisionFunc
    : IF '(' exprbloco ')' bloco (ELSE IF '(' exprbloco ')' bloco)* (ELSE bloco)?;

switchCase: SWITCH '(' VAR ')' '{' caseBlock+ defaultBlock? '}';

caseBlock: CASE NUM ':' linhas* BREAK ';';
defaultBlock: DEFAULT ':' linhas* BREAK ';';

loopFunc: whileLoop | forLoop;

whileLoop: WHILE '(' exprbloco ')' bloco;
forLoop
    : FOR '(' (atrib | ';') exprbloco? ';' (atrib | expression) ')' bloco
    ;

doWhileLoop: DO bloco WHILE '(' exprbloco ')' ';';

// Expressões
expression: terminais ('+' terminais | '-' terminais)*;
terminais: fator ('*' fator | '/' fator | '%' fator)*;
fator: '!' fator             // Suporte para negação lógica
    | '(' expression ')'     // Parênteses para agrupar expressões
    | NUM                   // Número
    | VAR                   // Variável
    | STR                   // String
    | CHAR                  // Caractere
    | VAR '++'              // Incremento pós-fixado
    | VAR '--';             // Decremento pós-fixado



// Expressões condicionais com suporte para operadores lógicos
exprbloco
    : '(' exprbloco ')'                    # ParentesisExpression
    | '!' exprbloco                        # NotExpression
    | exprbloco '&&' exprbloco             # AndExpression
    | exprbloco '||' exprbloco             # OrExpression
    | expression (RELOP expression)?      # RelationalExpression
    ;


// Casting e typeof
casting: '(' (INT | FLOAT | CHAR | DOUBLE | VOID) ')' VAR ';';
typeof: TYPEOF '(' VAR ')' ';';

// Operador ternário
ternary: exprbloco '?' expression ':' expression ';';

// Retorno
returnStmt: RETURN expression ';' | RETURN ';';

// Tokens
INCLUDE: '#include';
DEFINE: '#define';
LIB: '<' [a-zA-Z_][a-zA-Z0-9_]* '>';
COMMENTLINE: '//' ~[\r\n]* -> skip;
COMMENTBLOCK: '/*' .*? '*/' -> skip;

INT: 'int';
FLOAT: 'float';
CHAR: 'char';
DOUBLE: 'double';
VOID: 'void';
MAIN: 'main';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
MOD: '%';
AND: '&&';
OR: '||';
NOT: '!';
RELOP: '==' | '!=' | '<' | '<=' | '>' | '>=';

SOMA: '++';
SUB: '--';
ASSIGN: '=';
DOT: '.';
RETURN: 'return';
SCAN: 'scanf';
PRINT: 'printf';
GETS: 'gets';
PUTS: 'puts';
STRUCT: 'struct';
UNION: 'union';
IF: 'if';
ELSE: 'else';
SWITCH: 'switch';
CASE: 'case';
BREAK: 'break';
DEFAULT: 'default';
WHILE: 'while';
FOR: 'for';
DO: 'do';
TYPEOF: 'typeof';

WS: [ \t\r\n]+ -> skip;

VAR: [_a-zA-Z][_a-zA-Z0-9]*;
NUM: [0-9]+;
STR: '"' ~[\n"]* '"';
FORMAT: '"%' [a-zA-Z] '"';
