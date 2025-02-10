#include <stdio.h>

int main() {
    int a = 10; 
    int b = 20; 
    int c = 10;
    
    printf("Operadores Relacionais:\n");
    printf("a = %d, b = %d, c = %d\n", a, b, c);
    printf("a == b: %d\n", a == b);    // Espera 0 (falso)
    printf("a == c: %d\n", a == c);    // Espera 1 (verdadeiro)
    printf("a != b: %d\n", a != b);    // Espera 1 (verdadeiro)
    printf("a != c: %d\n", a != c);    // Espera 0 (falso)
    printf("a > b: %d\n", a > b);      // Espera 0 (falso)
    printf("a < b: %d\n", a < b);      // Espera 1 (verdadeiro)
    printf("a >= c: %d\n", a >= c);    // Espera 1 (verdadeiro)
    printf("b <= c: %d\n", b <= c);    // Espera 0 (falso)
    
    printf("\nOperadores Lógicos:\n");
    printf("(a == c) && (a < b): %d\n", (a == c) && (a < b)); // 1 && 1 = 1 (verdadeiro)
    printf("(a == c) || (a > b): %d\n", (a == c) || (a > b));   // 1 || 0 = 1 (verdadeiro)
    printf("!(a == c): %d\n", !(a == c));                       // !1 = 0 (falso)
    printf("!(a > b): %d\n", !(a > b));                         // !0 = 1 (verdadeiro)
    
    return 0;
}
