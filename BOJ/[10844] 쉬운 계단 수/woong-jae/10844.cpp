#include <iostream>
#include <cstring>

using namespace std;

long long cache[10][101];

long long stair_number(int input, int length) {//처음 숫자와 구할 계단 수의 길이
    if (length == 1) return 1;//기저사례
    long long &ret = cache[input][length];
    if (ret != -1) return ret;//cache에 있을 경우
    
    long long res = 0;
    if (input != 0) res = (res + stair_number(input - 1, length - 1)) % 1000000000;
    if (input != 9) res = (res + stair_number(input + 1, length - 1)) % 1000000000;
    
    ret = res % 1000000000;
    return ret;
}

int main() {
    int n;
    long long counter = 0;
    cin >> n;
    memset(cache, -1, sizeof(cache)); //cache 초기화
    
    for(int i = 1; i < 10; i++) {
        counter += stair_number(i, n);
    }
    
    cout << counter % 1000000000 << '\n';
}

