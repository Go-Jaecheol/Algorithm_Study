#include <iostream>
#include <vector>
#include <cstring>

using namespace std;
int s;
int cache[1001][1000];
int visited[1001];

int minimum_time(int cur, int clipboard) {
    if (cur >= s) return cur - s;
    int &ret = cache[cur][clipboard];
    if (ret != -1) return ret;
    
    int res = 1000;
    visited[cur] = 1;
    if (cur < s) {
        if (cur != clipboard) res = min(res, minimum_time(cur, cur) + 1);//복사
        if (clipboard) res = min(res, minimum_time(cur + clipboard, clipboard) + 1);
    }
    if (visited[cur - 1] == 0 && cur - 1 > 0) res = min(res, minimum_time(cur - 1, clipboard) + 1);
    ret = res;
    
    return ret;
}

int main() {
    cin >> s;
    memset(cache, -1, sizeof(cache));
    cout << minimum_time(1, 0) << '\n';
}
