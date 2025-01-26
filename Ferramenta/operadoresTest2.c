#include <stdio.h>

int main() {
    int a, b;

    // Solicita ao usuário que insira dois números inteiros
    printf("Digite o primeiro número inteiro (a): ");
    scanf("%d", &a);

    printf("Digite o segundo número inteiro (b): ");
    scanf("%d", &b);

    // Testa os operadores de comparação e exibe os resultados
    if (a > b) {
        printf("a (%d) é maior que b (%d).\n", a, b);
    } else if (a < b) {
        printf("a (%d) é menor que b (%d).\n", a, b);
    } else {
        printf("a (%d) é igual a b (%d).\n", a, b);
    }

    if (a >= b) {
        printf("a (%d) é maior ou igual a b (%d).\n", a, b);
    }

    if (a <= b) {
        printf("a (%d) é menor ou igual a b (%d).\n", a, b);
    }

    return 0;
}
