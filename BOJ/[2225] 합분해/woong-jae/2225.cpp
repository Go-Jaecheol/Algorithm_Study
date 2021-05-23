#include <iostream>
#include <cstring>

using namespace std;

int cache[201][201];

int decomposition(int n, int k) {
    if (k == 1) return 1;
    int &ret = cache[n][k];
    if (ret != -1) return ret;

    ret = 0;
    for (int i = 0; i <= n; i++) {
        ret += decomposition(n - i, k - 1);
        ret %= 1000000000;
    }

    return ret;
}

int main() {
    int n, k;
    cin >> n >> k;
    memset(cache, -1, sizeof(cache));
    
    int res = decomposition(n, k);
    
    cout << res << '\n';
}
