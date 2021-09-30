# [20056] 마법사 상어와 파이어볼
## Algorithm
- Simulation
## Logic
파이어볼을 옮길 때 한 칸에 여러 파이어볼이 들어갈 수 있기 때문에 3차원 배열을 선언해서 관리했다.

그리고 이동된 파이어볼은 `queue`에 삽입해서 처리했다.
```cpp
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
                if (field[r][c].size() == 1) { // 1개인 파이어볼
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
```
## Review
문제가 뭘 원하는지 햇갈려서 좀 해맸다. 파이어볼을 이동시킬 때 방향을 잡아주는 부분이 좀 난이도 있었던 것 같다.
