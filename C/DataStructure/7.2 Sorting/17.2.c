/* 심화컴퓨터공학 2014097056 우성현
	< 문제 17-2 >
	교재의 heapSort algorithm을 수정하여 정수들의 집합에 대해 non-increasing order로 정렬하여
	출력하라.
*/
#define _CRT_SECURE_NO_WARNINGS
#define MAX_SIZE 100
#define SWAP(x,y,t)((t)=(x),(x)=(y),(y)=(t))
#include <stdio.h>
#include <stdlib.h>
typedef struct {
	int key;
}element;
void adjust(element list[], int root, int n);
void heapsort(element list[], int n);

void main() {
	int n=0;
	element list[MAX_SIZE];

	FILE* fp = fopen("in.txt", "r");
	if (!fp) {
		fprintf(stderr, "file open failure");
		exit(EXIT_FAILURE);
	}
	for (int i = 1; !feof(fp); i++) {
		fscanf(fp, "%d", &list[i].key);
		n++;
	}
	heapsort(list, n);
	for (int i = 1; i <= n; i++) {
		printf("%d ", list[i]);
	};

	fclose(fp);
}

void adjust(element list[], int root, int n) {
	int child, rootkey;
	element temp;
	temp = list[root];
	rootkey = list[root].key;
	child = 2 * root;
	while (child <= n) {
		if ((child < n) && (list[child].key > list[child + 1].key))
			child++;
		if (rootkey < list[child].key)
			break;
		else{
			list[child / 2] = list[child];
		child *= 2;
		}
	}
	list[child / 2] = temp;
}

void heapsort(element list[], int n) {
	int i, j;
	element temp;
	for (i = n / 2; i > 0; i--) adjust(list, i, n);
	for (i = n - 1; i > 0; i--) {
		SWAP(list[1], list[i + 1], temp);
		adjust(list, 1, i);
	}
}