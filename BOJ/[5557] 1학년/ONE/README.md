# [5557] 1학년 - JAVA

## :black_circle: Algorithm
**Dynamic Programming**

## :black_circle: Logic

```Java
    private static long operation(int idx, int sum){
        if(sum < 0 || sum > 20)
            return 0;

        if(idx == N - 2){
            if(sum == arr[N - 1])
                return 1;
            return 0;
        }

        if(dp[idx][sum] != -1)
            return dp[idx][sum];

        dp[idx][sum] = 0;

        return dp[idx][sum] += operation(idx + 1, sum + arr[idx + 1]) + operation(idx + 1, sum - arr[idx + 1]);
    }
```

수식의 과정에서 음수일 경우와 20이 넘는 경우를 제외하고,  
덧셈의 경우와 뺄셈의 경우의 수를 더한다

## :black_circle: Review
조건만 생각해서 넣으면 됐었던 문제