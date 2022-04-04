/* 심화컴퓨터공학 2014097056 우성현
   < 문제 8-2 >
   오름차순으로 정렬된 정수들이 저장되어 있는 두 개의 파일을 읽어서 각각 오름차순의 를
   구성하고 두 개 의 정수 데이터들에 대한 합집합 를 구성한 후 그 결과를 출력하는 , list linked list
   프로그램을 작성하라.

   [ 프로그램 설명 ]
- file (in1.txt, in2.txt) , . 입력 원소들은 두 개의 로 입력 받으며 각 파일의 형식은 다음과 같다
N1 N2…Nm
- N 각 i는 서로 다른 정수로 구성되며, Ni < Ni+1이다.
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
	int data;
	polyPointer link;					/* 다음 노드의 주소를 저장할 포인터 */
};

void insert(polyPointer list, int newData);
polyPointer UnionSet(polyPointer a, polyPointer b);
void showList(polyPointer list);
void freeNode(polyPointer list);

/***************************** run ********************************/
void main() {
	int temp;
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
		fscanf_s(fp1, "%d", &temp);
		insert(a, temp);
	}
	fclose(fp1);

	MALLOC(b, sizeof(*b));
	b->link = NULL;
	while (feof(fp2) == 0) {			/* File -> Linked list */
		fscanf_s(fp2, "%d", &temp);
		insert(b, temp);
	}
	fclose(fp2);

	if (IS_EMPTY(a->link) || IS_EMPTY(b->link)) {		/* connection checking */
		fprintf(stderr, "Linked list connection failure");
		exit(EXIT_FAILURE);
	}

	c = UnionSet(a, b);
	showList(c);

	/* Dynamic memory return */
	freeNode(a); freeNode(b); freeNode(c);
}
/******************************************************************/
void insert(polyPointer list, int newData) {	/* 특정 위치에 노드를 삽입하는 함수 */
	polyPointer cur = list;				/* 현재 노드 저장 */

	polyPointer newNode;				/* 새로운 노드 생성 및 초기화 */
	MALLOC(newNode, sizeof(*newNode));
	newNode->data = newData;
	newNode->link = NULL;

	while (true) {
		if (IS_EMPTY(cur->link)) {	/* NULL을 만나면 제일 뒤에 링크 */
			cur->link = newNode;
			break;
		}
		cur = cur->link;
	}
}
polyPointer UnionSet(polyPointer a, polyPointer b) {
	polyPointer c, temp;
	int sum;
	MALLOC(c, sizeof(*c));
	c->link = NULL;

	while (a && b) {
		switch (COMPARE(a->data, b->data)) {
		case -1:
			insert(c, a->data);
			a = a->link;
			break;
		case 0:
			insert(c, a->data);
			a = a->link; b = b->link;
			break;
		case 1:
			insert(c, b->data);
			b = b->link;
		}
	}
	/* copy rest of list a and then list b */
	for (; a; a = a->link) insert(c, a->data);
	for (; b; b = b->link) insert(c, b->data);

	/* delete */
	temp = c;
	c = c->link;
	free(temp);
	return c;
}
void showList(polyPointer list) {
	polyPointer cur = list->link;	/* cur은 list가 가리키는 첫 노드를 가리킴 */
	while (cur != NULL) {			/* 다음 노드가 없을 때까지 반복 */
		printf("%d ", cur->data);
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

