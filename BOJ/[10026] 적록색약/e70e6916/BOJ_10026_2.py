from collections import deque

N = int(input())
picture = list(list(input()) for _ in range(N))
direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]  # 상, 하, 좌, 우


def bfs(row, col, is_blind):
    if visited[row][col] == 1:
        return 0
    visited[row][col] = 1

    queue = deque([(row, col)])
    while queue:
        i, j = queue.popleft()
        for d in direction:
            x, y = i + d[0], j + d[1]
            if 0 <= x < N and 0 <= y < N and visited[x][y] == 0:
                if picture[x][y] == picture[i][j]:
                    visited[x][y] = 1
                    queue.append((x, y))
                elif is_blind and picture[x][y] != 'B' and picture[i][j] != 'B':
                    visited[x][y] = 1
                    queue.append((x, y))
    return 1


visited = list([0] * N for _ in range(N))
notBlind = 0
for i in range(N):
    for j in range(N):
        notBlind += bfs(i, j, False)

visited = list([0] * N for _ in range(N))
blind = 0
for i in range(N):
    for j in range(N):
        blind += bfs(i, j, True)

print(notBlind, blind)