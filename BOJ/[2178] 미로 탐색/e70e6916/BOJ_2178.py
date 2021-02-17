from collections import deque

N, M = list(map(int, input().split()))
maze = list(list(map(int, input())) for _ in range(N))
route = list([0] * M for _ in range(N))
direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]

route[0][0] = 1
queue = deque([(0, 0)])
while queue:
    i, j = queue.popleft()
    for d in direction:
        x, y = i + d[0], j + d[1]
        if 0 <= x < N and 0 <= y < M and route[x][y] == 0 and maze[x][y] == 1:
            route[x][y] = route[i][j] + 1
            queue.append((x, y))

print(route[-1][-1])