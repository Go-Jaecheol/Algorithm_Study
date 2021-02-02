n = int(input())
A = [int(x) for x in input().split()]
dp = [1 for x in range(n)]

for i in range(n):
    for j in range(i):
        if(A[i] > A[j] and dp[j] >= dp[i]):
            dp[i] = dp[j] + 1
result = max(dp)
print(result)

tmp = [0 for x in range(result)]

for i in range(result, 0, -1):
    for j in range(n-1, -1, -1):
        if dp[j] == i:
            if i == result:
                tmp[i-1] = A[j]
            elif tmp[i] > A[j]:
                tmp[i-1] = A[j]

for i in range(result):
    print(tmp[i], end=' ')