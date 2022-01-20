// 분수 클래스를 완성하여 다음과 같은 프로그램이 수행되도록 하시오,
// 덧셈(+), 뺄셈(-), 곱셈(*), equal(==), 증감(++,--)
#include <iostream>
using namespace std;
class fraction {
    int num;
    int denom;
public:
    fraction(int a = 0, int b = 1) { num = a, denom = b; };
    void set(int a, int b) { num = a, denom = b; };
    int GCD(int a, int b); // 최대 공약수
    void show();

    fraction operator+(int n);
    fraction operator+(double f);
    fraction operator+(fraction ob);
    friend fraction operator+(int n, fraction ob);

    fraction operator-(int n);
    fraction operator-(double f);
    fraction operator-(fraction ob);
    friend fraction operator-(int n, fraction ob);

    fraction operator*(int n);
    fraction operator*(double f);
    fraction operator*(fraction ob);
    friend fraction operator*(int n, fraction ob);

    friend bool operator==(fraction ob1, fraction ob2);

    fraction& operator++();
    fraction operator++(int notused);
    fraction& operator--();
    fraction operator--(int notused);
};
int fraction::GCD(int a, int b) {
    int c;
    while (b) {
        c = a % b;
        a = b;
        b = c;
    } if (a < 0) a = -a;
    return a;
}
void fraction::show() {
    if (denom == 0) cout << "분모가 0입니다";
    else if (num == 0) cout << 0 << endl;
    else if (num == denom) cout << 1 << endl;
    else if (denom == 1) cout << num << endl;
    else cout << num << "/" << denom << endl;
}
fraction fraction::operator+(int n){
    fraction tmp(num + denom * n, denom);
    int x = GCD(tmp.num, tmp.denom);
    tmp.num /= x; tmp.denom /= x;
    return tmp;
}
fraction fraction::operator+(double f) {
    int p, i=0;
    while (1) {
        double d = f - (int)f;
        p = (int)pow(10, i);
        d *= p;
        d -= (int)d;
        if (d== 0) break;
        if (i == 5) break; // 소숫점 오차 방지
        i++;
    }
    fraction tmp((int)(f * p), p);
    return *this + tmp;
}
fraction fraction::operator+(fraction ob) {
    int x = GCD(ob.num, ob.denom);
    ob.num /= x; ob.denom /= x;
    fraction tmp(num * ob.denom + ob.num * denom, denom * ob.denom);
    x = GCD(tmp.num, tmp.denom);
    tmp.num /= x; tmp.denom /= x;
    return tmp;
}
fraction operator+(int n, fraction ob) {
    fraction tmp(ob.num + ob.denom * n, ob.denom);
    int x = tmp.GCD(tmp.num, tmp.denom);
    tmp.num /= x; tmp.denom /= x;
    return tmp;
}
fraction fraction::operator-(int n) {
    fraction tmp(num - denom * n, denom);
    int x = GCD(tmp.num, tmp.denom);
    tmp.num /= x; tmp.denom /= x;
    return tmp;
}
fraction fraction::operator-(double f) {
    int p, i = 0;
    while (1) {
        double d = f - (int)f;
        p = (int)pow(10, i);
        d *= p;
        d -= (int)d;
        if (d == 0) break;
        if (i == 5) break; // 소숫점 오차 방지
        i++;
    }
    fraction tmp((int)(f * p), p);
    return *this - tmp;
}
fraction fraction::operator-(fraction ob) {
    int x = GCD(ob.num, ob.denom);
    ob.num /= x; ob.denom /= x;
    fraction tmp(num * ob.denom - ob.num * denom, denom * ob.denom);
    x = GCD(tmp.num, tmp.denom);
    tmp.num /= x; tmp.denom /= x;
    return tmp;
}
fraction operator-(int n, fraction ob) {
    fraction tmp;
    tmp.num += ob.denom * n - ob.num;
    tmp.denom = ob.denom;
    int x = tmp.GCD(tmp.num, tmp.denom);
    tmp.num /= x; tmp.denom /= x;
    return tmp;
}
fraction fraction::operator*(int n) {
    fraction tmp(num * n, denom);
    int x = GCD(tmp.num, tmp.denom);
    tmp.num /= x; tmp.denom /= x;
    return tmp;
}
fraction fraction::operator*(double f) {
    int p, i = 0;
    while (1) {
        double d = f - (int)f;
        p = (int)pow(10, i);
        d *= p;
        d -= (int)d;
        if (d == 0) break;
        if (i == 5) break; // 소숫점 오차 방지
        i++;
    }
    fraction tmp((int)(f * p), p);
    return *this * tmp;
}
fraction fraction::operator*(fraction ob) {
    int x = GCD(ob.num, ob.denom);
    ob.num /= x; ob.denom /= x;
    fraction tmp(num * ob.num, denom * ob.denom);
    x = GCD(tmp.num, tmp.denom);
    tmp.num /= x; tmp.denom /= x;
    return tmp;
}
fraction operator*(int n, fraction ob) {
    fraction tmp(ob.num * n, ob.denom);
    int x = tmp.GCD(tmp.num, tmp.denom);
    tmp.num /= x; tmp.denom /= x;
    return tmp;
}
bool operator==(fraction ob1, fraction ob2) {
    return ob1.num == ob2.num && ob1.denom == ob2.denom;
}
fraction& fraction::operator++() { 
    num += denom;
    int x = GCD(num, denom);
    num /= x; denom /= x;
    return *this;
}
fraction fraction::operator++(int notused) {
    fraction tmp = *this;
    num += denom;
    int x = GCD(num,denom);
    num /= x; denom /= x;
    return tmp;
}
fraction& fraction::operator--() {
    num -= denom;
    int x = GCD(num, denom);
    num /= x; denom /= x;
    return *this;
}
fraction fraction::operator--(int notused) {
    fraction tmp = *this;
    num -= denom;
    int x = GCD(num, denom);
    num /= x; denom /= x;
    return tmp;
}

