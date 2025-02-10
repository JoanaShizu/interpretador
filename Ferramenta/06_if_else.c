#include <stdio.h>

int main() {
    int a = 10;
    int b = 20;
    int c = 0;

    // Estrutura condicional if-else-if-else
    if (a > b) {
        c = a;
        printf("Condição 1: a é maior que b\n");
    } else if (a == b) {
        c = a + b;
        printf("Condição 2: a é igual a b\n");
    } else {
        c = b;
        printf("Condição 3: a é menor que b\n");
    }

    printf("Valor de c = %d\n", c);

    // Um teste adicional com uma condição simples
    if (c > 10) {
        printf("Teste adicional: c é maior que 10\n");
    } else {
        printf("Teste adicional: c é menor ou igual a 10\n");
    }
    
    return 0;
}
