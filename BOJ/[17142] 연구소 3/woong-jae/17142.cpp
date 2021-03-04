#include <iostream>
#include <queue>
#include <utility>
#include <vector>

using namespace std;
int n, m;
vector<pair<int, int>> virus, safe;
vector<vector<int>> map(50, vector<int> (50, 0));
int dr[4] = {0, 1, 0, -1};
int dc[4] = {1, 0, -1, 0};

int spread_time(vector<pair<int, int>> v, vector<vector<int>> t_map) {
    int res = 0, counts = 0;
    vector<vector<int>> copy = t_map;
    int visited[50][50] = {0, }, spread_map[50][50];
    queue<pair<int, int>> q;

    for (int i = 0; i < m; i++) {
        q.push(v[i]);
        visited[v[i].first][v[i].second] = 1;
        spread_map[v[i].first][v[i].second] = 0;
    }
    while(q.size()) {
        int q_size = (int)q.size();
        for (int i = 0; i < q_size; i++) {
            for (int j = 0; j < 4; j++) {
                int nr = q.front().first + dr[j], nc = q.front().second + dc[j];
                if (counts == safe.size()) return res;
                if (0 <= nr && nr < n && 0 <= nc && nc < n && copy[nr][nc] != 1 && visited[nr][nc] == 0) {
                    q.push(make_pair(nr, nc));
                    spread_map[nr][nc] = spread_map[q.front().first][q.front().second] + 1;
                    if (copy[nr][nc] == 0) counts++;
                    res = max(res, spread_map[nr][nc]);
                    visited[nr][nc] = 1;
                    copy[nr][nc] = 2;
                }
            }
            q.pop();
        }
    }
    return -1;
}

int get_min_time(int cur, vector<pair<int, int>>& pick) {
    if (pick.size() == m) return spread_time(pick, map);
    
    pick.push_back(virus[cur]);
    int res = get_min_time(cur + 1, pick);
    pick.pop_back();
    if (m - pick.size() < virus.size() - cur) {
        int t_res = get_min_time(cur + 1, pick);
        if (t_res == -1 && res == -1) {
            res = -1;
        } else if (t_res == -1 || res == -1) {
            res = max(res, t_res);
        } else {
            res = min(res, t_res);
        }
    }
    
    return res;
}

int main() {
    vector<pair<int, int>> pick;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> map[i][j];
            if (map[i][j] == 2) {
                virus.push_back(make_pair(i, j));
            }
            if (map[i][j] == 0) {
                safe.push_back(make_pair(i, j));
            }
        }
    }
    cout << get_min_time(0, pick) << '\n';
}
