/*	��ȭ��ǻ�Ͱ��� 2014097056 �켺��
	< ���� 16 - 2 >
	qsort function(C/C++�� built-in function)�� �̿��Ͽ� ���� ���� �۾��� �����϶�.
	+ �������Ʈ: https://www.cplusplus.com/reference/cstdlib/qsort/
*/
#define _CRT_SECURE_NO_WARNINGS
#define MAX_SIZE 100
#include <stdio.h>
#include <stdlib.h>	/* qsort */

int values[MAX_SIZE];

int compare(const void* a, const void* b) {
	return (*(int*)a - *(int*)b);
}


void main() {
	int n = 0;
	FILE* fp = fopen("in.txt", "r");
	if (!fp) {
		fprintf(stderr, "file open failure");
		exit(EXIT_FAILURE);
	}

	for (int i = 0; !feof(fp); i++) {
		fscanf(fp, "%d", &values[i]);
		n++;
	}

	qsort(values, n, sizeof(int), compare);

	for (int i = 0; i < n; i++) {
		printf("%d ", values[i]);
	}

	fclose(fp);
}