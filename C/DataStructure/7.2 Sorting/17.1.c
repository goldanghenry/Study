/* 심화컴퓨터공학 2014097056 우성현
	< 문제 17-1 >
	교재의 rmergeSort algorithm을 이용하여 정수들의 집합에 대해서 non-decreasing order로
	정렬하여 출력하라.
*/
#define _CRT_SECURE_NO_WARNINGS
#define MAX_SIZE 100
#include <stdio.h>
#include <stdlib.h>
typedef struct {
	int data;
}element;

int rmergeSort(element a[], int link[], int left, int right);
int listMerge(element a[], int link[], int start1, int start2);

void main() {
	int start, current, n = 0;
	element a[MAX_SIZE];
	int link[MAX_SIZE]={0}; // 0으로 초기화

	FILE* fp = fopen("in.txt", "r");
	if (!fp) {
		fprintf(stderr, "file open failure");
		exit(EXIT_FAILURE);
	}
	for (int i = 1; !feof(fp); i++) {
		fscanf(fp, "%d", &a[i].data);
		n++;
	}

	rmergeSort(a, link, 1, n);
	for (int cur = link[0]; cur; cur = link[cur]){
		printf("%d ", a[cur].data);
	}
	
	fclose(fp);
}
int listMerge(element a[], int link[], int start1, int start2) {
	int last1, last2, lastResult = 0;
	for (last1 = start1, last2 = start2; last1 && last2;)
		if (a[last1].data <= a[last2].data) {
			link[lastResult] = last1;
			lastResult = last1; last1 = link[last1];
		}
		else {
			link[lastResult] = last2;
			lastResult = last2; last2 = link[last2];
		}
	if (last1 == 0) link[lastResult] = last2;
	else link[lastResult] = last1;
	return link[0];
}
int rmergeSort(element a[], int link[], int left, int right) {
	if (left >= right) return left;
	int mid = (left + right) / 2;
	return listMerge(a, link, rmergeSort(a, link, left, mid), rmergeSort(a, link, mid + 1, right));
}