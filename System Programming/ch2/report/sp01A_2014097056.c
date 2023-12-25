/* sp01A_2014097056.c 우성현
 * 명령어 줄에 입력된 argument 출력 프로그램
 * 정상적으로 종료시 0리턴
 * arg_num : 커맨드 라인에 전달된 인자의 개수
 * arg_arr[] : 커맨드 라인에 전달된 인자를 저장할 배열
 * arg_arr[0] : 프로그램의 이름이 저장
 * -> C언어에서는 표준 규약에 의해 항상 두 개의 매개변수(매개변수의 개수, 내용)가 전달된다.
 * -> arg_arr[0]은 항상 프로그램의 이름이 되는데, arg_num이 최소한 1이기 때문이다. 
 * -> 프로그램 이름은 항상 실행된 명령어의 일부이기에 arg_arr[0]에 저장된다.
*/

# include <stdio.h>

int main(int arg_num, char *arg_arr[]) 	/* 커맨드라인에 전달되는 인자는 arg_arr[1] 부터 저장 */
{
	for (int i=0; i<arg_num; i++) {
		printf("arg_num[%d] = '%s'\n",i, arg_arr[i]);
	}
	return 0;
}
