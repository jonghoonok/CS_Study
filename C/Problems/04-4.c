#include <stdio.h>

// 문제 1: 비트 연산을 이용하여 정수 값의 부호를 바꿔 출력하기
int main(void)
{
    int num;
    scanf("%d", &num);
    printf("%d", ~num + 1);
    return 0;
}