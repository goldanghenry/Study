#include <iostream>
#include <fstream>
#include <ctime>
#include <cstdlib>
using namespace std;

int main() {
	srand((unsigned)time(NULL));
	int z[5];
	for (int i = 0;i < 5;i++)
		z[i] = rand() % 10;

	cout << "*���� 5���� ����" << endl;
	ofstream zfout("z.txt");
	for(int i=0;i<5;i++)
		zfout << z[i] << endl;
	zfout.close();

	ifstream zfin("z.txt");
	float sum=0, n;
	for (int i = 0;i < 5;i++) {
		zfin >> n;
		cout << n << endl;
		sum += n;
	}
	sum /= 5;
	cout <<endl << "*���: " << sum << endl << endl;
	zfin.close();

	cout << "*��պ��� ū �� ���"<<endl;
	ifstream zzfin("z.txt");
	for (int i = 0;i < 5;i++) {
		zzfin >> n;
		if (n > sum)
			cout << n << endl;
	}
	zzfin.close();
}