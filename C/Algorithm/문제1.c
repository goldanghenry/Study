// ����1
// n���� ���� �����͸� �Է¹ް� �Էµ� �����Ϳ��� min���� ã�Ƽ� ����ϴ� �ڵ带 �ۼ��϶�.(array ���Ұ�)
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <limits.h>

void main(void) {
	int n, temp, min = INT_MAX;
	// n �Է¹ޱ�
	scanf("%d", &n);

	// n���� ������ �Է¹޾� ���ϱ�
	for (int i = 0;i < n;i++) {
		scanf("%d", &temp);
		if (temp < min)
			min = temp;
	}

	// ���
	printf("%d", min);
}

