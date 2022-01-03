# [2146] 다리 만들기 - Python

## :mag: Algorithm
**BFS**

## :computer: Logic

```Python
def divide_area(x, y, label):
    q = deque()
    visited[y][x] = True
    q.append((x, y))
    while q:
        cur_x, cur_y = q.popleft()
        for i in range(4):
            next_x = cur_x + dx[i]
            next_y = cur_y + dy[i]
            if 0 <= next_x <= N-1 and 0 <= next_y <= N-1:
                if not visited[next_y][next_x] and map[next_y][next_x]!=0:
                    visited[next_y][next_x] = True
                    q.append((next_x, next_y))
                elif map[next_y][next_x] == 0:
                    map[cur_y][cur_x] = label
```

- BFS로 섬을 나누고 label 설정  
  - 시작 노드의 `visited[y][x]`를 True로 설정  
  - 상하좌우를 확인해서 방문하지 않았고, map[next_y][next_x]의 값이 0이 아니면 큐에 append  
  - map[next_y][next_x]의 값이 0이면 현재 map[cur_t][cur_x]의 값을 label로 변경  
  - (섬의 가장자리 값을 label로 설정)  
  
---

```Python
def find_min(x, y, label):
    global result
    q = deque()
    visited = [[False for _ in range(N)] for _ in range(N)]
    count = 0
    visited[y][x] = True
    q.append((x, y, count))
    while q:
        cur_x, cur_y, count = q.popleft()
        for i in range(4):
            next_x = cur_x + dx[i]
            next_y = cur_y + dy[i]
            if 0 <= next_x <= N-1 and 0 <= next_y <= N-1 and not visited[next_y][next_x] and map[next_y][next_x] != 1 and map[next_y][next_x] != label:
                if map[next_y][next_x] == 0:
                    visited[next_y][next_x] = True
                    q.append((next_x, next_y, count+1))
                else:
                    result = min(result, count)
```

- BFS로 다리를 놓을 최소 거리 확인  
  - 시작 노드의 `visited[y][x]`를 True로 설정  
  - 상하좌우를 확인해서 방문하지 않았고, map[next_y][next_x]의 값이 1, 해당 label이 아닐 때만 체크  
  - map[next_y][next_x]의 값이 0이면 큐에 count + 1 한 다음 append  
  - 0이 아니면 result와의 최솟값을 result에 저장  

---

```Python
for y in range(N):
    for x in range(N):
        if not visited[y][x] and map[y][x] != 0:
            label += 1  # 섬 가장자리 label (2, 3, ...)
            divide_area(x, y, label)
result = sys.maxsize
for y in range(N):
    for x in range(N):
        if map[y][x] != 0 and map[y][x] != 1:
            find_min(x, y, map[y][x])
print(result)
```

- 가능한 모든 위치에서 divide_area, find_min 함수 실행  


## :memo: Review
섬을 나누는 과정과 최단 거리를 찾는 과정으로 탐색 과정을 2가지로 나눠서 진행했다.  
섬을 나누는 과정에서 섬마다 label을 설정해줬는데  
나중에 최단 거리를 찾을 때, 더 빠르게 하기 위해 섬의 가장자리에만 label을 설정했다.
