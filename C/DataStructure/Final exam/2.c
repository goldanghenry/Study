/* 2014097056-우성현 */
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define MALLOC(p,s)\
	if(!((p)=malloc(s))){ \
		fprintf(stderr, "insufficient memory!");\
		exit(EXIT_FAILURE);\
	}

typedef struct node* nodePointer;
typedef struct node {
	int data;
	nodePointer LC, RC;
}element;
nodePointer root = NULL;

nodePointer Search(nodePointer root, int data);
nodePointer Insert(nodePointer root, int data);
nodePointer minNode(nodePointer root);
nodePointer Delete(nodePointer root, int data);
void Inorder(nodePointer root);

void main() {
	int tmp, n = 0;
	FILE* fp = fopen("in2.txt", "r");
	if (!fp) {
		fprintf(stderr, "file open failue!");
		exit(EXIT_FAILURE);
	}

	for (int i = 0; !feof(fp); i++) {
		fscanf(fp, "%d", &tmp);
		root = Insert(root, tmp);
		n++;
	}

	// 메뉴 실행부
	int choice;
	while (1) {
		printf("----------------------------------------------------\n");
		printf("BST (1.insert 2.delete 3.search 4.output 5.exit) : ");
		scanf("%d", &choice);
		printf("\n");
		switch (choice) {
		case 1: // 1.insert
			printf("insert> ");
			scanf("%d", &tmp);
			root = Insert(root, tmp);
			Inorder(root);
			printf("\n");
			break;
		case 2: // 2.delete
			printf("delete> ");
			scanf("%d", &tmp);
			root = Delete(root, tmp);
			Inorder(root);
			printf("\n");
			break;
		case 3: // 3.search
			printf("search> ");
			scanf("%d", &tmp);
			root = Search(root, tmp);
			printf("\n");
			break;
		case 4: // 4.output
			Inorder(root);
			printf("\n");
			break;
		case 5: // 5.exit
			fprintf(stderr, "BST 프로그램을 종료합니다.");
			fclose(fp);
			exit(EXIT_FAILURE);
			break;
		default: // 잘못 입력한 경우
			printf("1~5의 메뉴 중 하나를 선택하세요.\n");
		}
		printf("----------------------------------------------------\n");
	}
}

nodePointer minNode(nodePointer root) {
	nodePointer tmp = root;
	while (tmp->LC != NULL)
		tmp = tmp->LC;
	return tmp;
}

nodePointer Insert(nodePointer root, int data) {
	if (root == NULL) {
		MALLOC(root, sizeof(*root));
		root->LC = root->RC = NULL;
		root->data = data;
		return root;
	}
	else {
		if (root->data > data)
			root->LC = Insert(root->LC, data);
		else
			root->RC = Insert(root->RC, data);
	}
	return root;
}

nodePointer Search(nodePointer root, int data) {
	nodePointer tNode = NULL;
	if (root == NULL) { printf("E"); return NULL; }
	if (root->data > data) root->LC = Search(root->LC, data);
	else if (root->data < data) root->RC = Search(root->RC, data);
	else {
		if (root->RC != NULL && root->LC != NULL) {
			tNode = minNode(root->RC);
			root->data = tNode->data;
			root->RC = Search(root->RC, tNode->data);
		}
		else {
			tNode = (root->LC == NULL) ? root->RC : root->LC;
			printf("S");
			return tNode;
		}
	}
	return root;
}
nodePointer Delete(nodePointer root, int data) {
	nodePointer tNode = NULL;
	if (root == NULL) return NULL;
	if (root->data > data) root->LC = Delete(root->LC, data);
	else if (root->data < data) root->RC = Delete(root->RC, data);
	else {
		if (root->RC != NULL && root->LC != NULL) {
			tNode = minNode(root->RC);
			root->data = tNode->data;
			root->RC = Delete(root->RC, tNode->data);
		}
		else {
			tNode = (root->LC == NULL) ? root->RC : root->LC;
			free(root);
			return tNode;
		}
	}
	return root;
}

void Inorder(nodePointer root) {
	nodePointer cur = root;
	if (cur) {
		Inorder(cur->LC);
		printf("%d ", cur->data);
		Inorder(cur->RC);
	}
}
