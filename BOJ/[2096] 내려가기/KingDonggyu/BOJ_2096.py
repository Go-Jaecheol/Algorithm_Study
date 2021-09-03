import sys
N = int(sys.stdin.readline())
max_dp, min_dp = [0] * 3, [0] * 3
max_temp, min_temp = [0] * 3, [0] * 3

for _ in range(N):
    x, y, z = map(int, sys.stdin.readline().split())
    for i in range(3):
        if i == 0:
            max_temp[0] = max(max_dp[0], max_dp[1]) + x
            min_temp[0] = min(min_dp[0], min_dp[1]) + x
        elif i == 2:
            max_temp[2] = max(max_dp[1], max_dp[2]) + z
            min_temp[2] = min(min_dp[1], min_dp[2]) + z
        else:
            max_temp[1] = max(max_dp[0], max_dp[1], max_dp[2]) + y
            min_temp[1] = min(min_dp[0], min_dp[1], min_dp[2]) + y
    max_dp, min_dp = list(max_temp), list(min_temp)
print(max(max_dp), min(min_dp))
