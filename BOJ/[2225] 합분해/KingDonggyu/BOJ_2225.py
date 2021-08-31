N, K = map(int, input().split())
dp = [1] * (N+1)

for _ in range(K-1):
    for i in range(1, N+1):
        dp[i] += dp[i-1]

print(dp[N]%1000000000)
