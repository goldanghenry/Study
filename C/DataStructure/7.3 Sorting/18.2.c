/* ��ȭ��ǻ�Ͱ��� 2014097056 �켺��
	< ����18-2 >
	Radix sort algorithm�� �̿��Ͽ� in.txt�� �־��� �ܾ���� lexicographic order (���� ����)��
	�����Ͽ� ����϶�.
*/
#define _CRT_SECURE_NO_WARNINGS
#define MAX_SIZE 100
#define r 26
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
	char X1;	// ù° �ڸ�
	char X2;	// ��° �ڸ�
	char X3;	// ��° �ڸ�
}element;

int radixSort(element a[], int link[], int d, int n);
int digit(element a, int i);

void main() {
	char temp[4];
	int start, n = 0;
	element a[MAX_SIZE];
	int link[MAX_SIZE] = { 0 };

	FILE* fp = fopen("in2.txt", "r");
	if (!fp) {
		fprintf(stderr, "file open failure");
		exit(EXIT_FAILURE);
	}

	for (int i = 1; !feof(fp); i++) {
		fscanf(fp, "%s", &temp);
		a[i].X1 = temp[0];
		a[i].X2 = temp[1];
		a[i].X3 = temp[2];
		n++;
	}
	
	start = radixSort(a, link, 3, n);
	//printf("start is %d: \n", start);
	/*
	for (int i = 1; i <= n; i++) {
		printf("%d ", link[i]);
	}
	printf("\n");
	*/

	for (int cur = start; cur; cur = link[cur]) {
		printf("%c%c%c ", a[cur].X1, a[cur].X2, a[cur].X3);
	}
	
	fclose(fp);
}
int digit(element a, int i) {
	switch (i) {
	case 0: return a.X1-'a'; break;
	case 1: return a.X2-'a'; break;
	case 2: return a.X3-'a'; break;
	}
}

int radixSort(element a[], int link[], int d, int n) {
	int front[r], rear[r];
	int i, bin, current, first, last;
	first = 1;
	for (i = 1; i < n; i++) link[i] = i + 1;
	link[n] = 0;
	for (i = d - 1; i >= 0; i--) {
		for (bin = 0; bin < r; bin++) front[bin] = 0;
		for (current = first; current; current = link[current])
		{/* put records into queues/bins */
			bin = digit(a[current], i);
			if (front[bin] == 0) front[bin] = current;
			else link[rear[bin]] = current;
			rear[bin] = current;
		}
		/* find first nonempty queue/bin */
		for (bin = 0; !front[bin]; bin++);
		first = front[bin]; last = rear[bin];
		/* concatenate remaining queues */
		for (bin++; bin < r; bin++)
			if (front[bin]) { link[last] = front[bin]; last = rear[bin]; }
		link[last] = 0;
	}
	return first;
}