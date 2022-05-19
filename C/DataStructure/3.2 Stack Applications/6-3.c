/* ��ȭ��ǻ�Ͱ��� 2014097056 �켺��	< ���� 6-3 >
   2�� �������� postfix ǥ���� ������ ����ϴ� �ڵ带 �߰��ϰ� ������ ���Ϸ� �Է¹޾� �� ���
   ����� ȭ�鿡 ����ϴ� �ڵ带 �ۼ��϶�.
 - ������ : +, -, *, / , %
 - �ǿ����� : 1~9 ������ �� �ڸ� ����
 - ��(��, ��)�� �����ڴ� ������� ����
 - divide by zero�� ���� �׽�Ʈ �� ó���� �������� ����
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_STACK_SIZE 100
#define MAX_EXPR_SIZE 100
typedef enum {lparen, rparen, plus, minus,	// ������ ����
	times, divide, mod, eos, operand } precedence;
precedence getToken(char* symbol, int* n);
int eval(void);
void push(int);
int pop();

int stack[MAX_STACK_SIZE]; /* global stack */
char expr[MAX_EXPR_SIZE];  /* global input string ( a postfix expression ) */
int top;

void main() {
	FILE* fp;	// ���� ������ ����
	int n=0;

	// ���� ���� �� �˻�
	fp = fopen("in3.txt", "r");	
	if (fp == NULL) {
		fprintf(stderr, "���� ���� ����");
		exit(EXIT_FAILURE);
	}

	// ���Ͽ��� postfix ǥ��� �޾� expr �迭�� �����ϱ�
	fgets(expr, MAX_EXPR_SIZE, fp);		// 62/3-42*+

	// ���� ����ϱ�
	printf("%d", eval());

	// ���� �ݱ�
	fclose(fp);	
}

precedence getToken(char* symbol, int* n) {
	*symbol = expr[(*n)++];		/* string �迭 */

	switch (*symbol) {
	case '(': return lparen;
	case ')': return rparen;
	case '+': return plus;
	case '-': return minus;
	case '/': return divide;
	case '*': return times;
	case '%': return mod;
	case '\0': return eos;
	default: return operand;	/* no error checking, default is operand */
	}
}

int eval(void) {
	precedence token;
	char symbol;
	int op1, op2;
	int n = 0; /* counter for the expression string */
	top = -1;
	token = getToken(&symbol, &n);
	while ( token != eos) {
		if (token == operand)
			push(symbol -'0'); /* convert: char  integer*/
		else {
			op2 = pop(); op1 = pop();
				switch(token) {
				case plus: push(op1+op2); break;
				case minus: push(op1-op2); break;
				case times: push(op1*op2); break;
				case divide: push(op1/op2); break;
				case mod: push(op1%op2);
				}
		}
		token = getToken(&symbol, &n);
	}
	return pop();	/* return result */
}
void push(int item) {
	/* add an item to the global stack */
	if (top >= MAX_STACK_SIZE - 1) {
		fprintf(stderr, "Stack is full, cannot add element");
		exit(EXIT_FAILURE);
	}
	stack[++top] = item;
}
int pop() {
	/* delete and return the top element from the stack */
	if (top == -1) printf("stack is full");
	return stack[top--];
}