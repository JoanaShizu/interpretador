grammar LangGrammar;

program : statement+ ;

statement
    : declaration EOL
    | initialization EOL
    | control_structure
    | function_definition
    | function_call EOL
    | input_statement EOL
    | output_statement EOL
    | preprocessor_directive EOL
    | return_statement EOL
    | struct_union_definition
    | pointer_manipulation EOL
    ;

// Variable declaration and initialization
declaration
    : TYPE VAR
    | TYPE VAR '[' NUM ']'
    ;

initialization
    : TYPE VAR '=' expression
    | TYPE VAR '[' NUM ']' '=' '{' expression_list '}'
    ;

expression
    : term (( '+' | '-' | '*' | '/' | '%' ) term)*
    ;

term
    : NUM
    | FLOAT_NUM
    | CHAR
    | STRING
    | VAR
    | '(' expression ')'
    ;

expression_list
    : expression (',' expression)*
    ;

// Input and Output
input_statement
    : 'scanf' '(' STRING ',' '&' VAR ')'
    ;

output_statement
    : 'printf' '(' STRING (',' expression)* ')'
        #Output
    ;

// Control structures
control_structure
    : if_statement
    | switch_statement
    | for_loop
    | while_loop
    | do_while_loop
    ;

if_statement
    : 'if' '(' expression ')' block ('else' block)?
    ;

switch_statement
    : 'switch' '(' VAR ')' '{' case_clause* ('default' ':' block)? '}'
    ;

case_clause
    : 'case' NUM ':' block
    ;

for_loop
    : 'for' '(' initialization EOL expression EOL VAR '=' expression ')' block
    ;

while_loop
    : 'while' '(' expression ')' block
    ;

do_while_loop
    : 'do' block 'while' '(' expression ')'
    ;

block
    : '{' statement* '}'
    ;

// Functions
function_definition
    : TYPE VAR '(' parameter_list? ')' block
    | 'void' VAR '(' parameter_list? ')' block
    ;

parameter_list
    : TYPE VAR (',' TYPE VAR)*
    ;

function_call
    : VAR '(' argument_list? ')'
    ;

argument_list
    : expression_list
    ;

return_statement
    : 'return' expression?
    ;

// Pointers
pointer_manipulation
    : TYPE '*' VAR
    | VAR '=' '&' VAR
    | '*' VAR '=' expression
    ;

// Structs and Unions
struct_union_definition
    : 'struct' VAR '{' struct_members '}'
    | 'union' VAR '{' struct_members '}'
    ;

struct_members
    : (TYPE VAR EOL)+
    ;

// Preprocessor Directives
preprocessor_directive
    : '#include' '<' VAR '>'
    | '#define' VAR expression
    ;

// Tokens
EOL : ';';
TYPE : 'int' | 'float' | 'char' | 'double' | 'string';
VAR : [a-zA-Z_][a-zA-Z_0-9]*;
NUM : [0-9]+;
FLOAT_NUM : [0-9]+ '.' [0-9]+;
CHAR : '\'' . '\'';
STRING : '"' ~["]* '"';
COMMENT : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;
WS : [ \t\r\n]+ -> skip;
