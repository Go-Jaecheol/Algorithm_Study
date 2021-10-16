# [1707] 이분 그래프 - Python

## :mag: Algorithm
**BFS**

## :computer: Logic

```Python
def bfs(v):
    q = deque()
    visited[v] = 1
    q.append((v, visited[v]))
    while q:
        i, color = q.popleft()
        for next in graph[i]:
            if visited[next] == -1:
                if color == 1:
                    visited[next] = 2
                else:
                    visited[next] = 1
                q.append((next, visited[next]))
            elif visited[next] == color:
                return -1
                # 이분그래프x
    return 0
```

- BFS로 탐색하면서 이분그래프인지 아닌지 판단  
  - 시작 노드의 visited[v]를 1로 설정(색깔을 1로 칠한다는 컨셉)  
  - visited값(-1: 방문x, 1: color1, 2: color2)  
  - 시작 노드 v의 인접 노드 next들을 보면서  
  - 방문하지 않았으면 현재 color와 다른 color로 visited 설정하고 값들 append  
  - 방문을 했는데 next노드의 color가 현재 color와 같으면 이분그래프가 아니므로 -1 return    
  - 정상이면 0 return  

---

```Python
for _ in range(K):
    V, E = map(int, sys.stdin.readline().split())
    graph = [[]for _ in range(V+1)]
    visited = [-1 for _ in range(V+1)]
    result = 0
    # -1: 방문x / 1: color1 / 2: color2
    for _ in range(E):
        a, b = map(int, sys.stdin.readline().split())
        graph[a].append(b)
        graph[b].append(a)
    for i in range(1, V+1):
        if visited[i] == -1:
            if bfs(i) == -1:
                result = -1
                break
    if(result == 0):
        print("YES")
    else:
        print("NO")
```

- 테스트 케이스 K만큼 실행  
  - 입력되는 간선 정보에 맞게 graph 설정  
  - 비연결 그래프의 경우도 생각해야 하기 때문에 모든 노드에 대해 for문 진행  

## :memo: Review
처음에는 연결된 그래프에 대해서만 생각하면 될 거라고 생각해서 틀렸다..  
for문으로 비연결 그래프의 경우도 체크하면서 BFS 진행하도록 바꾼 뒤 통과  
