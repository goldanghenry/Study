/* 심화컴퓨터공학 2014097056 우성현
   < 문제 7-3 >
   다음 지시사항에 따라 2번 코드를 수정하라.

   [ 프로그램 설명 ]
- scanf로 x값을 입력받음 (x가 –1이면 프로그램 종료)
- x가 list에 존재하는 경우 해당 node를 삭제하고, 존재하지 않은 경우 x를 list에 추가 (오름차순 유지)
- list의 데이터들을 순차적으로 출력
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define true 1
#define IS_EMPTY(first)(!(first))
#define MALLOC(p,s) \
	if(!((p) = malloc(s))) { \
		fprintf(stderr, "Insufficient memory"); \
		exit(EXIT_FAILURE); \
	}
typedef struct listNode* listPointer;	/* 자기참조 구조체 (재명명) */
typedef struct listNode {
	int data;
	listPointer link;					/* 다음 노드의 주소를 저장할 포인터 */
};

void insertNode(listPointer list, int newData);
void showList(listPointer list);
void freeNode(listPointer list);

/***************************** run ********************************/
void main() {
	int temp, n;
	FILE* fp;						/* Declare file pointer */
	listPointer first;				/* Head node of Linked list */
	MALLOC(first, sizeof(*first));
	first->link = NULL;

	fp = fopen("in3.txt", "r");		/* File open & error checking */
	if (IS_EMPTY(fp)) {
		fprintf(stderr, "File open failure");
		exit(EXIT_FAILURE);
	}

	while (feof(fp) == 0) {			/* File -> Linked list */
		fscanf_s(fp, "%d", &temp);
		insertNode(first, temp);
	}
	fclose(fp);

	if (IS_EMPTY(first->link)) {		/* connection checking */
		fprintf(stderr, "Linked list connection failure");
		exit(EXIT_FAILURE);
	}

	printf("(int2.txt)\n");			/* Print current List */
	showList(first);

	while (true) {
		printf("(입력) ");	scanf_s("%d", &n);
		if (n == -1) break;			/* exit condition */
		insertNode(first, n);
		printf("(출력) ");  showList(first);
	}
	freeNode(first);				/* Dynamic memory return */
}
/******************************************************************/

void insertNode(listPointer list, int newData) {	/* 특정 위치에 노드를 삽입하는 함수 */
	listPointer cur = list;			/* 현재 노드 저장 */
	listPointer pre = list;

	listPointer newNode;			/* 새로운 노드 생성 및 초기화 */
	MALLOC(newNode, sizeof(*newNode));
	newNode->data = newData;
	newNode->link = NULL;

	while (true) {
		/* x가 list의 맨 뒤에 있는 경우 -> delete Node */
		if ((cur->link == NULL) && (cur->data == newData)) {
			free(cur);
			pre->link = NULL;
			break;
		}
		/* x가 list에 없고, 가장 큰 경우 -> (맨 뒤)insert Node */
		else if (IS_EMPTY(cur->link)) {
			cur->link = newNode;
			break;
		}
		/* x가 list의 중간에 있는 경우 -> delete Node */
		else if ((cur->data == newData)){
			pre->link = cur->link;
			free(cur);
			break;
		}
		/* x가 list에 없고, 중간 값인 경우 -> (중간)insert Node */
		else if (newData < (cur->link->data)) {
			newNode->link = cur->link;
			cur->link = newNode;
			break;
		}
		pre = cur;			// 이전 노드 저장
		cur = cur->link;	// 다음 노드로 이동
	}
}
void showList(listPointer list) {
	listPointer cur = list->link;	/* cur은 list가 가리키는 첫 노드를 가리킴 */
	while (cur != NULL) {			/* 다음 노드가 없을 때까지 반복 */
		printf("%d ", cur->data);
		cur = cur->link;			/* 출력 후, 다음 노드를 가리킨다 */
	}
	printf("\n");
}
void freeNode(listPointer list) {
	listPointer cur = list;			/* 현재 노드 저장 */
	listPointer next;				/* 현재 노드를 삭제하면 다음 주소도 사라기 때문에 */
	while (cur != NULL) {
		next = cur->link;			/*  next에 다음 노드의 주소를 임시 저장 */
		free(cur);					/* 현재 노드 메모리 해제*/
		cur = next;					/* 다음 삭제할 노드를 가리킴 */
	}
}
