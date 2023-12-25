#include <stdio.h>      // 표준 입출력
#include <stdlib.h>     // exit(), malloc()
#include <unistd.h>     // execvp()
#include <string.h>     // strcpy()

#define MAXARGS 20      // 최대 인자 수
#define ARGLEN 100      // 최대 인자 길이

// 프로토타입
int execute(char *arglist[]);   // 명령 실행
char *makestring(char *buf);    // 동적으로 할당된 문자열 생성

int main(int argc, char *argv[])
{
    char *arglist[MAXARGS + 1]; // list of argments
    int numargs = 0;            //  cur args
    char argbuf[ARGLEN];        // 입력된 인자를 임시로 저장하는 버퍼

    // MAXARGS개의 인자를 받아들일 때까지 실행
    while (numargs < MAXARGS)
    {
        printf("Arg[%d]? \n", numargs); // 현재까지 입력된 인자 개수 출력

        // 사용자로부터 입력을 받아들임(입력이 비어있지 않고, 개행이 아닌 경우)
        if (fgets(argbuf, ARGLEN, stdin) && *argbuf != '\n')
            // 동적으로 생성된 문자열을 arglist 배열에 넣음
            arglist[numargs++] = makestring(argbuf); 
        else
        {
            // 입력이 없거나 Enter만 눌렀을 경우
            if (numargs > 0)
            {
                arglist[numargs] = NULL;
                execute(arglist);   // 입력된 명령 실행
                numargs = 0;        // 인자 수 초기화
            }
        }
    }
    return 0;
}

int execute(char *arglist[])
{
    execvp(arglist[0], arglist);
    perror("execvp failed");
    exit(1);
}

char *makestring(char *buf)
{
    char *cp;

    buf[strlen(buf) - 1] = '\0';
    cp = malloc(strlen(buf) + 1);
    if (cp == NULL)
    {
        fprintf(stderr, "no memory\n");
        exit(1);
    }
    strcpy(cp, buf);
    return cp;
}