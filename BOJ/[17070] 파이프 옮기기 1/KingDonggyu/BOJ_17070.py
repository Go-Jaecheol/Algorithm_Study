import sys
N = int(sys.stdin.readline())
home = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
dp = [[[0] * 3 for _ in range(N)] for _ in range(N)]  # 0: 가로, 1: 세로, 2: 대각선

dp[0][1][0] = 1
for i in range(N):
    for j in range(2, N):
        if home[i][j] == 0:
            dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2]
            dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2]
            if home[i-1][j] == 0 and home[i][j-1] == 0:
                dp[i][j][2] = sum(dp[i-1][j-1])
print(sum(dp[-1][-1]))
