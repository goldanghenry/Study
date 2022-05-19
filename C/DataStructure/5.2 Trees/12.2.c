/* ��ȭ��ǻ�Ͱ��� 2014097056 �켺��
	< ���� 12-2 >
	�־��� �Է¿� ���� max heap�� ������ ��, heap���� deletion�� ������ ���� heap�� 
	level order traversal�� ����� ����϶�..
*/
#define _CRT_SECURE_NO_WARNINGS
#define MAX_ELEMENTS 200 /* maximum heap size+1 */
#define HEAP_FULL(n) (n==MAX_ELEMENTS-1)
#define HEAP_EMPTY(n)(!n)
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int key;
}element;

void push(element item, int* n);	// heap push
element pop(int* n);				// heap pop

element heap[MAX_ELEMENTS];	// max heap array
int n = 0;

void main() {
	element item;
	int P_num, D_num;
	FILE* fp = fopen("in.txt", "r");
	if (!fp) {
		fprintf(stderr, "file open failue!");
		exit(EXIT_FAILURE);
	}

	// push
	fscanf(fp, "%d", &P_num);
	for (int i = 0; i < P_num;i++) {
		fscanf(fp, "%d", &(item.key));
		push(item, &n);
	}

	//pop
	fscanf(fp, "%d", &D_num);
	for (int i = 0; i < D_num; i++) {
		pop(&n);
	}

	// Level order traversal
	for (int i = 1; i <= n; i++) {
		printf("%d ", heap[i].key);
	}

	fclose(fp);
}

void push(element item, int* n) {
	/* insert item into a max heap of current size *n */
	int i;
	if (HEAP_FULL(*n)) {
		fprintf(stderr, "The heap is full. \n");
		exit(EXIT_FAILURE);
	}
	i = ++(*n);  // ������ �ؾ��ϱ� ������ ���� �������� �߰��� leaf node�� index�� ����
	while ((i != 1) && (item.key > heap[i / 2].key)) {	// ��Ʈ�� �����ϰų�, ���� �θ𺸴� ������ ����
		heap[i] = heap[i / 2];	// �θ��带 �ڽ� ���� ����
		i /= 2;	// �ڽ��� �θ� ���� �ø�
	}
	heap[i] = item;	// �ᱹ ã�� i�� �������� �����ϰ� �ȴ�.
}

element pop(int* n) {
	/* ��Ʈ��带 �̾Ƴ� �� Ʈ�� �������� �ؾ��Ѵ�. */
	/* �θ���� �׻� �ڽĳ�庸�� Ŀ�� �Ѵ�. */
	int parent, child;
	element item, temp;
	if (HEAP_EMPTY(*n)) {
		fprintf(stderr, "The heap is empty\n");
		exit(EXIT_FAILURE);
	}
	item = heap[1];	// ���� ū ���� pop
	temp = heap[(*n)--];  // ���� ������ ��带 temp�� ����
	parent = 1;	// ������ �Ʒ��� temp >= child ���� ������.
	child = 2;
	while (child <= *n) { // child�� ���� ���� ���� Ŀ���� ����
		if ((child < *n) && (heap[child].key < heap[child + 1].key)) // ������ ������ ��庸�� �۴ٸ�
			child++; // ������ ��� ����
		if (temp.key >= heap[child].key) break; // temp�� �� ũ�ٸ� parent�ڸ��� �ְ� ����
		heap[parent] = heap[child];	// �ƴ϶��, parent ��ġ�� child key ����(�� �ڸ� ����)
		parent = child;	// ������Ʈ
		child *= 2;	// �ڽ��� ��ĭ �Ʒ���
	}
	heap[parent] = temp;
	return item;
}