int main()
{
    // add(+)
    cout << "----------add(+)----------" << endl;
    fraction ob1, ob2(5, 3), ob3(10, 5); // 0/1, 5/3, 10/5
    ob1 = ob2 + ob3;
    ob1.show(); // 11/3 출력
    ob1 = ob2 + 3;
    ob1.show(); // 14/3 출력
    ob2 = ob3 + 1.25;
    ob2.show(); // 13/4 출력
    ob2 = 3 + ob2;
    ob2.show(); // 25/4 출력


    // sub(-)
    cout << "----------sub(-)----------" << endl;
    ob1.set(4, 3); ob2.set(7, 1); ob3.set(6, 12); // 4/3, 7/1, 6/12
    ob1 = ob1 - ob3;
    ob1.show();     // 5/6 출력
    ob3 = ob3 - 6;
    ob3.show();     // -11/2 출력
    ob2 = 2 - ob1;
    ob2.show();     // 7/6 출력
    ob3 = ob2 - 1.1;
    ob3.show();     // 1/15 출력

    // mul(*)
    cout << "----------mul(*)----------" << endl;
    ob1.set(9, 2); ob2.set(8, 13); ob3.set(13, 8); // 9/2, 8/13, 13/8
    ob2 = ob2 * ob3;
    ob2.show();     // 1 출력
    ob1 = ob1 * 3;
    ob1.show();     // 27/2 출력
    ob3 = 2 * ob3;
    ob3.show();     // 13/4 출력
    ob1 = ob3 * 1.5;
    ob1.show();     // 39/8 출력

    //equal(==)
    cout << "---------equal(==)----------" << endl;
    ob1.set(9, 2); ob2.set(9, 2); ob3.set(2, 3); // 9/2, 9/2, 2/3
    cout << (ob1 == ob2) << endl;   // 1 출력
    cout << (ob1 == ob3) << endl;   // 0 출력

    // I/D operator(++,--)
    cout << "------IDoperator(++,--)------" << endl;
    ob1.set(3, 4);
    ob2 = ob1++;
    ob2.show(); // 3/4 출력
    ob1.show(); // 7/4 출력

    ob2 = ob1--;
    ob2.show(); // 7/4 출력
    ob1.show(); // 3/4 출력

    ob1.set(3, 4);
    ob2 = ++ob1;
    ob2.show(); // 7/4 출력
    ob1.show(); // 7/4 출력

    ob2 = --ob1;
    ob2.show(); // 3/4 출력
    ob1.show(); // 3/4 출력
}
