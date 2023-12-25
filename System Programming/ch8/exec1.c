// exec1.c - shows how easy it is for a program to run a program
#include <unistd.h>
#include <stdio.h>

void main() {
    char *arglist[4];
    arglist[0] = "ls";
    arglist[1] = "-al";
    arglist[2] = 0;
    printf("* * * About to exec ls -l\n");
    execvp("ls", arglist);
    printf("* * * ls is done. bye\n");
    return;
}