# [1926] 그림
## 💡Algorithm

그래프, DFS

## 💡Logic

전체 그래프를 순회하면서 아직 방문하지 않은 그림을 탐색한다.

방문하지 않은 그림을 발견하면, 그 그림의 넓이를 DFS를 활용해서 탐색한다. 그 후 넓이를 가장 큰 것으로 갱신하면서 끝까지 탐색한다.


```c++
int getDimension(int r, int c) {
    int d = 1;
    visited[r][c] = 1;
    
    for(int i = 0; i < 4; i++) {
        int nc = c + x[i], nr = r + y[i];
        if(0 <= nc && nc < m && 0 <= nr && nr < n && paper[nr][nc] && !visited[nr][nc]) {
            d = d + getDimension(nr, nc);
        }
    }
    
    return d;
}
```

## 💡Review

쉬운 문제.
