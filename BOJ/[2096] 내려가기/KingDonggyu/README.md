# [2096] 내려가기 - Python

## :mag: Algorithm

Dynamic Programming

## :round_pushpin: Logic

- 모든 원소값이 0인 3 크기의 1차원 배열 `max_dp, min_dp, max_temp, min_temp`를 생성한다.

  ```python
  max_dp, min_dp = [0] * 3, [0] * 3
  max_temp, min_temp = [0] * 3, [0] * 3
  ```

<br />

- 한 줄씩 입력 받아 아래 코드와 같이 `max_dp`와 `min_dp`를 `N`번 업데이트한다. max_dp는 자신의 원소들 중 가장 큰 값과 입력 받은 수를 더하며 min_dp는 자신의 원소들 중 가장 작은 값과 입력받은 수를 더하는 것을 반복한다.

  ```python
  for _ in range(N):
  x, y, z = map(int, sys.stdin.readline().split())
  for i in range(3):
      if i == 0:
          max_temp[0] = max(max_dp[0], max_dp[1]) + x
          min_temp[0] = min(min_dp[0], min_dp[1]) + x
      elif i == 2:
          max_temp[2] = max(max_dp[1], max_dp[2]) + z
          min_temp[2] = min(min_dp[1], min_dp[2]) + z
      else:
          max_temp[1] = max(max_dp[0], max_dp[1], max_dp[2]) + y
          min_temp[1] = min(min_dp[0], min_dp[1], min_dp[2]) + y
  max_dp, min_dp = list(max_temp), list(min_temp)
  ```

  `max_dp`와 `min_dp`의 원소값을 즉각 업데이트 해버릴 시, 다른 인덱스의 값을 변경하는 과정에서 잘못된 값이 생기게된다. 그렇기에 업데이트된 값을 `max_temp, min_temp`에 잠시 넣어두었다가 3개의 원소(전체 원소)를 모두 조사한 뒤 `max_dp, min_dp`의 값을 `max_temp, min_temp`의 값으로 업데이트한다.

  <br />

- 위 과정을 마친 후, `max_dp`의 원소들 중 가장 큰 값, `min_dp`의 원소들 중 가장 작은 값을 출력한다.

  ```python
  print(max(max_dp), min(min_dp))
  ```

## :memo: Review

문제 해결법에 대해서는 금방 도출해낼 수 있었지만, 빈번한 **메모리 초과**가 생겼다.

- 첫 번째 코드

  ```python
  import sys
  N = int(input())
  board = list(list(map(int, sys.stdin.readline().split())) for _ in range(N))
  dp_max, dp_min = [0] * 3, [0] * 3
  temp_max, temp_min = [0] * 3, [0] * 3

  for i in range(N):
      for j in range(3):
          if j == 0:
              temp_max[0] = max(dp_max[0], dp_max[1]) + board[i][0]
              temp_min[0] = min(dp_min[0], dp_min[1]) + board[i][0]
          elif j == 2:
              temp_max[2] = max(dp_max[1], dp_max[2]) + board[i][2]
              temp_min[2] = min(dp_min[1], dp_min[2]) + board[i][2]
          else:
              temp_max[1] = max(dp_max[0], dp_max[1], dp_max[2]) + board[i][1]
              temp_min[1] = min(dp_min[0], dp_min[1], dp_min[2]) + board[i][1]
      dp_max, dp_min = list(temp_max), list(temp_min)

  print(max(dp_max), min(dp_min))
  ```

  위 첫 번째 코드에서 3번쨰 줄 `board` 배열을 입력받는 부분을 아래와 같이 변경하니 메모리 초과를 해결할 수 있었다.

  ```python
  board = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
  ```

  **map**을 이용하여 새 리스트를 계속해서 반환하게 되어 메모리를 많이 잡아먹은 것? 이라 추정된다.

<br />

- 두번째 코드

  ```python
  import sys
  N = int(sys.stdin.readline())
  max_dp, min_dp = [0] * 3, [0] * 3
  max_temp, min_temp = [0] * 3, [0] * 3

  for _ in range(N):
      x, y, z = map(int, sys.stdin.readline().split())
      for i in range(3):
          if i == 0:
              max_temp[0] = max(max_dp[0], max_dp[1]) + x
              min_temp[0] = min(min_dp[0], min_dp[1]) + x
          elif i == 2:
              max_temp[2] = max(max_dp[1], max_dp[2]) + z
              min_temp[2] = min(min_dp[1], min_dp[2]) + z
          else:
              max_temp[1] = max(max_dp[0], max_dp[1], max_dp[2]) + y
              min_temp[1] = min(min_dp[0], min_dp[1], min_dp[2]) + y
      max_dp, min_dp = list(max_temp), list(min_temp)
  print(max(max_dp), min(min_dp))
  ```

    또한, 첫번째 코드에서 2차원 배열을 입력받는 부분을 없애고 `max_dp, min_dp`를 업데이트하는 2중 반복문에서 함께 입력을 받오록 코드를 고쳤다. 

    그러자 메모리를 39452KB에서 29200KB로 줄일 수 있었고, 시간 또한 496ms에서 440ms로 줄었다.

<br />

오랜만의 **메모리 초과**라 애를 조금 먹었다. 앞으로 입력 받을시 **map**을 이용하는 것에 고민을 해야겠다.