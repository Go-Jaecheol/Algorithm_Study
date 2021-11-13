# [14891] 톱니바퀴 - Python

## :mag: Algorithm

**Simulation**

## :round_pushpin: Logic

- **입력**

  - 톱니바퀴의 상태를 `gear` 리스트로 입력 받았다. `gear` 리스트의 맨 앞에 `False`를 추가함으로써 1부터 K까지의 인덱스를 사용할 수 있게 하고, 인덱스 0을 무시하도록 했다.

  ```python
  import sys
  from collections import deque
  gear = [list(map(int, input())) for _ in range(4)]
  gear.insert(0, False)
  K = int(input())
  rotaion_info = [[int(x) for x in sys.stdin.readline().split()]
                  for _ in range(K)]
  ```

<br />

- **queue를 이용한 인접 톱니바퀴 회전**

  - 입력받은 회전시킨 방법 `rotaion_info`를 반복문을 통해 순차적으로 해당 톱니바퀴와 인접 톱니바퀴를 회전(업데이트)한다.

  - `rotaion_gear`함수를 통해 `rotaion_info`에 저장된 톱니바퀴 회전 방법을 시작으로 인접 톱니 바퀴를 회전한다.

    - **queue**에서 pop한 해당 톱니바퀴가 회전하기 전, 인접 톱니바퀴의 맞닿은 극이 다를 경우 **queue**에 인접 톱니바퀴 회전 방법을 append한다.

      - 맞닿은 오른쪽 극을 뜻하는 인덱스 2와 맞닿은 왼쪽 극을 뜻하는 인덱스 6을 이용한다.

    - **queue**에서 pop한 해당 톱니바퀴를 회전한다.

      - `d`가 -1일 경우(반시계 방향) 맨 앞의 원소를 제거하고, 해당 원소를 맨 뒤에 추가한다.

      - `d`가 +1일 경우(시계 방향) 맨 뒤의 원소를 제거하고, 해당 원소를 맨 앞에 추가한다.

    - **queue**에 원소가 없을 때까지 이를 반복한다.

  ```python
  def rotaion_gear(start, direction):
    rotated[start] = True
    queue = deque([[start, direction]])
    while queue:
        i, d = queue.popleft()
        rotated[i] = True
        if i != 4 and not rotated[i+1] and gear[i][R] != gear[i+1][L]:
            queue.append([i+1, d*-1])
        if i != 1 and not rotated[i-1] and gear[i][L] != gear[i-1][R]:
            queue.append([i-1, d*-1])

        if d == -1:
            temp = gear[i].pop(0)
            gear[i].append(temp)
        else:
            temp = gear[i].pop(7)
            gear[i].insert(0, temp)


  R, L = 2, 6
  for i, d in rotaion_info:
      rotated = [False] * 5
      rotaion_gear(i, d)
  ```

<br />

- **출력**

  - 각 톱니바퀴의 12시 방향을 뜻하는 인덱스 0의 값을 통해 결과값을 출력한다.

  ```python
  print(gear[1][0] + 2 * gear[2][0] + 4 * gear[3][0] + 8 * gear[4][0])
  ```

## :memo: Review

그저 문제에서 제시하는 방법대로 순차적으로 구현하니 금방 해결했다.

최근 **BFS** 문제를 많이 풀다보니 나도 모르게 **queue**를 이용하는 방법이 떠올랐다.
