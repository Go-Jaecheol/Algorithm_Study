import sys
N = int(sys.stdin.readline())
house = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
dp = [[[0 for _ in range(3)] for _ in range(N)] for _ in range(N)]
dp[0][1][0] = 1

for i in range(N):
    for j in range(2, N):
        if house[i][j] == 0:
            dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2]
            dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2]
        if house[i][j] == 0 and house[i-1][j] == 0 and house[i][j-1] == 0:
            dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]   
print(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2])