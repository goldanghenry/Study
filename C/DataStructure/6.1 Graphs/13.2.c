/* 심화컴퓨터공학 2014097056 우성현
	< 문제 13-2 >
	아래 undirected graph G1를 multilist로 구성한 뒤, 각 vertex의 adjacency list의 내용을 출력하라
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

// 전역 변수
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
	adjList = (vertexPointer*)calloc(Vn, sizeof(vertexPointer));	// vertex 동적할당
	N = (vertex*)calloc(En, sizeof(vertex));					// edge 동적할당

	for (int i = 0; i < En; i++) {
		fscanf_s(fp, "%d %d", &u, &v);
		N[i].vertex1 = u; 
		N[i].vertex2 = v;
		// adjList와 edge 연결
		for (int j = 0; j < Vn; j++) {	
			if (j == u && !adjList[j]) adjList[j] = &N[i]; // adjList[j]가 vertex1과 같은 경우
			if (j == v && !adjList[j]) adjList[j] = &N[i]; // adjList[j]가 vertex2와 같은 경우
		}
		// edge 간 링크 연결
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