#include <stdio.h>

int main() {
    // Declaração e inicialização de variáveis
    int x = 10;          // Declaração de uma variável inteira
    float y = 5.5;       // Declaração de uma variável ponto flutuante
    char c = 'a';        // Declaração de uma variável caractere

    // Declaração e manipulação de array
    int arr[5];          // Declaração de um array de inteiros com 5 elementos
    arr[0] = 10;         // Atribuição ao primeiro elemento do array
    arr[1] = 20;         // Atribuição ao segundo elemento do array

    // Declaração de ponteiro
    int *ptr;            // Declaração de um ponteiro para inteiro
    ptr = &x;            // Atribuição do endereço da variável x ao ponteiro
    *ptr = 20;           // Modifica o valor da variável apontada por ptr

    // Impressão dos resultados
    printf("x: %d\n", x);       // Deve imprimir: x: 20
    printf("y: %.1f\n", y);     // Deve imprimir: y: 5.5
    printf("c: %c\n", c);       // Deve imprimir: c: a
    printf("arr[0]: %d\n", arr[0]); // Deve imprimir: arr[0]: 10
    printf("arr[1]: %d\n", arr[1]); // Deve imprimir: arr[1]: 20
    printf("Valor apontado por ptr: %d\n", *ptr); // Deve imprimir: Valor apontado por ptr: 20

    return 0;
}
