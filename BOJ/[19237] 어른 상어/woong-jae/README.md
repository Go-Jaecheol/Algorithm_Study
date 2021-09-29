# [19237] 어른 상어
## Algorithm
- Simulation
## Logic
상어 이동의 경우 문제에서 시키는 대로 하면 된다.

하지만, 사라지는 냄새와 상어 추방은 어느 시점에 구현할 지 잘생각해야한다.

나는 상어를 이동시키면서 추방되는 상어를 걸러줬고, 원래 있던 냄새의 수명을 줄여주는 부분을 제일 앞부분으로 했다.
```cpp
int adultShark() {
    int time = 0, leftShark = M;
    vector<bool> alive(M + 1, true);
    
    for (int i = 1; i <= M; i++) {
        field[sharks[i].position.first][sharks[i].position.second] = make_pair(i, k);
    }
    
    while (time <= 1000) {
        vector<vector<pair<int, int>>> temp_field = field;
        
        for (int r = 1; r <= N; r++) { // 냄새 수명 내리기
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
```
## Review
입력 받는 것부터 햇갈려서 좀 해맸다. 문제만 제대로 읽으면 어렵지 않게 풀 수 있다. 제대로 안읽어서 그렇지ㅋㅋㅋ...
