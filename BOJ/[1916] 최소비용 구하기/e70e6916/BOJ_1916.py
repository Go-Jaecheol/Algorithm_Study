import sys, heapq

INF = sys.maxsize
N, M = int(input()), int(input())
bus_data = [[] for _ in range(N+1)]
for _ in range(M):
    start, end, cost = map(int, sys.stdin.readline().split())  
    bus_data[start].append((cost, end))
start_city, end_city = map(int, input().split())


SP = [INF for _ in range(N+1)]
SP[start_city] = 0
queue = [(0, start_city)]
while queue:
    current_cost, current_city = heapq.heappop(queue)
    if SP[current_city] < current_cost: continue
    for new_cost, new_city in bus_data[current_city]:
        cost = current_cost + new_cost
        if cost < SP[new_city]:
            SP[new_city] = cost
            heapq.heappush(queue, (cost, new_city))

print(SP[end_city])
