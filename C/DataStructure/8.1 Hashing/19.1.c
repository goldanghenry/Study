/* 심화컴퓨터공학 2014097056 우성현
	< 문제 19-1 >
	Division method를 이용하여 in.txt로 주어진 key들을 hash table에 insertion한 뒤, search.txt로
	주어진 key들을 hash table에서 차례대로 search한다. 각 search마다 성공하면 ‘S’, 실패하면 ‘E’를
	화면에 출력하고, search를 마치면 전체 hash table의 내용을 차례대로 화면에 출력하고 각 key옆에
	코드값을 출력한다.
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

unsigned int Key(char* key); // hashcode 생성
int h(int key);				 // hash function
int insertIndex(int k);		 // insert 할 인덱스 반환
int search(int k, char data[]);			 // 해당 값이 있으면 hashcode 반환

void main() {
	FILE* fp1 = fopen("in.txt", "r");
	FILE* fp2 = fopen("search.txt", "r");
	FILE* fp3 = fopen("out.txt", "w");

	scanf("%d", &b);
	MALLOC(ht, sizeof(ht)*b);
	for (int i = 0; i < b; i++) {
		MALLOC(ht[i], sizeof(ht[i]));
		ht[i]->key = 0;	// 초기화
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
	
	// search 결과 출력 -> out.txt
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
	homeBucket = h(k);	// 시작 인덱스
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
