/* 2014097056 ��ȭ��ǻ�� �켺�� �ڷᱸ�� 3���� ���� 3.4�� ����

*** ���α׷��� ����� �� �ִ� �ִ밪 N = 46 ***

*** ���α׷� ��� ��� ***
* Iterative F(46) = 1836311903
* F(46) Iterative Time = 0.000000
* Recursive F(46) = 1836311903
* F(46) Iterative Time = 78.544000

* N = 47�� ���, �Լ��� ��ȯ Ÿ��(int) ���� �ʰ��� -1323752223 ���(�����÷�)

*/
#define _CRT_SECURE_NO_WANINGS
#include <stdio.h>
#include <time.h>

int a=0, b=1, c;

int iFibo(int n);
int rFibo(int i);

void main() {
	int N;
	clock_t start;
	double duration;
	scanf_s("%d", &N);

	// �ݺ������� ������ �Ǻ���ġ ���
	start = clock();
	printf("Iterative F\(%d\) = %d\n", N, iFibo(N));
	duration = ((double)(clock() - start)) / CLOCKS_PER_SEC;
	printf("F\(%d\) Iterative Time = %f\n", N, duration);

	
	// ����Լ��� ������ �Ǻ���ġ ���
	start = clock();
	printf("Recursive F\(%d\) = %d\n", N, rFibo(N));
	duration = ((double)(clock() - start)) / CLOCKS_PER_SEC;
	printf("F\(%d\) Iterative Time = %f\n", N, duration);
}

// �Ǻ���ġ ���� �ݺ������� ����
int iFibo(int n) {
	for (int i = 0; i<n; i++) {
		c = a + b;
		a = b;
		b = c;
	}
	return a;
}

// �Ǻ���ġ ���� ����Լ��� ����
int rFibo(int i) {
	// ���� ����(1 Ȥ�� 2�� �� 1�� ��ȯ)
	if (i == 1 || i == 2) return 1;
	return rFibo(i - 1) + rFibo(i - 2);
}


