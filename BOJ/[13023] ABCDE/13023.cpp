#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;
int n, m, visited[2000];
vector<int> graph[2000];

int find_friend(int cur, int deep) {
    if (deep == 5) return 1;
    int res = 0;
    for (int i = 0; i < graph[cur].size(); i++) {
        if (visited[graph[cur][i]] == 0) {
            visited[graph[cur][i]] = 1;
            res = max(res, find_friend(graph[cur][i], deep + 1));
            if (res > 0) break;
            visited[graph[cur][i]] = 0;
        }
    }
    return res;
}

int main() {
    int res = 0;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int r, c;
        cin >> r >> c;
        graph[r].push_back(c);
        graph[c].push_back(r);
    }
    for (int i = 0; i < n; i++) {
        memset(visited, 0, sizeof(visited));
        visited[i] = 1;
        res = max(res, find_friend(i, 1));
        if (res > 0) break;
    }
    cout << res << '\n';
}


