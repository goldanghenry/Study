#define _CRT_SECURE_NO_WARNINGS
#define A 100000
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void SequentialSearch(char arr[][4], char target[], int n);
void binarySearch(char arr[][4], char target[], int left, int right);
void R_binarySearch(char arr[][4], char target[], int left, int right);

void main() {
    FILE* fp;
    int n = 0;
    char array[A][4];
    char target[4];

    fp = fopen("list.txt", "r");

    if (fp == NULL) {
        printf("Error When creating stream");
        exit(EXIT_FAILURE);
    }

    while (feof(fp) == 0) {
        fscanf(fp, "%s", array[n]);
        printf("%s\n", array[n]);
        n++;
    }
    fclose(fp);

    scanf("%s", target);
    SequentialSearch(array, target, n);
    binarySearch(array, target, 0, n);
    R_binarySearch(array, target, 0, n);
}

void SequentialSearch(char arr[][4], char target[], int n) {
    for (int i = 0;i < n;i++) {
        if (!strcmp(arr[i], target)) {
            printf("Sequential search result: S\n");
            return;
        }
    }
    printf("Sequential search result: F\n");
}

void binarySearch(char arr[][4], char target[], int left, int right) {
    int middle;
    while (left <= right) {
        middle = (left + right) / 2;
        switch (strcmp(arr[middle], target)) {
        case -1: left = middle + 1;
            break;
        case 0: printf("Iterative binary search result: S\n"); return;
        case 1: right = middle - 1;
        }
    }
    printf("Iterative binary search result: F\n");
    return;
}

void R_binarySearch(char arr[][4], char target[], int left, int right) {
    int middle;
    if (left <= right) {
        middle = (left + right) / 2;
        switch (strcmp(arr[middle], target)) {
        case -1: return R_binarySearch(arr, target, middle + 1, right);
        case 0: printf("Recursice binary search result: S\n"); return;
        case 1: return R_binarySearch(arr, target, left, middle - 1);
        }
    }
    printf("Recursice binary search result: F\n");
    return;
}