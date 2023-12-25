#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

#define DELAY 2

void child_code(int delay);
void parent_code(int childpid);

int main()
{
    int newpid;

    printf("before: mypid is %d\n", getpid());

    if ((newpid = fork()) == -1)
        perror("fork");
    else if (newpid == 0)
        child_code(DELAY);
    else
        parent_code(newpid);

    return 0;
}

void child_code(int delay)
{
    printf("child %d here. will sleep for %d seconds\n", getpid(), delay);
    sleep(delay);
    printf("child done. about to exit\n");
    exit(17);
}

void parent_code(int childpid)
{
    int wait_rv;
    int status;  // to store child process exit status

    /* return value from wait() */
    wait_rv = wait(&status);

    if (wait_rv == -1)
        perror("wait");
    else
        printf("done waiting for %d. Wait returned: %d\n", childpid, WEXITSTATUS(status));
}
