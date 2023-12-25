#include <stdio.h>
#include <curses.h>
#include <unistd.h>

#define LEFTEDGE 10
#define RIGHTEDGE 30
#define ROW 10

int main() {
    char message[] = "Hello";
    char blank[] = "     ";
    int dir = 1;
    int pos = LEFTEDGE;

    initscr();
    clear();

    while (1) {
        move(ROW, pos); // 10번째 줄의 왼쪽 모서리로 커서 이동
        addstr(message);    // 메시지 출력

        move(LINES-1, COLS-1);  // 우하단으로 커서 이동
        refresh();              // 복사

        sleep(1);
        move(ROW, pos);     // 공백으로 지우기
        addstr(blank);

        pos += dir;         // 우측으로 이동
        if (pos >= RIGHTEDGE) dir = -1; // 우측 끝에 도달하면 좌측 방향 설정
        if (pos <= LEFTEDGE) dir = 1;   // 좌측 끝에 도달하면 우측 방향 설정
    }
    
}