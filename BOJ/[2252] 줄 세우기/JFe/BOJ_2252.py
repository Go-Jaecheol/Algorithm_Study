import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N+1)]
indegree = [0 for _ in range(N+1)]
result = []
for _ in range(M):
    A, B = map(int, sys.stdin.readline().split())
    graph[A].append(B)
    indegree[B] += 1

def topology_sort():
    global result
    q = deque()
    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)
    while q:
        num = q.popleft()
        result.append(num)
        for i in graph[num]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)

topology_sort()
for i in result:
    print(i, end=' ')