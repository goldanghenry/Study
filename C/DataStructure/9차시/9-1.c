/* 심화컴퓨터공학 2014097056 우성현
   < 문제 8-1 >
   파일(in.txt)에 저장된 오름차순의 서로 다른 정수들을 차례대로 읽어 들여 doubly linked circular
   list with header node를 구성하고 출력하는 프로그램을 작성하라.

	[프로그램 설명]
 - List의 처음부터 끝 노드까지 차례대로 방문하여 내용을 출력하라.
   (정수들이 오름차순으로 출력됨)
 - List의 노드들을 역순으로 방문(끝 노드부터 첫 노드 순서로) 하여 내용을 출력하라.
   (정수들이 내림차순으로 출력됨)
*/

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
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
	R_printNode(head);
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
