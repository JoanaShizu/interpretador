#include <stdio.h>
#define PI 3.14

struct Point {
    int x;
    int y;
};

union Data {
    int i;
    float f;
};

void printPoint(struct Point p) {
    printf("Point: (%d, %d)\n", p.x, p.y);
}

int main(void) {
    int x = 10;
    float y = 5.5;
    char c = 'a';
    int arr[5] = {1, 2, 3, 4, 5};
    int *ptr = &x;

    printf("x: %d, y: %.2f, c: %c\n", x, y, c);
    printf("Pointer value: %d\n", *ptr);

    struct Point p = {10, 20};
    union Data d;
    d.i = 42;

    printPoint(p);
    printf("Union value: %d\n", d.i);

    if (x > 5) {
        printf("x is greater than 5\n");
    } else {
        printf("x is less than or equal to 5\n");
    }

    for (int i = 0; i < 5; i++) {
        printf("arr[%d]: %d\n", i, arr[i]);
    }

    return 0;
}
