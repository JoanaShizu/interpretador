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
    valor.inteiro = 42;
    tipo = 1; // Define que armazenamos um inteiro

    // Verificação semântica antes de acessar
    if (tipo == 1) {
        printf("Inteiro armazenado: %d\n", valor.inteiro);
    } else {
        printf("Erro: Tentativa de acessar um tipo incorreto na union!\n");
    }

    // Armazenando um float (sobrescreve o inteiro)
    valor.decimal = 3.14;
    tipo = 2; // Atualiza o tipo para float

    if (tipo == 2) {
        printf("Float armazenado: %f\n", valor.decimal);
    } else {
        printf("Erro: Tentativa de acessar um tipo incorreto na union!\n");
    }

    // Armazenando um char (sobrescreve o float)
    valor.letra = 'A';
    tipo = 3; // Atualiza o tipo para char

    if (tipo == 3) {
        printf("Char armazenado: %c\n", valor.letra);
    } else {
        printf("Erro: Tentativa de acessar um tipo incorreto na union!\n");
    }

    return 0;
}
