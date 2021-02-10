N, K = map(int, input().split())
product = [[int(x) for x in input().split()]for y in range(N)]
dp = [[0 for x in range(K+1)]for y in range(N+1)]

for i in range(1, N+1):
    row = i - 1
    for j in range(1, K+1):
        if j >= product[row][0]:
            dp[i][j] = max(dp[i-1][j], product[row][1] + dp[i-1][j-product[row][0]])
        else:
            dp[i][j] = dp[i-1][j]

print(dp[N][K])