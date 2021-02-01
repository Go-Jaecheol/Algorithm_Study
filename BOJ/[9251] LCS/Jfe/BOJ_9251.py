A = input()
B = input()
dp = [[0 for x in range(len(B)+1)]for y in range(len(A)+1)]

for i in range(len(A)):
    row = i + 1
    for j in range(len(B)):
        col = j + 1
        if(A[i] == B[j]):
            dp[row][col] = dp[row-1][col-1] + 1
        else:
            dp[row][col] = max(dp[row][col-1], dp[row-1][col])
        
print(max(dp[len(A)]))