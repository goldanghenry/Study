// [ ���� ] ���� �� �Ÿ��� ���� ª�� ��ü ����ϱ�
#include <iostream>
#include <stdlib.h>
#define n 10
using namespace std;

class Dot {	// x,y�� ������ �� �ִ� Ŭ����
public:
	double x, y;
	Dot() { x = y = 0; }
};

class dotFunction { // Ŭ���� Dot�� �迭�� �޾� ó���ϴ� ����� Ŭ����
private:
	double minimum = (n * 100);
	int dot_x, dot_y;
public:
	dotFunction() { dot_x = dot_y = 0; }
	void autoSetting(Dot* a);
	void dist(Dot* a);
};

void dotFunction::autoSetting(Dot* a) { // ���� ��ǥ ����
	srand(time(NULL)); // ���� �ʱ�ȭ
	for (int i= 0; i<n; i++) {
		a[i].x = rand() % (n * 10); 
		a[i].y = rand() % (n * 10);
		cout << "dot_" << i << " : ";
		cout << "(" << a[i].x << "," << a[i].y << ")" << endl;
	}
}

void dotFunction::dist(Dot* a) { // �Ÿ� ��
	for (int i = 0;i < n;i++) {
		for (int j = i + 1;j < n;j++) {
			double dx = a[j].x - a[i].x;
			double dy = a[j].y - a[i].y;
			double dist = sqrt(pow(dx, 2.0) + pow(dy, 2.0));
			if (dist < minimum) {
				minimum = dist;
				dot_x = i;
				dot_y = j;
			}
		}
	} // ��� ���
	cout << endl << "�� dot_" << dot_x << ", " << "dot_" << dot_y << " : " << minimum << "\n";
}

int main() {
	Dot ArrDot[n];
	dotFunction DF;

	cout << "����Ʈ ��ü " << n << "���� ���Ƿ� �ۼ��Ѵ�." << endl;
	cout << n << "���� ��ü�� �� �Ÿ��� ���� ����� �� ��ü�� �� �Ÿ��� ����϶�." << "\n\n";

	DF.autoSetting(ArrDot);
	DF.dist(ArrDot);
}