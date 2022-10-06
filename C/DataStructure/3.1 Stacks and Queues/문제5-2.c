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
int pop();
void stackEmpty();
void stackFull();

void main() {
	while (true) {
		int n = 0;
		printf('--------�޴�--------\n');
		printf('1. push\n');
		printf('2. pop\n');
		printf('3. print\n');
		printf('4. exit\n');
		printf('--------------------\n');

		scanf('%d', &n);
		switch (n) {
		case 1:
			printf('push�� ������ �Է����ּ��� :');
			scanf('%d', &n);
			push(n); break;
		case 2:
			printf('%d�� pop �߽��ϴ�.', pop()); break;
		case 3:
			printf('stack�� ����մϴ�.\n');
			for (int i = 0; i <= top; i++) {
				printf("%d ", stack[i].key);
			}
		case 4:
			exit(0)
		}
	}
}

void push(int item) {
	/* add an item to the global stack */
	if (top >= MAX_STACK_SIZE - 1)
		stackFull();
	stack[++top].key = item;
}

int pop() {
	/* delete and return the top element from the stack */
	if (top == -1) {
		stackEmpty();	/* return an error key */
	}
	else {
		top -= 1;
		t = top + 1;
		return stack[t].key;
	}
}

void stackFull() {
	fprintf(stderr, "Stack is full, cannot add element");
	exit(EXIT_FAILURE);
}

void stackEmpty() {
	printf("Stack empty\n");
}