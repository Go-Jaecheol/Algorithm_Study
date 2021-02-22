# [14502] 연구소 - Python

## :mag: Algorithm
**BFS, Brute-Force**

## :computer: Logic
### `BFS`

```Python
def spreadVirus():
    copy_lab = [lab[i][:] for i in range(N)]
    visited = [[0 for x in range(M)]for y in range(N)]
    que = deque()

    for i, j in virus:
        que.append((i, j))
        visited[j][i] = 1
        while que:
            x, y = que.popleft()
            for k in range(4):
                next_x = x + dx[k]
                next_y = y + dy[k]
                if 0 <= next_x < M and 0 <= next_y < N:
                    if visited[next_y][next_x] == 0 and copy_lab[next_y][next_x] != 1:
                        copy_lab[next_y][next_x] = 2
                        visited[next_y][next_x] = 1
                        que.append((next_x, next_y))
    checkBlank(copy_lab)
```
- **BFS로 바이러스를 퍼뜨리는 함수**  
  * 기존 lab 리스트를 건드리지 않기 위해 **copy_lab**이라는 새로운 리스트로 **복사**  
  * **virus**리스트에 들어있는 좌표를 **시작 지점**으로 해서  
  * 다른 BFS 문제처럼 상하좌우 확인하면서 방문하지 않았고 값이 1이 아니면  
  * 값을 ***2***로 바꿔주고 큐에 **append**  
  * 탐색이 끝나면 **checkBlank() 함수**를 실행해서 **안전 영역 크기**를 확인
---

```Python
def checkBlank(copy_lab):
    count = 0
    for i in range(N):
        for j in range(M):
            if copy_lab[i][j] == 0:
                count += 1
    safe_area.append(count)
```
- **안전 영역 크기를 확인하기 위한 함수**  
  * copy_lab의 값이 ***0***인 경우만 카운트해서   
  * **safe_area** 리스트에 **append**
---
### `Brute-Force`  
```Python
def buildWall(wall_count):
    if wall_count == 3:
        spreadVirus()
        return
    for i in range(N):
        for j in range(M):
            if lab[i][j] == 0:
                lab[i][j] = 1
                buildWall(wall_count + 1)
                lab[i][j] = 0
```
- **벽을 3개 세우기 위한 함수**  
  * 벽 3개를 세우기 위해서 **완전 탐색**을 해야 한다.  
  * **재귀 함수** 형식으로 구성하고  
  * wall_count가 ***3***인 경우에 **spreadVirus() 함수**를 호출  
---

```Python
def checkVirus():
    for i in range(N):
        for j in range(M):
            if lab[i][j] == 2:
                virus.append((j, i))
```
- **바이러스 좌표 체크하는 함수**  
  * lab 리스트 값이 ***2***인 경우에  
  * 해당 좌표를 **virus** 리스트에 **append**  

## :memo: Review
백준에서 Python3로는 시간초과 나고 PyPy3로는 통과했다,,,

바이러스를 퍼뜨리는 부분은 이전 BFS 문제랑 비슷했는데  
시작 위치를 다르게 여러번 하는 점이 살짝 다름

BFS 함수 짜는 부분보다 오히려 브루트포스로 벽 3개 세우는 부분이  
더 생각이 잘 안나서 시간이 걸린듯..

Python3로도 통과하는 사람들 있던데  
나중에 다시 해봐야지ㅜ

---

벽 세우는 부분을 combinations()를 이용하니까  
Python3에서도 시간초과 안나고 잘 돌아감

```Python
def buildWall(wall_count):
    blank = []
    for i in range(N):
        for j in range(M):
            if lab[i][j] == 0:
                blank.append((i, j))

    comb = list(combinations(blank, 3))
    for c in comb:
        copy_lab = [lab[i][:] for i in range(N)]
        for i in range(3):
            copy_lab[c[i][0]][c[i][1]] = 1
        spreadVirus(copy_lab)
```

