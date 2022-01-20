// [ 과제 ] 점들 간 거리가 가장 짧은 객체 출력하기
#include <iostream>
#include <stdlib.h>
#define n 10
using namespace std;

class Dot {	// x,y를 저장할 수 있는 클래스
public:
	double x, y;
	Dot() { x = y = 0; }
};

class dotFunction { // 클래스 Dot의 배열을 받아 처리하는 기능의 클래스
private:
	double minimum = (n * 100);
	int dot_x, dot_y;
public:
	dotFunction() { dot_x = dot_y = 0; }
	void autoSetting(Dot* a);
	void dist(Dot* a);
};

void dotFunction::autoSetting(Dot* a) { // 랜덤 좌표 지정
	srand(time(NULL)); // 난수 초기화
	for (int i= 0; i<n; i++) {
		a[i].x = rand() % (n * 10); 
		a[i].y = rand() % (n * 10);
		cout << "dot_" << i << " : ";
		cout << "(" << a[i].x << "," << a[i].y << ")" << endl;
	}
}

void dotFunction::dist(Dot* a) { // 거리 비교
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
	} // 결과 출력
	cout << endl << "▶ dot_" << dot_x << ", " << "dot_" << dot_y << " : " << minimum << "\n";
}

int main() {
	Dot ArrDot[n];
	dotFunction DF;

	cout << "포인트 객체 " << n << "개를 임의로 작성한다." << endl;
	cout << n << "개의 객체들 중 거리가 가장 가까운 두 객체와 그 거리를 출력하라." << "\n\n";

	DF.autoSetting(ArrDot);
	DF.dist(ArrDot);
}