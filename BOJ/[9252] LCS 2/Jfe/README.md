# [9252] LCS 2 - Python

## :mag: Algorithm
**Dynamic Programming**

## :computer: Logic
### `Bottom-up`

- **LCS 길이를 출력하는 부분**은  
`[9251] LCS` 문제 풀이랑 같음
```Python
for i in range(len(A)):
  row = i + 1
  for j in range(len(B)):
    col = j + 1
    if(A[i] == B[j]):
      dp[row][col] = dp[row-1][col-1] + 1
    else:
      dp[row][col] = max(dp[row][col-1], dp[row-1][col])
```

- **LCS를 출력하는 방법**은  
**dp**처럼 **result**라는 문자열을 저장할 배열을 만들고  
LCS 길이를 구할 때처럼 같은 방법으로 배열에 저장을 한다.  
**max 값을 구할 때**는 **dp 값을 비교한 다음**, result 값을 저장해야 하기 때문에
아래처럼 **삼항연산자**를 사용했다.
```Python
result[row][col] = result[row][col-1] if dp[row][col-1] >= dp[row-1][col] else result[row-1][col]
```

- 위의 모든 조건을 코드로 나타내면 아래와 같다.  
```Python
for i in range(len(A)):
  row = i + 1
  for j in range(len(B)):
    col = j + 1
    if(A[i] == B[j]):
      dp[row][col] = dp[row-1][col-1] + 1
      result[row][col] = result[row-1][col-1] + B[j]
    else:
      dp[row][col] = max(dp[row][col-1], dp[row-1][col])
      result[row][col] = result[row][col-1] if dp[row][col-1] >= dp[row-1][col] else result[row-1][col]
```

## :memo: Review
`[9251] LCS` 문제의 심화 버전이다.  

처음에는 저장된 dp 값을 역추적해서  
해당되는 문자들을 출력하는 방식으로 하려고 했는데  
반례를 찾기가 힘들어서 

아예 다른 방식으로 다시 접근했다.
