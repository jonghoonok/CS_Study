#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    // printf("range of random number: from 0 to %d \n", RAND_MAX);
    printf("range of random number: from 0 to 99 \n");
    for(int i=0; i<5; i++)
        printf("print random numbers: %d \n", rand() % 100);
    return 0;
}