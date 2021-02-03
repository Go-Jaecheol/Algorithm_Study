N = int(input())
student = [int(input()) for x in range(N)]
dp = [1 for x in range(N)]

for i in range(N):
    for j in range(i):
        if(student[i] > student[j] and dp[j] >= dp[i]):
            dp[i] = dp[j] + 1
print(N-max(dp))