#include <stdio.h>

int gcd(int a, int b)
{
    int r = a % b;
    if(r == 0)
        return b;
    else
        return gcd(b, r);
}

int main(void)
{
    int num1, num2;
    scanf("%d %d", &num1, &num2);
    
    int small, big;
    if(num1 < num2)
    {
        small = num1;
        big = num2;
    }
    else
    {
        small = num2;
        big = num1;
    }

    int result = gcd(big, small);
    printf("gcd of %d and %d is %d", num1, num2, result);
    
    return 0;
}  