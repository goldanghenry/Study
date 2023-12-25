// 2014097056 Woo Seong Hyun
// sp05A A program that performs similar functions to the NIX shell
// Restrictions: The command line can only accept one argument.

#include <stdio.h>      // Standard input/output
#include <stdlib.h>     // exit(), malloc()
#include <unistd.h>     // execvp()

// Function prototype 
int execute(char *cmd);   // Execute the command

int main(int argc, char *argv[])
{
    // Check if the correct number of arguments is provided
    if (argc == 2)
        execute(argv[1]);   // Call the execute function with the provided command
    else
    {
        // Print an error message if the number of arguments is incorrect
        fprintf(stderr, "Usage: [command] <- only one!\n");
    }
    return 0;
}

int execute(char *cmd)
{
    char *arglist[2];
    arglist[0] = cmd;
    arglist[1] = 0;   // Terminate the argument list with NULL for execvp
    execvp(arglist[0], arglist);

    // If execvp fails, print an error message and exit the process
    perror("execvp failed");
    exit(1);
}