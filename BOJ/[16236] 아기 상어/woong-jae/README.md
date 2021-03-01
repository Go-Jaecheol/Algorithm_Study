# [16236] 아기 상어
## 💡Algorithm

그래프, BFS, 시뮬레이션

## 💡Logic

현재 아기상어의 위치에서부터 BFS로 도달할 수 있는 가장 가까운 물고기를 탐색해서 ```vector<pair<int, int>> s``` 에 저장한다.

- 저장된게 없다면, 먹을 수 있는 물고기가 없다는 뜻이므로 0을 반환한다.

- 저장된게 있다면, 배열을 정렬해서 제일 좌상단에 있는 물고기를 찾는다.

```c++
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
```

## 💡Review
시뮬레이션 문제가 아직 익숙하지 않아서 오래 걸린 것 같다. 특히 이런 시뮬레이션 문제는 종료 조건을 잘 구현해야하는데, 그러지 못해서 시간 초과가 났다. 시뮬레이션에서 시간 초과가 나면 종료 조건을 빼먹어서 무한 루프를 도는게 아닌지 봐야겠다.
