/* 심화컴퓨터공학 2014097056 우성현
	< 문제 12-2 >
	주어진 입력에 따라 max heap을 구성한 뒤, heap에서 deletion을 수행한 후의 heap을 
	level order traversal한 결과를 출력하라..
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
	i = ++(*n);  // 삽입을 해야하기 때문에 가장 마지막에 추가할 leaf node의 index를 가짐
	while ((i != 1) && (item.key > heap[i / 2].key)) {	// 루트에 도착하거나, 내가 부모보다 작으면 종료
		heap[i] = heap[i / 2];	// 부모노드를 자식 노드로 내림
		i /= 2;	// 자식은 부모 노드로 올림
	}
	heap[i] = item;	// 결국 찾은 i에 아이템을 삽입하게 된다.
}

element pop(int* n) {
	/* 루트노드를 뽑아낸 후 트리 재정렬을 해야한다. */
	/* 부모노드는 항상 자식노드보다 커야 한다. */
	int parent, child;
	element item, temp;
	if (HEAP_EMPTY(*n)) {
		fprintf(stderr, "The heap is empty\n");
		exit(EXIT_FAILURE);
	}
	item = heap[1];	// 가장 큰 값이 pop
	temp = heap[(*n)--];  // 힙의 마지막 노드를 temp에 저장
	parent = 1;	// 위에서 아래로 temp >= child 까지 내려옴.
	child = 2;
	while (child <= *n) { // child가 힙의 노드수 보다 커지면 종료
		if ((child < *n) && (heap[child].key < heap[child + 1].key)) // 왼쪽이 오른쪽 노드보다 작다면
			child++; // 오른쪽 노드 선택
		if (temp.key >= heap[child].key) break; // temp가 더 크다면 parent자리에 넣고 종료
		heap[parent] = heap[child];	// 아니라면, parent 위치에 child key 대입(빈 자리 당기기)
		parent = child;	// 업데이트
		child *= 2;	// 자식은 한칸 아래로
	}
	heap[parent] = temp;
	return item;
}