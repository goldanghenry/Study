#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/time.h>
#include <signal.h>

// Function prototype for the signal handler and timer
void countdown(int);
int set_ticker(int);

// Default countdown duration and counter
static int i = 1, num = 3; 

int main(int argc, char *argv[]) {

    // Check for correct command-line arguments
    if (argc != 1 && argc != 2) {
        fprintf(stderr, "Usage: [sesc] <- only one or empty!\n");
        return 0;
    }

    // If an argument is provided, set the countdown duration accordingly
    if (argc == 2) {
        int t = atoi(argv[1]);
        num = (t <= 0) ? 3 : t;
    }

    // Register the signal handler functions for SIGALRM and SIGINT (Ctrl + C)
    signal(SIGALRM, countdown);
    signal(SIGINT, countdown);

    // Set the timer to generate a SIGALRM signal every 1 second
    if (set_ticker(1000) == -1) {
        perror("set_ticker");
    } else {
        // Wait for a SIGALRM signal indefinitely
        while (1) {
            pause();
        }
    }
    return 0;
}

// Signal handler function for handling SIGALRM and SIGINT signals
// Performs countdown and exits the program when the countdown reaches 0
void countdown(int signum) {
    if (signum == SIGALRM) {
        printf("after %ds\n", i++);
        fflush(stdout);
        if (i > num) {
            printf("time out\n");
            exit(0);
        }
    } else if (signum == SIGINT) {
        printf("user interrupt\n");
        exit(0);
    }
}

// Function to set the timer with a given interval in milliseconds
// Generates a SIGALRM signal at regular intervals
int set_ticker(int n_msecs) {
    struct itimerval new_timeset;
    long n_sec, n_usecs;

    n_sec = n_msecs / 1000;                   // Integer seconds
    n_usecs = (n_msecs % 1000) * 1000L;      // Microseconds remainder

    // Set the timer interval
    new_timeset.it_interval.tv_sec = n_sec;   // Set reload
    new_timeset.it_interval.tv_usec = n_usecs; // New ticker value

    // Set the initial timer value
    new_timeset.it_value.tv_sec = n_sec;      // Store this
    new_timeset.it_value.tv_usec = n_usecs;    // And this

    // Set the timer using ITIMER_REAL and the new_timeset structure
    return setitimer(ITIMER_REAL, &new_timeset, NULL);
}
