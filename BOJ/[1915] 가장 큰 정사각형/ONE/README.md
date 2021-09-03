# [1915] 가장 큰 정사각혛 - JAVA

## :black_circle: Algorithm
**Dynamic Programming**

## :black_circle: Logic

```Java
for(int i = 0; i < n; i ++){
    char[] input = scanner.next().toCharArray();
    for(int j = 0; j < m; j++){
        dp[i + 1][j + 1] = input[j] - '0';
        if(dp[i + 1][j + 1] != 0){
            int temp = Math.min(dp[i][j], dp[i][j + 1]);
            dp[i + 1][j + 1] = Math.min(temp, dp[i + 1][j]) + 1;
            result = Math.max(result, dp[i + 1][j + 1]);
        }
    }
}
```
입력을 받으면서 최대 변의 길이를 구하여 결과에 넓이 * 넓이를 출력한다.  
DP를 이용하여 1이라면 위와 왼쪽의 최솟값을 구하여 +1 하여 저장

## :black_circle: Review
DP를 오랜만에 풀어봐서 오래 걸렸던 문제.  
원래는 좀 더 복잡하게 생각했었으나 힌트를 참고하여 풀었다.