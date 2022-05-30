/* ��ȭ��ǻ�Ͱ��� 2014097056 �켺��
	< ���� 19-2 >
	1�� �������� overflow handling�� chaining���� �����Ͽ� �����϶�.
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_SIZE 100
#define MALLOC(p,s) \
	if(!((p)=malloc(s))) {\
		fprintf(stderr, "insufficient memory");\
		exit(EXIT_FAILURE);\
	}
typedef struct element* Pointer;
typedef struct element {
	int key;		// hashcode
	char data[4];	// data
	Pointer link;
}element;

Pointer* ht;
int b;

unsigned int Key(char* key);			// hashcode ����
int h(int key);							// hash function
int search(int k, char data[]);			// �ش� ���� ������ hashcode ��ȯ

void main() {
	Pointer cur = NULL;
	int key, index;
	char temp[4];
	FILE* fp1 = fopen("in.txt", "r");	
	FILE* fp2 = fopen("search.txt", "r"); 
	FILE* fp3 = fopen("out2.txt", "w");

	scanf("%d", &b);
	
	MALLOC(ht, sizeof(ht) * b);
	for (int i = 0; i < b; i++) {
		MALLOC(ht[i], sizeof(ht[i]));
		ht[i]->key = 0;	// �ʱ�ȭ
		ht[i]->link = NULL;
	}

	// insert data
	for (int i = 0; !feof(fp1); i++) {
		Pointer t;
		MALLOC(t, sizeof(t));
		fscanf(fp1, "%s", &t->data);
		t->key = Key(t->data);			// hash code
		t->link = NULL;

		// insert
		index = h(t->key);
		cur = ht[index];
		if (!cur->key) { ht[index] = t;	} // ��ũ ù��°�� insert
		else {
			while (cur->link !=NULL) cur = cur->link; 
			cur->link = t;	// ��ũ �������� insert
		}
	}

	// search ��� ��� -> out.txt
	while (!feof(fp2)) {
		fscanf(fp2, "%s", &temp);
		key = Key(temp);
		if (search(key, temp)) fputs("S ", fp3);
		else fputs("E ", fp3);
	}

	// print table
	printf("\n(Hash table )\n");
	for (int i = 0; i < b; i++) {
		printf("%d: ", i);
		if (ht[i]->key != 0) {
			cur = ht[i];
			while (cur) {
				printf("%s (%d)", cur->data, cur->key);
				cur = cur->link;
				if (cur) printf(" -> ");
			}
		}
		printf("\n");
	}
	fclose(fp1);
	fclose(fp2);
	fclose(fp3);
}
// hash key
unsigned int Key(char* key) {
	/* simple additive approach to create a natural number that is within the integer range */
	int number = 0;
	while (*key)
		number += *key++;
	return number;
}

// hash function
int h(int key) {
	return key % b;
}

// serarch, k is target of hashcode
int search(int k, char data[]) { // Ű�� ���� ������ �ٸ� ��츦 ���� data[] �߰�
	int index = h(k);
	Pointer cur = ht[index];
	while(cur){
		if (cur->key == k && !strcmp(cur->data, data)) return cur->key;
		else cur = cur->link;
		if (cur == NULL) break;
	}
	return 0;
}
