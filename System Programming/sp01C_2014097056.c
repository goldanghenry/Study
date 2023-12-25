/* sp01C_2014097056.c 우성현
 * cp 명령어 구현하는 프로그램
 * 사용형식(usage) : 파일명 src_file copy_file1 copy_file2 ...
 */

#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <stdlib.h>

#define BUFFERSIZE 4096
#define COPYMODE 0644

/* COPYMODE 0644 파일의 permission
 * 0 : 특별 권한
 * 6 : 소유자의 읽기(4) + 쓰기(2) 권한
 * 4 : 그룹의 읽기(4) 권한
 * 4 : 다른 사용자의 읽기(4) 권한
 * */

void print_error(char *error_message, char *file_name);	/* function prototype */

int main(int arg_num, char *arg_arr[])
{
	int in_fd, out_fd, n_chars;	/* in_fd, out_fd : 입출력 파일 descriptor, 
					 * n_chars: 실제 읽거나 쓴 바이트 수(0보다 작으면 오류) */
	char buf[BUFFERSIZE];
	
	/* 잘못된 인자가 전달된 경우 사용법 출력 */
	if(arg_num < 3){
		fprintf(stderr,"usage:%s source copy_file1 copy_file2 ...\n", arg_arr[0]); /* print usage */
		return 1;
	}
	/* 여러 개의 파일로 복사하는 경우 for 루프를 돌며 복사 */	
	for(int i=2; i< arg_num; i++) {
		if((in_fd = open(arg_arr[1], O_RDONLY)) == -1)		/* 소프 파일을 열 수 없는 경우 */
			print_error("Cannot open",arg_arr[1]);

		if((out_fd = creat(arg_arr[i], COPYMODE)) == -1)	/* 카피 파일을 생성할 수 없는 경우 */
			print_error("Cannot creat",arg_arr[i]);
	
		while((n_chars = read(in_fd, buf, BUFFERSIZE)) > 0) {	
			if(write(out_fd, buf, n_chars) != n_chars)
				print_error("write error to", arg_arr[i]);
			if(n_chars == -1)
				print_error("read error from", arg_arr[1]);
			if(close(in_fd) == -1 || close(out_fd) == -1)
				print_error("error closeing file","");
		}
	}
	return 0;	/* 정상 종료 */
}

/* perror를 이용한 에러 메시지 출력 */
void print_error(char *error_message, char *file_name)
{
	fprintf(stderr,"error:%s", error_message);
	perror(file_name);
	exit(1);
}

