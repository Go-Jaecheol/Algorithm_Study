n = int(input())
A = [int(x) for x in input().split()]
dp = [1 for x in range(n)]

for i in range(n):
    for j in range(i):
        if (A[j] < A[i]) and (dp[j] >= dp[i]):
            dp[i] = dp[j] + 1
print(max(dp))