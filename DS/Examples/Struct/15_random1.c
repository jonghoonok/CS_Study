/* 난수 생성 */
#include <stdio.h> 
#include <stdlib.h> 

int main(void)
{
	int x;
	int y;

	x = rand(); /* 0 이상 RAND_MAX 이하의 난수를 생성 */
	y = rand(); /* 0 이상 RAND_MAX 이하의 난수를 생성 */
	printf("x 값은 %d이고 y 값은 %d입니다.\n", x, y);

	return 0;
}