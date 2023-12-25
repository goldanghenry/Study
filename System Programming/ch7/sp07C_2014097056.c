#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

#define MAXLINE 100

// Function for error handling
void oops(char *s, int x) {
    perror(s);
    exit(x);
}

int main(int argc, char *argv[]) {
    int n, pid, fd[2];
    char line[MAXLINE];

    // Create a pipe
    if (pipe(fd) == -1) {
        oops("Pipe creation failed", 1);
    }

    // Child process
    if ((pid = fork()) == 0) {
        close(fd[0]); // Close the read end of the pipe
        dup2(fd[1], 1); // Redirect stdout to the write end of the pipe
        close(fd[1]); // Close the write end of the pipe

        // Execute the "ls" command
        execl("/bin/ls", "ls", NULL);

        // If execl fails
        oops("execl call failed", 2);
    } else { // Parent process
        close(fd[1]); // Close the write end of the pipe
        dup2(fd[0], 0); // Redirect stdin to the read end of the pipe
        close(fd[0]); // Close the read end of the pipe

        // Execute the "wc" command
        execl("/bin/wc", "wc", NULL);

        // If execl fails
        oops("execl call failed", 3);
    }

    exit(0);
}
