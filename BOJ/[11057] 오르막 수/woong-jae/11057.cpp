#include <iostream>
#include <cstring>

using namespace std;

int cache[10][1001];

int ascending_number(int num, int length) {
    if (length == 1) return 1;
    int &ret = cache[num][length];
    if (ret != -1) return ret;
    //캐쉬에 없을 때
    int sum = 0;
    for(int i = num ; i < 10; i++) {
        sum = (sum + ascending_number(i, length - 1)) % 10007;
    }
    ret = sum;
    
    return ret;
}

int main() {
    int n, sum = 0;
    cin >> n;
    memset(cache, -1, sizeof(cache));
    for(int i = 0; i < 10; i++) {
        sum = (sum + ascending_number(i, n)) % 10007;
    }
    cout << sum << '\n';
}

