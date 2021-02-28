# [10026] 적록색약 - Python

## :mag: Algorithm

**BFS**

## :round_pushpin: Logic
**BOJ_10026_2.py**

```python
def bfs(row, col, is_blind):
    if visited[row][col] == 1:
        return 0
    visited[row][col] = 1

    queue = deque([(row, col)])
    while queue:
        i, j = queue.popleft()
        for d in direction:
            x, y = i + d[0], j + d[1]
            if 0 <= x < N and 0 <= y < N and visited[x][y] == 0:
                if picture[x][y] == picture[i][j]:
                    visited[x][y] = 1
                    queue.append((x, y))
                elif is_blind and picture[x][y] != 'B' and picture[i][j] != 'B':
                    visited[x][y] = 1
                    queue.append((x, y))
    return 1
```
```is_blind```가 ```False```인 경우 적록색약인 아닌 사람 즉, 상하좌우로 같은 색인 
경우만 탐색한다.

만약 ```is_blind```가 ```True```인 경우 아래의 조건을 만족할 때 (서로 
파란색인 아닌 경우 = 서로 빨강 또는 초록) 적록색약을 적용하여 같은 색이 아니더라도 탐색한다.
```python
elif is_blind and picture[x][y] != 'B' and picture[i][j] != 'B': 
```


## :memo: Review

**BOJ_10026_2.py**와 달리 처음에는 **BOJ_10026.py**로 시도했었다. 

적록색약이 아닌 경우와 적록색약인 경우를 함께 탐색하는 방법이었다. 

그런데 '틀렸습니다'가 계속 나왔고 이틀 간 계속 고민해봐도 반례를 못찾았다.

아직 왜 틀린건지 잘 모르겠다... 백준 질문 게시판에 올렸는데 아직 답글이 없다...