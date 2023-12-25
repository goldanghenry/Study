#include <stdio.h>
#include <curses.h>
#include <unistd.h>

void main() {
    int i;

    initscr();  // curses 시작
    clear();    // draw 화면 생성
    for(i=0; i<LINES; i++) {
        move(i,i+i);
        if (i%2==1) standout();
        addstr("Hello, world");
        if (i%2==1) standout();
        sleep(1);
        refresh();
    }
    endwin();
}