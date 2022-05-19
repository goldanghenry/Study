/* 심화컴퓨터공학 2014097056 우성현
   < 문제 8-1 >
   polynomial non-zero term <coefficient, exponent> file linked 의 에 대한 데이터를 에서 입력받아
   list , polynomial addition . 로 표현하고 결과를 출력하는 코드를 작성하라

   [ 프로그램 설명 ]
- file (in1.txt, in2.txt) , : 데이터 입력은 두 개의 로 주어지며 각 파일의 형식은 다음과 같다
	c1 e1 c2 e2…cm em
- e 각 i는 차수를 나타내며, ei > ei+1이다.
- c 각 i는 차수 ei항의 를 나타낸다
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define true 1
#define IS_EMPTY(first)(!(first))
#define COMPARE(x,y)(((x)<(y))?-1:((x)==(y)?0:1))
#define MALLOC(p,s) \
	if(!((p) = malloc(s))) { \
		fprintf(stderr, "Insufficient memory"); \
		exit(EXIT_FAILURE); \
	}
typedef struct polyNode* polyPointer;	/* 자기 참조 구조체 - 이름 재명명(별칭) */
typedef struct polyNode {
	int coef;
	int expon;
	polyPointer link;					/* 다음 노드의 주소를 저장할 포인터 */
};

void insert(polyPointer list, int coef, int expon);
polyPointer padd(polyPointer a, polyPointer b);
void showList(polyPointer list);
void freeNode(polyPointer list);

/***************************** run ********************************/
void main() {
	int temp_C, temp_E;
	FILE* fp1 = fopen("in1.txt", "r");
	FILE* fp2 = fopen("in2.txt", "r");

	if (fp1 == NULL || fp2 == NULL) {
		fprintf(stderr, "File open failure!");
		exit(EXIT_FAILURE);
	}
	polyPointer a, b, c;				/* Head node of Linked list */
	MALLOC(a, sizeof(*a));
	a->link = NULL;
	while (feof(fp1) == 0) {			/* File -> Linked list */
		fscanf_s(fp1, "%d", &temp_C);
		fscanf_s(fp1, "%d", &temp_E);
		insert(a, temp_C, temp_E);
	}
	fclose(fp1);

	MALLOC(b, sizeof(*b));
	b->link = NULL;
	while (feof(fp2) == 0) {			/* File -> Linked list */
		fscanf_s(fp2, "%d", &temp_C);
		fscanf_s(fp2, "%d", &temp_E);
		insert(b, temp_C, temp_E);
	}
	fclose(fp2);

	if (IS_EMPTY(a->link) || IS_EMPTY(b->link)) {		/* connection checking */
		fprintf(stderr, "Linked list connection failure");
		exit(EXIT_FAILURE);
	}

	c = padd(a, b);
	showList(c);

	/* Dynamic memory return */
	freeNode(a); freeNode(b); freeNode(c);
}
/******************************************************************/
void insert(polyPointer list, int coef, int expon) {	/* 특정 위치에 노드를 삽입하는 함수 */
	polyPointer cur = list;			/* 현재 노드 저장 */

	polyPointer newNode;			/* 새로운 노드 생성 및 초기화 */
	MALLOC(newNode, sizeof(*newNode));
	newNode->coef = coef;
	newNode->expon = expon;
	newNode->link = NULL;

	while (true) {
		if (IS_EMPTY(cur->link)) { /* NULL을 만나면 제일 뒤에 링크 */
			cur->link = newNode;
			break;
		}
		cur = cur->link;
	}
}
polyPointer padd(polyPointer a, polyPointer b) {
	polyPointer c, temp;
	int sum;
	MALLOC(c, sizeof(*c));
	c->link = NULL;
	while (a && b) {
		switch (COMPARE((a->expon), (b->expon))) {
		case -1: /* a->expon < b->expon */
			insert(c, b->coef, b->expon);
			b = b->link; break;
		case 0: /* a->expon = b->expon */
			sum = a->coef + b->coef;
			if (sum) insert(c, sum, a->expon);
			a = a->link; b = b->link; break;
		case 1:	/* a->expon > b->expon */
			insert(c, a->coef, a->expon);
			a = a->link;
		}
	}
	/* copy rest of list a and then list b */
	for (; a; a = a->link) insert(c, a->coef, a->expon);
	for (; b; b = b->link) insert(c, b->coef, b->expon);

	/* delete */
	temp = c;
	c = c->link;
	free(temp);
	return c;
}
void showList(polyPointer list) {
	polyPointer cur = list->link;	/* cur은 list가 가리키는 첫 노드를 가리킴 */
	while (cur != NULL) {			/* 다음 노드가 없을 때까지 반복 */
		printf("%d %d ", cur->coef, cur->expon);
		cur = cur->link;			/* 출력 후, 다음 노드를 가리킨다 */
	}
	printf("\n");
}
void freeNode(polyPointer list) {
	polyPointer cur = list;			/* 현재 노드 저장 */
	polyPointer next;				/* 현재 노드를 삭제하면 다음 주소도 사라기 때문에 */
	while (cur != NULL) {
		next = cur->link;			/*  next에 다음 노드의 주소를 임시 저장 */
		free(cur);					/* 현재 노드 메모리 해제*/
		cur = next;					/* 다음 삭제할 노드를 가리킴 */
	}
}

