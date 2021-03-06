# [16234] 인구 이동 - Python

## :mag: Algorithm
**BFS, 시뮬레이션**

## :computer: Logic
### `BFS`

```Python
def bfs(x, y):
    global alliance
    que = deque()
    que.append((y, x))
    while que:
        y, x = que.popleft()
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if 0 <= next_x < N and 0 <= next_y < N and visited[next_y][next_x] == 0:
                if L <= abs(nations[next_y][next_x] - nations[y][x]) <= R:
                    visited[next_y][next_x] = 1
                    que.append((next_y, next_x))
                    alliance.append((y, x))
                    alliance.append((next_y, next_x))
    my_set = set(alliance)
    alliance = list(my_set)

    if len(alliance) == 0:
        return 0
    else:
        return 1
```
- **BFS로 연합을 확인하는 함수**  
  * 다른 BFS 문제처럼 상하좌우 확인하면서 방문하지 않았고  
  * **두 인구 차이**가 **L ~ R** 이면 큐에 **append**  
  * 또한 **연합**인 경우이기 때문에 **두 국가의 좌표** 둘 다 **alliance** 리스트에 **append**  
  * 탐색이 끝나면 alliance 리스트의 **중복을 제거**하기 위해 `set()` 사용 후  
  * 연합이 없으면 ***0***을 반환, 있으면 ***1***을 반환  
---

```Python
def movePopulation():
    temp = []
    population_sum = 0
    length = len(alliance)
    for _ in range(length):
        y, x = alliance.pop()
        population_sum += nations[y][x]
        temp.append((y, x))
    for _ in range(length):
        y, x = temp.pop()
        nations[y][x] = int(population_sum / length)
```
- **평균을 계산해서 인구 이동하는 함수**  
  * **alliance**에 저장되어 있는 좌표들을 이용해서  
  * 평균 계산 후 **nations** 값 업데이트  
---
```Python
while True:
    change = False
    visited = [[0 for x in range(N)]for y in range(N)]
    for i in range(N):
        for j in range(N):
            if visited[i][j] == 0:
                visited[i][j] = 1
                if bfs(j, i):
                    change = True
                    movePopulation()
    if not change:
        print(count)
        break
    count += 1
```
- **인구 이동이 없을 때까지 반복**  
  * 모두 방문할 때까지 for문을 돌면서 `bfs()` 함수 호출  
  * `bfs()` 반환 값이 ***1***이면 change를 ***True***로 바꿔주고 `movePopulation()` 함수 호출  
  * change가 ***False***면 한번도 인구 이동을 안한 것이기 때문에  
  * **count** 출력 후 종료  
---

## :memo: Review
> 최근에 BFS 문제 계속 풀어서 그런지 감은 빨리 잡았다.  
> 
> 중간에 실수했던 부분은  
> visited를 확인하는 걸 bfs 함수에서만 했던거랑  
> 연합이 한번에 여러 개가 생길 수 있는걸 고려 안한점?  
> 그래도 생각보다 빨리 풀어서 오랜만에 재밌었음 ㅎㅎ
> 
> 오늘 새로 알게 된거는 set() 정도...?
> 
> PyPy3로 통과
