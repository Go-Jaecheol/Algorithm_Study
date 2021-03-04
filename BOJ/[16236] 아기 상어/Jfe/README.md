# [16236] 아기 상어 - Python

## :mag: Algorithm
**BFS, 시뮬레이션, 우선순위 큐**

## :computer: Logic
### `BFS`

```Python
def bfs(x, y, result):
    visited = [[0 for x in range(N)]for y in range(N)]
    que = deque()
    visited[y][x] = 1
    que.append((x, y, result))
    eat_cnt = 0
    max_size = 401
    h.clear()

    while que:
        x, y, result = que.popleft()
        if result >= max_size:
            break
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if 0 <= next_x < N and 0 <= next_y < N and visited[next_y][next_x] == 0:
                if space[next_y][next_x] == 0 or space[next_y][next_x] == size:
                    next_result = result + 1
                    visited[next_y][next_x] = 1
                    que.append((next_x, next_y, next_result))
                elif 0 < space[next_y][next_x] < size:
                    next_result = result + 1
                    visited[next_y][next_x] = 1
                    max_size = next_result
                    heapq.heappush(h, (next_y, next_x, next_result))
                    eat_cnt += 1
    if eat_cnt == 0:
        return False
    else:
        return True
```
- **BFS로 가능한 경로를 저장하는 함수**  
  * 다른 **BFS** 문제처럼 상하좌우 확인하면서 방문하지 않았고  
  * 값이 ***0***이거나 상어와 **크기가 같으면** 큐에 **append** 하고  
  * 값이 ***0 ~ 상어크기 사이***면 **우선순위 큐**(heapq)에 **heappush** 해주고 **eat_cnt를 카운트** 해줌  
  * eat_cnt가 0이면 **False**, 0이 아니면 **True**를 반환  
---

```Python
for i in range(N):
    for j in range(N):
        if space[i][j] == 9:
            location_y = i
            location_x = j
            space[i][j] = 0
            break
```
- **처음 상어 위치 찾기**  
  * space 값이 ***9***인 경우에  
  * 값을 ***0***으로 바꿔주고 위치를 location_x, location_y에 저장  
---

```Python
while True:
    finish = bfs(location_x, location_y, 0)
    if finish == 0:
        print(time)
        break
    else:
        location_y, location_x, result = heapq.heappop(h)
        space[location_y][location_x] = 0
        time += result
        exp += 1
        if exp == size:
            size += 1
            exp = 0
```
- **물고기를 못먹을때까지 동작하는 반복문**  
  * bfs함수의 반환 값이 ***0***이면 time을 출력하고 종료  
  * 반환 값이 0이 아니면 **우선순위 큐**(heapq)의 제일 처음 값을 **heappop** 해서 저장하고  
  * 그 값들을 가지고 다시 **bfs**  
  * exp를 조건에 맞게 채우면 size 업  
---

## :memo: Review

처음 문제를 정할 때 생각했던 것보다 많이 어려웠다.  
감을 못잡아서 다른 사람들 풀이도 조금씩 보고  
특히 우선순위 큐도 처음 사용해 봤는데 이거 좀 괜찮네,,

예제 1, 2, 3까지는 잘 되다가  
4, 5, 6 값이 제대로 안나와서 고생했는데  
```Python
if result >= max_size:
            break
```
여기에 부등호를 >= 가 아닌 > 로 해놓은게 문제였음  
후,, 이제 시작인데 그럴 수도 있지;;;;;
