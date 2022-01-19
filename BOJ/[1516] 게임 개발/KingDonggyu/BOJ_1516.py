import sys, heapq


def topology_sort():
    heap = []
    for i in range(1, N+1):
        if indegree[i] == 0:
            heapq.heappush(heap, (build_time[i], i))
    
    while heap:
        time, node = heapq.heappop(heap)

        for next_node in graph[node]:
            indegree[next_node] -= 1
            if indegree[next_node] == 0:
                heapq.heappush(heap, (build_time[next_node] + time, next_node))

        build_time[node] = time


N = int(input())
build_time = [0 for _ in range(N+1)]
graph = [[] for _ in range(N+1)]
indegree = [0 for _ in range(N+1)]

for i in range(1, N+1):
    building = [int(x) for x in sys.stdin.readline().split()]
    build_time[i] = building[0]
    for j, v in enumerate(building):
        if j == 0: continue
        if v == -1: break
        graph[v].append(i)
        indegree[i] += 1

topology_sort()

for number, time in enumerate(build_time):
    if number == 0: continue
    print(time)