# [1926] 그림
## 💡Algorithm

그래프, BFS

## 💡Logic

시작점부터 그래프를 BFS로 탐색한다. 현재 노드의 상하좌우를 탐색하면서 아직 탐색하지 않은 노드라면, 현재 노드의 깊이 + 1을 visited 배열에 저장한다. 

그렇게 해서 목표 노드의 깊이를 찾아내면 그것이 최단 경로가 된다.


```c++
int minPass(int r, int c) {
    position cur, temp;
    cur.r = r; cur.c = c;
    
    q.push(cur);
    visited[r][c] = 1;
    while(1) {
        cur = q.front();
        q.pop();
        for(int i = 0; i < 4; i++) {//상,하,좌,우 탐색
                int nc = cur.c + x[i], nr = cur.r + y[i];
                if(0 <= nc && nc < m && 0 <= nr && nr < n && maze[nr][nc] == '1' && !visited[nr][nc]) {
                    temp.r = nr; temp.c = nc;
                    visited[nr][nc] = visited[cur.r][cur.c] + 1;
                    if(nr == n - 1 && nc == m - 1) {
                        return visited[n - 1][m - 1];
                    };
                    q.push(temp);
                }
            }
    }
}

```

## 💡Review

BFS가 생소해서 어떻게 풀어야 할지 생각하는데 오래걸렸다. 어렵다...
