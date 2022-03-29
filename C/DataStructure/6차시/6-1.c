/* ��ȭ��ǻ�Ͱ��� 2014097056 �켺�� < ���� 6-1 >
   maze �˰����� �����϶�. 
 - maze�� ���Ϸ� �Է¹ް� maze ��δ� ȭ�鿡 ����Ѵ�.
 - maze, mark, move, stack ������ ��� �����Ҵ� ���
 - maze�� entrance�� left top�� exit�� right bottom���� ����
*/

#define _CRT_SECURE_NO_WARNINGS
#define MAX_ROWS 100
#define MAX_COLS 100
#define MAX_STACK_SIZE 100
#define TRUE 1
#define FALSE 0
#include <stdio.h>
#include <stdlib.h>

void initDir();
void path(void);
typedef struct {	// keeps pass history : stack
	short int row;
	short int col;
	short int dir;	// next direction
}element;
typedef struct {
	short int vert;
	short int horiz;
}offsets;

element stack[MAX_STACK_SIZE];
offsets move[8];	/* array of moves for each direction */
int maze[MAX_ROWS][MAX_COLS];
int mark[MAX_ROWS][MAX_COLS];
int top = -1;				// ������ �ε���
int EXIT_ROW, EXIT_COL;

void main() {
	FILE* fp;

	// ���� ����(�б� ���) �� �˻�
	fp = fopen("in1.txt", "r");
	if (fp == NULL) {
		fprintf(stderr, "���� ���� ����");
		exit(EXIT_FAILURE);
	}

	// �迭 �ʱ�ȭ
	for (int i = 0; i < MAX_ROWS; i++) {
		for (int j = 0; j < MAX_COLS; j++) {
			maze[i][j] = 1;
			mark[i][j] = 0;
		}
	}

	// ���Ͽ��� EXIT_ROW, EXIT_COL �о� ����
	fscanf(fp, "%d %d", &EXIT_ROW, &EXIT_COL);

	// ���Ͽ��� �� �ҷ�����
	for (int i = 1; i <= EXIT_ROW; i++) {
		for (int j = 1; j <= EXIT_COL; j++) {
			fscanf(fp, "%d", &maze[i][j]);
		}
	}
	// ���� �� row, col �ʱ�ȭ
	initDir();

	// �� ã�� ����
	path();

	// ���� �ݱ�
	fclose(fp);
}

void push(element item) {
	/* add an item to the global stack */
	if (top >= MAX_STACK_SIZE - 1) {
		fprintf(stderr, "Stack is full, cannot add element");
		exit(EXIT_FAILURE);
	}
	stack[++top] = item;
}

element pop() {
	/* delete and return the top element from the stack */
	if (top == -1) printf("stack is full");
	return stack[top--];
}

void path(void) {
	int i, row, col, nextRow, nextCol, dir;
	int found = FALSE;
	element position;	// ���� ��ġ�� ����
	mark[1][1] = 1; top = 0;
	stack[0].row = 1;  stack[0].col = 1;  stack[0].dir = 1; // (next dir) �ϰ����� ����
	while (top > -1 && !found) {	// ������ �� ���, ã�� ������ �ݺ�
		position = pop();	// Ž���ؾ��� ��ġ
		row = position.row;  col = position.col;  dir = position.dir;
		while (dir < 8 && !found) {
			/* move in direction dir */
			nextRow = row + move[dir].vert; nextCol = col + move[dir].horiz;

			if (nextRow == EXIT_ROW && nextCol == EXIT_COL)	// �ⱸ�� �����ߴٸ�,
				found = TRUE;
			else if (!maze[nextRow][nextCol] && !mark[nextRow][nextCol]) {	// �Ѵ� 0�̸� �̵�
				mark[nextRow][nextCol] = 1;
				position.row = row;  position.col = col;  position.dir = ++dir;
				push(position);
				row = nextRow;  col = nextCol;  dir = 0;
			}
			else ++dir;
		}
	}
	if (found) {	// ã���� ��
		printf("The path is:\n");
		printf("row col\n");
		for (int i = 0; i <= top; i++)
			printf("%2d%5d\n", stack[i].row, stack[i].col);
		printf("%2d%5d\n", row, col);
		printf("%2d%5d\n", EXIT_ROW, EXIT_COL);
	}
	else printf("The maze does not have a path\n");
}

void initDir() {
	move[0].vert = -1; move[0].horiz =  0;
	move[1].vert = -1; move[1].horiz =  1;
	move[2].vert =  0; move[2].horiz =  1;
	move[3].vert =  1; move[3].horiz =  1;
	move[4].vert =  1; move[4].horiz =  0;
	move[5].vert =  1; move[5].horiz = -1;
	move[6].vert =  0; move[6].horiz = -1;
	move[7].vert = -1; move[7].horiz = -1;
}