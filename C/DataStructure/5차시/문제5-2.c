// 2014097056 ��ȭ��ǻ�� �켺�� �ڷᱸ�� 5���� ���� 2�� ����
#define _CRT_SECURE_NO_WARNINGS
#define MAX_STACK_SIZE 100
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int key;// store integer
} element;

element stack[MAX_STACK_SIZE];
int top = -1;

void push(int item);
void pop();
void stackEmpty();
void stackFull();

void main() {
	char CdKey;
	int data, checkF=1;

	while (checkF==1) {
		scanf_s("%c", &CdKey);
		switch (CdKey) {
		case 'I': scanf_s("%d", &data); push(data); break;	// insert
		case 'D': pop(); break;								// delete
		case 'F': checkF = -1; break;						// exit
		}
	}

	// ���
	for (int i = 0; i <= top; i++) {
		printf("%d ", stack[i].key);
	}
}

void push(int item) {
	/* add an item to the global stack */
	if (top >= MAX_STACK_SIZE - 1)
		stackFull();
	stack[++top].key = item;
}

void pop() {
	/* delete and return the top element from the stack */
	if (top == -1) {
		stackEmpty();	/* return an error key */
	}
	else top -= 1;
}

void stackFull() {
	fprintf(stderr, "Stack is full, cannot add element");
	exit(EXIT_FAILURE);
}

void stackEmpty() {
	printf("Stack empty\n");
}