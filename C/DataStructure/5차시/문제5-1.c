// 2014097056 심화컴퓨터 우성현 자료구조 5차시 과제 1번 문제
#define _CRT_SECURE_NO_WARNINGS
#define MAX_COL 101
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int row;
    int col;
    int value;
}term;
term a[MAX_COL];
term b[MAX_COL];

void fastTranspose(term a[], term b[]);
void matrixPrint(term a[], char c);

void main() {
    // 파일 열기 및 검사
    FILE* fp1 = fopen("a.txt", "r");
    FILE* fp2 = fopen("b.txt", "w");
    if (fp1 == NULL || fp2 == NULL) {
        printf("Error When creating stream");
        exit(EXIT_FAILURE);
    }

    // 파일에서 읽어와 terms a[i]에 저장
    for (int i = 0; feof(fp1) == 0; i++) {
        fscanf_s(fp1, "%d %d %d", &a[i].row, &a[i].col, &a[i].value);
    }

    // Transpose
    fastTranspose(a, b);

    // term b -> b.txt에 저장
    for (int i = 0; i <= b[0].value; i++) {
        fprintf(fp2, "%5d %5d %5d\n", b[i].row, b[i].col,b[i].value);
    }

    // 화면 출력
    matrixPrint(a, 'A');
    matrixPrint(b, 'B');

    // 파일 닫기
    fclose(fp1);
    fclose(fp2);
}

void fastTranspose(term a[], term b[]) {
    int rowTerms[MAX_COL], startingPos[MAX_COL];
    int i, j, numCols = a[0].col, numTerms = a[0].value;
    // b의 정보
    b[0].row = numCols; b[0].col = a[0].row;
    b[0].value = numTerms;
    if (numTerms > 0) {
        // 초기화
        for (i = 0; i < numCols; i++) rowTerms[i] = 0;
        for (i = 1; i <= numTerms; i++) rowTerms[a[i].col]++;

        startingPos[0] = 1;
        for (i = 1; i < numCols; i++)
            startingPos[i] = startingPos[i - 1] + rowTerms[i - 1];

        for (i = 1; i <= numTerms; i++) {
            j = startingPos[a[i].col]++;
            b[j].row = a[i].col; b[j].col = a[i].row;
            b[j].value = a[i].value;
        }
    }
}

// matrix 출력 함수, 2차원 배열을 만들지 않고, 구조체를 확인해서 값이 있으면 출력, 없으면 0을 출력.
void matrixPrint(term a[], char c) {
    int index_a = 1;
    printf("%c\n", c);

    // i,j에 해당하는 value가 있다면 출력
    for (int i = 0; i < a[0].row; i++) {
        for (int j = 0; j < a[0].col; j++) {
            if (i == a[index_a].row && j == a[index_a].col) {   
                printf("%5d", a[index_a].value);
                index_a++;
            }
            else printf("%5d", 0);
        }
        printf("\n");
    }
}
