#include <stdio.h>

void MaxAndMin(int* array, int** mnPtr, int** mxPtr)
{
    //int* max, min;  // 선언주의: 이러면 min은 포인터가 아니라 int 타입 변수가 됨
    int *max, *min;
    max = min = &array[0];

    for(int i=0; i<5; i++)
    {
        if(array[i] > *max)
            max = &array[i];
        if(array[i] < *min)
            min = &array[i];
    }

    *mnPtr = min;
    *mxPtr = max;
}

int main(void)
{
    int *minPtr, *maxPtr;
    int arr[5] = {1, 2, 3, 4, 5};

    MaxAndMin(arr, &minPtr, &maxPtr);

    printf("Max: %p, Min: %p", maxPtr, minPtr);
    return 0;
}