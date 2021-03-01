from collections import deque
n = int(input())
picture = []
copy = [[0] * n for i in range(n)]
cnt = 0
cntt = 0
for i in range(n):
    picture.append(list(map(str, input())))
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(i, j, v, arr):
    que = deque()
    que.append((i,j))
    arr[i][j] = 0
    while que:
        a, b = que.popleft()
        for k in range(4):
            x = a + dx[k]
            y = b + dy[k]
            if 0 <= x < n and 0 <= y < n and arr[x][y] == v:
                que.append((x, y))
                arr[x][y] = 0

for i in range(n):
    for j in range(n):
        if picture[i][j] == "R" or picture[i][j] == "G":
            copy[i][j] = 1
        else:
            copy[i][j] = 2
for i in range(n):
    for j in range(n):
        if picture[i][j] != 0:
            bfs(i, j, picture[i][j], picture)
            cnt += 1
        if copy[i][j] != 0:
            bfs(i, j, copy[i][j], copy)
            cntt += 1
print(cnt, cntt)