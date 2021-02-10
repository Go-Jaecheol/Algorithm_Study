# [12865] 평범한 배낭 - Python

## :mag: Algorithm
**Dynamic Programming**

## :computer: Logic
### `Bottom-up`

- 1번째 물건부터 N번째 물건까지 보면서  
`dp[i][j]`에 **i번째 물건**까지 봤을 때 **j만큼의 무게**까지 넣을 수 있는  
**가치의 최댓값**을 저장한다.  
*(i : 1 ~ N, j: 1 ~ K)*  
(**i**는 살펴볼 물건의 **인덱스**를 의미하고, **j**는 가방이 버틸 수 있는 **무게**를 의미)

- 이 때 dp에 저장할 가치의 **최댓값을 구하는 방법**은  
가방 무게 j가 현재 보고 있는 물건의 무게보다 **크거나 같으면**  
`(j >= product[row][0])`  
**바로 위의 dp값**`(dp[i-1][j])`과 **현재 물건+j에서 현재 물건의 무게를 뺀 이전 dp값**`(product[row][1] + dp[i-1][j-product[row][0]])`  
중에서 **최댓값**을 구해서 dp에 저장한다.
```Python
if j >= product[row][0]:
  dp[i][j] = max(dp[i-1][j], product[row][1] + dp[i-1][j-product[row][0]])
```

- 가방 무게 j가 현재 보고 있는 물건의 무게보다 **작으면**  
**바로 위의 dp값**`(dp[i-1][j])`으로 dp에 저장한다.
```Python
else:
  dp[i][j] = dp[i-1][j]
```

- 위의 모든 조건을 코드로 나타내면 아래와 같다.  
```Python
for i in range(1, N+1):
  row = i - 1
  for j in range(1, K+1):
    if j >= product[row][0]:
      dp[i][j] = max(dp[i-1][j], product[row][1] + dp[i-1][j-product[row][0]])
    else:
      dp[i][j] = dp[i-1][j]
```

## :memo: Review
대표적인 **냅색 문제**다.

어떻게 접근해야 되는지 처음에 많이 헤맸는데  
직접 어떻게 되는지 그려보고 디버깅 하면서  
점화식을 구할 수 있었다.

다른 DP 문제들처럼 생각하면 됐었는데  
모든 물건들을 한번에 다 보고 하려고 했던게  
시간을 많이 잡아먹은거 같다,,,
