A = input()
B = input()
dp = [[0 for x in range(len(B))]for y in range(len(A))]

for i in range(len(A)):
    for j in range(len(B)):
        if(A[i] == B[j]):
            if (A[i] != A[i-1]):
                dp[i][j] = dp[i-1][j] + 1
            else:
                dp[i][j] = dp[i-1][j-1] + 1
        dp[i][j] = max(dp[i][j-1], dp[i][j], dp[i-1][j])
        
print(max(dp[len(A)-1]))