#include <stdio.h>

int main(void)
{
    int * arr1[5];
    int * arr2[3][5];

    int ** ptr1 = arr1;
    int* (*ptr2)[5] = arr2;
}