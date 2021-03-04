# [17142] 연구소
## 💡Algorithm
그래프, BFS
## 📚Logic
Input을 받을 때 바이러스의 위치와 빈칸의 위치를 따로 저장해 둔다. 바이러스를 퍼뜨릴 곳을 정하는 것과 바이러스가 다 퍼졌는지 확인하는 것을 빠르게 하기 위해서이다.

바이러스를 퍼뜨릴 곳을 m개를 정하면 그 바이러스들을 시작으로 BFS로 순회하면서 바이러스를 퍼뜨린다.
```c++
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
```
 바이러스를 퍼뜨릴 때, 퍼뜨린 칸이 빈 칸이라면 ```counts```를 증가시킨다. ```counts```가 처음 저장한 빈 칸의 총 개수와 같아지면 바이러스를 다 퍼뜨린 것이므로 걸린 시간을 반환하면 된다.
```c++
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
```
## 📝Review
항상 BFS 구현은 쉽지만 시뮬레이션의 상세한 조건을 구현하는 것이 골치아프다. 그래도 이번 문제는 적응이 좀 돼서 그런지 어렵지 않게 풀었다.
