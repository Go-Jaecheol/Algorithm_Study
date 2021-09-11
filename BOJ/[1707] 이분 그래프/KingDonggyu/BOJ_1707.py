import sys
from collections import deque
input = sys.stdin.readline


def bfs(start):
    visited[start] = 1
    queue = deque([start])
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if visited[i] == 0:
                visited[i] = -visited[v]
                queue.append(i)
            else:
                if visited[i] == visited[v]:
                    return False
    return True


K = int(input())
for _ in range(K):
    V, E = map(int, input().split())
    graph = [[] for _ in range(V+1)]
    visited = [0] * (V+1)
    isBipartite = True
    for _ in range(E):
        x, y = map(int, input().split())
        graph[x].append(y)
        graph[y].append(x)
    for i in range(1, V+1):
        if visited[i] == 0:
            if not bfs(i):
                isBipartite = False
                break
    print("YES" if isBipartite else "NO")
