#include <stdio.h>
#define MAX 30
// Função que retorna a soma de dois números inteiros
int soma(int a, int b) {
    return a + b;
}

// Função que retorna a média de dois números reais
float media(float x, float y) {
    return (x + y) / 2;
}

int main() {
    //Resultado deve ser 40 
    int resultado = soma(10, MAX);
    printf("Soma: %d\n", resultado);

    //resultado deve ser 6.85
    float resultadoFloat = media(5.5, 8.2);
    printf("Média: %f\n", resultadoFloat);
    return 0;
}
