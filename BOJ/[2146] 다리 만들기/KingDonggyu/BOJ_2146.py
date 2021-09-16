import sys
from collections import deque
input = sys.stdin.readline


def find_island(start_x, start_y):
    queue = deque([(start_x, start_y)])
    visited[start_x][start_y] = 1
    while queue:
        i, j = queue.popleft()
        for d in direction:
            x, y = i + d[0], j + d[1]
            if 0 <= x < N and 0 <= y < N:
                if visited[x][y] == 0 and land[x][y] == 1:
                    queue.append((x, y))
                    visited[x][y] = 1
                elif land[x][y] == 0:
                    land[i][j] = island_id


def find_bridge(id):
    global bridge
    queue = deque()
    for i in range(N):
        for j in range(N):
            if land[i][j] == id: queue.append((i, j))
    visited = [[0] * N for _ in range(N)]
    while queue:
        i, j = queue.popleft()
        for d in direction:
            x, y = i + d[0], j + d[1]
            if 0 <= x < N and 0 <= y < N:
                if land[x][y] == 0 and visited[x][y] == 0:
                        visited[x][y] = visited[i][j] + 1
                        queue.append((x, y))
                elif land[x][y] > 1 and land[x][y] != id:
                    bridge = min(bridge, visited[i][j])
                    return


N = int(input())
land = [[int(x) for x in input().split()] for _ in range(N)]
visited = [[0] * N for _ in range(N)]
direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # 상, 하, 좌, 우

island_id = 2
for i in range(N):
    for j in range(N):
        if land[i][j] == 1 and visited[i][j] == 0:
            find_island(i, j)
            island_id += 1

bridge = sys.maxsize
for i in range(2, island_id):
    find_bridge(i)
print(bridge)
