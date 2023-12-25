#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/time.h>
#include <signal.h>

int set_ticker(int);

static int num = 10;

int main() {
    void countdown(int);

    // enroll signal handler 
    signal(SIGALRM, countdown);

    // 500 밀리초 간격으로 ITIMER_REAL 타이머 설정
    if (set_ticker(500) == -1) {
        perror("set_ticker");
    } else {
        // waiting a SIGARM
        while (1) {
            pause();
        }
    }
    return 0;
}

// SIGALRM 시그널을 처리하는 핸들러 함수
// 카운터 다운을 수행하고 일정 값 이하로 내려가면 프로그램 종료
void countdown(int signum) {
    printf("%d ..", num--);
    fflush(stdout);
    if (num < 0) {
        printf("DONE!\n");
        exit(0);
    }
}

// 타이머 설정
// 밀리초를 받아와 타이머 설정
// 주어진 주기마다 SIGALRM 시그널 발생
int set_ticker(int n_msecs){
    struct itimerval new_timeset;
    long n_sec, n_usecs;

    n_sec = n_msecs / 1000;                 // int
    n_usecs = (n_msecs % 1000) *1000L;      // remainder

    new_timeset.it_interval.tv_sec = n_sec; // set reload
    new_timeset.it_interval.tv_usec = n_usecs; // new ticker value
    new_timeset.it_value.tv_sec = n_sec;    // store this
    new_timeset.it_value.tv_usec = n_usecs; // and this

    return setitimer(ITIMER_REAL, &new_timeset, NULL);
}