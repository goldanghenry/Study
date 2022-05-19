/* 심화컴퓨터공학 2014097056 우성현
	< 문제 8-1 >
	doubly linked circular list를 사용해서 sparse matrix 구성하고 출력하는 메뉴기반의 프로그램을
	작성하라.
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define MAX_SIZE 50	/* size of largest matrix */
#define MALLOC(p,s)	\
if(!((p)=malloc(s))) { \
	fprintf(stderr, "insufficient memory!");\
	exit(EXIT_FAILURE);\
}

typedef enum { head, entry } tagfield;	/* head or entry 식별*/
typedef struct matrixNode* matrixPointer;
typedef struct {
	int row;
	int col;
	int value;
}entryNode;
typedef struct matrixNode {
	matrixPointer down;
	matrixPointer right;
	tagfield tag;
	union {
		matrixPointer next;
		entryNode entry;
	}u;
};

matrixPointer hdnode[MAX_SIZE];
matrixPointer mread(void);
void mwrite(matrixPointer node);
void merase(matrixPointer* node);
matrixPointer newNode();
void menu();

void main() {
	menu();
}

void menu() {
	int select;
	matrixPointer node =NULL;
	while (TRUE) {
		printf("matrix 작업 선택 (1.입력 2.출력 3.삭제 4.종료): ");
		scanf("%d", &select);
		if(select == 4){ 
			printf("matrix 작업을 종료합니다.");
			break;
		}
		switch (select) {
		case 1: node = mread(); break;
		case 2: mwrite(node);  break;
		case 3: merase(&node);
		}
	}
}
matrixPointer newNode() {
	matrixPointer t;
	MALLOC(t, sizeof(*t));
	return t;
}
matrixPointer mread(void) {
	/* read in a matrix and set up it;s linked representation. An auxiliary global
	array hdnode is used */
	int numRows, numCols, numTerms, numHeads, i;
	int row, col, value, currentRow;
	matrixPointer temp, last, node;

	printf("행과 열의 크기 및 nonzero 항의 개수 입력\n");
	scanf("%d%d%d", &numRows, &numCols, &numTerms);

	numHeads = (numCols > numRows) ? numCols : numRows;
	/* set up header node for the list of header nodes */
	node = newNode(); node->tag = entry;
	node->u.entry.row = numRows;
	node->u.entry.col = numCols;
	if (!numHeads)node->right = node;
	else { /* initialize the header nodes */
		for (i = 0; i < numHeads; i++) {
			temp = newNode();
			hdnode[i] = temp;
			hdnode[i]->tag = head;
			hdnode[i]->right = temp;
			hdnode[i]->u.next = temp;
		}
		currentRow = 0;
		last = hdnode[0];	/* last node in current row */
		printf("행, 열, 값 입력\n");
		for (i = 0; i < numTerms; i++) {
			scanf("%d%d%d", &row, &col, &value);

			if (row > currentRow) {/* close current row */
				last->right = hdnode[currentRow];
				currentRow = row;
				last = hdnode[row];
			}
			temp = newNode();
			temp->tag = entry;
			temp->u.entry.row = row; temp->u.entry.col = col;
			temp->u.entry.value = value;

			last->right = temp; /* link into row list */
			last = temp;
			/* link into column list */
			hdnode[col]->u.next->down = temp;
			hdnode[col]->u.next = temp;
		}
		/* close last row */
		last->right = hdnode[currentRow];
		/* close all column lists */
		for (i = 0; i < numCols; i++)
			hdnode[i]->u.next->down = hdnode[i];
		/* link all header nodes together */
		for (i = 0; i < numHeads - 1; i++)
			hdnode[i]->u.next = hdnode[i + 1];

		hdnode[numHeads - 1]->u.next = node;
		node->right = hdnode[0];
	}
	return node;
}

void mwrite(matrixPointer node) {
	/* print out the matrix in row major form*/
	int i;
	matrixPointer temp, head = node->right;
	/* matrix dimensions */
	printf("\n numRows = %d, numCols =%d \n", node->u.entry.row, node->u.entry.col);

	printf(" The metrix by row, colmn, and value: \n\n");
	for (i = 0; i < node->u.entry.row; i++) {
		/* print out the entries each row */
		for (temp = head->right; temp != head; temp = temp->right)
			printf("%5d%5d%5d\n", temp->u.entry.row, temp->u.entry.col, temp->u.entry.value);
		head = head->u.next;	/* next row */
	}
}

void merase(matrixPointer* node) {
	/* erase the matrix, return the nodes to the heap */
	matrixPointer x, y, head = (*node)->right;
	int i, numHeads;
	/* free the entry and header nodes by row */
	for (i = 0; i < (*node)->u.entry.row; i++) {
		y = head->right;
		while (y != head) { x = y; y = y->right; free(x); }
		x = head; head = head->u.next; free(x);
	}
	/* free remaining header nodes */
	y = head;
	while (y != *node) { x = y; y = y->u.next; free(x); }
	free(*node); *node = NULL;
}