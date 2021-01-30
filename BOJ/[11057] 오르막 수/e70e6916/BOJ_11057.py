N = int(input())
dp = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]

for _ in range(N-1):
    for i in range(10):
        temp = 0
        for j in range(i, 10):
            temp += dp[j]
        dp[i] = temp
print(sum(dp) % 10007)
