N, K = map(int, input().split())
stuff = [list(map(int, input().split())) for _ in range(N)]
dp = list([0] * (K+1) for _ in range(N+1))

stuff.insert(0, [0, 0])
for i in range(1, N+1):
    for w in range(K + 1):
        if stuff[i][0] <= w:
            dp[i][w] = max(stuff[i][1] + dp[i - 1][w - stuff[i][0]], dp[i - 1][w])
        else:
            dp[i][w] = dp[i - 1][w]
print(dp[-1][-1])