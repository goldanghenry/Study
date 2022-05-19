/* 심화컴퓨터공학 2014097056 우성현
	< 문제 11-1 >
	그림과 같은 binary tree를 linked representation으로 구성한 뒤, preorder traversal 결과를
	화면에 출력하라.
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define MAX_STACK_SIZE 100
#define MALLOC(p,s) \
	if(!((p)=malloc(s))){ \
		fprintf(stderr, "insufficient memory!");\
		exit(EXIT_FAILURE);\
	}

typedef struct node* treePointer;
typedef struct node {
	int data;
	treePointer leftChild, rightChild;
};

treePointer makeNode(int data);
void preorder(treePointer ptr);

void main() {
	treePointer root = makeNode(4);
	treePointer cur = root;

	cur->leftChild = makeNode(3);
	cur->rightChild = makeNode(6);
	cur->leftChild->leftChild = makeNode(2);
	cur->leftChild->rightChild = makeNode(5);
	cur->rightChild->rightChild = makeNode(8);

	preorder(root);
}

treePointer makeNode(int data) {
	treePointer temp;
	MALLOC(temp, sizeof(*temp));
	temp->data = data;
	temp->leftChild = NULL;
	temp->rightChild = NULL;
	return temp;
}

void preorder(treePointer ptr) {
	/* preorder tree traversal */
	if (ptr) {
		printf("%d ", ptr->data);
		preorder(ptr->leftChild);
		preorder(ptr->rightChild);
	}
}