/* 2014097056-우성현 */
#define _CRT_SECURE_NO_WARNINGS
#define MAX_SIZE 105
#define SWAP(x,y,t)((t)=(x),(x)=(y),(y)=(t))
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
	int key;
	char data[11];
}element;
void Adjust(element list[], int root, int n);
void Heap_sort(element list[], int n);

void main() {
	int n = 0;
	char tmp[11];
	element list[MAX_SIZE];

	FILE* fp = fopen("in1.txt", "r");
	if (!fp) {
		fprintf(stderr, "file open failure");
		exit(EXIT_FAILURE);
	}
	for (int i = 1; !feof(fp); i++) {
		fscanf(fp, "%s", &list[i].data); // 데이터 넣기
		list[i].key = list[i].data[0]; // 첫번 째 문자를 숫자로 변환해서 키에 넣기 넣기
		n++;
	}

	Heap_sort(list, n); // 정렬

	for (int i = 1; i <= n; i++) { // 출력
		printf("%s ", list[i].data);
	};

	fclose(fp);
}

void Adjust(element list[], int root, int n) {
	int child, rootkey;
	element temp;
	temp = list[root];
	rootkey = list[root].key;
	child = 2 * root;
	while (child <= n) {
		if ((child < n) && (list[child].key > list[child + 1].key)) // non-increasing
			child++;
		if (rootkey < list[child].key)
			break;
		else {
			list[child / 2] = list[child];
			child *= 2;
		}
	}
	list[child / 2] = temp;
}

void Heap_sort(element list[], int n) {
	int i, j;
	element temp;
	for (i = n / 2; i > 0; i--) Adjust(list, i, n);
	for (i = n - 1; i > 0; i--) {
		SWAP(list[1], list[i + 1], temp);
		Adjust(list, 1, i);
	}
}