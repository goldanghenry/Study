/* ��ȭ��ǻ�Ͱ��� 2014097056 �켺��
   < ���� 8-2 >
   ������������ ���ĵ� �������� ����Ǿ� �ִ� �� ���� ������ �о ���� ���������� ��
   �����ϰ� �� �� �� ���� �����͵鿡 ���� ������ �� ������ �� �� ����� ����ϴ� , list linked list
   ���α׷��� �ۼ��϶�.

   [ ���α׷� ���� ]
- file (in1.txt, in2.txt) , . �Է� ���ҵ��� �� ���� �� �Է� ������ �� ������ ������ ������ ����
N1 N2��Nm
- N �� i�� ���� �ٸ� ������ �����Ǹ�, Ni < Ni+1�̴�.
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
typedef struct polyNode* polyPointer;	/* �ڱ� ���� ����ü - �̸� ����(��Ī) */
typedef struct polyNode {
	int data;
	polyPointer link;					/* ���� ����� �ּҸ� ������ ������ */
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
void insert(polyPointer list, int newData) {	/* Ư�� ��ġ�� ��带 �����ϴ� �Լ� */
	polyPointer cur = list;				/* ���� ��� ���� */

	polyPointer newNode;				/* ���ο� ��� ���� �� �ʱ�ȭ */
	MALLOC(newNode, sizeof(*newNode));
	newNode->data = newData;
	newNode->link = NULL;

	while (true) {
		if (IS_EMPTY(cur->link)) {	/* NULL�� ������ ���� �ڿ� ��ũ */
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
	polyPointer cur = list->link;	/* cur�� list�� ����Ű�� ù ��带 ����Ŵ */
	while (cur != NULL) {			/* ���� ��尡 ���� ������ �ݺ� */
		printf("%d ", cur->data);
		cur = cur->link;			/* ��� ��, ���� ��带 ����Ų�� */
	}
	printf("\n");
}
void freeNode(polyPointer list) {
	polyPointer cur = list;			/* ���� ��� ���� */
	polyPointer next;				/* ���� ��带 �����ϸ� ���� �ּҵ� ���� ������ */
	while (cur != NULL) {
		next = cur->link;			/*  next�� ���� ����� �ּҸ� �ӽ� ���� */
		free(cur);					/* ���� ��� �޸� ����*/
		cur = next;					/* ���� ������ ��带 ����Ŵ */
	}
}

