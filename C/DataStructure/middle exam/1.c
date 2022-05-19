// 2014097056 - ¿ì¼ºÇö
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#define TRUE 1
#define FALSE 0
#define MALLOC(p,s)\
if(!((p)=malloc(s) )){\
	fprintf(stderr, "insufficient memory!");\
	exit(EXIT_FAILURE);\
}

typedef struct {
	int data;
}element;

int capacity = 1;
element *stack;
int top = -1;

void push(int data);
void pop();
void stackEmpty();
void stackFull();

void main() {
	FILE* fp = fopen("in3.txt", "r");
	if (fp == NULL) {
		fprintf(stderr, "file open failure!");
		exit(EXIT_FAILURE);
	}
	char key;
	int data;
	MALLOC(stack, sizeof(*stack));

	while (feof(fp)==0) {
		fscanf(fp, "%c", &key);
		switch (key) {
		case 'I':
			fscanf(fp, "%d", &data); 
			push(data); break;
		case 'D': pop(); break;
		default: break;
		}
	}

	for (int i = 0; i <= top; i++) {
		printf("%d ", stack[i].data);
	}
}
void push(int data) {
	if (top >= capacity-1) {
		stackFull();
	}
	stack[++top].data = data;
}
void pop() {
	if (top == -1) {
		stackEmpty();
	}
	else {
		--top;
	}
}
void stackEmpty() {
	printf("stack is Empty!\n");
}
void stackFull() {
	capacity *= 2;
	stack = realloc(stack, sizeof(*stack) *capacity);
}