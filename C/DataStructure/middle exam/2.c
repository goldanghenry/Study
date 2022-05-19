// 2014097056 �켺��
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0
#define IS_EMPTY(p)(!(p))
#define MALLOC(p,s)\
if(!((p)=malloc(s) )){\
	fprintf(stderr, "insufficient memory!");\
	exit(EXIT_FAILURE);\
}

typedef struct listNode* listPointer;
typedef struct listNode {
	char data;
	listPointer link;
};

int check = FALSE;
int count = 0;
void deleteNode(listPointer node, char deleteData);
void insertNode(listPointer node, char newdata);
void printNode(listPointer node);
void freeNode(listPointer node);

void main() {
	int menu;
	char temp;
	listPointer head;
	MALLOC(head, sizeof(*head));
	head->link = NULL;
	
	while (TRUE ) {
		printf("> �޴��� �����ϼ��� (1.���� 2.���� 3.����): ");
		scanf_s("%d", &menu);
		getchar();

		if (menu == 1) {
			printf("���ڸ� �Է��ϼ���: ");
			scanf("%c", &temp);
			insertNode(head, temp);
			printNode(head);
		}
		else if (menu == 2) {
			printf("������ ���ڸ� �Է��ϼ���: ");
			scanf("%c", &temp);
			deleteNode(head, temp);
			if (check == TRUE) {
				printNode(head);
				check = FALSE;
			}
			if (!count) printf("empty\n");
		}
		else if (menu == 3) {
			printf("���α׷��� �����մϴ�."); 
			freeNode(head);
			exit(EXIT_FAILURE);
		}
		printf("\n\n");
	}
}
void deleteNode(listPointer node, char deleteData) {
	listPointer cur = node;
	listPointer pre = node;
	check = FALSE;

	while (cur) {
		if (cur->data == deleteData) {
			pre->link = cur->link;
			free(cur); check = TRUE; count--;
			break;
		}
		pre = cur;
		cur = cur->link;
	}
	if (check == FALSE)
		printf("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
}

void insertNode(listPointer node, char newdata) {
	listPointer cur = node;
	listPointer newNode;
	MALLOC(newNode, sizeof(*newNode));
	newNode->data = newdata;
	newNode->link = NULL;

	while (TRUE) {
		if (IS_EMPTY(cur->link)) {	// ����� ���� ���� �߰�
			cur->link = newNode;
			count++;
			break;
		}
		cur = cur->link;
	}
}
void printNode(listPointer node) {
	listPointer cur = node->link;
	while (cur != NULL) {
		printf("%c ", cur->data);
		cur = cur->link;
	}
}
void freeNode(listPointer node) {
	listPointer next;
	while (node != NULL) {
		next = node->link;
		free(node);
		node = next;
	}
}