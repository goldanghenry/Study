/* ��ȭ��ǻ�Ͱ��� 2014097056 �켺��
	< ���� 13-2 >
	�Ʒ� undirected graph G1�� multilist�� ������ ��, �� vertex�� adjacency list�� ������ ����϶�
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct vertex* vertexPointer;
typedef struct vertex {
	int vertex1;
	vertexPointer link1;
	int vertex2;
	vertexPointer link2;
} vertex;

// ���� ����
vertexPointer* adjList;
vertex* N;
int Vn, En, u, v;

void printG();

void main() {
	FILE* fp= fopen("in2.txt", "r");
	if (!fp) {
		fprintf(stderr, "File opne failure!");
		exit(EXIT_FAILURE);
	}

	fscanf_s(fp, "%d %d", &Vn, &En);
	adjList = (vertexPointer*)calloc(Vn, sizeof(vertexPointer));	// vertex �����Ҵ�
	N = (vertex*)calloc(En, sizeof(vertex));					// edge �����Ҵ�

	for (int i = 0; i < En; i++) {
		fscanf_s(fp, "%d %d", &u, &v);
		N[i].vertex1 = u; 
		N[i].vertex2 = v;
		// adjList�� edge ����
		for (int j = 0; j < Vn; j++) {	
			if (j == u && !adjList[j]) adjList[j] = &N[i]; // adjList[j]�� vertex1�� ���� ���
			if (j == v && !adjList[j]) adjList[j] = &N[i]; // adjList[j]�� vertex2�� ���� ���
		}
		// edge �� ��ũ ����
		for (int j = 0; j < i; j++) {	
			if (N[j].vertex1 == u && !N[j].link1) N[j].link1 = &N[i];
			if (N[j].vertex2 == u && !N[j].link2) N[j].link2 = &N[i];
			if (N[j].vertex1 == v && !N[j].link1) N[j].link1 = &N[i];
			if (N[j].vertex2 == v && !N[j].link2) N[j].link2 = &N[i];
		}
	}
	fclose(fp);
	printG();
}

void printG() {
	vertexPointer cur; 
	int i;
	for (i = 0; i < Vn; i++) {
		printf("Vertex %d: ", i);
		cur = adjList[i];
		while(cur) {
			printf("(%d, %d)", cur->vertex1, cur->vertex2);
			if (i == cur->vertex1) cur = cur->link1;
			else cur = cur->link2;
		}
		printf("\n");
	}
}