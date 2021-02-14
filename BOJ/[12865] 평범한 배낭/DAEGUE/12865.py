import sys

N, K = map(int, sys.stdin.readline().split(" "))
dp = [[0 for _ in range(K+1)] for _ in range(N+1)]
items = []
for _ in range(N):
    w, v = map(int, sys.stdin.readline().split(" "))
    items.append([w,v])

for i in range(1,N+1):
    for j in range(1,K+1):
        if items[i-1][0] <= j:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-items[i-1][0]] + items[i-1][1])
        else:
            dp[i][j] = dp[i-1][j]

print(dp[N][K])