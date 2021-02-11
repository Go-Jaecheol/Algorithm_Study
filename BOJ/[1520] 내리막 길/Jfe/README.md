# [1520] 내리막 길 - Python

## :mag: Algorithm
**Dynamic Programming**, **DFS**

## :computer: Logic
### `Top-down`

- **dfs 알고리즘** 이용

- `dp[y][x]`는 처음 한번 방문하면 ***0***으로 초기화  
한번도 방문 안하면 ***-1***

- **next_x, next_y** 값을 **dx, dy** 값과 더하면서  
해당 위치에서 **상하좌우** 전부 확인

- **next_x, next_y**가 **범위에 해당**하는지 확인하고  
```Python
if 0 <= next_x < N and 0 <= next_y < M
```

- **다음 위치**가 **현재 위치**보다 **작으면**  
dfs에 next_x, next_y 값을 인자로 넘겨서 **재귀**하고  
**반환 값**을 `dp[y][x]`에 더해줌  
```Python
dp[y][x] = dp[y][x] + dfs(next_x, next_y)
```

- x, y 값이 **마지막 위치(N-1, M-1)**에 도착하면  
***1***을 반환해서 **그 전 dp[y][x] 값**에 더할 수 있도록 함

- **상하좌우를 다 확인한 경우**에  
`dp[y][x]` 값을 반환

- **한번이라도 방문한 경우** (`dp[y][x] > -1`)에는  
`dp[y][x]` 값을 반환

- 전부 살펴본 다음에는 `dp[0][0]`에 가능한 **경로의 개수**가 저장되어 있음

- 위의 모든 조건을 코드로 나타내면 아래와 같다.  
```Python
def dfs(x, y):
  if x == N-1 and y == M-1:
    return 1
  elif dp[y][x] > -1:
    return dp[y][x]
  else:
    dp[y][x] = 0
    for i in range(4):
      next_x = x + dx[i]
      next_y = y + dy[i]
      if 0 <= next_x < N and 0 <= next_y < M:
        if location[y][x] > location[next_y][next_x]:
          dp[y][x] = dp[y][x] + dfs(next_x, next_y)
    return dp[y][x]
```

## :memo: Review
그래프 문제를 거의 안 풀어봐서  
dfs도 어떻게 해야되는지 헷갈려서  
예전 테트로미노 문제도 다시 봤다..

이전 DP 문제들처럼 Bottom-up으로 풀려고 했는데  
dfs를 사용해야 돼서 그냥 Top-down으로 풀었다.

dp 배열을 처음에 0으로 초기화하고  
방문하면 + 해주는 방식으로 했는데 시간초과가 나서  
방문 안하면 -1, 일단 방문만 하면 0, 길이 있으면 + 해주는 방식으로 바꿨다.  

DP 문제만 계속 풀어서 그런지  
그래프 섞이니까 감을 못잡겠다,,,  
다음주는 그래프로 ㄱ

