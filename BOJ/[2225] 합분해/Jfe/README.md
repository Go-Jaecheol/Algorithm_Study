# [2225] 합분해 - Python

## :mag: Algorithm
**Dynamic Programming**

## :computer: Logic
### `Bottom-up`
```Python
dp = [[1 for _ in range(K+1)] for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(2, K+1):
        dp[i][j] = dp[i-1][j] + dp[i][j-1]
print(dp[N][K] % 1000000000)
```

- dp[x][y] = dp[i-1][j] + dp[i][j-1]
  - 나열해서 규칙을 찾아보면 위와 같은 점화식을 찾을 수 있음  

## :memo: Review
처음에는 dp[i][j] = dp[k][y-1] ... k = 0 ~ x 까지의 합으로 표현하려고 했지만  
dp[i][j] = dp[i-1][j] + dp[i][j-1]  
이 점화식이 더 간단해서 이렇게 표현
