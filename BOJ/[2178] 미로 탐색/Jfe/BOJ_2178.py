from collections import deque
n, m = map(int, input().split())
maze = [[int(x) for x in input()]for y in range(n)]
visited = [[0 for x in range(m)]for y in range(n)]
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y, result):
    que = deque()
    visited[y][x] = 1
    que.append((x, y, result))

    while que:
        x, y, result = que.popleft()
        if (x, y) == (m-1, n-1):
            print(result)
            return
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if 0 <= next_x < m and 0 <= next_y < n:
                if maze[next_y][next_x] and visited[next_y][next_x] == 0:
                    next_result = result + 1
                    visited[next_y][next_x] = 1
                    que.append((next_x, next_y, next_result))

bfs(0, 0, 1)