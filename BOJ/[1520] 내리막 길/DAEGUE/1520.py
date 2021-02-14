import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

M, N = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(M)]
path = [[-1] * N for _ in range(M)]
px = [1, -1, 0, 0]
py = [0, 0, 1, -1]

def cal(x, y):
    if x == 0 and y == 0:
        return 1
    if path[x][y] == -1:
        path[x][y] = 0
        for i in range(4):
            nx = x + px[i]
            ny = y + py[i]
            if 0 <= nx < M and 0 <= ny < N:
                if map[x][y] < map[nx][ny]:
                    path[x][y] += cal(nx, ny)
    return path[x][y]

print(cal(M-1, N-1))