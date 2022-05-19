/* ��ȭ��ǻ�Ͱ��� 2014097056 �켺��
	< ���� 13-1 >
	�־��� undirected graph�� ���� adjacency matrix�� linked adjacency list�� ��ȯ�� ��, linked
	adjacency list�� ������ ����϶�.
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
	int** adjacencyM = make2DArray(n+1, n+1);	// ���� ���
	init2DArray(adjacencyM, n+1, n+1);		// 0���� ��� �ʱ�ȭ
	// adjacency matrix�� upper diagonal�� ���� �Է¹ޱ�
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

	// ���� ����Ʈ �Է� �� ����
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

	// ����Ʈ ���
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
	free2DArray(adjacencyM, n+1);			// �����Ҵ� �޸� ��ȯ
}

int** make2DArray(int rows, int cols) {
	int** x;
	MALLOC(x, sizeof(*x)*rows);
	for (int i = 0; i < rows; i++)
		MALLOC(x[i], sizeof(**x) * cols);
	if (x == NULL) {
		printf("�����Ҵ� ����");
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