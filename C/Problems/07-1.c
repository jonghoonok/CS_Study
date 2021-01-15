#include <stdio.h>

int main(void)
{
    int n, cnt = 0, num = 0, sum = 0;

    printf("how many numbers do you need to get the average value?: ");
    scanf("%d", &n);

    while(cnt++ < n)
    {
        scanf("%d", &num);
        sum += num;
    }

    printf("The average is %f", (double)sum / n);

    return 0;
}