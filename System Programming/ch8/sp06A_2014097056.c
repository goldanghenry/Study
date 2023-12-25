// 2014097056 Woo Seong Hyun
// sp06A : a program using fork(), exit(), wait() etc.
// (1) Each process outputs a statement saying who it is.
// (2) Before each process exits, it prints on the screen the statement that it is exiting.
// (3) The parent process also confirms that the child exited before the child process exited
#include <stdio.h>      // Standard input, output
#include <stdlib.h>     // exit()
#include <string.h>     // strcmp()
#include <sys/types.h>  
#include <sys/wait.h>   // wait() system call
#include <unistd.h>

void parent_process(pid_t son_pid, pid_t daughter_pid);
void child_process(char* name);

int main() {
    pid_t son_pid, daughter_pid;

    // Create son process
    son_pid = fork();
    if (son_pid == -1) {    // error
        perror("Error in fork");
        exit(EXIT_FAILURE);
    } 
    else if (son_pid == 0) {  // In son process
        child_process("son");
    } else {                    // In parent process
        printf("I am parent.\n");
        fflush(stdout);

        // Create daughter process
        daughter_pid = fork();
        if (daughter_pid == -1) {
            perror("Error in fork");
            exit(EXIT_FAILURE);
        } else if (daughter_pid == 0) { // In daughter process
            child_process("daughter");
        } else {                        // In parent process
            parent_process(son_pid, daughter_pid);
        }
    }
    return 0;
}

void child_process(char* name) {
    printf("I am %s.\n", name);
    fflush(stdout);

    // If “son” generate “grandson” and “granddaughter”
    if (strcmp(name, "son") == 0) {
        pid_t grandson_pid, granddaughter_pid;

        // Create grandson process
        grandson_pid = fork();
        if (grandson_pid == -1) {
            perror("Error in fork");
            exit(EXIT_FAILURE);
        } else if (grandson_pid == 0) {     // In grandson process
            child_process("grandson");
        } else {                            // In son process
            // Create granddaughter process
            granddaughter_pid = fork();
            if (granddaughter_pid == -1) {
                perror("Error in fork");
                exit(EXIT_FAILURE);
            } else if (granddaughter_pid == 0) {
                // In granddaughter process
                child_process("granddaughter");
            } else {
                // In son process
                // Wait for both grandson and granddaughter to exit
                waitpid(grandson_pid, NULL, 0);
                waitpid(granddaughter_pid, NULL, 0);
                printf("%s finished waiting for grandson.\n", name);
                fflush(stdout);
                printf("%s finished waiting for granddaughter.\n", name);
                fflush(stdout);
            }
        }
    }
    sleep(3);
    printf("%s exits.\n", name);
    fflush(stdout);
    exit(0);
}

void parent_process(pid_t son_pid, pid_t daughter_pid) {
    int status;

    // Wait for son and daughter to exit
    waitpid(son_pid, &status, 0);
    printf("parent finished waiting for son.\n");
    fflush(stdout);

    waitpid(daughter_pid, &status, 0);
    printf("parent finished waiting for daughter.\n");
    printf("parent exits.\n");
    fflush(stdout);
}