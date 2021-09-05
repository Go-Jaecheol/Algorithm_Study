# [5557] 1학년 - Python

## :mag: Algorithm

Dynamic Programming

## :round_pushpin: Logic

- 모든 원소의 값이 0인 **(N - 1) \* 21** 크기의 2차원 배열 dp를 생성한다.

  ```python
  dp = [[0] * 21 for _ in range(N-1)]
  ```

  > row: N - 1 은 주어진 숫자들 중 마지막 수는 조사할 필요가 없기 때문이며, col: 21 은 중간에 나오는 수가 0 이상 20 이하이기 때문이다.

    <br />
  생성 후, 아래 코드와 같이 입력 받은 숫자들의 첫번째 수를 인덱스로 한 원소의 값을 1로 설정한다.

  ```python
  dp[0][numbers[0]] = 1
  ```

<br />

- 2중 반복문을 통해 `i > 0`의 dp의 모든 원소를 조사하며, 아래 두 조건을 만족할 시 값(경우의 수)을 업데이트해준다.

  <br />

  - `numbers[i]`를 더하는 경우

    ```python
      if 0 <= j + numbers[i] <= 20:
            dp[i][j + numbers[i]] += dp[i-1][j]
    ```

  <br />

  - `numbers[i]`를 빼는 경우
    ```python
    if 0 <= j - numbers[i] <= 20:
              dp[i][j - numbers[i]] += dp[i-1][j]
    ```

  <br />

  아래 코드는 위 내용들을 종합한 코드이다.

  ```python
  for i in range(1, N-1):
      for j in range(21):
          if 0 <= j + numbers[i] <= 20:
              dp[i][j + numbers[i]] += dp[i-1][j]
          if 0 <= j - numbers[i] <= 20:
              dp[i][j - numbers[i]] += dp[i-1][j]
  ```

- 최종 업데이트 된 배열 dp의 **입력 받은 숫자들의 마지막 수**를 인덱스로한 원소 값을 출력한다.

  ```python
  print(dp[-1][numbers[-1]])
  ```

## :memo: Review

문제를 해결하기 위한 아이디어를 떠올리는 데 많은 시간을 소요했다.

끝내, 스스로 해결법을 찾지 못하여 구글 상에 존재하는 한 천재의 아이디어를 참조했다..

그래도 이번 문제를 통해 DP 문제의 색다른 접근법을 터득할 수 있었던 것 같다.