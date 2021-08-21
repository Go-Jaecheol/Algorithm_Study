import sys
n, m = map(int, sys.stdin.readline().split())
arr = [[int(x) for x in input()] for _ in range(n)]
dp = [[0 for _ in range(m)] for _ in range(n)]

for i in range(n):
    for j in range(m):
        if i-1 < 0 or j-1 < 0:
            dp[i][j] = arr[i][j]
        else:
            if arr[i][j] == 1:
                dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
length = max(map(max, dp))
print(length*length)