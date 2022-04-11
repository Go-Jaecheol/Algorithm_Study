# [43162] 네트워크 - Java

## :pushpin: **Algorithm**

DFS, BFS

## :round_pushpin: **Logic**

```java
private void dfs(int[][] computers, int idx) {
    if (visited[idx] != 0) return;
    
    visited[idx] = answer;
    
    for (int i = 0; i < computers[idx].length; i++)
        if (computers[idx][i] == 1 && visited[i] == 0)
            dfs(computers, i);
}
```

- 재귀적인 DFS를 이용해 방문하지 않은 computer를 방문하여 방문 여부에 answer를 기록한다.
- 방문 가능한 모든 computer를 방문한 후 answer를 증가시키고, 다음 탐색을 시작한다.

## :black_nib: **Review**

- 보자마자 풀이가 떠올라 그대로 통과했다.
