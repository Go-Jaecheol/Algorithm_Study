# [2178] 미로 탐색 - Python

## :mag: Algorithm
**BFS**

## :computer: Logic
### `BFS`

- 시작 지점의 (x좌표, y좌표, 이동 칸 수)를 **큐**에 넣고  
**visited**의 값을 ***1***로 업데이트

- 큐에 있는 값 (x좌표, y좌표, 이동 칸 수)을 **꺼내서**  
**상하좌우**를 확인하고 **maze 값**이 ***1***이고 **방문하지 않았으면**  
**result++하고 visited값 업데이트**하고 큐에 **append**

- 큐에 값이 있는 동안 계속 **반복**하고  
마지막 위치에 도달하면 **return**

```Python
def bfs(x, y, result):
  que = deque()
  visited[y][x] = 1
  que.append((x, y, result))

  while que:
    x, y, result = que.popleft()
    if (x, y) == (m-1, n-1):
      print(result)
      return
    for i in range(4):
      next_x = x + dx[i]
      next_y = y + dy[i]
      if 0 <= next_x < m and 0 <= next_y < n:
        if maze[next_y][next_x] and visited[next_y][next_x] == 0:
          next_result = result + 1
          visited[next_y][next_x] = 1
          que.append((next_x, next_y, next_result))
```

## :memo: Review
BFS 문제를 처음 풀어서 처음 알고리즘 자체를 이해하는게  
시간이 걸리긴 했는데

이해하고 나서는 DFS보다 괜찮은듯..?

---
파이썬에서 큐를 사용할 때  
```Python
from queue import Queue
```
```Python
from collections import deque  
```
둘 다 사용 가능한데

```Python
from queue import Queue
```
는 멀티스레딩 환경에서 사용되기 때문에 비교적 시간이 많이 걸림
