// 2014097056 심화컴퓨터 우성현 자료구조 3차시 과제 1번 문제
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MALLOC(p,s) \
	if (!((p) = malloc(s))){ \
		fprintf(stderr, "Insufficient memory"); \
		exit(EXIT_FAILURE);	\
	}

int** make2Array(int rows, int cols);
void init2dArray(int **a, int rows, int cols);
void print2dArray(int **a, int rows, int cols);
void add(int **a, int **b, int **c, int rows, int cols);
void free2dArray(int **a, int rows);

void main() {
	srand((unsigned)time(NULL));
	int row, column;
	printf("Enter row size and column size (ex)3 4 :");
	scanf("%d", &row);
	scanf("%d", &column);

	// 2차원 동적 배열 생성
	int** matrix_A = make2Array(row, column);
	int** matrix_B = make2Array(row, column);
	int** matrix_C = make2Array(row, column);
	
	// 2차원 동적 행렬 초기화
	init2dArray(matrix_A, row, column);
	init2dArray(matrix_B, row, column);

	// 2차원 행렬 출력
	printf("maxtrix A\n");
	print2dArray(matrix_A, row, column);
	printf("maxtrix B\n");
	print2dArray(matrix_B, row, column);
	
	// 2차원 행렬간 덧셈
	add(matrix_A, matrix_B, matrix_C, row, column);

	// 덧셈 결과 출력
	printf("maxtrix C\n");
	print2dArray(matrix_C, row, column);

	// 동적 할당 해제
	void free2dArray(a);
	void free2dArray(b);
	void free2dArray(c);
	printf("2d array - free!!!");
}

// 2차원 동적배열 생성
int** make2Array(int rows, int cols) {
	int** x, i;
	MALLOC(x, rows * sizeof(*x));
	for (i = 0; i < rows;i++)
		MALLOC(x[i], cols * sizeof(**x));
	if (x == NULL) {
		printf("동적할당 실패");
		exit(EXIT_FAILURE);
	}
	return x;
}

// 2차원 배열 랜덤으로 초기화
void init2dArray(int** a, int rows, int cols) {
	for (int i = 0; i < rows;i++) {
		for (int j = 0; j < cols; j++)
			a[i][j] = rand() % 10;
	}
}

// 2차원 배열 출력
void print2dArray(int** a, int rows, int cols) {
	for (int i = 0; i < rows;i++) {
		for (int j = 0; j < cols; j++) {
			printf("%3d", a[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

// 2차원 배열 간 덧셈
void add(int** a, int** b, int** c, int rows, int cols) {
	for (int i = 0;i < rows;i++) {
		for (int j = 0; j < cols; j++)
			c[i][j] = a[i][j] + b[i][j];
	}
}

// 2차원 동적 할당 메모리 반환
void free2dArray(int** a, int rows) {
	for (int i = 0; i < rows;i++)
		free(a[i]);
	free(a);
}