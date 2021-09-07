# [5557] 1학년 - Python

## :mag: Algorithm
**Dynamic Programming**

## :computer: Logic
### `Bottom-up`
```Python
num = [int(x) for x in sys.stdin.readline().split()]
dp = [[0 for _ in range(21)] for _ in range(N)]
dp[0][num[0]] = 1

for i in range(1, N-1):
    for j in range(21):
        if dp[i-1][j] != 0:
            sum = j + num[i]
            diff = j - num[i]
            if 0 <= sum <= 20:
                dp[i][sum] += dp[i-1][j]
            if 0 <= diff <= 20:
                dp[i][diff] += dp[i-1][j]
print(dp[N-2][num[N-1]])
```

- 인덱스마다 계산 결과(sum, diff)를 보고 해당 `dp[i][sum or diff]` 업데이트  
  - dp[i][sum or diff]에서 **sum, diff**는 `sum: + 계산 결과, diff: - 계산 결과`  
  - 문제 조건에 맞게 **0 이상 20이하**인 경우에만 진행  
  - 등식 마지막 수(`num[N-1]`)에 해당하는 `dp[N-2][num[N-1]]` 값 출력  

## :memo: Review
+, - 갈림길 둘 중에서 하나를 고르면서 생기는 경우의 수를 생각하면서 풀려고 했는데  
아무리 봐도 아닌 것 같아서 접근 방법을 바꿨다.

이차원 리스트에서 두번째 인덱스를 어떻게 놓고 풀까 생각하다가  
시간이 조금 걸렸던 것 같다ㅜ
