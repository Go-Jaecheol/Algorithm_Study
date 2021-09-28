#include <iostream>
#include <vector>
#include <queue>
#include <utility>

using namespace std;

typedef struct shark {
    pair<int, int> position;
    int dir;
} shark;

int N, M, k;
vector<vector<pair<int, int>>> field;
vector<vector<vector<int>>> priority;
vector<shark> sharks;
int dr[4] = {-1, 1, 0, 0};
int dc[4] = {0, 0, -1, 1};

int adultShark() {
    int time = 0, leftShark = M;
    vector<bool> alive(M + 1, true);
    
    for (int i = 1; i <= M; i++) {
        field[sharks[i].position.first][sharks[i].position.second] = make_pair(i, k);
    }
    
    while (time <= 1000) {
        vector<vector<pair<int, int>>> temp_field = field;
        
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                temp_field[r][c].second--;
            }
        }
        
        // 냄새 뿌리기
        for (int i = 1; i <= M; i++) { // 냄새 없는 칸 찾기
            if (alive[i]) {
                bool found = false;
                for (int dir = 0; dir < 4; dir++) {
                    int ndir = priority[i][sharks[i].dir - 1][dir];
                    int nr = sharks[i].position.first + dr[ndir - 1], nc = sharks[i].position.second + dc[ndir - 1];
                    if (0 < nr && nr <= N && 0 < nc && nc <= N && field[nr][nc].first == 0) {
                        found = true;
                        if (temp_field[nr][nc].first > 0) { // 상어 추방
                            alive[i] = false;
                            leftShark--;
                            break;
                        }
                        else {
                            sharks[i].position = make_pair(nr, nc);
                            sharks[i].dir = ndir;
                            temp_field[nr][nc] = make_pair(i, k);
                            break;
                        }
                    }
                }
                if (!found) { // 자신의 냄새가 있는 칸 찾기
                    for (int dir = 0; dir < 4; dir++) {
                        int ndir = priority[i][sharks[i].dir - 1][dir];
                        int nr = sharks[i].position.first + dr[ndir - 1], nc = sharks[i].position.second + dc[ndir - 1];
                        if (0 < nr && nr <= N && 0 < nc && nc <= N && field[nr][nc].first == i) {
                            sharks[i].position = make_pair(nr, nc);
                            temp_field[nr][nc].second = k;
                            sharks[i].dir = ndir;
                            break;
                        }
                    }
                }
            }
        }
        // 사라지는 냄새 확인
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (temp_field[r][c].second == 0) {
                    temp_field[r][c].first = 0;
                }
            }
        }
        
        if (leftShark == 1) break;
        field = temp_field;
        time++;
    }
    
    if (time >= 1000) return -1;
    else return time + 1;
}

int main() {
    cin >> N >> M >> k;
    // init
    field = vector<vector<pair<int, int>>> (N + 1, vector<pair<int, int>> (N + 1));
    sharks = vector<shark> (M + 1);
    priority = vector<vector<vector<int>>> (M + 1);
    for (int r = 1; r <= N; r++) {
        for (int c = 1; c <= N; c++) {
            cin >> field[r][c].first;
            if (field[r][c].first > 0) {
                sharks[field[r][c].first].position = make_pair(r, c);
            }
        }
    }
    for (int i = 1; i <= M; i++) {
        cin >> sharks[i].dir;
    }
    for (int i = 1; i <= M; i++) {
        for (int s = 0; s < 4; s++) {
            vector<int> p(4);
            for (int j = 0; j < 4; j++) {
                cin >> p[j];
            }
            priority[i].push_back(p);
        }
    }
    // result
    cout << adultShark() << '\n';
}
