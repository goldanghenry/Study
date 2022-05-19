/* 심화컴퓨터공학 2014097056 우성현
	< 문제 13-1 >
	주어진 undirected graph에 대한 adjacency matrix를 linked adjacency list로 변환한 뒤, linked
	adjacency list의 내용을 출력하라.
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define MALLOC(p,s)\
if(!((p)=malloc(s))){\
	fprintf(stderr, "insufficient memory!");\
	exit(EXIT_FAILURE);\
}
typedef struct node* nodePointer;
typedef struct node {
	int data;
	nodePointer link;
};

int** make2DArray(int rows, int cols);
void init2DArray(int** a, int rows, int cols);
void free2DArray(int** a, int rows);
nodePointer makeNode(int data);

void main() {
	int n, temp;
	FILE* fp = fopen("in1.txt", "r");
	if (!fp) {
		fprintf(stderr, "File open failure!");
		exit(EXIT_FAILURE);
	}
	fscanf(fp, "%d", &n);
	int** adjacencyM = make2DArray(n+1, n+1);	// 인접 행렬
	init2DArray(adjacencyM, n+1, n+1);		// 0으로 행렬 초기화
	// adjacency matrix의 upper diagonal로 원소 입력받기
	for (int i = 1; i < n; i++) {
		for (int j = i + 1; j <= n; j++) {
			fscanf(fp, "%d", &temp);
			if (temp) {
				adjacencyM[i][j] = 1;
				adjacencyM[j][i] = 1;
			}
		}
	}

	// adjacency List
	nodePointer *adjacencyL = (nodePointer)malloc(sizeof(nodePointer) * (n+1));

	// 연결 리스트 입력 및 연결
	nodePointer cur = NULL;
	for (int i = 1; i <= n; i++) {
		cur = &adjacencyL[i];
		for (int j = 1; j <= n; j++) {
			if (adjacencyM[i][j]) {
				cur->link = makeNode(j);
				cur = cur->link;
			}
		}
	}

	// 리스트 출력
	for (int i = 1; i <= n; i++) {
		cur = &adjacencyL[i];
		cur = cur->link;
		printf("Vertex %d: ", i);
		while(cur){
			printf("%d ", cur->data);
			cur = cur->link;
		}
		printf("\n");
	}
	fclose(fp);
	free2DArray(adjacencyM, n+1);			// 동적할당 메모리 반환
}

int** make2DArray(int rows, int cols) {
	int** x;
	MALLOC(x, sizeof(*x)*rows);
	for (int i = 0; i < rows; i++)
		MALLOC(x[i], sizeof(**x) * cols);
	if (x == NULL) {
		printf("동적할당 실패");
		exit(EXIT_FAILURE);
	}
	return x;
}

void init2DArray(int** a, int rows, int cols) {
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
			a[i][j] = 0;
		}
	}
}

void free2DArray(int** a, int rows) {
	for (int i = 0; i < rows; i++)
		free(a[i]);
	free(a);
}

nodePointer makeNode(int data) {
	nodePointer x = NULL;
	MALLOC(x, sizeof(*x));
	x->data = data;
	x->link = NULL;
	return x;
}