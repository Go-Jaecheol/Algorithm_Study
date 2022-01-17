import sys, heapq


def topology_sort():
    heap, result = [], []

    for i in range(1, N+1):
        if indegree[i] == 0:
            heapq.heappush(heap, i)

    while heap:
        node = heapq.heappop(heap)
        result.append(node)
        
        for next_node in graph[node]:
            indegree[next_node] -= 1
            if indegree[next_node] == 0:
                heapq.heappush(heap, next_node)
    
    for res in result:
        print(res, end=" ")


N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
indegree = [0 for _ in range(N+1)]

for _ in range(M):
    A, B = map(int, sys.stdin.readline().split())
    graph[A].append(B)

for A in range(1, N+1):
    for B in graph[A]:
        indegree[B] += 1

topology_sort()