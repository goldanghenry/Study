// 2014097056 우성현
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
		printf("> 메뉴를 선택하세요 (1.삽입 2.삭제 3.종료): ");
		scanf_s("%d", &menu);
		getchar();

		if (menu == 1) {
			printf("문자를 입력하세요: ");
			scanf("%c", &temp);
			insertNode(head, temp);
			printNode(head);
		}
		else if (menu == 2) {
			printf("삭제할 문자를 입력하세요: ");
			scanf("%c", &temp);
			deleteNode(head, temp);
			if (check == TRUE) {
				printNode(head);
				check = FALSE;
			}
			if (!count) printf("empty\n");
		}
		else if (menu == 3) {
			printf("프로그램을 종료합니다."); 
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
		printf("잘못 입력하셨습니다. 다시 입력하세요.");
}

void insertNode(listPointer node, char newdata) {
	listPointer cur = node;
	listPointer newNode;
	MALLOC(newNode, sizeof(*newNode));
	newNode->data = newdata;
	newNode->link = NULL;

	while (TRUE) {
		if (IS_EMPTY(cur->link)) {	// 노드의 제일 끝에 추가
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