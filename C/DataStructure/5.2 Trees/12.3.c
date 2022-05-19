/* 심화컴퓨터공학 2014097056 우성현
	< 문제 12-3 >
	주어진 입력에 따라 binary search tree를 구성한 뒤, 지정된 원소들을 tree에서 차례대로
	deletion하고 결과로 얻어진 tree에 대한 inorder traversal 결과를 출력하라.
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define MALLOC(p,s)\
	if(!((p)=malloc(s))){ \
		fprintf(stderr, "insufficient memory!");\
		exit(EXIT_FAILURE);\
	}

typedef struct node* treePointer;
typedef struct node {
	int data;
	treePointer leftChild, rightChild;
}element;
treePointer root = NULL;

treePointer BST_search(treePointer root, int data);
treePointer BST_insert(treePointer root, int data);
treePointer findMinNode(treePointer root);
treePointer BST_delete(treePointer root, int data);
void inorderTraversal(treePointer root);

void main() {
	int n, m, temp;
	FILE* fp = fopen("in.txt", "r");
	if (!fp) {
		fprintf(stderr, "file open failue!");
		exit(EXIT_FAILURE);
	}

	fscanf(fp, "%d", &n);
	for (int i = 0; i < n; i++) {
		fscanf(fp, "%d", &temp);
		root = BST_insert(root, temp);
	}

	fscanf(fp, "%d", &m);
	for (int i = 0; i < m; i++) {
		fscanf(fp, "%d", &temp);
        root = BST_delete(root, temp);
	}

    inorderTraversal(root);
	fclose(fp);
}

treePointer BST_search(treePointer root, int data) {
	if (root == NULL)
		return NULL;

	if (root->data == data)
		return &(root->data);
	else if (root->data > data)
		return BST_search(root->leftChild, data);
	else
		return BST_search(root->rightChild, data);
}

treePointer findMinNode(treePointer root) {
	treePointer tmp = root;
	while (tmp->leftChild != NULL)
		tmp = tmp->leftChild;
	return tmp;
}
treePointer BST_insert(treePointer root, int data) {
	if (root == NULL)
	{
		MALLOC(root, sizeof(*root));
		root->leftChild = root->rightChild = NULL;
		root->data = data;
		return root;
	}
	else
	{
		if (root->data > data)
			root->leftChild = BST_insert(root->leftChild, data);
		else
			root->rightChild = BST_insert(root->rightChild, data);
	}
	return root;
}

treePointer BST_delete(treePointer root, int data) {
	treePointer tNode = NULL;
	if (root == NULL){
		printf("E ");
		return NULL;
	}

	if (root->data > data)
		root->leftChild = BST_delete(root->leftChild, data);
	else if (root->data < data)
		root->rightChild = BST_delete(root->rightChild, data);
	else
	{
		// 자식 노드가 둘 다 있을 경우
		if (root->rightChild != NULL && root->leftChild != NULL)
		{
			tNode = findMinNode(root->rightChild);
			root->data = tNode->data;
			root->rightChild = BST_delete(root->rightChild, tNode->data);
		}
		else
		{
			tNode = (root->leftChild == NULL) ? root->rightChild : root->leftChild;
			free(root);
			printf("S ");
			return tNode;
		}
	}
	return root;
}

void inorderTraversal(treePointer root) {
	treePointer cur = root;
	/* inorder tree traversal */
	if (cur) {
		inorderTraversal(cur->leftChild);
		printf("%d ", cur->data);
		inorderTraversal(cur->rightChild);
	}
}
