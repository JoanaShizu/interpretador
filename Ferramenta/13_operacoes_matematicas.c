#include <stdio.h>

int main() {
    int a = 20;
    int b = 3;

    int soma = a + b;
    int subtracao = a - b;
    int multiplicacao = a * b;
    float divisao = a / b;  // Para divisão, convertemos para float
    int modulo = a % b;

    printf("Valores: a = %d, b = %d\n", a, b);
    printf("Adição: %d + %d = %d\n", a, b, soma);
    printf("Subtração: %d - %d = %d\n", a, b, subtracao);
    printf("Multiplicação: %d * %d = %d\n", a, b, multiplicacao);
    printf("Divisão: %d / %d = %f\n", a, b, divisao);
    printf("Módulo: %d %% %d = %d\n", a, b, modulo);

    return 0;
}
