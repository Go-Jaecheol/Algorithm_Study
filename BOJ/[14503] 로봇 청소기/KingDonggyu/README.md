# [14503] 로봇 청소기 - Python

## :mag: Algorithm

**Simulation**

## :round_pushpin: Logic

- 입력

  ```python
  import sys
  N, M = map(int, input().split())
  r, c, d = map(int, input().split())
  space = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
  ```

<br />

- `while` 반목문을 이용한 문제 해결

  - 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽으로 이동하도록 `direction` 리스트를 생성 및 활용했다.

  - 현재 바라보는 방향을 뜻하는 d가 0일 경우 3이 되게 하고, 0이 아닐 경우 1을 빼도록 하여 로봇 청소기를 왼쪽으로 회전한다.

    - 회전하며 가르키는 `space[i][j]`가 0일 경우 현재 위치를 뜻하는 `now` 튜플을 업데이트하고, 청소한 위치를 표사하기 위해 `space[i][j]`를 2로 설정한다. 그리고 `cleaning_cnt`에 1을 더한다.

      - `now` 튜플은 현재 위치 좌표와 방향을 가지고 있다.

    - 회전하며 가르키는 `space[i][j]`가 0인 경우가 없고, 현재 바라보는 방향의 반대 방향이 2일 경우, 현재 위치 `now`를 반대 방향으로 이동하는 좌표 및 방향으로 업데이트 한다.

  ```python
  direction = [(-1, 0), (0, 1), (1, 0), (0, -1)]  # 북, 동, 남, 서
  now = [(r, c, d)]
  space[r][c], cleaning_cnt = 2, 1
  while now:
      x, y, d = now.pop()
      for check in range(4):
          if d == 0: d = 3
          else: d -= 1
          i, j = x + direction[d][0], y + direction[d][1]
          if space[i][j] == 0:
              now.append((i, j, d))
              space[i][j] = 2
              cleaning_cnt += 1
              break
          elif check == 3:
              i, j = x + direction[d-2][0], y + direction[d-2][1]
              if 0 <= i < N and 0 <= j < M and space[i][j] == 2:
                  now.append((i, j, d))
  print(cleaning_cnt)
  ```

## :memo: Review

문제에서 제시한대로 순차적으로 구현하다보니 금방 코드를 완성할 수 있었다.

그러나 바라보는 방향을 변경하는 아래 코드의 위치를 잘못 두어, 예시 코드에 대한 정확한 출력값이 나오지 않아 문제가 있는 부분을 찾느라 시간을 꽤 소모했다.

```python
if d == 0: d = 3
else: d -= 1
```

시뮬레이션 문제는 처음부터 차근차근 집중해서 고민하면 충분히 쉽게 해결할 수 있는 것 같다.