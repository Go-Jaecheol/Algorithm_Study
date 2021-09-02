#include <iostream>
#include <vector>
#include <queue>
#include <utility>

using namespace std;
int n;
vector<vector<int>> map;
vector<vector<pair<int, int>>> islands;
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};

int getMinDist() {
    int res = n * n;

    for (int i = 0; i < islands.size(); i++) { // 섬마다 다른 섬까지 최소 거리 구하기
        vector<pair<int, int>> curIsland = islands[i];
        vector<vector<int>> visited(n, vector<int> (n));
        queue<pair<int, int>> q;
        for (int j = 0; j < curIsland.size(); j++) {
            pair<int, int> c  = curIsland[j];
            for (int dir = 0; dir < 4; dir++) {
                int nr = c.first + dr[dir], nc = c.second + dc[dir];
                if (0 <= nr && nr < n && 0 <= nc && nc < n && map[nr][nc] == 1) {
                    visited[nr][nc] = 1;
                }
            }
            q.push(make_pair(c.first, c.second));
            visited[c.first][c.second] = 1;
        }
        while (islands[i].size()) {
            pair<int, int> cur = q.front();
            int curDist = visited[cur.first][cur.second];

            bool founded = false;
            for (int dir = 0; dir < 4; dir++) {
                int nr = cur.first + dr[dir], nc = cur.second + dc[dir];
                if (0 <= nr && nr < n && 0 <= nc && nc < n && !visited[nr][nc]) {
                    if (map[nr][nc] == 0) {
                        q.push(make_pair(nr, nc));
                        visited[nr][nc] = curDist + 1;
                    }
                    else {
                        founded = true;
                    }
                }
            }
            if (founded) {
                res = min(res, visited[cur.first][cur.second] - 1);
                break;
            }

            q.pop();
        }
    }

    return res;
}


void distinguishIslands() {
    vector<vector<int>> visited(n, vector<int> (n));
    for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
             if (map[i][j] == 1 && !visited[i][j]) {
                 vector<pair<int, int>> newIsland;
                 queue<pair<int, int>> q;
                 q.push(make_pair(i, j));
                 visited[i][j] = 1;
                 while (q.size()) { // 발견된 섬의 가장자리를 BFS로 탐색
                     pair<int, int> cur = q.front();
                     
                     bool isEdge = false;
                     for (int dir = 0; dir < 4; dir++) {
                         int nr = cur.first + dr[dir], nc = cur.second + dc[dir];
                         if (0 <= nr && nr < n && 0 <= nc && nc < n) {
                             if (map[nr][nc] == 1 && !visited[nr][nc]) {
                                 q.push(make_pair(nr, nc));
                                 visited[nr][nc] = 1;
                             }
                             if (map[nr][nc] == 0) isEdge = true;
                         }
                     }
                     if (isEdge) newIsland.push_back(cur);
                     
                     q.pop();
                 }
                 islands.push_back(newIsland);
            }
        }
    }
}

int main() {
    cin >> n;
    map = vector<vector<int>> (n, vector<int> (n));
    for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            cin >> map[i][j];
        }
    }
    distinguishIslands();
    int res = getMinDist();
    cout << res << '\n';
}
