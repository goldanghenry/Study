#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_SIZE 100

typedef struct {
	int key;
	char name[20];
	int grade;
}element;
element a[MAX_SIZE];
void insert(element e, element a[], int i);
void insertionSort(element a[], int n);

void main() {
	int n;
	FILE* fp = fopen("in.txt", "r");
	if (!fp) {
		fprintf(stderr, "file open error!");
		exit(EXIT_FAILURE);
	}

	fscanf(fp, "%d", &n);
	for (int i = 1; i <= n; i++) {
		fscanf(fp, "%d %s %d", &a[i].key, &a[i].name, &a[i].grade);
	}
	insertionSort(a, n);
	for (int i = 1; i <= n; i++) {
		printf("%d %s %d\n", a[i].key, a[i].name, a[i].grade);
	}
	fclose(fp);
}
 
void insert(element e, element a[], int i) {
	a[0] = e;
	while (e.key < a[i].key) {
		a[i + 1] = a[i];
		i--;
	}
	a[i + 1] = e;
}

void insertionSort(element a[], int n) {
	int j;
	for (j = 2; j <= n; j++) {
		element temp = a[j];
		insert(temp, a, j - 1);
	}
}