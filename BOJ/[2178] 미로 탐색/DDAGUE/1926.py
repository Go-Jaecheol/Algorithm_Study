import sys
input = sys.stdin.readline

n, m = map(int, input().split())
p = [list(map(int, input().split())) for _ in range(n)]
c = [[0]*m for _ in range(n)]
count = 0
depth = 0
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def cal(x, y):
    k = 1
    queue = [(x, y)]
    while queue:
        x, y = queue.pop()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if p[nx][ny] == 1 and not c[nx][ny]:
                    k += 1
                    c[nx][ny] = 1
                    queue.append((nx, ny))
    return k

for i in range(n):
    for j in range(m):
        if p[i][j] == 1 and not c[i][j]:
            count += 1
            c[i][j] = 1
            depth = max(depth, cal(i, j))
print(count)
print(depth)