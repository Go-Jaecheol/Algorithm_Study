# [16234] 인구 이동
## 💡Algorithm
그래프, BFS
## 📚Logic
그래프를 순회하면서 각 노드마다 BFS로 돌면서 국경이 이어지는 부분을 찾는다.
- 국경이 이어지는 부분이 있다면 인구수의 평균으로 연합의 인구수를 변경해준다. 국경이 이어지는 부분은 ```vector<pair<int, int>> s```에 따로 저장해준다.
- 국경이 이어지는 부분이 없어 인구 이동이 없었다며 0을 반환해 반복을 끝낸다.
```c++
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
```
## 📝Review
시뮬레이션 문제는 알다가도 모르겠다. 더 풀어서 감을 잡아야겠다. 항상 아이디어는 쉽게 잡는데, 구현 부분에서 애먹는다. 글이 너무 길어 대충 읽어서 조건을 계속 빼먹는것도 한 몫 하는 것 같다. 
