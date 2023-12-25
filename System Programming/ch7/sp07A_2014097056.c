#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>
#include <time.h>

// Function to handle signals received by the parent process
void signalHandler(int signum) {
    if (signum == SIGUSR1) {
        printf("SIGUSR1 is received.\n");  // Print message for SIGUSR1
    } else if (signum == SIGUSR2) {
        printf("SIGUSR2 is received.\n");  // Print message for SIGUSR2
    } else if (signum == SIGCHLD) {
        printf("SIGCHLD is received.\nparent is terminated.\n");  // Print message for SIGCHLD
        exit(EXIT_SUCCESS);  // Terminate the parent process
    }
    fflush(stdout); // Flush the output buffer
}

int main() {
    pid_t child_pid;

    // Set up the parent signal handler
    struct sigaction parent_sa;           // Signal handling structure
    parent_sa.sa_handler = signalHandler; // Register the signal handler
    sigaction(SIGUSR1, &parent_sa, NULL); // Register the handler for SIGUSR1
    sigaction(SIGUSR2, &parent_sa, NULL); // Register the handler for SIGUSR2
    sigaction(SIGCHLD, &parent_sa, NULL); // Register the handler for SIGCHLD

    // Set the random seed
    srand(time(NULL));

    // Create a child process
    child_pid = fork();

    if (child_pid == -1) {
        perror("Error in fork");
        exit(EXIT_FAILURE);
    }
    // Child process
    if (child_pid == 0) { 
        // Send signals to the parent process
        for (int i = 0; i < 3; ++i) {
            kill(getppid(), (rand() % 2 == 0) ? SIGUSR1 : SIGUSR2);
            sleep(1);
        }
        kill(getppid(),SIGCHLD);
        // Child process terminates
        exit(EXIT_SUCCESS);
    } else {
        // Parent process
        // Pause and wait for signals
        pause();    
        pause();
        pause();
        pause();
    }

    return 0;
}
