#include <stdio.h>

int main() {
    int a;       // Declarada, mas sem inicialização
    float b;     // Declarada, mas sem inicialização

    // Tenta usar 'a' sem inicialização:
    b = a + 1.0;  // 'a' não foi inicializada, portanto a verificação deve detectar esse erro

    printf("a = %d\n", a);
    printf("b = %f\n", b);

    return 0;
}
