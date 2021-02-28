from collections import deque

N = int(input())
picture = list(list(input()) for _ in range(N))
visited = list([-1] * N for _ in range(N))  # -1: 방문x, 0: 적록, 1: 방문o
direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]  # 상, 하, 좌, 우


def bfs(row, col):
    check_rg = True
    if visited[row][col] == 1:
        return
    elif visited[row][col] == 0:
        check_rg = False
    visited[row][col] = 1

    queue = deque([(row, col)])
    while queue:
        i, j = queue.popleft()
        for d in direction:
            x, y = i + d[0], j + d[1]
            if 0 <= x < N and 0 <= y < N and visited[x][y] < 1:
                if picture[x][y] == picture[i][j]:
                    if visited[x][y] == 0:
                        check_rg = False
                    visited[x][y] = 1
                    queue.append((x, y))
                elif visited[x][y] == -1 and picture[i][j] != 'B' and picture[x][y] != 'B':
                    visited[x][y] = 0

    global blind
    global notBlind
    if check_rg: blind += 1
    notBlind += 1


blind = 0
notBlind = 0
for i in range(N):
    for j in range(N):
        bfs(i, j)
print(notBlind, blind)