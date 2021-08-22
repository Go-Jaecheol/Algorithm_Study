# [2096] 내려가기 - Python

## :mag: Algorithm
**Dynamic Programming**, **Sliding Window**

## :computer: Logic
### `Bottom-up`
```Python
max_dp = [0 for _ in range(3)]
min_dp = [0 for _ in range(3)]
max_temp = [0 for _ in range(3)]
min_temp = [0 for _ in range(3)]
```

- 최소한의 배열로 메모이제이션을 하기 위해 배열 선언  
  - 바로 전 dp 값의 최댓값과 최솟값은 `max_dp`, `min_dp`에 저장  
  - 새로운 dp 값의 최댓값과 최솟값은 `max_temp`, `min_temp`에 저장

```Python
for i in range(N):
    for j in range(3):
        if j == 0:
            max_temp[j] = max(max_dp[0], max_dp[1]) + num[i][j]
            min_temp[j] = min(min_dp[0], min_dp[1]) + num[i][j]
        elif j == 1:
            max_temp[j] = max(max_dp[0], max_dp[1], max_dp[2]) + num[i][j]
            min_temp[j] = min(min_dp[0], min_dp[1], min_dp[2]) + num[i][j]
        else:
            max_temp[j] = max(max_dp[1], max_dp[2]) + num[i][j]
            min_temp[j] = min(min_dp[1], min_dp[2]) + num[i][j]
    for k in range(3):
        max_dp[k] = max_temp[k]
        min_dp[k] = min_temp[k]
print(max(max_dp), min(min_dp))
```

- 문제 조건에 맞게 최댓값과 최솟값 계산
  - 이전 dp 값이 저장된 `max_dp`, `min_dp`의 각각 **max**와 **min**을 구해서 현재 `num`과 더해서 새로운 `max_temp`, `min_temp`에 저장  
  - 다음 루프로 넘어가기 전에 `max_dp`, `min_dp`의 값을 `max_temp`와 `min_temp`로 바꿈  
  - 루프가 끝나고 마지막에 저장된 `max_dp`, `min_dp`의 각각 **max**와 **min** 값이 정답  

## :memo: Review
```Python
import sys
N = int(sys.stdin.readline())
num = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
max_dp = [[0 for _ in range(3)] for _ in range(N)]
min_dp = [[0 for _ in range(3)] for _ in range(N)]

for i in range(N):
    for j in range(3):
        if i == 0:
            max_dp[i][j] = num[i][j]
            min_dp[i][j] = num[i][j]
        elif j == 0:
            max_dp[i][j] = max(max_dp[i-1][0], max_dp[i-1][1]) + num[i][j]
            min_dp[i][j] = min(min_dp[i-1][0], min_dp[i-1][1]) + num[i][j]
        elif j == 1:
            max_dp[i][j] = max(max_dp[i-1][0], max_dp[i-1][1], max_dp[i-1][2]) + num[i][j]
            min_dp[i][j] = min(min_dp[i-1][0], min_dp[i-1][1], min_dp[i-1][2]) + num[i][j]
        else:
            max_dp[i][j] = max(max_dp[i-1][1], max_dp[i-1][2]) + num[i][j]
            min_dp[i][j] = min(min_dp[i-1][1], min_dp[i-1][2]) + num[i][j]
print(max(max_dp[N-1]), min(min_dp[N-1]))
```

처음에는 평소 DP 문제 푸는 것처럼 위와 같이 쉽게 풀었지만  
문제에서 원하는 메모리 제한(4MB)에 적합하지 않아서 다른 방법을 생각해봤다.

그 과정에서 알게 된 알고리즘이 네트워크 관련 수업을 들었을 때도 들었던 **Sliding Window** 였다.  
이 알고리즘을 보고 다시 문제를 보니 굳이 N줄의 배열을 만들 필요 없이 현재 라인과 이전 라인,  
이렇게 2줄의 배열만 있어도 된다는 것을 알게 되었고 다음과 같이 코드를 변경했다.

---

```Python
import sys
N = int(sys.stdin.readline())
num = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
max_dp = [0 for _ in range(3)]
min_dp = [0 for _ in range(3)]
max_temp = [0 for _ in range(3)]
min_temp = [0 for _ in range(3)]

for i in range(N):
    for j in range(3):
        if j == 0:
            max_temp[j] = max(max_dp[0], max_dp[1]) + num[i][j]
            min_temp[j] = min(min_dp[0], min_dp[1]) + num[i][j]
        elif j == 1:
            max_temp[j] = max(max_dp[0], max_dp[1], max_dp[2]) + num[i][j]
            min_temp[j] = min(min_dp[0], min_dp[1], min_dp[2]) + num[i][j]
        else:
            max_temp[j] = max(max_dp[1], max_dp[2]) + num[i][j]
            min_temp[j] = min(min_dp[1], min_dp[2]) + num[i][j]
    for k in range(3):
        max_dp[k] = max_temp[k]
        min_dp[k] = min_temp[k]
print(max(max_dp), min(min_dp))
```
