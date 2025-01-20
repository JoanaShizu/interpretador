#include <stdio.h>
#include <stdlib.h>

// 1. Declaração e Inicialização de Variáveis
int x = 10;
float y = 3.14;
char c = 'A';
int arr[5] = {1, 2, 3, 4, 5};

// 2. Estruturas de Controle
void testarControles() {
    // if-else
    if (x > 5) {
        printf("x é maior que 5\n");
    } else {
        printf("x é menor ou igual a 5\n");
    }

    // switch-case
    switch (c) {
        case 'A':
            printf("Letra A\n");
            break;
        case 'B':
            printf("Letra B\n");
            break;
        default:
            printf("Outra letra\n");
    }

    // for
    for (int i = 0; i < 5; i++) {
        printf("arr[%d] = %d\n", i, arr[i]);
    }

    // while
    int i = 0;
    while (i < 3) {
        printf("i = %d\n", i);
        i++;
    }

    // do-while
    i = 0;
    do {
        printf("do-while i = %d\n", i);
        i++;
    } while (i < 3);
}

// 3. Entrada e Saída
void testarEntradaSaida() {
    int a;
    // printf
    printf("Digite um número: ");
    scanf("%d", &a);
    printf("Você digitou: %d\n", a);

    // gets e puts (atenção: gets pode ser inseguro)
    char str[50];
    printf("Digite uma string: ");
    gets(str);  // Nota: gets pode causar problemas de segurança
    printf("Você digitou: ");
    puts(str);
}

// 4. Operadores
void testarOperadores() {
    int a = 10, b = 3;
    printf("Soma: %d\n", a + b);
    printf("Subtração: %d\n", a - b);
    printf("Multiplicação: %d\n", a * b);
    printf("Divisão: %d\n", a / b);
    printf("Módulo: %d\n", a % b);
    printf("Igualdade: %d\n", a == b);
    printf("Diferente: %d\n", a != b);
    printf("Maior que: %d\n", a > b);
    printf("Menor que: %d\n", a < b);
    printf("Maior ou igual: %d\n", a >= b);
    printf("Menor ou igual: %d\n", a <= b);
    printf("E lógico: %d\n", (a > b) && (b > 0));
    printf("Ou lógico: %d\n", (a > b) || (b < 0));
    printf("Negação lógica: %d\n", !(a == b));
}

// 5. Manipulação de Ponteiros
void testarPonteiros() {
    int x = 5, *ptr;
    ptr = &x;
    printf("Valor de x: %d\n", x);
    printf("Valor de ptr (endereço de x): %p\n", ptr);
    *ptr = 20;
    printf("Novo valor de x através do ponteiro: %d\n", x);
}

// 6. Funções
int soma(int a, int b) {
    return a + b;
}

void testarFuncoes() {
    printf("Soma de 5 e 10: %d\n", soma(5, 10));
}

// 7. Estruturas e Unions
struct Ponto {
    int x;
    int y;
};

union Valor {
    int inteiro;
    float flutuante;
};

void testarEstruturasEUnions() {
    struct Ponto p1 = {10, 20};
    printf("Ponto: (%d, %d)\n", p1.x, p1.y);

    union Valor v;
    v.inteiro = 5;
    printf("Valor inteiro: %d\n", v.inteiro);
    v.flutuante = 3.14;
    printf("Valor flutuante: %f\n", v.flutuante);
}

// 8. Diretivas do Pré-processador
#define PI 3.14

void testarPreProcessador() {
    printf("O valor de PI é: %f\n", PI);
}

// 9. Comentários
// Comentário de uma linha
/*
Comentário de bloco
*/

int main() {
    // Testando todas as funcionalidades
    testarControles();
    testarEntradaSaida();
    testarOperadores();
    testarPonteiros();
    testarFuncoes();
    testarEstruturasEUnions();
    testarPreProcessador();

    return 0;
}
