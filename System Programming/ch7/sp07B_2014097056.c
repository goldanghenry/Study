#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

void error(char *msg) {
    perror(msg);
    exit(EXIT_FAILURE);
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <string>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    int pipeChildToParent[2];   // Pipe from child to parent (parent reads[0], child writes[1])
    int pipeParentToChild[2];   // Pipe from parent to child (child reads[0], parent writes[1])
    
    pid_t pid;

    // Create pipes
    if (pipe(pipeChildToParent) == -1 || pipe(pipeParentToChild) == -1) {
        error("pipe");
    }

    // Fork to create a child process
    pid = fork();

    if (pid == -1) {
        error("fork");
    }

    // Child process
    if (pid == 0) {  
        close(pipeChildToParent[0]);  // Close the read end of the pipe from child to parent
        close(pipeParentToChild[1]);  // Close the write end of the pipe from parent to child

        // Send the string received as a command-line argument to the parent
        if (write(pipeChildToParent[1], argv[1], sizeof(argv[1])) == -1) {
            error("write to pipe");
        }

        // Receive a message from the parent
        char buffer[256];
        if (read(pipeParentToChild[0], buffer, sizeof(buffer)) == -1) {
            error("read from pipe");
        }

        // Print the received message
        printf("child: %s\n", buffer);

        // Convert each character in the received message to the next character in ASCII
        for (int i = 0; buffer[i] != '\0'; i++) {
            buffer[i] = buffer[i] + 2;
        }

        // Send the modified message back to the parent
        if (write(pipeChildToParent[1], buffer, sizeof(buffer)) == -1) {
            error("write to pipe");
        }

        // Close the read end of the pipe from parent to child
        close(pipeParentToChild[0]);
        // Close the write end of the pipe from child to parent
        close(pipeChildToParent[1]);

        exit(EXIT_SUCCESS);
    } else {  // Parent process
        close(pipeChildToParent[1]);  // Close the write end of the pipe from child to parent
        close(pipeParentToChild[0]);  // Close the read end of the pipe from parent to child

        // Receive a message from the child
        char buffer[256];
        if (read(pipeChildToParent[0], buffer, sizeof(buffer)) == -1) {
            error("read from pipe");
        }

        // Print the received message
        printf("parent: %s\n", buffer);
        
        // Convert each character in the received message to the next character in ASCII
        for (int i = 0; buffer[i] != '\0'; i++) {
            buffer[i]++;
        }
        
        // Send the modified message to the child
        if (write(pipeParentToChild[1], buffer, sizeof(buffer)) == -1) {
            error("write to pipe");
        }

        // Receive another message from the child
        if (read(pipeChildToParent[0], buffer, sizeof(buffer)) == -1) {
            error("read from pipe");
        }

        // Print the received message
        printf("parent: %s\n", buffer);
        
        // Close the read end of the pipe from child to parent
        close(pipeChildToParent[0]);
        // Close the write end of the pipe from parent to child
        close(pipeParentToChild[1]);

        // Wait for the child to exit
        waitpid(pid, NULL, 0);
        exit(EXIT_SUCCESS);
    }

    return 0;
}
