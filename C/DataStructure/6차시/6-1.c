/* 심화컴퓨터공학 2014097056 우성현 < 문제 6-1 >
   maze 알고리즘을 구현하라. 
 - maze는 파일로 입력받고 maze 경로는 화면에 출력한다.
 - maze, mark, move, stack 변수는 모두 정적할당 사용
 - maze의 entrance는 left top로 exit는 right bottom으로 가정
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
int top = -1;				// 스택의 인덱스
int EXIT_ROW, EXIT_COL;

void main() {
	FILE* fp;

	// 파일 오픈(읽기 모드) 및 검사
	fp = fopen("in1.txt", "r");
	if (fp == NULL) {
		fprintf(stderr, "파일 오픈 실패");
		exit(EXIT_FAILURE);
	}

	// 배열 초기화
	for (int i = 0; i < MAX_ROWS; i++) {
		for (int j = 0; j < MAX_COLS; j++) {
			maze[i][j] = 1;
			mark[i][j] = 0;
		}
	}

	// 파일에서 EXIT_ROW, EXIT_COL 읽어 오기
	fscanf(fp, "%d %d", &EXIT_ROW, &EXIT_COL);

	// 파일에서 맵 불러오기
	for (int i = 1; i <= EXIT_ROW; i++) {
		for (int j = 1; j <= EXIT_COL; j++) {
			fscanf(fp, "%d", &maze[i][j]);
		}
	}
	// 방향 별 row, col 초기화
	initDir();

	// 길 찾기 실행
	path();

	// 파일 닫기
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
	element position;	// 현재 위치와 방향
	mark[1][1] = 1; top = 0;
	stack[0].row = 1;  stack[0].col = 1;  stack[0].dir = 1; // (next dir) 일관성을 위해
	while (top > -1 && !found) {	// 스택이 다 비고, 찾기 전까지 반복
		position = pop();	// 탐색해야할 위치
		row = position.row;  col = position.col;  dir = position.dir;
		while (dir < 8 && !found) {
			/* move in direction dir */
			nextRow = row + move[dir].vert; nextCol = col + move[dir].horiz;

			if (nextRow == EXIT_ROW && nextCol == EXIT_COL)	// 출구에 도달했다면,
				found = TRUE;
			else if (!maze[nextRow][nextCol] && !mark[nextRow][nextCol]) {	// 둘다 0이면 이동
				mark[nextRow][nextCol] = 1;
				position.row = row;  position.col = col;  position.dir = ++dir;
				push(position);
				row = nextRow;  col = nextCol;  dir = 0;
			}
			else ++dir;
		}
	}
	if (found) {	// 찾았을 때
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