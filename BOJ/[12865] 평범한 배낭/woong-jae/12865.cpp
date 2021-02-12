#include <iostream>
#include <cstring>

using namespace std;
int n, k;
int wv[100][2], cache[1000001][100];

int packing(int weight, int item) {
    if(item == n) return 0;
    int& ret = cache[weight][item];
    if(ret != -1) return ret;
    
    int res = 0;
    if(weight - wv[item][0] >= 0) {
        res = max(res, packing(weight - wv[item][0], item + 1) + wv[item][1]);
    }
    res = max(res, packing(weight, item + 1));
    ret = res;
    
    return ret;
}

int main() {
    cin >> n >> k;
    for(int i = 0; i < n; i++) {
        cin >> wv[i][0] >> wv[i][1];
    }
    memset(cache, -1, sizeof(cache));
    cout << packing(k, 0) << '\n';
}

