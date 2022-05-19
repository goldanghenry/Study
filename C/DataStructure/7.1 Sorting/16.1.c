/*	심화컴퓨터공학 2014097056 우성현
	< 문제 16 - 1 >
	quicksort algorithm을 이용하여 정수들의 집합에 대해 non-decreasing order로 
	정렬하여 출력하라
*/
#define _CRT_SECURE_NO_WARNINGS
#define SWAP(x,y,t)((t)=(x), (x)=(y), (y)=(t))
#define MAX_SIZE 100
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int key;
}element;

void quickSort(element a[], int left, int right);

void main() {
	int n = 0;
	element a[MAX_SIZE];
	FILE* fp = fopen("in.txt", "r");
	if (!fp) {
		fprintf(stderr, "file open failure");
		exit(EXIT_FAILURE);
	}

	for (int i=1; !feof(fp); i++) {
		fscanf(fp, "%d", &a[i].key);
		n++;
	}

	quickSort(a, 0, n);

	for (int i = 1; i <= n; i++) {
		printf("%d ", a[i].key);
	}

	fclose(fp);
}

void quickSort(element a[], int left, int right) {
	int pivot, i, j; element temp;
	if (left < right) {
		i = left; j = right + 1;
		pivot = a[left].key;
		do {
			do i++; while (a[i].key < pivot);
			do j--; while (a[j].key > pivot);
			if (i < j) SWAP(a[i], a[j], temp);
		} while (i < j);
		SWAP(a[left], a[j], temp);
		quickSort(a, left, j - 1);
		quickSort(a, j + 1, right);
	}
}