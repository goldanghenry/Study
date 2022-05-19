/* 심화컴퓨터공학 2014097056 우성현
	< 문제 11-2 >
	파일(in.txt)의 데이터들을 순차적으로 삽입하여 binary search tree T를 구성한 뒤, 
	T에 대해 inorder traversal을 수행한 결과를 화면에 출력하라.
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
void inorder(treePointer ptr);
void insert(treePointer* node, int k);

void main() {
	int temp;
	FILE* fp = fopen("in.txt", "r");
	if (fp == NULL) {
		fprintf(stderr, "file open failure!");
		exit(EXIT_FAILURE);
	}

	fscanf(fp, "%d", &temp);
	treePointer root = makeNode(temp);

	while (feof(fp) == 0) {
		fscanf(fp, "%d", &temp);
		insert(root, temp);
	}
	inorder(root);
	fclose(fp);
}
treePointer makeNode(int data) {
	treePointer temp;
	MALLOC(temp, sizeof(*temp));
	temp->data = data;
	temp->leftChild = NULL;
	temp->rightChild = NULL;
	return temp;
}
void inorder(treePointer ptr) {
	treePointer cur = ptr;
	/* inorder tree traversal */
	if (cur) {
		inorder(cur->leftChild);
		printf("%d ", cur->data);
		inorder(cur->rightChild);
	}
}
void insert(treePointer* node, int k) {
	treePointer cur = node;
	treePointer newNode = makeNode(k);

	if (cur == NULL) node = newNode;
	else {
		while (1) {
			if (cur->data == k) break;	// 중복일 경우
			else if (cur->data < k) {
				if (cur->rightChild == NULL) {
					cur->rightChild = newNode;
					break;
				}
				else {
					cur = cur->rightChild;
				}
			}
			else {
				if (cur->leftChild == NULL) {
					cur->leftChild = newNode;
					break;
				}
				else {
					cur = cur->leftChild;
				}
			}
		}
	}
}