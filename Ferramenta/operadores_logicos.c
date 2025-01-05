#include <stdio.h>

int main() {
    int a = 5;
    int b = 10;
    int c = 0;

    // Teste com &&
    if (a < b && b > c) {
        printf("\nTeste 1: a < b && b > c é verdadeiro.\n");
    } else {
        printf("Teste 1: a < b && b > c é falso.\n");
    }

    // Teste com ||
    if (a > b || c == 0) {
        printf("\nTeste 2: a > b || c == 0 é verdadeiro.\n");
    } else {
        printf("Teste 2: a > b || c == 0 é falso.\n");
    }

    // Combinação de && e ||
    if ((a < b && c != 0) || b > 5) {
        printf("\nTeste 3: (a < b && c != 0) || b > 5 é verdadeiro.\n");
    } else {
        printf("Teste 3: (a < b && c != 0) || b > 5 é falso.\n");
    }

    // Negação com !
    if (!(a > b)) {
        printf("\nTeste 4: !(a > b) é verdadeiro.\n");
    } else {
        printf("Teste 4: !(a > b) é falso.\n");
    }

    return 0;
}
