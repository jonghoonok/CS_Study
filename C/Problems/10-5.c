#include <stdio.h>

int isPrime(int num)
{
    for(int n=2; n*n<=num; n++)
    {
        if(num % n == 0)
            return 0;
    }
    printf("%d ", num);
    return 1;
}

int main(void)
{
    int num = 2, cnt = 0;
    while(cnt < 10)
    {
        if(isPrime(num++))
            cnt++;
        else
            continue;
    }
    return 0;
}