n = int(input())
dp = [[0 for x in range(10)]for y in range(n)]

for i in range(10):
    dp[0][i] = 1

for i in range(1, n):
    for j in range(10):
        for k in range(j+1):
            dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007

print(sum(dp[n-1])%10007)