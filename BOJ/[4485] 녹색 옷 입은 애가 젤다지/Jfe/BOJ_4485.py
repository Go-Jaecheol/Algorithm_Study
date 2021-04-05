import sys, heapq
count = 1
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def dijkstra(N, cave):
    global distance, h
    distance = [float('inf') for _ in range(N*N)]
    h = []
    distance[0] = 0
    heapq.heappush(h, [distance[0], 0, 0])
    while h:
        cur_w, cur_y, cur_x = heapq.heappop(h)
        cur_v = N * cur_y + cur_x
        if distance[cur_v] < cur_w:
            continue
        for i in range(4):
            next_x, next_y = cur_x + dx[i], cur_y + dy[i]
            next_v = N * next_y + next_x
            if 0 <= next_x < N and 0 <= next_y < N:
                next_w = cur_w + cave[next_y][next_x]
                if next_w < distance[next_v]:
                    distance[next_v] = next_w
                    heapq.heappush(h, [next_w, next_y, next_x])
    return distance

while True:
    N = int(input())
    if N == 0:
        break
    cave = [[int(x) for x in sys.stdin.readline().split()] for y in range(N)]
    distance = dijkstra(N, cave)
    result = cave[0][0] + distance[N*N-1]
    print("Problem ", count, ": ", result, sep="")
    count += 1