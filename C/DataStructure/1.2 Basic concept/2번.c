// 2014097056 심화컴퓨터공학 2학년 우성현
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

void main() {
    FILE* fp1 = fopen("data1.txt", "r");
    FILE* fp2 = fopen("data2.txt", "r");
    if (fp1 == NULL || fp2 == NULL) {
        printf("Error When creating stream");
        exit(EXIT_FAILURE);
    }

    int* list1; int* list2;
    if ((list1 = (int*)malloc(sizeof(int) * 10)) == NULL ||
        (list2 = (int*)malloc(sizeof(int) * 10)) == NULL) {
        fprintf(stderr, "Insufficient memory");
        exit(EXIT_FAILURE);
    }

    int n = 0, m = 0;

    for (int i = 0; feof(fp1) == 0; i++) {
        fscanf(fp1, "%d", &list1[i]);
        n++;
        if (n % 10 == 0) {  // Allocate an additional 10 space when memory is full
            list1 = realloc(list1, sizeof(int) * 10 * (n / 10 + 1));
        }
    }

    for (int i = 0; feof(fp2) == 0; i++) {
        fscanf(fp2, "%d", &list2[i]);
        m++;
        if (m % 10 == 0) {
            list2 = realloc(list2, sizeof(int) * 10 * (m / 10 + 1));
        }
    }

    // 교집합을 오름차순으로 출력
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (list1[i] == list2[j]) {
                printf("%d ", list1[i]);
                break;
            }
        }
    }

    fclose(fp1);
    fclose(fp2);
    free(list1);
    free(list2);
}