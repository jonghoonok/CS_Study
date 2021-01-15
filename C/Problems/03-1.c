#include <stdio.h>

int main(void)
{
    int num1, num2;
    int result;

    scanf("%d %d", &num1, &num2);
    result = num1 + num2;
    printf("The sum of two numbers is %d\n", result);

    result = num1 - num2;
    printf("The difference of two numbers is %d", result);
    
    return 0;
}