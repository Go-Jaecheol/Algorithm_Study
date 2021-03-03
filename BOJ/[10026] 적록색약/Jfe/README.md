# [10026] 적록색약 - Python

## :mag: Algorithm
**BFS**

## :computer: Logic
### `BFS`

```Python
def bfs(x, y, picture):
    que = deque()
    visited[y][x] = 1
    que.append((x, y))

    while que:
        x, y = que.popleft()
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if 0 <= next_x < N and 0 <= next_y < N and visited[next_y][next_x] == 0:
                if picture[next_y][next_x] == picture[y][x]:
                    visited[next_y][next_x] = 1
                    que.append((next_x, next_y))
```
- **BFS**를 통해 같은 글자면 큐에 **append** 하는 방식으로 탐색

```Python
for i in range(N):
    for j in range(N):
        if copy_picture[i][j] == 'G':
            copy_picture[i][j] = 'R'
```
- 적록색약일 경우(copy_picture)에는 모든 'G'를 'R'로 바꿔준다

```Python
for i in range(N):
    for j in range(N):
        if visited[i][j] == 0:
            bfs(j, i, picture)
            cnt += 1
```
- visited가 0인 모든 경우에 bfs 함수를 호출하면서 cnt 카운트  
- 적록색약인 경우에도 copy_picture를 인자로 준 다음 실행하면서 color_weak를 카운트

## :memo: Review
일반적인 BFS 문제

더 단순하게 코드를 짜는 방법도 있었을 것 같은데  
그건 다시 생각해봐야겠다..
