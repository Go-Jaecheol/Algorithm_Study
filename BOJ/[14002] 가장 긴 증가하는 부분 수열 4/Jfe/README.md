# [14002] 가장 긴 증가하는 부분 수열 4 - Python

## :mag: Algorithm
**Dynamic Programming**

## :computer: Logic
### `Bottom-up`

- LIS의 길이를 출력하는 부분은  
`[11053] 가장 긴 증가하는 부분 수열` 문제 풀이랑 같음
```Python
for i in range(n):
  for j in range(i):
    if (A[j] < A[i]) and (dp[j] >= dp[i]):
      dp[i] = dp[j] + 1
```

- LIS를 출력하는 방법은  
**LIS의 길이**`(result)`만큼의 **tmp**라는 배열을 만들고  
**dp 값이 i와 같을 때** (이 때 ***i = result ~ 1***)  
`tmp[i-1]`에 `A[j]`를 넣어준다. ***(j = dp와 i가 같을 때 dp[j]의 인덱스 값)*** 

이 과정에서 바로 한 단계 위의 tmp[i] 값이 해당 A[j]보다 **작거나 같으면 안되기 때문에**  
`tmp[i] > A[j]`라는 조건에 해당할 때만  
`tmp[i-1] = A[j]`를 하도록 한다.

또한 위의 조건에서 `i == result`인 경우에는  
배열 인덱스가 맞지 않기 때문에 **예외 처리**해준다.

- 위의 조건을 코드로 나타내면 아래와 같다.  
```Python
for i in range(result, 0, -1):
  for j in range(n-1, -1, -1):
    if dp[j] == i:
      if i == result:
        tmp[i-1] = A[j]
      elif tmp[i] > A[j]:
        tmp[i-1] = A[j]
```

## :memo: Review
`[11053] 가장 긴 증가하는 부분 수열` 문제의 심화 버전이다.  

처음에는 수열을 출력할 때  
앞에서부터 출력하려고 해서 자꾸 틀렸는데  
생각을 바꿔서 뒤에서 부터 배열에 따로 저장하고  
마지막에 출력하도록 바꾸니 바로 해결됐다.

이 과정은 Top-down으로 하는게 편할거 같긴 한데  
Bottom-up에 익숙해져서 걸리는 시간은 비슷할듯ㅎ,,

코드 깔끔하게 짜고 싶었는데  
이건 천천히 노력해봐야지...
