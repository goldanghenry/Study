#include <stdio.h>
#include <curses.h>

void main() {
    initscr();      // turn on curses
    clear();        // send requests
    move(10,20);    // clear screen
    addstr("Hello, world"); // add a string
    move(LINES-1, 0); // move to LL 좌하단

    refresh();      // update the screen
    getch();        // wait for user input
    endwin();       // turn off curses
}