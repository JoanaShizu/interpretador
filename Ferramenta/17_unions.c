#include <stdio.h>

// Definição da union com int, float e char
union Dado {
    int inteiro;
    float decimal;
    char letra;
};

int main() {
    union Dado valor;
    int tipo = 0; // 1 = inteiro, 2 = float, 3 = char

    // Armazenando um inteiro
    valor.inteiro = 100;
    tipo = 1;
    printf("Inteiro armazenado: %d\n", valor.inteiro);

    // Armazenando um float (sobrescreve o inteiro)
    valor.decimal = 3.14;
    tipo = 2;
    printf("Float armazenado: %f\n", valor.decimal);

    // Armazenando um char (sobrescreve o float)
    valor.letra = 'A';
    tipo = 3;
    printf("Char armazenado: %c\n", valor.letra);

    return 0;
}
