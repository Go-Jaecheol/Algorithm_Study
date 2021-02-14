M, N = map(int, input().split())
_map = list(list(map(int, input().split())) for _ in range(M))
move = list([-1] * N for _ in range(M))
direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def search_route(i, j):
    if move[i][j] > 0:
        return

    move[i][j] = 0
    for d in direction:
        x, y = i + d[0], j + d[1]
        if 0 <= x < M and 0 <= y < N and _map[i][j] < _map[x][y]:
            if move[x][y] == -1:
                search_route(x, y)
            move[i][j] += move[x][y]

move[0][0] = 1
for i in range(0, M):
    for j in range(0, N):
        search_route(i, j)
print(move[-1][-1])