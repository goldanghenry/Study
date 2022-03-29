/* 심화컴퓨터공학 2014097056 우성현	< 문제 6-3 >
   2번 과제에서 postfix 표기의 수식을 계산하는 코드를 추가하고 수식을 파일로 입력받아 그 계산
   결과를 화면에 출력하는 코드를 작성하라.
 - 연산자 : +, -, *, / , %
 - 피연산자 : 1~9 사이의 한 자리 정수
 - ‘(’, ‘)’ 연산자는 사용하지 않음
 - divide by zero에 대한 테스트 및 처리는 구현하지 않음
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_STACK_SIZE 100
#define MAX_EXPR_SIZE 100
typedef enum {lparen, rparen, plus, minus,	// 열거형 정의
	times, divide, mod, eos, operand } precedence;
precedence getToken(char* symbol, int* n);
int eval(void);
void push(int);
int pop();

int stack[MAX_STACK_SIZE]; /* global stack */
char expr[MAX_EXPR_SIZE];  /* global input string ( a postfix expression ) */
int top;

void main() {
	FILE* fp;	// 파일 포인터 선언
	int n=0;

	// 파일 오픈 및 검사
	fp = fopen("in3.txt", "r");	
	if (fp == NULL) {
		fprintf(stderr, "파일 오픈 실패");
		exit(EXIT_FAILURE);
	}

	// 파일에서 postfix 표기식 받아 expr 배열에 저장하기
	fgets(expr, MAX_EXPR_SIZE, fp);		// 62/3-42*+

	// 수식 계산하기
	printf("%d", eval());

	// 파일 닫기
	fclose(fp);	
}

precedence getToken(char* symbol, int* n) {
	*symbol = expr[(*n)++];		/* string 배열 */

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