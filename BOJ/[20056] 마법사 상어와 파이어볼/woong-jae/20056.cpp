#include <iostream>
#include <utility>
#include <vector>
#include <queue>

using namespace std;

typedef struct fireball {
    pair<int, int> pos;
    int m;
    int s;
    int d;
} fireball;

int N, M, K;
queue<fireball> fireballs;

int dr[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dc[8] = {0, 1, 1, 1, 0, -1, -1, -1};

int magicSharkAndFireball() {
    int ret = 0;
    
    for (int k = 0; k < K; k++) {
        vector<vector<vector<fireball>>> field(N, vector<vector<fireball>> (N));
        while (fireballs.size()) { // 파이어볼 이동
            fireball cur = fireballs.front();
            int nr, nc;
            if (dr[cur.d] < 0) {
                nr = (N + cur.pos.first + (dr[cur.d] * cur.s) % N) % N;
            } else {
                nr = (cur.pos.first + (dr[cur.d] * cur.s) % N) % N;
            }
            if (dc[cur.d] < 0) {
                nc = (N + cur.pos.second + (dc[cur.d] * cur.s) % N) % N;
            } else {
                nc = (cur.pos.second + (dc[cur.d] * cur.s) % N) % N;
            }
            fireball next = {make_pair(nr, nc), cur.m, cur.s, cur.d};
            field[nr][nc].push_back(next);
            fireballs.pop();
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (field[r][c].size() == 1) {
                    fireballs.push(field[r][c][0]);
                }
                else if (field[r][c].size() >= 2) { // 2개 이상 파이어볼 처리
                    fireball merged = {make_pair(r, c), 0, 0, 0};
                    int evenCount = 0;
                    for (int i = 0; i < field[r][c].size(); i++) { // 같은 칸에 있는 파이어볼 합치기
                        merged.m += field[r][c][i].m;
                        merged.s += field[r][c][i].s;
                        if(field[r][c][i].d % 2 == 0) evenCount++;
                    }
                    // 나눴을 때 질량과 속력
                    merged.m /= 5;
                    merged.s /= field[r][c].size();
                    if (merged.m > 0) { // 질량이 0보다 크면 파이어볼 4개로 나누기
                        if (evenCount == field[r][c].size() || evenCount == 0) { // 짝수
                            for (int i = 0; i < 8; i+=2) {
                                fireball splited = {make_pair(r, c), merged.m, merged.s, i};
                                fireballs.push(splited);
                            }
                        } else { // 홀수
                            for (int i = 1; i < 8; i+=2) {
                                fireball splited = {make_pair(r, c), merged.m, merged.s, i};
                                fireballs.push(splited);
                            }
                        }
                    }
                }
            }
        }
    }
    
    while(fireballs.size()) {
        ret += fireballs.front().m;
        fireballs.pop();
    }
    
    return ret;
}

int main() {
    cin >> N >> M >> K;
    for (int i = 0; i < M; i++) {
        int r, c, m, s, d;
        cin >> r >> c >> m >> s >> d;
        fireball ball = {make_pair(r - 1, c - 1), m, s, d};
        fireballs.push(ball);
    }
    cout << magicSharkAndFireball() << '\n';
}
