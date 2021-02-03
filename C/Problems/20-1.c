#include <stdio.h>

void rotateArr(int (*arr)[4])
{
    int rotatedArr[4][4];
    
    for(int i=0; i<4; i++)
    {
        for(int j=0; j<4; j++)
        {
            rotatedArr[i][j] = arr[3-j][i];
            printf("%d ", rotatedArr[i][j]);
        }
        printf("\n");
    }
    printf("\n");

    // arr = rotatedArr;
    // 이렇게 하면 함수 끝날 때 rotatedArr가 사라지기 때문에 arr가 가리키는 곳이 없어짐
    // 배열 이름은 따로 저장되지 않으므로 배열 이름을 가리키는 포인터를 이용한 swap은 애초에 불가능
    // 따라서 배열 내의 원소들을 일일이 바꿔주는 수밖에 없음
    // 그리고 함수 내에서 바뀐 배열의 원소들은 함수가 끝나도 유지됨
    // Call By Reference

}

int main(void)
{
    int arr[4][4] = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16},
    };
    for(int i=0; i<3; i++){
        rotateArr(arr);
        for(int i=0; i<4; i++)
        {
            for(int j=0; j<4; j++)
            {
                printf("%d ", arr[i][j]);
            }
            printf("\n");
        }
        printf("\n");
    }
    return 0;
}