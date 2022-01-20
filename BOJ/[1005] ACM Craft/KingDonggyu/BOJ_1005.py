import sys, heapq
input = sys.stdin.readline


def topology_sort():
    heap = []
    for i in range(1, N+1):
        if indegree[i] == 0:
            heapq.heappush(heap, (build_time[i], i))

    while heap:
        time, number = heapq.heappop(heap)
        if number == W:
            result.append(time)
            break
        
        for next_number in graph[number]:
            indegree[next_number] -= 1
            if indegree[next_number] == 0:
                heapq.heappush(heap, (build_time[next_number] + time, next_number))


result = []
T = int(input())
for _ in range(T):
    N, K = map(int, input().split())
    build_time = [0] + [int(i) for i in input().split()]

    graph = [[] for _ in range(N+1)]
    indegree = [0 for _ in range(N+1)]

    for _ in range(K):
        X, Y = map(int, input().split())
        graph[X].append(Y)
        indegree[Y] += 1
    
    W = int(input())
    topology_sort()

for res in result: print(res)