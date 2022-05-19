// 2014097056 ��ȭ��ǻ�� �켺�� �ڷᱸ�� 5���� ���� 1�� ����
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
    // ���� ���� �� �˻�
    FILE* fp1 = fopen("a.txt", "r");
    FILE* fp2 = fopen("b.txt", "w");
    if (fp1 == NULL || fp2 == NULL) {
        printf("Error When creating stream");
        exit(EXIT_FAILURE);
    }

    // ���Ͽ��� �о�� terms a[i]�� ����
    for (int i = 0; feof(fp1) == 0; i++) {
        fscanf_s(fp1, "%d %d %d", &a[i].row, &a[i].col, &a[i].value);
    }

    // Transpose
    fastTranspose(a, b);

    // term b -> b.txt�� ����
    for (int i = 0; i <= b[0].value; i++) {
        fprintf(fp2, "%5d %5d %5d\n", b[i].row, b[i].col,b[i].value);
    }

    // ȭ�� ���
    matrixPrint(a, 'A');
    matrixPrint(b, 'B');

    // ���� �ݱ�
    fclose(fp1);
    fclose(fp2);
}

void fastTranspose(term a[], term b[]) {
    int rowTerms[MAX_COL], startingPos[MAX_COL];
    int i, j, numCols = a[0].col, numTerms = a[0].value;
    // b�� ����
    b[0].row = numCols; b[0].col = a[0].row;
    b[0].value = numTerms;
    if (numTerms > 0) {
        // �ʱ�ȭ
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

// matrix ��� �Լ�, 2���� �迭�� ������ �ʰ�, ����ü�� Ȯ���ؼ� ���� ������ ���, ������ 0�� ���.
void matrixPrint(term a[], char c) {
    int index_a = 1;
    printf("%c\n", c);

    // i,j�� �ش��ϴ� value�� �ִٸ� ���
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
