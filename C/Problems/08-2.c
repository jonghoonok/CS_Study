#include <stdio.h>

int main(void)
{
    int dan = 1, num;

    while(dan++ < 9)
    {
        num = 1;

        if (dan % 2 != 0)
            continue;
        while(num <= dan)
        {
            printf("%-2d * %2d = %2d\n", dan, num, dan * num);
            num++;
        }
    }

    return 0;
}