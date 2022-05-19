/* 심화컴퓨터공학 2014097056 우성현
	< 문제 12-1 >
	주어진 level order traversal 출력 결과에 따라 complete binary tree 를 구성한 뒤,
	이 tree에 대해 inorder traversal 한 결과를 출력하라.
*/
#define _CRT_SECURE_NO_WARNINGS
#define MAX_ELEMENTS 200
#define HEAP_FULL(n) (n== MAX_ELEMENTS-1)
#define HEAP_EMPTY(n) (!n)
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	char data;
}element;

void inorderTraversal();

element CBT_List[MAX_ELEMENTS]; // heap
int stack[MAX_ELEMENTS]; //inorder에 쓸 스택
int n;

void main() {
	char temp;
	FILE* fp = fopen("in.txt", "r");
	if (fp == NULL) {
		fprintf(stderr, "file open failure!");
		exit(EXIT_FAILURE);
	}
	fscanf(fp, "%d", &n);
	for (int i = 1; i <= n; i++) {
		fgetc(fp);
		CBT_List[i].data = fgetc(fp);
	}
	fclose(fp);
	inorderTraversal();
}

void inorderTraversal() {
	int i = 1, top = -1;
	while (1) {
		while (n >= i) {
			stack[++top] = i;
			i = i * 2;
		}
		if (top == -1) return;
		i = stack[top--];
		printf("%c ", CBT_List[i].data);
		i = i * 2 + 1;
	}
}