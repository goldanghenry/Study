/* ��ȭ��ǻ�Ͱ��� 2014097056 �켺��
	< ���� 12-1 >
	�־��� level order traversal ��� ����� ���� complete binary tree �� ������ ��,
	�� tree�� ���� inorder traversal �� ����� ����϶�.
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
int stack[MAX_ELEMENTS]; //inorder�� �� ����
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