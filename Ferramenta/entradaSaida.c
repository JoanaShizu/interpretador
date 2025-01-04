int main() {
    int x;
    char str[50];

    printf("Digite um número: ");
    scanf("%d", &x);

    printf("Você digitou: %d\n", x);

    printf("Digite uma string: ");
    gets(str);

    puts(str);

    return 0;
}
