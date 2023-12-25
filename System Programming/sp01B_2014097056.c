/* sp01B_2014097056.c 우성현
 * 명령어 줄에 파일 이름을 입력하면 그 파일 내용이 화면에 출력되는 프로그램
 * 오류메시지 출력에는 perror이 사용됨
 */

#include <stdio.h>
#include <stdlib.h>

void print_file(char *filename);	/* function prototype 선언 */

int main(int arg_num, char *arg_arr[]) 
{
	/* 인자가 없는 경우 메시지를 출력하고
	 * 인자가 들어온 경우 print_file(filename) 함수를 실행시켜 내용을 출력한다. */ 
	if (arg_num == 1) {
		printf("출력하고자 하는 파일명을 입력해주세요.\n");
	} else {
		for (int i=1; i<arg_num;i++) {
			print_file(arg_arr[i]);
		}
	}
	return 0;
}

/* 파일내용 출력 함수 
 * 파일명을 인자로 받아 파일을 열고 한 줄씩 읽어서 출력한다. 
 */
void print_file(char *filename)
{
	FILE *file = fopen(filename, "r");	/* 읽기 모드로 파일을 열고 파일 포인터를 저장 */
	
	if (file == NULL) {
		perror(filename);		/* perror을 이용해 오류 메시지 출력 */
		return;
	}

	char line_buffer[512];			/* 한 줄에 512바이트를 저장할 수 있는 버퍼 선언  */
						/* fgets를 이용해 한 줄씩 읽기 */
	while (fgets(line_buffer, sizeof(line_buffer), file)) {	
		printf("%s", line_buffer);
	}

	fclose(file);				/* 파일 닫기  */


}
