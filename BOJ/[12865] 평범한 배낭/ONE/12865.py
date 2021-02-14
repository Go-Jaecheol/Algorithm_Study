N, K = map(int, input().split())
things = [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * (K + 1) for _ in range(N + 1)]
things.insert(0, [0, 0]) # +1 한 길이를 맞추기위해 물건 인덱스에 빈 값 추가
for i in range(1, N + 1):
    for j in range(1, K + 1):
        if j >= things[i][0]:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j - things[i][0]] + things[i][1])
        else:
            dp[i][j] = dp[i-1][j]
print(dp[N][K])
