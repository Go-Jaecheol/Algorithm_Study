#include <iostream>
#include <cstring>

using namespace std;
int n, seq[100];
unsigned long long cache[100][21];

unsigned long long correct_equation(int cur, int sum) {
    if (cur == n - 1) {
        if (sum == seq[n - 1]) return 1;
        else return 0;
    }
    unsigned long long &ret = cache[cur][sum];
    if (ret != -1) return ret;
    
    unsigned long long res = 0;
    if (sum + seq[cur] <= 20) res += correct_equation(cur + 1, sum + seq[cur]);
    if (sum - seq[cur] >= 0) res += correct_equation(cur + 1, sum - seq[cur]);
    ret = res;
    
    return ret;
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> seq[i];
    }
    memset(cache, -1, sizeof(cache));
    cout << correct_equation(1, seq[0]) << '\n';
}
