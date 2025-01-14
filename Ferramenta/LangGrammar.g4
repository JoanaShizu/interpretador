grammar LangGrammar;

// Regras principais
programa: cabecalho corpo;

cabecalho: (includeDecl | defineDecl | comentario)*;

includeDecl: INCLUDE LIB EOL;
defineDecl: DEFINE VAR expression? EOL;

corpo: mainFunction (functionDecl | structDecl | unionDecl | comentario)*;

mainFunction: INT MAIN OPEN_PAREN VOID CLOSE_PAREN bloco;

bloco: OPEN_BRACE linhas* CLOSE_BRACE;

linhas: comentario
      | atrib EOL
      | arrayDecl EOL
      | pointerDecl EOL
      | pointerAssign EOL
      | pointerDereference EOL
      | functionCall EOL
      | structAccess EOL
      | unionAccess EOL
      | in EOL
      | out EOL
      | getsStmt EOL
      | putsStmt EOL
      | decisionFunc
      | switchCase
      | loopFunc
      | doWhileLoop
      | casting EOL
      | typeof EOL
      | ternary EOL
      | returnStmt EOL;

// Regras de comentário
comentario: COMMENTLINE | COMMENTBLOCK;

// Declarações de variáveis
atrib: (INT | FLOAT | CHAR | DOUBLE | VOID) VAR '=' expression
     | (INT | FLOAT | CHAR | DOUBLE | VOID) VAR
     | VAR '=' expression;

arrayDecl: (INT | FLOAT | CHAR | DOUBLE | VOID) VAR '[' NUM ']' ('=' '{' elementosArray '}')?;
elementosArray: expression (',' expression)*;

// Declaração de ponteiros
pointerDecl: (INT | FLOAT | CHAR | DOUBLE | VOID) '*' VAR;
pointerAssign: VAR '=' '&' VAR;
pointerDereference: '*' VAR '=' expression;

// Entrada e saída
in: SCAN '(' FORMAT ',' '&' VAR ')';
out: PRINT '(' STR (',' expression)* ')' EOL;
getsStmt: GETS '(' VAR ')';
putsStmt: PUTS '(' VAR ')';

// Declarações de funções
functionDecl: (INT | FLOAT | CHAR | DOUBLE | VOID) VAR '(' parametros? ')' bloco;

// Chamada de funções
functionCall: VAR '(' argumentos? ')';
parametros: (INT | FLOAT | CHAR | DOUBLE | VOID) VAR (',' (INT | FLOAT | CHAR | DOUBLE | VOID) VAR)*;
argumentos: expression (',' expression)*;

// Declaração de estruturas
structDecl: STRUCT VAR '{' structFields '}' EOL;
structFields: ((INT | FLOAT | CHAR | DOUBLE | VOID) VAR EOL)+;

// Declaração de uniões
unionDecl: UNION VAR '{' unionFields '}' EOL;
unionFields: ((INT | FLOAT | CHAR | DOUBLE | VOID) VAR EOL)+;

// Acesso a campos de estruturas e uniões
structAccess: VAR DOT VAR '=' expression
            | VAR DOT VAR;

unionAccess: VAR DOT VAR '=' expression
           | VAR DOT VAR;

// Controle de fluxo
decisionFunc: IF '(' exprbloco ')' bloco | IF '(' exprbloco ')' bloco ELSE bloco;
switchCase: SWITCH '(' VAR ')' '{' caseBlock+ defaultBlock? '}';
caseBlock: CASE NUM ':' linhas* BREAK EOL;
defaultBlock: DEFAULT ':' linhas* BREAK EOL;

loopFunc: WHILE '(' exprbloco ')' bloco | FOR '(' atrib EOL exprbloco EOL atrib ')' bloco;
doWhileLoop: DO bloco WHILE '(' exprbloco ')' EOL;

// Expressões
expression: terminais ('+' terminais | '-' terminais)*;
terminais: fator ('*' fator | '/' fator | '%' fator)*;
fator: '(' expression ')' | NUM | VAR | STR | CHAR | VAR SOMA SOMA | VAR SUB SUB;

// Expressões condicionais
exprbloco: expression (RELOP expression)?
         | exprbloco AND exprbloco
         | exprbloco OR exprbloco
         | NOT exprbloco;

// Casting e typeof
casting: '(' (INT | FLOAT | CHAR | DOUBLE | VOID) ')' VAR;
typeof: TYPEOF '(' VAR ')';

// Operador ternário
ternary: exprbloco '?' bloco ':' bloco;

// Retorno
returnStmt: RETURN expression | RETURN;

// Tokens
INCLUDE: '#include';
DEFINE: '#define';
EOL: ';';
LIB: '<' [a-zA-Z_][a-zA-Z0-9_]* '>';
COMMENTLINE: '//' ~[\r\n]* -> skip;
COMMENTBLOCK: '/*' .*? '*/' -> skip;

INT: 'int';
FLOAT: 'float';
CHAR: 'char';
DOUBLE: 'double';
VOID: 'void';
MAIN: 'main';

VAR: [_a-zA-Z][_a-zA-Z0-9]*;
NUM: [0-9]+;
STR: '"' ~[\n"]* '"';
FORMAT: '"%' [a-zA-Z] '"';

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
OPEN_PAREN: '(';
CLOSE_PAREN: ')';
OPEN_BRACE: '{';
CLOSE_BRACE: '}';
VIR: ',';
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
