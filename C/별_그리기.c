// 1)�� �׸��� 2)������ �� ���ϱ� 3)��Ÿ��� ������ �����ϴ� �� ���ϱ�
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	// 1) �簢�� �Ǵ� �ﰢ�� �׸���
	int i,j,n;
	printf("������ ���� n�� �Է��ϼ���(0<=n<40):");
	scanf("%d", &n);
	if (n < 0 || n >= 40) {
		printf("�Է��� ������ ���� �Ǵ� 40�̻��Դϴ�.\n");
		printf("���α׷��� �����մϴ�.\n");
	}
	else if(n % 2 == 0) // ¦���� ��� : �簢��
	{
		for (i = 1; i <= n; i++) {
			for (j = 1;j <= n;j++)
				printf("*");
			printf("\n");
		}
	}
	else if (n % 2 == 1) //Ȧ���� ��� : �ﰢ��
	{
		for (i = 1;i <= n;i += 2) {
			for (j = 1;j <= (n - i) / 2;j++)
				printf(" ");
			for (j = 1;j <= i;j++)
				printf("*");
			printf("\n");
		}
	}

	// 2) ������ �� ���ϱ�
	int x, y=1;
	double sum=0.0;
	for (x = 1;x <= 199;x += 2,y++) {
		if (y % 2 == 0)
			sum -= ((float)x / (y * y));
		else
			sum += ((float)x / (y * y));
	}
	printf("\n--> ó����� : %f\n\n", sum);

	// 3) ��Ÿ��� ������ �����ϴ� ���� ���ϱ�
	int a, b, c, count=0;
	for (a = 1;a <= 2000;a++)
		for (b = a + 1;b <= 2000;b++)
			for (c = b + 1;c <= 2000;c++)
				if (a * a + b * b == c * c) {
					count++;
				}
	printf("\n--> ó����� :%dȸ\n", count);
	return 0;
}