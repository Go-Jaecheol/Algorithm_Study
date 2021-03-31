import sys, heapq

INF = sys.maxsize
V, E = map(int, input().split())
start_v = int(input())
graph = [[] for _ in range(V+1)]
for _ in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append([w, v])

    
SP = [INF for _ in range(V+1)]
SP[start_v] = 0
queue = [(0, start_v)]
while queue:
    current_w, current_v = heapq.heappop(queue)
    if SP[current_v] < current_w: continue
    for new_w, new_v in graph[current_v]:
        distance = current_w + new_w
        if distance < SP[new_v]:
            SP[new_v] = distance
            heapq.heappush(queue, (distance, new_v))
    
 
for i in range(1, V+1):
    print(SP[i] if SP[i] != INF else 'INF')
