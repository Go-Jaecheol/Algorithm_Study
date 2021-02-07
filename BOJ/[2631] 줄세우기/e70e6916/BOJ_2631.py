N = int(input())
child = [int(input()) for _ in range(N)]
dp = [1] * N
for i in range(N):
    for j in reversed(range(i)):
        if child[i] > child[j] and dp[i] <= dp[j]:
            dp[i] = dp[j] + 1
print(N - max(dp))