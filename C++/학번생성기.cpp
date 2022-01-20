// 과제 : 바이너리 파일 및 텍스트 파일을 연습한 프로그램을 제출하시오.
// 주제 : 학번을 랜덤으로 생성해 학과별로 분류하기
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <ctime>
#include <vector>
#include <algorithm>
#define Y 2022000000
using namespace std;

int main() {
	// 랜덤으로 Y년 학번 n명 생성
	srand((unsigned)time(NULL));
	int n = rand() % 401 + 100;
	int x=Y;
	vector<int> sn;
	for (int i = 0;i < n;i++)
		sn.push_back(Y + (rand() %5+1)* 100000 + rand() % 1000);
	
	// 파일 출력 스트림 객체 생성과 동시에 열기
	ofstream wfout("AllList.bin", ios::out | ios::binary);

	// 루프를 위해 상단에 연도와 총 학생 수 저장
	wfout.write((char*)&x, sizeof(x));
	wfout.write((char*)&n, sizeof(n)); 

	// 정렬 후 파일에 쓰기
	sort(sn.begin(), sn.end()); 
	for (int i = 0;i < sn.size();i++)
		wfout.write((char*)&sn[i], sizeof(sn[i]));
	wfout.close();

	cout << n << "명의 학번이 생성되었습니다.";

}