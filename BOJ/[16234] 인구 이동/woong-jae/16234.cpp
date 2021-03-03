#include <iostream>
#include <queue>
#include <utility>
#include <cstdlib>
#include <vector>

using namespace std;
int n, r, l;
int land[50][50];
int dr[4] = {0, 1, 0, -1};
int dc[4] = {1, 0, -1, 0};

void change_land(vector<pair<int, int>> s, int mean) {
    for (int i = 0; i < s.size(); i++) {
        land[s[i].first][s[i].second] = mean;
    }
}

int population_migration() {
    int visited[50][50] = {0, }, res = 0;
    
    for (int tr = 0; tr < n; tr++) {
        for (int tc = 0; tc < n; tc++) {
            if (visited[tr][tc] != 1) {
                int sum = land[tr][tc];
                vector<pair<int, int>> s; queue<pair<int, int>> q;
                q.push(pair<int, int> (tr, tc));
                s.push_back(pair<int, int> (tr, tc));
                visited[tr][tc] = 1;
                while (q.size()) {
                    int nr, nc;
                    for (int i = 0; i < 4; i++) {
                        nr = q.front().first + dr[i]; nc = q.front().second + dc[i];
                        if (0 <= nr && nr < n && 0 <= nc && nc < n && visited[nr][nc] != 1 && l <= abs(land[q.front().first][q.front().second] - land[nr][nc]) &&  abs(land[q.front().first][q.front().second] - land[nr][nc]) <= r) {
                            q.push(pair<int, int> (nr, nc));
                            s.push_back(pair<int, int> (nr, nc));
                            sum += land[nr][nc];
                            visited[nr][nc] = 1;
                        }
                    }
                    q.pop();
                }
                if (s.size() > 1) { //국경이 이어지면 인구이동을 한다.
                    change_land(s, sum / s.size());
                    res++;
                }
            }
        }
    }
    if (res) return res;
    return res;
}

int main() {
    int res = 0;
    cin >> n >> l >> r;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> land[i][j];
        }
    }
    
    while (population_migration()) {
        res++;
    }
    cout << res << '\n';
}
