from collections import deque

N, M = map(int, input().split())
maze = [list(map(int, input())) for _ in range(N)]
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]


def bfs():
    queue = deque([(0, 0, 0)])
    while queue:
        i, j, cnt = queue.popleft()
        if not 0 <= i < N or not 0 <= j < M or maze[i][j] != 1:
            continue
        maze[i][j] = maze[i][j] + cnt
        cnt += 1
        for k in range(4):
            queue.append((i + dy[k], j + dx[k], cnt))


bfs()
print(maze[-1][-1])
