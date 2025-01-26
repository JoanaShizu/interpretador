#include <stdio.h>

int main() {
    // Declaração e inicialização de variáveis
    int x = 10;                 // Variável inteira
    float y = 5.5;              // Variável ponto flutuante
    char c = 'a';               // Variável caractere
    int arr[5];                 // Array de inteiros com 5 elementos

    // Exibe os valores iniciais
    printf("Valor inicial de x (int): %d\n", x);
    printf("Valor inicial de y (float): %.2f\n", y);
    printf("Valor inicial de c (char): %c\n", c);

    // Inicializa o array com valores
    for (int i = 0; i < 5; i++) {
        arr[i] = i + 1; // Define valores de 1 a 5
    }

    // Exibe os valores do array
    printf("Valores do array (arr): ");
    for (int i = 0; i < 5; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    // Operações com as variáveis
    x += 5;  // Incrementa x
    y *= 2;  // Multiplica y por 2
    c += 1;  // Incrementa o caractere (ASCII)

    // Exibe os valores após as operações
    printf("Novo valor de x (int): %d\n", x);
    printf("Novo valor de y (float): %.2f\n", y);
    printf("Novo valor de c (char): %c\n", c);

    int array[3] = {1, 2, 3};
    printf("Valores do array: %d %d %d\n", array[0], array[1], array[2]);

    return 0;
}
