#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
using namespace std;

int main() {
    vector<pair<int, int>> P;
    srand((unsigned)time(NULL));
    for (int i = 0;i < 100;i++) {
        P.push_back({ rand() % 11,rand() % 11 });
    }
    sort(P.begin(), P.end());
    for (int i = 0;i < P.size();) {
        if (P[i].first == P[i + 1].first && P[i].second == P[i + 1].second)
            P.erase(P.begin() + i);
        else i++;
        if (i == P.size() - 1) break;
    }
    for (int i = 0;i < P.size();i++) {
        cout << "(" << P[i].first << "," << P[i].second << ")" << endl;
    }
}

