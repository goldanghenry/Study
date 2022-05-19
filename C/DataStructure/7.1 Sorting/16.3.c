/*	심화컴퓨터공학 2014097056 우성현
	< 문제 16 - 3 >
	iterative merge sort algorithm을 이용하여 정수들의 집합에 대해 non-decreasing order로
	정렬하여 출력하라.
*/
#define _CRT_SECURE_NO_WARNINGS
#define MAX_SIZE 100
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int X;
	int Y;
	int Z;
}element;
char key;

void merge(element initList[], element mergedList[], int i, int m, int n);
void mergePass(element initLIst[], element mergedList[], int n, int s);
void mergeSort(element a[], int n);

void main() {
	element initList[MAX_SIZE];
	int n = 0;
	FILE* fp = fopen("in.txt", "r");
	if (!fp) {
		fprintf(stderr, "file open failure");
		exit(EXIT_FAILURE);
	}

	for (int i = 1; !feof(fp); i++) {
		fscanf(fp, "%d %d %d", &initList[i].X, &initList[i].Y, &initList[i].Z);
		printf("%3d %3d %3d\n", initList[i].X, initList[i].Y, initList[i].Z);
		n++;
	}

	printf("\nKey 값(X,Y,Z)을 입력하세요 >> ");
	scanf("%c", &key); 
	while (key != 'X' && key != 'Y' && key != 'z') {
		printf("다시 입력하세요 >> ");
		scanf("%c", &key);
	}
	
	mergeSort(initList, n);

	for (int i = 1; i <= n; i++) {
		printf("%3d %3d %3d\n", initList[i].X, initList[i].Y, initList[i].Z);
	}
	fclose(fp);
}

void merge(element initList[], element mergedList[], int i, int m, int n) {
	/* the sorted lists initList[i:m] and initList[m+1:n] are merged
	to obtain the sorted list mergedList[i:n] */
	int j, k, t;
	j = m + 1;	/* index for the second sublist */
	k = i;		/* index for the merged list */

	while (i <= m && j <= n) {
		switch (key) {
		case 'X':
			if (initList[i].X <= initList[j].X)
				mergedList[k++] = initList[i++];
			else
				mergedList[k++] = initList[j++]; break;
		case 'Y':
			if (initList[i].Y <= initList[j].Y)
				mergedList[k++] = initList[i++];
			else
				mergedList[k++] = initList[j++]; break;
		case 'Z':
			if (initList[i].Z <= initList[j].Z)
				mergedList[k++] = initList[i++];
			else
				mergedList[k++] = initList[j++];
		}
	}
	if (i > m)	/* mergedList[k:n] = initList[j:n] */
		for (t = j; t <= n; t++)
			mergedList[t] = initList[t];
	else        /* mergedList[k:n] = initList[i:m] */
		for (t = i; t <= m; t++)
			mergedList[k + t - i] = initList[t];
}

void mergePass(element initLIst[], element mergedList[], int n, int s){
	int i, j;
	for (i = 1; i <= n - 2 * s + 1; i += 2 * s)
		merge(initLIst, mergedList, i, i + s - 1, i + 2 * s - 1);
	if (i + s - 1 < n)
		merge(initLIst, mergedList, i, i + s - 1, n);
	else
		for (j = i; j <= n; j++)
			mergedList[j] = initLIst[j];
}

void mergeSort(element a[], int n) {
	int s = 1;
	element extra[MAX_SIZE];
	while (s < n) {
		mergePass(a, extra, n, s);
		s *= 2;
		mergePass(extra, a, n, s);
		s *= 2;
	}
}