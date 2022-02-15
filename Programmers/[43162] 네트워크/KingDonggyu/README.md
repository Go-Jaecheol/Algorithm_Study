# [43162] 네트워크 - Python

## :mag: Algorithm

### DFS

## :round_pushpin: Logic

💡 **DFS**를 통해 연결되어 있는 컴퓨터를 방문하며 `n` 크기의 `visited`에 방문여부를 표시한다.

```python
for i in range(n):
    if not visited[i]:
        dfs(i)
        answer += 1
```

- **방문하지 않은 컴퓨터만 탐색한다.** (해당 컴퓨터와 연결되어 있는 모든 컴퓨터 방문)

  - 즉, `dfs` 함수가 몇번 동작하는지 횟수를 구한다.

## :memo: Review

DFS를 활용하는 가장 기초적인 쉬운 문제였다.