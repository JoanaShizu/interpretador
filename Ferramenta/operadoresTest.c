#include <stdio.h>

int main() {
    int a = 10;
    int b = 5; //depois testar com float
    int c = 3;

    // Operações Aritméticas
    printf("Operações Aritméticas:\n");
    printf("a + b = %d\n", a + b); // Adição
    printf("a - b = %d\n", a - b); // Subtração
    printf("a * b = %d\n", a * b); // Multiplicação
    printf("a / b = %d\n", a / b); // Divisão
    printf("a %% b = %d\n", a % b); // Módulo (resto da divisão inteira)

    // Operações Relacionais
    printf("\nOperações Relacionais:\n");
    printf("a == b = %d\n", a == b); // Igualdade
    printf("a != b = %d\n", a != b); // Diferente
    printf("a > b = %d\n", a > b);   // Maior que
    printf("a < b = %d\n", a < b);   // Menor que
    printf("a >= b = %d\n", a >= b); // Maior ou igual a
    printf("a <= b = %d\n", a <= b); // Menor ou igual a

    // Teste com expressões combinadas
    printf("\nTestes de Expressões Combinadas:\n");
    printf("(a + b) > c = %d\n", (a + b) > c); // Soma e comparação
    printf("(a - b) <= c = %d\n", (a - b) <= c); // Subtração e comparação
    printf("(a * c) == (b * b) = %d\n", (a * c) == (b * b)); // Multiplicação e igualdade
    printf("(a / c) != (b - c) = %d\n", (a / c) != (b - c)); // Divisão e diferença

    // Operadores Lógicos
    printf("\nTestes de Operadores Lógicos:\n");
    printf("(a > b) && (b > c) = %d\n", (a > b) && (b > c));
    printf("(a > b) || (c > b) = %d\n", (a > b) || (c > b));
    printf("!(a > b) = %d\n", !(a > b));
    /* saida esperada
        Operações Aritméticas:
        a + b = 15
        a - b = 5
        a * b = 50
        a / b = 2
        a % b = 0

        Operações Relacionais:
        a == b = 0
        a != b = 1
        a > b = 1
        a < b = 0
        a >= b = 1
        a <= b = 0

        Testes de Expressões Combinadas:
        (a + b) > c = 1
        (a - b) <= c = 0
        (a * c) == (b * b) = 0
        (a / c) != (b - c) = 1

        Testes de Operadores Lógicos:
        (a > b) && (b > c) = 1
        (a > b) || (c > b) = 1
        !(a > b) = 0

    */
    return 0;
}
