import sys
from collections import deque
K = int(sys.stdin.readline())

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