#include <iostream>
#include <vector>
#include <cstring>

using namespace std;
int n;
int cache[1001], input[1001];

int lis(int start) {
    int& ret = cache[start];
    if(ret != -1) return ret;
    
    ret = 1;
    for(int i = start + 1; i < n; i++) {
        if(input[start] < input[i])
            ret = max(ret, lis(i) + 1);
    }
    
    return ret;
}

int main() {
    int maxlen = 0;
    cin >> n;
    memset(cache, -1, sizeof(cache));
    for (int i = 0; i < n; i++) {
        cin >> input[i];
    }
    for(int i = 0; i < n; i++) {
        maxlen = max(maxlen, lis(i));
    }
    cout << maxlen << '\n';
    return 0;
}

