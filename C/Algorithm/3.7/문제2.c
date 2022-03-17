// 문제2
// 파일로 n개의 정수 데이터를 입력받고, 입력된 데이터에서 min값을 찾아서 출력하는 코드를 작성하라.
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <limits.h>

void main() {
	FILE* fp;
	int n, temp, min = INT_MAX;
	char s[10];
	scanf("%s", &s);
	fp = fopen(s, "r");
	fscanf(fp, "%d", &n);
	for (int i = 0;i < n;i++) {
		fscanf(fp, "%d", &temp);
		if (temp < min)
			min = temp;
	}
	printf("%d", min);
	fclose(fp);
}

