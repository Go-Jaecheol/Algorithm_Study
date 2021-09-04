# [17070] 파이프 옮기기 1 - Python

## :mag: Algorithm
**Dynamic Programming**

## :computer: Logic
### `Bottom-up`
```Python
house = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
dp = [[[0 for _ in range(3)] for _ in range(N)] for _ in range(N)]
dp[0][1][0] = 1

for i in range(N):
    for j in range(2, N):
        if house[i][j] == 0:
            dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2]
            dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2]
        if house[i][j] == 0 and house[i-1][j] == 0 and house[i][j-1] == 0:
            dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]   
print(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2])
```

- 파이프가 놓인 상태(**state**)마다 가능한 **경우의 수**를 dp[i][j][state]에 저장  
  - dp[i][j][state]에서 **state**는 `0: 가로, 1: 세로, 2: 대각선`  
  - **벽**이 없는 경우(`house[i][j] == 0`)에만 진행  
  - 대각선 상태에서는 옮기면서 걸리는 **벽** 상태도 생각 (`house[i-1][j] == 0 and house[i][j-1] == 0`)  
  - 각각 **state**마다 가능한 이전의 dp값을 더해서 해당 dp값에 저장  
  - 마지막 위치(N-1, N-1)에 해당하는 **모든 경우의 수** 더해서 출력  

## :memo: Review
처음에는 메모이제이션 배열에 상태를 저장하면서 해야되나 생각했지만  
그렇게 하면 의미가 없다는 것을 깨닫고 dp 리스트를 상태마다 저장할 수 있도록 3차원으로 늘리고  
dp 리스트 값으로 가능한 경우의 수들을 저장하는 방법으로 바꿨다.  

원하는 결과 값을 기준으로 천천히 생각해보면서 풀자,,
