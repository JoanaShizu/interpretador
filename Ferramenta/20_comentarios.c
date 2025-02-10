#include <stdio.h>

int main() {
    // Este é um comentário de uma linha
    printf("Teste de comentário de uma linha\n");

    /* 
       Este é um comentário de bloco.
       Ele pode ocupar várias linhas e deve ser ignorado pelo interpretador.
    */
    
    int x = 20; // Comentário ao lado da declaração

    /* 
       Comentário de bloco antes de uma operação.
       Vamos somar dois números.
    */
    int y = 20;
    int soma = x + y;  // Soma de dois números

    printf("Soma: %d\n", soma);

    return 0;
}
