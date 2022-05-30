/* 심화컴퓨터공학 2014097056 우성현
	< 문제18-1 >
	Radix sort algorithm을 이용하여 in.txt로 주어진 정수들을 non-decreasing order로 정렬하여
	출력하라.
*/
#define _CRT_SECURE_NO_WARNINGS
#define MAX_SIZE 100
#define r 10 // base
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int X1;	// 백의 자리
	int X2;	// 십의 자리
	int X3; // 일의 자리
}element;

int radixSort(element a[], int link[], int d, int n);
int digit(element a, int i);

void main() {
	int temp, start, n=0;
	element a[MAX_SIZE];
	int link[MAX_SIZE] = {0};
	
	FILE* fp = fopen("in.txt", "r");
	if (!fp) {
		fprintf(stderr, "file open failure");
		exit(EXIT_FAILURE);
	}
	
	for (int i = 1; !feof(fp); i++) {
		fscanf(fp, "%d", &temp);
		a[i].X1 = (temp - temp % 100) / 100; // 백의자리
		a[i].X2 = (temp % 100 - temp % 10) / 10;  // 십의자리
		a[i].X3 = temp % 10;	// 일의자리
		//printf("%d %d %d\n", a[i].X1, a[i].X2, a[i].X3);
		n++;
	}

	start = radixSort(a, link, 3, n);
	//printf("start is %d: \n", start);
	

	for (int cur = start; cur; cur = link[cur]) {
		printf("%d ", a[cur].X1*100+ a[cur].X2*10 + a[cur].X3);
	}

	fclose(fp);
}
int digit(element a, int i) {
	switch (i) {
	case 0: return a.X1; break;
	case 1: return a.X2; break;
	case 2: return a.X3; break;
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