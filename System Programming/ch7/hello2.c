#include <stdio.h>
#include <curses.h>

void main() {
    int i;

    initscr();      // turn on curses
    clear();        // draw some stuff
    for(i=0; i<LINES; i++){
        move(i, i+1);
        if(i%2==1)
            standout();
        addstr("Hello, world");
        if(i%2==1)
            standout();
    }
    refresh();      // update the screen
    sleep(5);       // wait 5 secs
    endwin();       // reset the tty etc

}