/* 심화컴퓨터공학 2014097056 우성현
   < 문제 9-2 >
   1번 과제에서 노드 추가, 삭제 기능을 추가한다.

   [ 프로그램 설명 ]
- scanf로 x값을 입력 받는다.
- x가 list에 존재하면 x를 list에서 삭제한 후, list를 처음부터 끝까지 차례대로 방문하여 내용을 출력한
다.
- x가 list에 존재하지 않으면, x를 list에 삽입한 후, list를 처음부터 끝까지 차례대로 방문하여 내용을
출력한다.
*/

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define true 1
#define false 0
#define MALLOC(p,s) \
	if(!((p) = malloc(s))) { \
		fprintf(stderr, "Insufficient memory"); \
		exit(EXIT_FAILURE); \
	}

typedef struct node* nodePointer;
typedef struct node {
	nodePointer llink;		/* 이전 노드 주소 저장 */
	int data;
	nodePointer rlink;		/* 다음 노드 주소 저장 */
};

nodePointer makeNode(int data);
void dinsert(nodePointer node, nodePointer newnode);
void printNode(nodePointer head);
void R_printNode(nodePointer head);
int nodeSize = 0;			/* 루프를 위한 노드 개수 기록 */

void main() {
	int temp;
	FILE* fp = fopen("in.txt", "r");
	if (fp == NULL) {
		fprintf(stderr, "File open failure");
		exit(EXIT_FAILURE);
	}

	nodePointer head = makeNode(NULL);		/* Head node of Linked list */
	head->llink = head;
	head->rlink = head;

	nodePointer cur = head;					/* current node */
	while (feof(fp) == 0) {					/* File -> doubly linked circular list */
		fscanf_s(fp, "%d", &temp);
		dinsert(cur, makeNode(temp));
		nodeSize++;
		cur = cur->rlink;
	}
	fclose(fp);

	printNode(head);
	
	printf("9999를 입력하면 프로그램이 종료됩니다.\n");
	int check;
	while (true) {
		cur = head->rlink;			/* reset the starting point */
		check = false;				/* 삭제나 삽입이 한 번만 실행되도록 체크 */
		scanf("%d", &temp);
		if (temp == 9999) break;
		for (int i = 0; i < nodeSize; i++) {			/* 노드를 순차적으로 이동 */
			if ((temp == cur->data)&& check== false) {	/* 이미 리스트에 값이 있는 경우 제거 */
				cur->llink->rlink = cur->rlink;
				cur->rlink->llink = cur->llink;
				free(cur);
				nodeSize--;
				check = true;
				break;
			}
			if ((temp < cur->data) && check == false) {	/* 리스트 가운데 삽입 */ 
				dinsert(cur->llink, makeNode(temp));
				nodeSize++;
				check = true;
				break;
			}
			cur = cur->rlink;		/* 다음 노드로 이동 */
		}
		if (check == false) {		/* 리스트의 제일 끝에 삽입 */
			dinsert(head->llink, makeNode(temp));
			nodeSize++;
		}
		printNode(head);
	}
}
nodePointer makeNode(int data) {
	nodePointer temp;
	MALLOC(temp, sizeof(*temp));
	temp->data = data;
}
void dinsert(nodePointer node, nodePointer newnode) {
	/* insert newnode to the right of node */
	newnode->llink = node;
	newnode->rlink = node->rlink;
	node->rlink->llink = newnode;
	node->rlink = newnode;
}
void printNode(nodePointer head) {
	nodePointer cur = head->rlink;

	for (int i = 0; i < nodeSize; i++) {
		printf("%d ", cur->data);
		cur = cur->rlink;
	}
	printf("\n");
}
void R_printNode(nodePointer head) {
	nodePointer cur = head->llink;
	for (int i = 0; i < nodeSize; i++) {
		printf("%d ", cur->data);
		cur = cur->llink;
	}
}
