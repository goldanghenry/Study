/*	심화컴퓨터공학 2014097056 우성현
	< 문제 16 - 2 >
	qsort function(C/C++의 built-in function)을 이용하여 위와 같은 작업을 수행하라.
	+ 참고사이트: https://www.cplusplus.com/reference/cstdlib/qsort/
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