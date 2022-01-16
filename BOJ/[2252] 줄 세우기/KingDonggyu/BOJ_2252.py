import sys
from collections import deque


def topology_sort():
    result = []
    queue = deque()

    for i in range(1, N+1):
        if indegree_cnt[i] == 0:
            queue.append(i)
    
    while queue:
        node = queue.popleft()
        result.append(node)

        for next_node in graph[node]:
            indegree_cnt[next_node] -= 1
            if indegree_cnt[next_node] == 0:
                queue.append(next_node)

    for res in result:
        print(res, end=" ")


N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
indegree_cnt = [0 for _ in range(N+1)]

for _ in range(M):
    A, B = map(int, sys.stdin.readline().split())
    graph[A].append(B)

for A in range(1, N+1):
    for B in graph[A]:
        indegree_cnt[B] += 1

topology_sort()