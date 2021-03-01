from collections import deque

N = int(input())
picture = list(list(input()) for i in range(N))
copy_picture = [picture[i][:] for i in range(N)]
visited = [[0 for x in range(N)]for y in range(N)]
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
cnt = 0
color_weak = 0

def bfs(x, y, picture):
    que = deque()
    visited[y][x] = 1
    que.append((x, y))

    while que:
        x, y = que.popleft()
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if 0 <= next_x < N and 0 <= next_y < N and visited[next_y][next_x] == 0:
                if picture[next_y][next_x] == picture[y][x]:
                    visited[next_y][next_x] = 1
                    que.append((next_x, next_y))
for i in range(N):
    for j in range(N):
        if copy_picture[i][j] == 'G':
            copy_picture[i][j] = 'R'

for i in range(N):
    for j in range(N):
        if visited[i][j] == 0:
            bfs(j, i, picture)
            cnt += 1

visited = [[0 for x in range(N)]for y in range(N)]
for i in range(N):
    for j in range(N):
        if visited[i][j] == 0:
            bfs(j, i, copy_picture)
            color_weak += 1

print(cnt, color_weak)