// ����5
// '�����˻�'�� �����ϰ� �������� ����ϴ� �ڵ带 �ۼ��϶�.
// - �˻����� �����ϴ� ��� S(�ε���), �������� �ʴ� ��� F(-1) ���
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

#define SWAP(x,y,t)((t)=(x),(x)=(y),(y)=(t))
#define COMPARE(x,y)(((x)<(y))?-1:((x)==(y)?0:1))
void sort(int[], int);
int binarysearch(int arr[], int searchnum, int left, int right);

void main() {
	FILE* fp;
	int n, temp, k, result;
	char s[10];

	scanf("%s", &s);
	scanf("%d", &k);

	fp = fopen(s, "r");
	fscanf(fp, "%d", &n);
	int* array = (int*)malloc(sizeof(int) * n);
	for (int i = 0; i < n; i++) {
		fscanf(fp, "%d", &temp);
		array[i] = temp;
	}
	fclose(fp);

	sort(array, n);
	
	result = binarysearch(array, k, 0, n);
	if (result == -1)
		printf("F \(%d\)", result);
	else
		printf("S \(%d\)", result);
}

void sort(int arr[], int n) {
	int i, j, min, temp;
	for (i = 0;i < n - 1;i++) {
		min = i;
		for (j = i + 1;j < n;j++)
			if (arr[j] < arr[min])
				min = j;
		SWAP(arr[i], arr[min], temp);
	}
}

int binarysearch(int arr[], int searchnum, int left, int right) {
	int middle;
	if (left <= right) {
		middle = (left + right) / 2;
		switch (COMPARE(arr[middle], searchnum)) {
		case -1: return binarysearch(arr, searchnum, middle + 1, right);
		case 0: return middle;
		case 1: return binarysearch(arr, searchnum, left, middle - 1);
		}
	}
	return -1;
}

