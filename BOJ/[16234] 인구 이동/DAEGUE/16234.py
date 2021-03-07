import sys
input = sys.stdin.readline

def dfs(start):
    sy, sx = start
    union[sy][sx] = num
    sum_list[num][0] += F_list[sy][sx]
    sum_list[num][1] += 1
    for i in range(4):
        ny = sy + dy[i]
        nx = sx + dx[i]
        if 0 <= ny < N and 0 <= nx < N:
            if not union[ny][nx]:
                if L <= abs(F_list[ny][nx] - F_list[sy][sx]) <= R:
                    dfs((ny, nx))

def move():
    for i in range(N):
        for j in range(N):
            F_list[i][j] = sum_list[union[i][j]][0] // sum_list[union[i][j]][1]

N, L, R = map(int, input().split())
F_list = []
for _ in range(N):
    row = list(map(int, input().split()))
    F_list.append(row)
count = 0
dx = [1, -1, 0 ,0]
dy = [0, 0, 1, -1]

while True:
    num = 1
    union = [[0] * N for _ in range(N)]
    sum_list = [[0, 0] for _ in range(N**2+1)]
    for i in range(N):
        for j in range(N):
            if not union[i][j]:
                dfs((i, j))
                num += 1
    if union[-1][-1] == N**2:
        break
    move()
    count += 1
print(count)