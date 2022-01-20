// �а����� �����ϱ�
#include <iostream>
#include <fstream>
using namespace std;

int main() {
	int Y, n, sn;
	ifstream rfin("AllList.bin", ios::in | ios::binary);
	ofstream SW("Software.txt"); // 100
	ofstream AE("AutomotiveEngineering.txt"); // 200
	ofstream ME("MechanicalEngineering.txt"); // 300
	ofstream FI("FoodServiceIndustry.txt"); // 400
	ofstream FD("FashionDesign.txt"); // 500

	// ������ �� �л���(n) �о����
	rfin.read((char*)&Y, sizeof(Y));
	rfin.read((char*)&n, sizeof(n));

	// �й� �з��ؼ� �����ϱ�
	for (int i = 0;i < n;i++) {
		rfin.read((char*)&sn, sizeof(sn));
		if(sn < Y + 2 * 100000) SW << sn << endl;
		else if (sn < Y + 3 * 100000) AE << sn << endl;
		else if (sn < Y + 4 * 100000) ME << sn << endl;
		else if (sn < Y + 5 * 100000) FI << sn << endl;
		else if (sn < Y + 6 * 100000) FD << sn << endl;
	}
	
	rfin.close();
	SW.close();
	AE.close();
	ME.close();
	FI.close();
	FD.close();

	cout << "�а����� �����߽��ϴ�.";
}