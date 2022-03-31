/* 심화컴퓨터공학 2014097056 우성현	
   < 문제 7-1 >
   infix 표기로 표현된 수식을 파일로 입력받아 postfix 표기로 변환해서 화면에 출력하는 코드를
   작성하라. (program 3.14, 3.15)
*/
#define _CRT_SECURE_NO_WARNINGS
#define MAX_STACK_SIZE 100
#define MAX_EXPR_SIZE 100
#include <stdio.h>
#include <stdlib.h>

typedef enum {   /* 열거형 정의(constants) */
    lparen, rparen, plus, minus,    
    times, divide, mod, eos, operand
} precedence;

precedence getToken(char* symbol, int* n);
void postfix(void);
void printToken(precedence token);
void push(int item);
int pop();
void stackFull();
void stackEmpty();

/* isp and icp arrays index is value of precedence : lparen , rparen , plus, minus, times, divide, mod, eos */
int isp[] = { 0,19, 12, 12, 13, 13, 13, 0 };     /* in - stack precedence */
int icp[] = { 20, 19, 12, 12, 13, 13, 13, 0 };   /* incoming precedence */
int stack[MAX_STACK_SIZE];                       /* global stack */
char expr[MAX_EXPR_SIZE];                        /* global input string ( a postfix expression ) */
int n = 0;
int top = -1;

/***************************** run ********************************/
void main() {
    FILE* fp;   /* declare File Pointer */

    /* File open& Error Checking */ 
    fp = fopen("in1.txt", "r");
    if (fp == NULL) {
        fprintf(stderr, "파일 오픈 실패");
        exit(EXIT_FAILURE);
    }

    /* 파일에서 infix 표기식을 입력받아 expr[]에 저장하기 */ 
    fgets(expr, MAX_EXPR_SIZE, fp);      /* e / (f + a * d) + c */ 

    /* infix -> postfix */ 
    postfix();

    /* close File */ 
    fclose(fp);
}
/******************************************************************/
void postfix(void) {
    char symbol; precedence token;
    n = 0;
    top = 0; /* place eos on stack */
    stack[0] = eos;
    for (token = getToken(&symbol, &n); token != eos; token = getToken(&symbol, &n)) {
        if (token == operand)   /* operand의 경우 바로 출력 */
            printf("%c ", symbol);
        else if (token == rparen) {  /* unstack tokens until left parenthesis */
            while (stack[top] != lparen)
                printToken(pop());
            pop();   /* discard the left parenthesis */
        }
        else {  /* remove and print symbols whose isp is greater than or equal to the current token's icp */
            while (isp[stack[top]] >= icp[token])
                printToken(pop());
            push(token);
        }
    }
    while ((token = pop()) != eos) printToken(token);
    printf("\n");
}
precedence getToken(char* symbol, int* n) {
    *symbol = expr[(*n)++];      /* string 배열 */

    switch (*symbol) {
    case '(': return lparen;
    case ')': return rparen;
    case '+': return plus;
    case '-': return minus;
    case '/': return divide;
    case '*': return times;
    case '%': return mod;
    case '\0': return eos;
    default: return operand;   /* no error checking, default is operand */
    }
}
void printToken(precedence token) {
    switch (token) {
    case lparen:printf("( ");  break;
    case rparen:printf(") ");  break;
    case plus:  printf("+ ");  break;
    case minus: printf("- ");  break;
    case divide:printf("/ ");  break;
    case times: printf("* ");  break;
    case mod:   printf("%% "); break;
    case eos:   printf(" ");   break;
    default:    printf("\n ");
    }
}
void push(int item) {
    /* add an item to the global stack */
    if (top >= MAX_STACK_SIZE - 1) {
        stackFull();
    }
    stack[++top] = item;
}
int pop() {
    if (top == -1) {
        stackEmpty();
    }
    return stack[top--];
}
void stackFull() {
    fprintf(stderr, "stack is full!!\n");
    exit(EXIT_FAILURE);
}
void stackEmpty() {
    fprintf(stderr, "stack is empty!!\n");
    exit(EXIT_FAILURE);
}