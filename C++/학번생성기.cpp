// ���� : ���̳ʸ� ���� �� �ؽ�Ʈ ������ ������ ���α׷��� �����Ͻÿ�.
// ���� : �й��� �������� ������ �а����� �з��ϱ�
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <ctime>
#include <vector>
#include <algorithm>
#define Y 2022000000
using namespace std;

int main() {
	// �������� Y�� �й� n�� ����
	srand((unsigned)time(NULL));
	int n = rand() % 401 + 100;
	int x=Y;
	vector<int> sn;
	for (int i = 0;i < n;i++)
		sn.push_back(Y + (rand() %5+1)* 100000 + rand() % 1000);
	
	// ���� ��� ��Ʈ�� ��ü ������ ���ÿ� ����
	ofstream wfout("AllList.bin", ios::out | ios::binary);

	// ������ ���� ��ܿ� ������ �� �л� �� ����
	wfout.write((char*)&x, sizeof(x));
	wfout.write((char*)&n, sizeof(n)); 

	// ���� �� ���Ͽ� ����
	sort(sn.begin(), sn.end()); 
	for (int i = 0;i < sn.size();i++)
		wfout.write((char*)&sn[i], sizeof(sn[i]));
	wfout.close();

	cout << n << "���� �й��� �����Ǿ����ϴ�.";

}