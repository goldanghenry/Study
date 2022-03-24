// 2014097056 심화컴퓨터 우성현 자료구조 4차시 과제 2번 문제
// 두 다항식을 입력받고 다항식 덧셈 연산을 수행 후 그 결과를 출력하는 프로그램을 작성하라.
#define _CRT_SECURE_NO_WARNINGS
#define MAX_TERMS 100
#define COMPARE(x,y) ( ((x) < (y)) ? -1 : ((x) == (y) ? 0 : 1 ))
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    float coef;
    int expon;
}polynominal;

polynominal terms[MAX_TERMS];
int avail = 0;
int *startd;
int *finishd;

void P_input(int start, int finish, char c);
void P_attach(float coefficient, int exponent);
void P_print(int start, int finish, char c);
void P_add(int start_a, int finish_a, int start_b, int finish_b, int* startd, int* finishd);

void main() {
    int n, m;
    // input the number of items
    printf("<< D(x) = A(x) + B(x) >>\n");
    printf("Input the number of items of A(x) : ");
    scanf_s("%d", &n);
    printf("Input the number of items of B(x) : ");
    scanf_s("%d", &m);
    int a_start = 0, a_finish = n - 1, b_start = n, b_finish = n + m - 1, avail = n + m;

    // input in descending order
    printf("\ninput in descending order\n");
    P_input(a_start, a_finish, 'A');
    P_input(b_start, b_finish, 'B');

    // add
    P_add(a_start, a_finish, b_start, b_finish, &startd, &finishd);
    
    // print
    P_print(a_start, a_finish, 'A');
    P_print(b_start, b_finish, 'B');
    P_print(startd, finishd, 'D');
}

void P_input(int start, int finish, char c) {
    int j = 1;
    for (int i = start; i <= finish; i++) {
        switch (j) {
        case 1: printf("The 1st coefficient and exponent of %c(x), (ex)10 3 : ", c); break;
        case 2: printf("The 2nd coefficient and exponent of %c(x), (ex)10 3 : ", c); break;
        case 3: printf("The 3rd coefficient and exponent of %c(x), (ex)10 3 : ", c); break;
        default: printf("The %dth coefficient and exponent of %c(x), (ex)10 3 : ", j, c);
        }
        scanf_s("%f %d", &terms[i].coef, &terms[i].expon);
        P_attach(terms[i].coef, terms[i].expon);
        j++;
    }
    printf("\n");
}

void P_attach(float coefficient, int exponent) {
    /* add a new term to the polynominal */
    if (avail >= MAX_TERMS) {
        fprintf(stderr, "Too many terms in the polynominal\n");
        exit(EXIT_FAILURE);
    }
    terms[avail].coef = coefficient;
    terms[avail++].expon = exponent;
}

void P_print(int start, int finish, char c){
    printf("%c(x) = ", c);
    for (int i = start; i <= finish; i++) {
        if (i != start) printf(" + ");
        if (terms[i].expon != 0)
            printf("%fx^%d", terms[i].coef, terms[i].expon);
        else printf("%f", terms[i].coef);
    }
    printf("\n");
}

void P_add(int start_a, int finish_a, int start_b, int finish_b, int* startd, int* finishd) {
    /* add A(x) and B(x) to obtain D(x) */
    float coefficient;
    *startd = avail;
    while (start_a <= finish_a && start_b <= finish_b)
        switch (COMPARE(terms[start_a].expon, terms[start_b].expon)) {
        case -1:/* a expon < b expon */
            P_attach(terms[start_b].coef, terms[start_b].expon);
            start_b++; break;
        case 0:/* equal exponenets */
            coefficient = terms[start_a].coef + terms[start_b].coef;
            if (coefficient) P_attach(coefficient, terms[start_a].expon);
            start_a++; start_b++; break;
        case 1: /* a expon > b expon */
            P_attach(terms[start_a].coef, terms[start_a].expon);
            start_a++;
        }
    /* add in remaining terms of A(x) */
    for (; start_a <= finish_a; start_a++)
        P_attach(terms[start_a].coef, terms[start_a].expon);

    /* add in remaining terms of B(x) */
    for (; start_b <= finish_b; start_b++)
        P_attach(terms[start_b].coef, terms[start_a].expon);

    *finishd = avail - 1;
}

