#include <stdio.h>

int main() {
    int x;
    char str[100];

    printf("Digite um número inteiro: ");
    scanf("%d", &x);
    printf("Você digitou: %d\n", x);

    printf("Digite uma string: ");
    gets(str);
    puts(str);

    return 0;
}
