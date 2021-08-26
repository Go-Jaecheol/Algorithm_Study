# [1915] 가장 큰 정사각형 - Python

## :mag: Algorithm
**Dynamic Programming**

## :computer: Logic
### `Bottom-up`
```Python
for i in range(n):
    for j in range(m):
        if i-1 < 0 or j-1 < 0:
            dp[i][j] = arr[i][j]
        else:
            if arr[i][j] == 1:
                dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
length = max(map(max, dp))
print(length*length)
```

- dp[x][y] = x, y좌표를 맨 오른쪽 꼭짓점으로 하는 정사각형의 길이  
  - i or j가 0인 경우에는 arr 좌표 값 그대로 dp에 저장  
  - arr 좌표 값이 0인 경우에는 1로 된 정사각형이 아니기 때문에 저장 X  
  - 좌표 값이 1인 경우에는 해당 좌표 기준 바로 왼쪽, 위, 대각선 위의 dp 값들 중 `최솟값+1`을 저장  

## :memo: Review
오랜만에 풀었던 DP 문제여서 쉽게 풀지 못하고  
힌트를 참고해서 풀었다...  
점화식 찾는 것부터 전체적으로 감을 다시 찾아야겠다,,
