// 문제1
// n개의 정수 데이터를 입력받고 입력된 데이터에서 min값을 찾아서 출력하는 코드를 작성하라.(array 사용불가)
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <limits.h>

void main(void) {
	int n, temp, min = INT_MAX;
	// n 입력받기
	scanf("%d", &n);

	// n개의 데이터 입력받아 비교하기
	for (int i = 0;i < n;i++) {
		scanf("%d", &temp);
		if (temp < min)
			min = temp;
	}

	// 출력
	printf("%d", min);
}

