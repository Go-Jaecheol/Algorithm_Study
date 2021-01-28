# [11057] 오르막 수 - Python

## :mag: Algorithm
**Dynamic Programming**

## :computer: Logic
### `Bottom-up`

**dp[i][j]를 업데이트** 해주면서 오르막 수가 몇 개 있는지 체크  
(i : 오르막 수의 길이, j : 0~9 중 해당하는 숫자)

- **이전 라인**(i-1)에 **0 ~ j**에 해당하는  
**dp 값**`(dp[i-1][k]) (k : 0 ~ j)`을 더해서 **dp[i][j] 업데이트**
```Python
for i in range(1, n):
  for j in range(10):
    for k in range(j+1):
      dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007
```
각각 계산 과정마다 **오버플로우**가 발생하지 않도록  
문제에서 요구하는 것처럼 10007을 **MOD 연산**

## :memo: Review
`[10844] 쉬운 계단 수`랑 비슷한 문제

유형이 거의 비슷해서  
이전 문제를 정확히 이해했다면 어렵지 않게 풀 수 있는 문제였다.
