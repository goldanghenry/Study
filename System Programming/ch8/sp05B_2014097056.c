// 2014097056 Woo Seong Hyun
// sp05B : Implement a program that performs some of the functions of the shell.
// Restrictions: Must be implemented using fork() and exec().
#include <stdio.h>      // Standard input/output
#include <stdlib.h>     // exit(), malloc()
#include <unistd.h>     // execvp()
#include <string.h>     // strcpy()

#define MAXARGS 20      // Maximum number of arguments
#define ARGLEN 100      // Maximum length of an argument

// Function prototypes
int execute(char *arglist[]);   // Execute the command

int main(int argc, char *argv[])
{
    char *arglist[MAXARGS + 1]; // List of arguments
    int numargs = 0;            // Current number of arguments
    char argbuf[ARGLEN];        // Buffer to temporarily store input arguments

    // Continue receiving input until MAXARGS arguments are received or "exit" is entered
    while (1)
    {
        // Receive input from the user (if input is not empty and not just a newline)
        if (fgets(argbuf, ARGLEN, stdin) && *argbuf != '\n')
        {
            // Remove newline character at the end of the string entered with fgets
            if (argbuf[strlen(argbuf) - 1] == '\n') {
                argbuf[strlen(argbuf) - 1] = '\0';
            }

            // Tokenize the input string based on spaces
            char *token = strtok(argbuf, " ");

            // Dynamically allocate memory for the string and copy it to arglist
            arglist[numargs] = malloc(strlen(token) + 1);
            strcpy(arglist[numargs], token);

            numargs++;

            token = strtok(NULL, "");

            // Dynamically allocate memory for the remaining string and copy it to arglist
            if (token != NULL) {
                arglist[numargs] = malloc(strlen(token) + 1);
                strcpy(arglist[numargs], token);
                numargs++;
            }

            arglist[numargs] = NULL; // Terminate the argument list with NULL for execvp
            execute(arglist);        // Execute the entered command

            // Free the allocated memory for each argument
            for (int i = 0; i < numargs; i++) {
                free(arglist[i]);
            }

            numargs = 0; // Reset the number of arguments
        }
    }

    return 0;
}

int execute(char *arglist[])
{
    pid_t child_pid, wait_pid;
    int status;

    // Check if the user entered "exit" and exit the program if true
    // parent
    if (strcmp(arglist[0], "exit") == 0)
    {
        arglist[0] = "pwd";
        arglist[1] = NULL; // Terminate the argument list with NULL for execvp
        execute(arglist);
        exit(1);
    }

    // Create a child process
    if ((child_pid = fork()) == -1)
    {
        perror("fork failed");
        exit(1);
    }

    // child process -> run -> exit(1)
    if (child_pid == 0)
    {
        execvp(arglist[0], arglist); // Execute the command
        perror("execvp failed : The command does not exist");     // Print an error message if execvp fails
        exit(1);
    }
}
