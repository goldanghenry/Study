// 2014097056 ��ȭ��ǻ�� �켺�� �ڷᱸ�� 3���� ���� 1�� ����
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

	// 2���� ���� �迭 ����
	int** matrix_A = make2Array(row, column);
	int** matrix_B = make2Array(row, column);
	int** matrix_C = make2Array(row, column);
	
	// 2���� ���� ��� �ʱ�ȭ
	init2dArray(matrix_A, row, column);
	init2dArray(matrix_B, row, column);

	// 2���� ��� ���
	printf("maxtrix A\n");
	print2dArray(matrix_A, row, column);
	printf("maxtrix B\n");
	print2dArray(matrix_B, row, column);
	
	// 2���� ��İ� ����
	add(matrix_A, matrix_B, matrix_C, row, column);

	// ���� ��� ���
	printf("maxtrix C\n");
	print2dArray(matrix_C, row, column);

	// ���� �Ҵ� ����
	void free2dArray(a);
	void free2dArray(b);
	void free2dArray(c);
	printf("2d array - free!!!");
}

// 2���� �����迭 ����
int** make2Array(int rows, int cols) {
	int** x, i;
	MALLOC(x, rows * sizeof(*x));
	for (i = 0; i < rows;i++)
		MALLOC(x[i], cols * sizeof(**x));
	if (x == NULL) {
		printf("�����Ҵ� ����");
		exit(EXIT_FAILURE);
	}
	return x;
}

// 2���� �迭 �������� �ʱ�ȭ
void init2dArray(int** a, int rows, int cols) {
	for (int i = 0; i < rows;i++) {
		for (int j = 0; j < cols; j++)
			a[i][j] = rand() % 10;
	}
}

// 2���� �迭 ���
void print2dArray(int** a, int rows, int cols) {
	for (int i = 0; i < rows;i++) {
		for (int j = 0; j < cols; j++) {
			printf("%3d", a[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

// 2���� �迭 �� ����
void add(int** a, int** b, int** c, int rows, int cols) {
	for (int i = 0;i < rows;i++) {
		for (int j = 0; j < cols; j++)
			c[i][j] = a[i][j] + b[i][j];
	}
}

// 2���� ���� �Ҵ� �޸� ��ȯ
void free2dArray(int** a, int rows) {
	for (int i = 0; i < rows;i++)
		free(a[i]);
	free(a);
}