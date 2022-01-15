import sys
N = int(input())
Map = [[int(i) for i in sys.stdin.readline().split()] for _ in range(N)]


def scatter_sand(x, y, current_sand, d): 
    global total_sand
    for dx, dy, ratio in direction[d]:
        if ratio == 0:
            sand = Map[x][y]
            Map[x][y] = 0
        else:
            sand = int(ratio * current_sand)
            Map[x][y] -= sand

        next_x, next_y = x + dx, y + dy
        if 0 <= next_x < N and 0 <= next_y < N:
            Map[next_x][next_y] += sand
        else: total_sand += sand


left = [(1, 1, 0.01), (-1, 1, 0.01), (2, 0, 0.02), (-2, 0, 0.02), (1, 0, 0.07),
        (-1, 0, 0.07), (1, -1, 0.1), (-1, -1, 0.1), (0, -2, 0.05), (0, -1, 0)]
down = [(-y, x, z) for x, y, z in left]
right = [(x, -y, z) for x, y, z in left]
up = [(y, x, z) for x, y, z in left]

direction = [left, down, right, up]
dx = [0, 1, 0, -1]; dy = [-1, 0, 1, 0]

x, y = N//2, N//2
total_sand = 0
cnt = 1

while cnt:
    for d in range(4):
        if d == 2: cnt += 1
        for _ in range(cnt):
            x += dx[d]; y += dy[d]
            scatter_sand(x, y, Map[x][y] , d)
        if x == 0 and y == 0:
            cnt = 0; break
 
    if x != 0 and y != N-1: cnt += 1

print(total_sand)