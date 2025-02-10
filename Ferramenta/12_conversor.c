#include <stdio.h>
#include <stdlib.h>

int main() {
    char strInt[] = "12345";
    char strFloat[] = "3.1415";

    int num = atoi(strInt);
    float dnum = atof(strFloat);

    printf("String strInt convertida para int: %d\n", strInt, num);
    printf("String strFloat convertida para float: %f\n", strFloat, dnum);

    return 0;
}
