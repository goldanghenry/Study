// 1)별 그리기 2)수식의 합 구하기 3)피타고라스 정리를 만족하는 수 구하기
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	// 1) 사각형 또는 삼각형 그리기
	int i,j,n;
	printf("임의의 정수 n을 입력하세요(0<=n<40):");
	scanf("%d", &n);
	if (n < 0 || n >= 40) {
		printf("입력한 정수가 음수 또는 40이상입니다.\n");
		printf("프로그램을 종료합니다.\n");
	}
	else if(n % 2 == 0) // 짝수일 경우 : 사각형
	{
		for (i = 1; i <= n; i++) {
			for (j = 1;j <= n;j++)
				printf("*");
			printf("\n");
		}
	}
	else if (n % 2 == 1) //홀수일 경우 : 삼각형
	{
		for (i = 1;i <= n;i += 2) {
			for (j = 1;j <= (n - i) / 2;j++)
				printf(" ");
			for (j = 1;j <= i;j++)
				printf("*");
			printf("\n");
		}
	}

	// 2) 수식의 합 구하기
	int x, y=1;
	double sum=0.0;
	for (x = 1;x <= 199;x += 2,y++) {
		if (y % 2 == 0)
			sum -= ((float)x / (y * y));
		else
			sum += ((float)x / (y * y));
	}
	printf("\n--> 처리결과 : %f\n\n", sum);

	// 3) 피타고라스 정리를 만족하는 수를 구하기
	int a, b, c, count=0;
	for (a = 1;a <= 2000;a++)
		for (b = a + 1;b <= 2000;b++)
			for (c = b + 1;c <= 2000;c++)
				if (a * a + b * b == c * c) {
					count++;
				}
	printf("\n--> 처리결과 :%d회\n", count);
	return 0;
}