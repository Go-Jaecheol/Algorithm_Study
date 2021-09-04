import sys
N = int(sys.stdin.readline())
num = [int(x) for x in sys.stdin.readline().split()]
dp = [[0 for _ in range(21)] for _ in range(N)]
dp[0][num[0]] = 1

for i in range(1, N-1):
    for j in range(21):
        if dp[i-1][j] != 0:
            sum = j + num[i]
            diff = j - num[i]
            if 0 <= sum <= 20:
                dp[i][sum] += dp[i-1][j]
            if 0 <= diff <= 20:
                dp[i][diff] += dp[i-1][j]
print(dp[N-2][num[N-1]])