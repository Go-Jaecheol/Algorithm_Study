#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <utility>

using namespace std;
int n;
int map[20][20], fish[7];
int dr[4] = {-1, 0, 0, 1};
int dc[4] = {0, -1, 1, 0};

int getFishToEat(pair<int, int>& cur, int size) {
    int res = 0, visited[20][20] = {0, };
    queue<pair<int, int>> q;
    vector<pair<int, int>> s;
    
    q.push(cur);
    map[cur.first][cur.second] = 0;
    while (q.size()) {
        int q_size = (int)q.size();
        for (int i = 0; i < q_size; i++) {
            for (int i = 0; i < 4; i++) {
                int nr = q.front().first + dr[i], nc = q.front().second + dc[i];
                if (0 <= nr && nr < n && 0 <= nc && nc < n && map[nr][nc] <= size && visited[nr][nc] == 0) {
                    q.push(pair<int, int> (nr, nc));
                    visited[nr][nc] = 1;
                    if (0 < map[nr][nc] && map[nr][nc] < size) {
                        s.push_back(pair<int, int> (nr, nc));
                    }
                }
            }
            q.pop();
        }
        res++;
        if (s.size()) {
            sort(s.begin(), s.end());
            cur = s.front();
            map[cur.first][cur.second] = 0;
            return res;
        }
    }
    res = 0;
    return res;
}

int shark_time(pair<int, int> c) {
    int res = 0;
    pair<int, int> cur = c;
    int size = 2, eaten = 0;
    
    while (1) {
        int t = getFishToEat(cur, size);
        if (t == 0) break;
        res += t;
        if (++eaten == size) {
            size++;
            eaten = 0;
        }
        
    }
    
    return res;
}

int main() {
    cin >> n;
    pair<int, int> cur;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> map[i][j];
            if (map[i][j] == 9) cur = pair<int, int> (i, j);
        }
    }
    cout << shark_time(cur) << '\n';
}

