/* ��ȭ��ǻ�Ͱ��� 2014097056 �켺��
	< ���� 15-1 >
	�Ʒ� graph�� linked adjacency list�� ������ ��, breath-first search ����� ȭ�鿡 ����϶�.
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define FALSE 0
#define TRUE 1
#define MAX_VERTEX 101
#define MALLOC(p,s)\
   if(!((p) = malloc(s))){\
      fprintf(stderr, "Insufficient memory");\
      exit(EXIT_FAILURE);\
   }

typedef struct node* listPointer;
typedef struct node {
    int data;
    listPointer link;
};
listPointer* adjacencyL;
short int visited[MAX_VERTEX];
int queue[MAX_VERTEX];
int rear = -1, front = -1;

void addq(int num);
int deleteq();
listPointer insert(listPointer* first, listPointer x, int num);
void bfs(int v);

void main() {
    FILE* fp = fopen("input.txt", "r");
    int start,v;
    fscanf(fp, "%d", &v);
    int** adjacencyM;

    adjacencyM = (int**)malloc(sizeof(int*) * v);
    for (int i = 0; i < v; ++i) {
        adjacencyM[i] = (int*)malloc(sizeof(int) * v);
    }

    printf("< ���� ����Ʈ >\n");
    for (int i = 0; i < v; ++i) {
        for (int j = 0; j < v; ++j) {
            fscanf(fp, "%d", &adjacencyM[i][j]);
            printf("%d ", adjacencyM[i][j]);
        }
        printf("\n");
    }
    printf("\n");

    adjacencyL = (listPointer*)malloc(sizeof(listPointer) * v); //adjancyList �����Ҵ�.
    for (int i = 0; i < v; ++i) {
        adjacencyL[i] = NULL;
    }

    listPointer temp = NULL;
    for (int i = 0; i < v; ++i) {
        temp = adjacencyL[i];
        for (int j = 0; j < v; ++j) {
            if (adjacencyM[i][j] == 1) temp = insert(&adjacencyL[i], temp, j);
        }
    }
    
    printf("���� ��带 �Է��ϼ���>> ");
    scanf("%d", &start);
    printf("BFS: ");
    bfs(start);

    /*
    for (int i = 0; i < v; ++i) {
        printf("vertex %d: ", i);
        printlist(adjancyM[i]);
    }
    for (int i = 0; i < MAX_VERTEX; ++i) { //visited �迭 �ʱ�ȭ
        visited[i] = FALSE;
    }
    printf("DFS: ");
    dfs(0);
    */
    fclose(fp);
}

void addq(int num) {
    if (rear == MAX_VERTEX - 1) {
        printf("queue is full!");
        return;
    }
    queue[++rear] = num;
}

int deleteq() {
    if (front == rear) {
        return -999;
    }
    return queue[++front];
}

listPointer insert(listPointer* first, listPointer x, int num) {
    listPointer temp;
    MALLOC(temp, sizeof(*temp));
    temp->data = num;
    if (*first) {
        temp->link = x->link;
        x->link = temp;
    }
    else {
        temp->link = NULL;
        *first = temp;
    }
    return temp; //index return -> ������� ���
}

void bfs(int v) {
    listPointer w;
    visited[v] = TRUE;
    printf("%d ", v);
    addq(v);
    while (TRUE) {
        v = deleteq();
        if (v == -999) break; // queue is empty
        for (w = adjacencyL[v]; w; w = w->link) {
            if (!visited[w->data]) {
                printf("%d ", w->data);
                addq(w->data);
                visited[w->data] = TRUE;
            }
        }
    }
}
/*
void printlist(listPointer ptr) {
    for (; ptr; ptr = ptr->link) {
        printf("%d ", ptr->data);
    }
    printf("\n");
}

void dfs(int v) {
    listPointer w;
    visited[v] = TRUE;
    printf("%d ", v);
    for (w = adjancyL[v]; w; w = w->link) {
        if (!visited[w->data]) dfs(w->data);
    }
}
*/