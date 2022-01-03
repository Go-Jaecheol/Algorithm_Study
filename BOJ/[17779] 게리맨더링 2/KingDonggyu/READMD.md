# [17779] 게리맨더링 2 - Python

## :mag: Algorithm

Simulation

BruteForce

## :round_pushpin: Logic

- 입력

  ```python
  import sys
  N = int(sys.stdin.readline())
  A = [False]+[[False]+[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
  ```

  - 가독성 높은 index 사용을 위해 선거구 인구 수의 입력에 대한 2차원 배열을 `(N+1)*(N+1)` 크기로 생성하여, row index가 0이거나 col index가 0인 값을 `false`로 지정한다.

<br />

- 첫번째 조건을 통한 인수 지정하기

  ```python
  population_diff = sys.maxsize
  for x in range(1, N+1):
      for y in range(1, N+1):
          for d1 in range(1, N+1):
              for d2 in range(1, N+1):
                  if 1 <= x < x+d1+d2 <= N and 1 <= y-d1 < y < y+d2 <= N:
                      population_diff = min(population_diff, set_area(x, y, d1, d2))
  ```

  - 문제에서 제시한 첫번째 조건을 위해 4중 반복문을 이용하며, 조건에 해당하는 `x`, `y`, `d1`, `d2` 를 각 선거구의 인구 수 합을 구하는 함수 `set_area` 를 위한 인수로 지정한다.

  - `set_area` 의 `return` 값(인구가 가장 많은 선거구와 가장 적은 선거구의 인구 차이)을 이용하여 `population_diff` 를 최소값으로 업데이트한다.

<br />

- 각 선거구의 인구 수 구하기

```python
def set_area(x, y, d1, d2):
    population_sum = [0] * 5
    check_five = [[False] * (N+1) for _ in range(N+1)]
    for i in range(0, d1+1): check_five[x+i][y-i] = True
    for i in range(1, d2+1): check_five[x+i][y+i] = True
    for i in range(1, d2+1): check_five[x+d1+i][y-d1+i] = True
    for i in range(1, d1+1): check_five[x+d2+i][y+d2-i] = True
    
    # 1번 선거구
    for r in range(1, x+d1):
        for c in range(1, y+1): 
            if check_five[r][c]: break
            population_sum[0] += A[r][c]
    # 2번 선거구
    for r in range(1, x+d2+1):
        for c in reversed(range(y+1, N+1)):
            if check_five[r][c]: break
            population_sum[1] += A[r][c]
    # 3번 선거구
    for r in range(x+d1, N+1):
        for c in range(1, y-d1+d2):
            if check_five[r][c]: break
            population_sum[2] += A[r][c]
    # 4번 선거구
    for r in range(x+d2+1, N+1):
        for c in reversed(range(y-d1+d2, N+1)):
            if check_five[r][c]: break
            population_sum[3] += A[r][c]
    # 5번 선거구
    population_sum[4] = population_total - sum(population_sum)

    return max(population_sum) - min(population_sum)
```

- 먼저, 문제에서 제시한 두번째 조건을 통한 반복문으로 경계선의 위치를 `true` 로 설정한 `check_five` 를 생성 및 설정한다.

- 문제에서 제시한 네번째 조건으로 1~4번 선거구의 인구 수를 2중 반복문을 통해 구한다. 

- 이때, 세번째 조건을 위해 해당 위치의 `check_five` 가 `true` 일 경우(경계선일 경우) `break` 한다. 이 때문에 2번, 4번 선거구의 인구 수를 구하기 위한 반복문 시 **역순으로 시행**한다.

- 마지막으로, 미리 구해놓은 `population_total` (모든 선거구의 합)에 `sum(population_sum)` (1~4번 선거구의 인구수 합)을 뺸 값을 5번 선거구의 인구수로 설정하여 `max(population_sum) - min(population_sum)` (인구가 가장 많은 선거구와 가장 적은 선거구의 인구 차이)를 `return` 한다.

## :memo: Review

문제에서 제시한 조건을 따라 로직을 구현하면 금방 해결할 수 있을거라 단언했지만 생각보다 꽤 오랜 시간이 소요되었다.

그 이유는 각 선거구의 인구수를 구하는 반복문 시, 2번째 조건을 위해 설정한 경계면에 위치했을 때 `break` 를 시행하는 것을 고려하여 **2번, 4번 선거구의 반복문을 역순으로 해야한다는 점**을 간과한 것이다.