#include <stdio.h>

int snail(int cnt, int rot, int n, int* arr)    // 배열 길이가 문제가 됨: 동적할당 필요
{
    int i=rot, j=rot;
    int len = n - (1 + 2 * rot);

    if(len==0)
    {
        arr[i][j] = ++cnt;
        return cnt;
    }

    for(;j<len;j++)
        arr[i][j] = ++cnt;
    for(;i<len;i++)
        arr[i][j] = ++cnt;
    for(;j>rot;j--)
        arr[i][j] = ++cnt;
    for(;i>rot;i--)
        arr[i][j] = ++cnt;
    
    return cnt;
}

int main(void)
{
    int n = 0;
    scanf("%d", &n);
    int arr[n][n];

    int cnt=0, rot=0;;
    while(cnt < n*n)
    {
        cnt = snail(cnt, rot, n, arr);
        rot++;
    }

    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
        {
            printf("%2d", arr[i][j]);
        }
        printf("\n");
    }

    return 0;
}