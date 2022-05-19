/* 심화컴퓨터공학 2014097056 우성현
	< 문제 14-2 >
	위의 프로그램을 이용하여, in.txt로 주어진 undirected graph가 몇 개의 connected component로
	구성되었는지 계산하여 화면에 출력하라.
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define MAX_VERTICES 100
#define FALSE 0
#define TRUE 1
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
nodePointer* adjacencyL;
int count = 0;
int** make2DArray(int rows, int cols);
void init2DArray(int** a, int rows, int cols);
void free2DArray(int** a, int rows);
nodePointer makeNode(int data);
short int visited[MAX_VERTICES];
void dfs(int v);
void connect(int n);

void main() {
	int n, temp, v;
	FILE* fp = fopen("in.txt", "r");
	if (!fp) {
		fprintf(stderr, "File open failure!");
		exit(EXIT_FAILURE);
	}
	fscanf(fp, "%d", &n);
	int** adjacencyM = make2DArray(n + 1, n + 1);	// 인접 행렬
	init2DArray(adjacencyM, n + 1, n + 1);		// 0으로 행렬 초기화
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
	adjacencyL = (nodePointer)malloc(sizeof(nodePointer) * (n + 1));

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
	connect(n);
	printf("%d", count);
	fclose(fp);
	free2DArray(adjacencyM, n + 1);			// 동적할당 메모리 반환
}

void connect(int n) {
	/* determine the connected components of a graph */
	for (int i = 1; i <= n; i++) {
		if (!visited[i]) {
			dfs(i); count++;
		}
	}
}

void dfs(int v) {
	/* depth first search of a graph begining at v */
	nodePointer w;
	w = &adjacencyL[v];
	w = w->link;
	visited[v] = TRUE;
	for (; w; w = w->link)
		if (!visited[w->data])
			dfs(w->data);
}

int** make2DArray(int rows, int cols) {
	int** x;
	MALLOC(x, sizeof(*x) * rows);
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