#include <stdio.h>

// Função sem retorno
void sayHello() {
    printf("Hello, world!\n");
}

// Função com retorno
int add(int a, int b) {
    return a + b;
}

int main() {
    // Invocação de função sem retorno
    sayHello();

    // Invocação de função com retorno
    int sum = add(10, 20);
    printf("Sum: %d\n", sum);

    return 0;
}
