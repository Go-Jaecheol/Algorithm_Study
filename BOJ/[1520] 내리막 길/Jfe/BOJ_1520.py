import sys
sys.setrecursionlimit(10**8)

M, N = map(int, input().split())
location = [[int(x) for x in input().split()]for y in range(M)]
dp = [[-1 for x in range(N)]for y in range(M)]
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def dfs(x, y):
    if x == N-1 and y == M-1:
        return 1
    elif dp[y][x] > -1:
        return dp[y][x]
    else:
        dp[y][x] = 0
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if 0 <= next_x < N and 0 <= next_y < M:
                if location[y][x] > location[next_y][next_x]:
                    dp[y][x] = dp[y][x] + dfs(next_x, next_y)
        return dp[y][x]

dfs(0, 0)
print(dp[0][0])