# [2631] 줄세우기 - Python

## :mag: Algorithm
**Dynamic Programming**

## :computer: Logic
### `Bottom-up`

- **LIS를 구하고** 구한 값을 전체 **학생 수 N에서 뺀 값**이 구하고자 하는 **최소 수**이다.  
*(LIS를 구하는 방법은 `[11053] 가장 긴 증가하는 부분 수열` 문제와 동일)*

```Python
for i in range(N):
  for j in range(i):
    if(student[i] > student[j] and dp[j] >= dp[i]):
      dp[i] = dp[j] + 1
print(N-max(dp))
```

## :memo: Review
처음에는 어떤 규칙인지 찾는 데 고민을 많이 하다가  
오름차순으로 정렬되어 있는 부분 수열은 안건드려도 된다는 걸 알았고  

오름차순인 부분 수열이 여러 개 있으면  
어차피 제일 큰 수열을 제외하고는 다 옮겨야 된다는 것도 알게 되어서

LIS만 구해서 바로 풀었다.  
규칙만 찾으면 쉬운데 규칙 찾는게 아직 시간이 걸리는듯..
