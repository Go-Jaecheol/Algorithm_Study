# [2178] 미로 탐색 - C++

## :pushpin: **Algorithm**

그래프 이론, 그래프 탐색, BFS

## :round_pushpin: **Logic**

```c++
void maze(int x, int y);
```

- 시작점에서부터 상하좌우를 확인하며 방문한 적 없으면서 '1'인 좌표를 찾아 경로를 계산하는 함수

```c++
int** visited;
```

- 방문 여부를 저장하는 배열, -1로 초기화

```c++
if (next.first >= 0 && next.first < row && next.second >= 0 && next.second < col) {
    if (map[next.first][next.second] == '1' && visited[next.first][next.second] == -1) {
        if (visited[next.first][next.second] == -1 || (visited[next.first][next.second] > visited[cur.first][cur.second] + 1))
            visited[next.first][next.second] = visited[cur.first][cur.second] + 1;
        q.push(make_pair(next.first, next.second));
    }
}
```

- 좌표가 '1'이고 방문하지 않은 경우(-1로 초기화된 미로)에 최단 경로를 계속 visited에 저장해야 하므로 비교 후 저장

## :black_nib: **Review**

- **그림** 문제와 유사하게 접근하려 했으나 너비 우선 탐색이라고 해서 처음엔 왜 이걸 BFS로 풀어야 하는지부터 알아봄

- 방문 여부를 저장하는 visited 배열을 단순히 방문했다, 안 했다만 저장하는 용도가 아닌 해당 좌표까지의 경로 수를 저장하는 배열로 사용하여 해결