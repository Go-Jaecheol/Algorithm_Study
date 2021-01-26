# [11053] 가장 긴 증가하는 부분 수열 - Python

## :mag: Algorithm
**Dynamic Programming**

## :computer: Logic
### `Bottom-up`

- `A[j] < A[i]`인 경우만 체크  
(i : 0 ~ n-1 , j: 0 ~ i-1)

- `dp[j] >= dp[i]`인 경우에만 **dp[i] 값 업데이트**  
(`dp[j] < dp[i]`인 경우는 ***ex. 20 10 30*** 인 케이스에서 ***10 < 30***처럼  
이전 dp[j] 값보다 현재 dp[j] 값이 같거나 작은 경우이기 때문에 **제외**해야 함)  
```Python
for i in range(n):
  for j in range(i):
    if (A[j] < A[i]) and (dp[j] >= dp[i]):
      dp[i] = dp[j] + 1
```

`dp[i]`에는 i번째 인덱스에 해당하는 숫자가 마지막이 되는 **부분 수열의 길이**에 대한 값이 들어감

## :memo: Review
이렇게 하면 시간복잡도가 O(n^2)이 된다.

이 문제는 다양한 방법이 있어서 비슷한 문제가 많다.

이 문제에서는 입력 크기가 크지 않아서 통과했지만  
비슷한 `[12015] 가장 긴 증가하는 부분 수열 2` 같은 문제를 풀 때는  
다른 방법을 생각해야 할 듯
