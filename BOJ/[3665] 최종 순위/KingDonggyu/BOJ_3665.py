import sys
from collections import deque
input = sys.stdin.readline


def topology_sort():   
    result = []
    q = deque()

    for i in range(1, n+1):
        if indegree[i] == 0:
            q.append(i)
    
    while q:
        node = q.popleft()
        result.append(node)

        for next_node in graph[node]:
            indegree[next_node] -= 1
            if indegree[next_node] == 0:
                q.append(next_node)

    if len(result) == n: result_set.append(result)
    else: result_set.append("IMPOSSIBLE")


result_set = []
for _ in range(int(input())):
    n = int(input())
    rank = [int(i) for i in input().split()]
    m = int(input())

    graph = [[] for _ in range(n+1)]
    indegree = [0 for _ in range(n+1)]

    for i in range(0, n):
        for j in range(i+1, n):
            graph[rank[i]].append(rank[j])
    
    for _ in range(m):
        A, B = map(int, input().split())
        if A in graph[B]:
            graph[B].remove(A)
            graph[A].append(B)
        else:
            graph[A].remove(B)
            graph[B].append(A)
    
    for A in range(1, n+1):
        for B in graph[A]:
            indegree[B] += 1

    topology_sort()

for i, result in enumerate(result_set):
    if not isinstance(result, list):
        print(result); continue
    for res in result:
        print(res, end=" ")
    if i != len(result_set)-1: print()