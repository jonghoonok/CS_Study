#include <stdio.h>

int main(void)
{
    int cnt = 0, sum = 0, num = 0;

    while(cnt++ < 5)
    {
        while(num > 0)
        {
            scanf("%d", &num);
        }
        sum += num;
        num = 0;
    }
    printf("%d", sum);
    return 0;
}