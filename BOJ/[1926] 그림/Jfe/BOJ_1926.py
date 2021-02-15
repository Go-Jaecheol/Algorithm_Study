import sys
sys.setrecursionlimit(10**8)

n, m = map(int, input().split())
paper = [[int(x) for x in input().split()]for y in range(n)]
visited = [[0 for x in range(m)]for y in range(n)]
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
count = 0
max_result = 0

def dfs(y, x, area):
    visited[y][x] = True
    area += 1
    for i in range(4):
        next_x = x + dx[i]
        next_y = y + dy[i]
        if (0 <= next_x < m) and (0 <= next_y < n):
            if paper[next_y][next_x] and visited[next_y][next_x]==0:
                area = dfs(next_y, next_x, area)
    return area

for i in range(n):
    for j in range(m):
        if paper[i][j] and visited[i][j]==0:
            max_result = max(max_result, dfs(i, j, 0))
            count += 1
print(count)
print(max_result)