
grammar LangGrammar;

// Regras principais
programa: cabecalho corpo EOF;

cabecalho: (includeDecl | defineDecl | comentario)*;

includeDecl: INCLUDE LIB;
defineDecl: DEFINE VAR expression?;

corpo: (structDecl | mainFunction | functionDecl | unionDecl | comentario)*;

mainFunction: INT MAIN '(' (VOID | ) ')' bloco ;

bloco: '{' linhas* '}';

// Declaração de struct
structDecl
    : 'struct' VAR '{' structMember* '}' ';'
    ;

structInstDecl
    : 'struct' VAR VAR ('=' structLiteral)? ';'
    ;

// Membros de struct
structMember
    : tipo VAR (CO (CONSTANT | NUM) CC)? ';'
    ;
    
structAccess: VAR DOT VAR ASSIGN expression ';'; 

structFieldAccess
    : VAR DOT VAR
    ;


linhas

    : unionAccess
    | structAccess
    | functionCall
    | atrib
    | comentario
    | arrayDecl
    | pointerDecl
    | pointerAssign
    | pointerDereference
    | input
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
atrib: tipo VAR ('=' expression)? ';'
     | VAR '=' expression ';' 
     | structAccess
     ;

arrayDecl
    : tipo VAR CO size CC '=' STR ';'
    | tipo VAR CO size CC '=' CD elementosArray CE ';'
    | tipo VAR CO size CC ';'
    ;

size
    : NUM
    | /* vazio */
    ;

elementosArray: expression (COMMA expression)*;

arrayAccess: VAR '[' expression ']';

// Declaração de ponteiros
pointerDecl: (INT | FLOAT | CHAR | DOUBLE | VOID) '*' VAR ';';
pointerAssign: VAR '=' '&' VAR ';';
pointerDereference: '*' VAR '=' expression ';';

// Entrada e saída
input: 'scanf' '('FORMAT COMMA '&' VAR ')' ';';
output
    : 'printf' '(' STR (COMMA arg+=argument)* ')' ';'
    | STR (COMMA arg+=argument)*
    ;

getsStmt: GETS '(' VAR ')' ';'; 
putsStmt: PUTS '(' VAR ')' ';';

structLiteral: CD expression (COMMA expression)* CE;

// Declarações de funções
functionDecl: tipo VAR '(' parametros? ')' blocoFunction ;

functionCall: VAR PD argumentos? PE ;
blocoFunction: '{' linhas+ '}' ;

parametros: tipo VAR (COMMA tipo VAR)*;
tipo: INT 
    | FLOAT 
    | CHAR 
    | DOUBLE 
    | VOID 
    | 'struct' VAR 
    | 'union' VAR 
    | VAR
    ;

argumentos: expression (COMMA expression)*;

// Declaração de uniões
unionDecl: UNION VAR '{' unionFields '}' ';';
unionFields: ((INT | FLOAT | CHAR | DOUBLE | VOID) VAR ';')+;

// Acesso a campos de estruturas e uniões
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
expression
    : structLiteral
    | terminais (('+' | '-') terminais)*
    | arrayAccess
    ;

arrayUpdate
    : VAR '[' expression ']' '=' expression
    ;

terminais: fator ((MULT | DIV | MOD) fator)*;


fator: '!' fator
    | '(' expression ')'
    | arrayAccess          // nova alternativa para acesso a arrays
    | structFieldAccess 
    | structAccess         // nova alternativa para acesso a campos de struct
    | NUM
    | CONSTANT       // Opcional: para tratar números com ponto
    | VAR
    | STR
    | CHARLIT        // Literais de caractere
    | VAR '++'
    | VAR '--'
    ;
    
argument
    : expression
    | exprbloco
    | arrayAccess
    | structFieldAccess
    ;


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
returnStmt: RETURN expression ';';

// Tokens
LIB : '<' [a-zA-Z_][a-zA-Z0-9_]* ('.' [a-zA-Z0-9_]+)* '>' 
    | '"' [a-zA-Z_][a-zA-Z0-9_]* ('.' [a-zA-Z0-9_]+)* '"';

 //Para aceitar bibliotecas locais 
INCLUDE: '#include';
DEFINE: '#define';
RELOP: '==' | '!=' | '<' | '<=' | '>' | '>=';
COMMENTLINE: '//' ~[\r\n]* -> skip;
COMMENTBLOCK: '/*' .*? '*/' -> skip;

INT: 'int';
FLOAT: 'float';
CHAR: 'char';
DOUBLE: 'double';
VOID: 'void';
MAIN: 'main';
COMMA: ',';
PV: ';';
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
MOD: '%';
AND: '&&';
OR: '||';
NOT: '!';
CD: '{';
CE: '}';
PD: '(';
PE: ')';
CO: '[';
CC: ']';
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
CONSTANT: [0-9]+ '.' [0-9]+;
CHARLIT : '\'' ( ~[\\'\r\n] | '\\' . ) '\'';

FORMAT: '"%' [dcsfxe] '"';
STR: '"' ~[\n"]* '"';
