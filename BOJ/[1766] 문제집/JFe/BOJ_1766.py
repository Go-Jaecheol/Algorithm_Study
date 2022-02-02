import sys, heapq

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
    heap = []
    for i in range(1, N+1):
        if indegree[i] == 0:
            heapq.heappush(heap, i)
    while heap:
        num = heapq.heappop(heap)
        result.append(num)
        for i in graph[num]:
            indegree[i] -= 1
            if indegree[i] == 0:
                heapq.heappush(heap, i)

topology_sort()
for i in result:
    print(i, end=' ')