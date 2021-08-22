import sys
N = int(sys.stdin.readline())
num = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
max_dp = [0 for _ in range(3)]
min_dp = [0 for _ in range(3)]
max_temp = [0 for _ in range(3)]
min_temp = [0 for _ in range(3)]

for i in range(N):
    for j in range(3):
        if j == 0:
            max_temp[j] = max(max_dp[0], max_dp[1]) + num[i][j]
            min_temp[j] = min(min_dp[0], min_dp[1]) + num[i][j]
        elif j == 1:
            max_temp[j] = max(max_dp[0], max_dp[1], max_dp[2]) + num[i][j]
            min_temp[j] = min(min_dp[0], min_dp[1], min_dp[2]) + num[i][j]
        else:
            max_temp[j] = max(max_dp[1], max_dp[2]) + num[i][j]
            min_temp[j] = min(min_dp[1], min_dp[2]) + num[i][j]
    for k in range(3):
        max_dp[k] = max_temp[k]
        min_dp[k] = min_temp[k]
print(max(max_dp), min(min_dp))