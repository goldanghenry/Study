// ����4
// ���Ϸ� n���� �����͸� �Է¹޾� �迭�� �����ϰ� ����� �����͸� ������������ '��������'�� 
// �����ϰ� �� ����� ����϶�.
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define SWAP(x,y,t)((t)=(x),(x)=(y),(y)=(t))
void sort(int[], int);

void main() {
	FILE* fp;
	int n, temp;
	char s[10];
	scanf("%s", &s);
	fp = fopen(s, "r");

	fscanf(fp, "%d", &n);
	int* array = (int*)malloc(sizeof(int) * n);

	for (int i = 0; i < n; i++) {
		fscanf(fp, "%d", &temp);
		array[i] = temp;
	}
	fclose(fp);

	sort(array, n);
	for (int i = 0;i < n;i++) {
		printf("%d ", array[i]);
	}
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

