//성적처리 프로그램
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){
	int i,n,K_sum=0,E_sum=0,M_sum=0,T_sum=0;
	int K[100]={0},E[100]={0},M[100]={0};

	srand((unsigned)time(NULL));
	n = rand()%71 + 30;

	printf("번호  국어  영어  수학  합계   평균\n");
	for (i = 0;i < n;i++) {
		K[i] = rand() % 101;
		E[i] = rand() % 101;
		M[i] = rand() % 101;
		K_sum += K[i];
		E_sum += E[i];
		M_sum += M[i];
		printf("%4d  %4d  %4d  %4d  %4d   %.1f\n", 
			i+1, K[i], E[i], M[i], K[i]+E[i]+M[i], (K[i]+E[i]+M[i])/3.0);
	}
	T_sum = K_sum + E_sum + M_sum;
	printf("------------------------------------\n");
	printf("합계 %5d %5d %5d %5d   %.1f\n", K_sum, E_sum, M_sum, T_sum, (float)T_sum/(n*3));
	printf("평균  %.1f  %.1f  %.1f  %.1f   %.1f\n", 
		(float)K_sum/n, (float)E_sum/n, (float)M_sum/n, (float)T_sum/(n*3), (float)T_sum/(n*3));
	return 0;
}