n, m = map(int, input().split())
arr = list(list(map(int, input())) for _ in range(n))
dp = [[0] * m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if arr[i][j] == 1:
            if i == 0 or m == 0:
                dp[i][j] = arr[i][j]
            else:
                dp[i][j] = min(dp[i-1][j-1], dp[i-1][j],
                               dp[i][j-1]) + arr[i][j]

size = max(map(max, dp))
print(size*size)
