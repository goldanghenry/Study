/* ��ȭ��ǻ�Ͱ��� 2014097056 �켺��
   < ���� 9-2 >
   1�� �������� ��� �߰�, ���� ����� �߰��Ѵ�.

   [ ���α׷� ���� ]
- scanf�� x���� �Է� �޴´�.
- x�� list�� �����ϸ� x�� list���� ������ ��, list�� ó������ ������ ���ʴ�� �湮�Ͽ� ������ �����
��.
- x�� list�� �������� ������, x�� list�� ������ ��, list�� ó������ ������ ���ʴ�� �湮�Ͽ� ������
����Ѵ�.
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
	nodePointer llink;		/* ���� ��� �ּ� ���� */
	int data;
	nodePointer rlink;		/* ���� ��� �ּ� ���� */
};

nodePointer makeNode(int data);
void dinsert(nodePointer node, nodePointer newnode);
void printNode(nodePointer head);
void R_printNode(nodePointer head);
int nodeSize = 0;			/* ������ ���� ��� ���� ��� */

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
	
	printf("9999�� �Է��ϸ� ���α׷��� ����˴ϴ�.\n");
	int check;
	while (true) {
		cur = head->rlink;			/* reset the starting point */
		check = false;				/* ������ ������ �� ���� ����ǵ��� üũ */
		scanf("%d", &temp);
		if (temp == 9999) break;
		for (int i = 0; i < nodeSize; i++) {			/* ��带 ���������� �̵� */
			if ((temp == cur->data)&& check== false) {	/* �̹� ����Ʈ�� ���� �ִ� ��� ���� */
				cur->llink->rlink = cur->rlink;
				cur->rlink->llink = cur->llink;
				free(cur);
				nodeSize--;
				check = true;
				break;
			}
			if ((temp < cur->data) && check == false) {	/* ����Ʈ ��� ���� */ 
				dinsert(cur->llink, makeNode(temp));
				nodeSize++;
				check = true;
				break;
			}
			cur = cur->rlink;		/* ���� ���� �̵� */
		}
		if (check == false) {		/* ����Ʈ�� ���� ���� ���� */
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
