import sys, heapq
V = int(sys.stdin.readline())
E = int(sys.stdin.readline())
graph = [[] for _ in range(V+1)]
distance = [float('inf') for _ in range(V+1)]

def inputGraph():
    for _ in range(E):
        u, v, w = map(int, sys.stdin.readline().split())
        graph[u].append([v, w])
    start, end = map(int, sys.stdin.readline().split())
    return start, end

def dijkstra(start):
    h = []
    distance[start] = 0
    heapq.heappush(h, [distance[start], start])
    while h:
        cur_value, cur_state = heapq.heappop(h)
        if distance[cur_state] < cur_value:
            continue
        for new_state, new_value in graph[cur_state]:
            value = cur_value + new_value
            if value < distance[new_state]:
                distance[new_state] = value
                heapq.heappush(h, [value, new_state])

start, end = inputGraph()
dijkstra(start)
print(distance[end])