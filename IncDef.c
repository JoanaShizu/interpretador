//#include <>
#include <stdio.h>
#include <math.h>


#define PI 3.14159
#define MAX 100
#define LETRA 'A'
//#define PI 2256

int main() {
    int x = MAX;
    float y = PI; // A variável 'y' receberá a constante PI

    printf("x = %d\n", x);
    printf("y = %f\n", y); // Imprimindo 'y' como float


    printf("Novo valor de PI: %f\n", PI);  // Tentando imprimir PI, mas agora é uma string, o que causará erro.

    printf("LETRA = %c\n", LETRA);
    return 0;
}
