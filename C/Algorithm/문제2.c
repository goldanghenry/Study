// ����2
// ���Ϸ� n���� ���� �����͸� �Է¹ް�, �Էµ� �����Ϳ��� min���� ã�Ƽ� ����ϴ� �ڵ带 �ۼ��϶�.
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

