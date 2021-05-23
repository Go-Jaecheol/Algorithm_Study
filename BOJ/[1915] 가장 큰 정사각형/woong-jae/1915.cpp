#include <iostream>
#include <cstring>
#include <utility>

using namespace std;
int n, m;
int cache[1000][1000];
char input[1001][1001];
int r[3] = {1, 0, 1};
int c[3] = {1, 1, 0};

int maxSqare(pair<int, int> position) {
    if(position.first >= n || position.second >= m || input[position.first][position.second] == '0') return 0;
    int& ret = cache[position.first][position.second];
    if(ret != -1) return ret;
    
    int size = 1000;
    for(int i = 0; i < 3; i++) {
        size = min(size, maxSqare(pair<int, int> (position.first + r[i], position.second + c[i])));
    }
    ret = size + 1;
    
    return ret;
}

int main() {
    int res = 0;
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> input[i];
    }
    memset(cache, -1, sizeof(cache));
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            res = max(res, maxSqare(pair<int, int> (i, j)));
        }
    }
    cout << res * res << '\n';
}

