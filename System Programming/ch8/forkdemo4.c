// 2014097056 Woo Seong Hyun
// sp05B : Implement a program that performs some of the functions of the shell.
// Restrictions: Must be implemented using fork() and exec().
#include <stdio.h>      // Standard input/output
#include <stdlib.h>     // exit(), malloc()
#include <unistd.h>     // execvp()
#include <string.h>     // strcpy()
#include <sys/wait.h>   // wait() system call

#define MAXARGS 20      // Maximum number of arguments
#define ARGLEN 100      // Maximum length of an argument

// Function prototypes
int execute(char *arglist[]);   // Execute the command
char *makestring(char *buf);    // Dynamically allocate memory for a string

int main(int argc, char *argv[])
{
    char *arglist[MAXARGS + 1]; // List of arguments
    int numargs = 0;            // Current number of arguments
    char argbuf[ARGLEN];        // Buffer to temporarily store input arguments

    // Continue receiving input until MAXARGS arguments are received or "exit" is entered
    while (numargs < MAXARGS)
    {
        printf("Arg[%d]? \n", numargs); // Print the current number of input arguments

        // Receive input from the user (if input is not empty and not just a newline)
        if (fgets(argbuf, ARGLEN, stdin) && *argbuf != '\n')
        {
            // Add the dynamically allocated string to the arglist array
            arglist[numargs++] = makestring(argbuf);

            // Check if the user entered "exit" and exit the program if true
            if (strcmp(arglist[0], "exit") == 0)
            {
                printf("Exiting the shell.\n");
                exit(0);
            }
        }
        else
        {
            // If there is no input or only Enter is pressed
            if (numargs > 0)
            {
                arglist[numargs] = NULL;
                execute(arglist);   // Execute the entered command
                numargs = 0;        // Reset the number of arguments
            }
        }
    }
    return 0;
}

int execute(char *arglist[])
{
    pid_t child_pid, wait_pid;
    int status;

    // Create a child process
    if ((child_pid = fork()) == -1)
    {
        perror("fork failed");
        exit(1);
    }

    // Child process
    if (child_pid == 0)
    {
        execvp(arglist[0], arglist); // Execute the command
        perror("execvp failed");     // Print an error message if execvp fails
        exit(1);
    }
    // Parent process
    else
    {
        // Wait for the child process to complete
        do
        {
            wait_pid = waitpid(child_pid, &status, WUNTRACED | WCONTINUED);
            if (wait_pid == -1)
            {
                perror("waitpid failed");
                exit(1);
            }

            // Check the status of the child process
            if (WIFEXITED(status))
                printf("Child process exited with status %d\n", WEXITSTATUS(status));
            else if (WIFSIGNALED(status))
                printf("Child process terminated by signal %d\n", WTERMSIG(status));
            else if (WIFSTOPPED(status))
                printf("Child process stopped by signal %d\n", WSTOPSIG(status));
            else if (WIFCONTINUED(status))
                printf("Child process continued\n");

        } while (!WIFEXITED(status) && !WIFSIGNALED(status));
    }
}

char *makestring(char *buf)
{
    char *cp;

    buf[strlen(buf) - 1] = '\0'; // Remove the newline character
    cp = malloc(strlen(buf) + 1); // Dynamically allocate memory for the string
    if (cp == NULL)
    {
        fprintf(stderr, "no memory\n");
        exit(1);
    }
    strcpy(cp, buf); // Copy the string to the allocated memory
    return cp;
}
