#include <stdio.h>
#include <signal.h>
#include <unistd.h>

void main() {
    void wakeup(int);

    printf("about to sleep for 4 seconds\n");
    signal(SIGALRM, wakeup);
    alarm(4);
    pause();
    printf("Morning so sonn?\n");

}

void wakeup(int signum){
    printf("Alarm reveived from kernel\n");
}