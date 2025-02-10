#include <stdio.h>
#define PI 3.14
#define GREETING "Hello, World!"

int main() {
    int radius = 5;
    float area = PI * radius * radius;
    
    printf("%s\n", GREETING);
    printf("Área do círculo de raio %d: %.2f\n", radius, area);
    
    return 0;
}
