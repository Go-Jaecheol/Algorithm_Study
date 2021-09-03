# [2225] 합분해 - JAVA

## :black_circle: Algorithm
**Dynamic Programming**

## :black_circle: Logic

```Java
for(int i = 1; i <= K; i++){
    dp[i][0] = 1;
}

for(int i = 1; i <= K; i++)
    for(int j = 1; j <= N; j++)
        dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
```

DP[i][j] = DP[i][j - 1] + DP[i - 1][j]  
점화식을 구해서 간단히 풀 수 있다

## :black_circle: Review
점화식만 구하면 쉽게 풀었던 문제