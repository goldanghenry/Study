/* ��ȭ��ǻ�Ͱ��� 2014097056 �켺��
	< ���� 19-1 >
	Division method�� �̿��Ͽ� in.txt�� �־��� key���� hash table�� insertion�� ��, search.txt��
	�־��� key���� hash table���� ���ʴ�� search�Ѵ�. �� search���� �����ϸ� ��S��, �����ϸ� ��E����
	ȭ�鿡 ����ϰ�, search�� ��ġ�� ��ü hash table�� ������ ���ʴ�� ȭ�鿡 ����ϰ� �� key����
	�ڵ尪�� ����Ѵ�.
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

typedef struct {
	int key;		// hashcode
	char data[4];	// data
}element;
 
element** ht;
int b;

unsigned int Key(char* key); // hashcode ����
int h(int key);				 // hash function
int insertIndex(int k);		 // insert �� �ε��� ��ȯ
int search(int k, char data[]);			 // �ش� ���� ������ hashcode ��ȯ

void main() {
	FILE* fp1 = fopen("in.txt", "r");
	FILE* fp2 = fopen("search.txt", "r");
	FILE* fp3 = fopen("out.txt", "w");

	scanf("%d", &b);
	MALLOC(ht, sizeof(ht)*b);
	for (int i = 0; i < b; i++) {
		MALLOC(ht[i], sizeof(ht[i]));
		ht[i]->key = 0;	// �ʱ�ȭ
	}

	// insert data
	char temp[4];
	int key; int index;
	for (int i =0;!feof(fp1);i++) {
		fscanf(fp1, "%s", &temp);
		key = Key(temp);			// hash code
		index = insertIndex(key);	// index
		strcpy(ht[index]->data, temp);
		ht[index]->key = key;
	}
	
	// search ��� ��� -> out.txt
	while(!feof(fp2)) {
		fscanf(fp2, "%s", &temp);
		key = Key(temp);
		if (search(key, temp)) fputs("S ", fp3);
		else fputs("E ", fp3);
	}
	
	// print table
	printf("\n(Hash table )\n");
	for (int i = 0; i < b; i++) {
		printf("%d: ", i);
		if(ht[i]->key){
			printf("%s (%d)", ht[i]->data, ht[i]->key);
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

// insertIndex, parameter : hashcode
int insertIndex(int k) {
	int homeBucket, currentBucket;
	homeBucket = h(k);	// ���� �ε���
	currentBucket = homeBucket;
	if (ht[homeBucket]->key == 0) return homeBucket;
	else {
		while (1) {
			currentBucket = (currentBucket + 1) % b;
			if (ht[currentBucket]->key == 0) break;
			if (homeBucket == currentBucket) {
				printf("table is full\n");
				exit(EXIT_FAILURE);
			}
		}
		return currentBucket;
	}
}

// serarch, k is target of hashcode
int search(int k, char data[]) {
	/* search the linear probing hash table ht(each bucket has exactly one slot) for k,
    if a pair with key k is found, return a pointer to this pair;
	otherwise, return NULL */
	int homeBucket, currentBucket;
	homeBucket = h(k);
	for (currentBucket = homeBucket; ht[currentBucket]->key && ht[currentBucket]->key != k && strcmp(ht[currentBucket], data);) {
		currentBucket = (currentBucket + 1) % b;
		 /* treat the table as circular */
		if (currentBucket == homeBucket)
			return 0;  /* back to start point */
	}
	if (ht[currentBucket]->key == k)
		return ht[currentBucket]->key;
	return 0;
}
