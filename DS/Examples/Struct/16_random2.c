/* 난수 생성(난수의 seed(씨앗)을 현재 시간에 따라 결정) */
#include < time.h > 
#include < stdio.h > 
#include < stdlib.h > 

int main(void)
{
	int x;
	int y;

	srand(time(NULL));
	x = rand(); /* 0 이상 RAND_MAX 이하의 난수를 생성 */
	y = rand(); /* 0 이상 RAND_MAX 이하의 난수를 생성 */
	printf("x 값은 %d이고 y 값은 %d입니다.\n", x, y);

	return 0;
}