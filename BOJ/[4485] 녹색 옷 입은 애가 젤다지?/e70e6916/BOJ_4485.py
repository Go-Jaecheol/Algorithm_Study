import sys, heapq
problem = 1
INF = sys.maxsize
direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]

while True:
    N = int(input())
    if N == 0: break
      
    cave = list(list(map(int, sys.stdin.readline().split())) for _ in range(N))
    SP = list([INF] * N for _ in range(N))
    SP[0][0] = cave[0][0]
    queue = [(cave[0][0], (0, 0))]

    while queue:
        current_rupee, (current_x, current_y) = heapq.heappop(queue)
        if current_x == N-1 and current_y == N-1: break
        if SP[current_x][current_y] < current_rupee: continue
        for d in direction:
            x, y = current_x + d[0], current_y + d[1]
            if 0 <= x < N and 0 <= y < N:
                rupee = current_rupee + cave[x][y]
                if rupee < SP[x][y]:
                    SP[x][y] = rupee
                    heapq.heappush(queue, (rupee, (x, y)))
    
    print('Problem ', problem, ': ', SP[-1][-1], sep='')
    problem += 1
