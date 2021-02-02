#include <stdio.h>

int main(void)
{
    char  str1[] = "My String";
    char* str2 = "My String";
    printf("%s \n", str1);
    printf("%s \n", str2);

    str1[1] = 'K';
    // *(str2+1) = 'J';     // Data 영역에 저장된 데이터를 건드림: segmentation fault
    printf("%s \n", str1);
    // printf("%s \n", str2);
}