import sys
from collections import deque


def topology_sort():
    result = []
    q = deque()
    
    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        node = q.popleft()
        result.append(node)

        for next_node in graph[node]:
            indegree[next_node] -= 1
            if indegree[next_node] == 0:
                q.append(next_node)
    
    if len(result) != N: 
        print(0)
    else:
        for res in result: 
            print(res)


N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
indegree = [0 for _ in range(N+1)]

for _ in range(M):
    order = [int(i) for i in sys.stdin.readline().split()]
    for i in range(1, order[0]):
        graph[order[i]].append(order[i+1])

for A in range(1, N+1):
    for B in graph[A]:
        indegree[B] += 1

topology_sort()