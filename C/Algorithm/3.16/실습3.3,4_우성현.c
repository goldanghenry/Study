/* 2014097056 심화컴퓨터 우성현 자료구조 3차시 과제 3.4번 문제

*** 프로그램이 수행될 수 있는 최대값 N = 46 ***

*** 프로그램 출력 결과 ***
* Iterative F(46) = 1836311903
* F(46) Iterative Time = 0.000000
* Recursive F(46) = 1836311903
* F(46) Iterative Time = 78.544000

* N = 47일 경우, 함수의 반환 타입(int) 범위 초과로 -1323752223 출력(오버플로)

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

	// 반복문으로 구현한 피보나치 출력
	start = clock();
	printf("Iterative F\(%d\) = %d\n", N, iFibo(N));
	duration = ((double)(clock() - start)) / CLOCKS_PER_SEC;
	printf("F\(%d\) Iterative Time = %f\n", N, duration);

	
	// 재귀함수로 구현한 피보나치 출력
	start = clock();
	printf("Recursive F\(%d\) = %d\n", N, rFibo(N));
	duration = ((double)(clock() - start)) / CLOCKS_PER_SEC;
	printf("F\(%d\) Iterative Time = %f\n", N, duration);
}

// 피보나치 수열 반복문으로 구현
int iFibo(int n) {
	for (int i = 0; i<n; i++) {
		c = a + b;
		a = b;
		b = c;
	}
	return a;
}

// 피보나치 수열 재귀함수로 구현
int rFibo(int i) {
	// 종료 조건(1 혹은 2일 때 1을 반환)
	if (i == 1 || i == 2) return 1;
	return rFibo(i - 1) + rFibo(i - 2);
}


