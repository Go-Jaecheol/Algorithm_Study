import sys, heapq
V , E = map(int, sys.stdin.readline().split())
K = int(sys.stdin.readline())
graph = [[] for _ in range(V)]
distance = [float('inf') for _ in range(V)]

def inputGraph():
    for _ in range(E):
        u, v, w = map(int, sys.stdin.readline().split())
        graph[u-1].append([v-1, w])

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

inputGraph()
dijkstra(K-1)
for i in range(V):
    print(distance[i] if distance[i] != float('inf') else 'INF')
