# [11559] Puyo Puyo - Python

## :mag: Algorithm

BFS

시뮬레이션

## :round_pushpin: Logic

- **입력 및 주요 변수 설정**

  ```python
  field = list(list(input()) for _ in range(12))
  visited = [[False] * 6 for _ in range(12)]  # BFS 시 방문 여부를 확인
  direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # BFS 시 상하좌우 탐색
  chain = 0  # 최종 출력값 (연쇄의 수)
  ```

<br />

- **Main**

  ```python
  while True:
      pop_count = 0
      for i in reversed(range(12)):
          for j in range(6):
              if field[i][j] != '.':
                  pop_count += puyo_pop(i, j)  # 뿌요 터뜨리기

      # 한 턴에 연쇄가 하나라도 발생할 경우
      if pop_count > 0:
          chain += 1
          puyo_drop()  # 뿌요 떨어뜨리기
          visited = [[False] * 6 for _ in range(12)]
      else: break
  ```

<br />

- **BFS => 뿌요 터뜨리기**

  ```python
  def puyo_pop(start_x, start_y):
    queue = deque([(start_x, start_y)])
    visited[start_x][start_y] = True
    puyo = [(start_x, start_y)]

    # BFS 를 통해 상하좌우 같은 색의 뿌요 찾기
    while queue:
        i, j = queue.popleft()
        for d in direction:
            x, y = i + d[0], j + d[1]
            if 0 <= x < 12 and 0 <= y < 6 and not visited[x][y]:
                if field[start_x][start_y] == field[x][y]:
                    queue.append((x, y))
                    puyo.append((x, y))
                    visited[x][y] = True

    # 뿌요가 4개 이상일 경우 뿌요가 있던 자리를 '.' 으로 초기화
    if len(puyo) >= 4:
        for i, j in puyo: field[i][j] = '.'
        return 1
    return 0
  ```

<br />

- **뿌요 떨어뜨리기**

  ```python
  def puyo_drop():
    # 한 열씩 조사
    for j in range(6):
        puyo = []
        for i in reversed(range(12)):
            # 떨어뜨릴 뿌요 찾은 후 '.' 으로 초기화
            if field[i][j] != '.':
                puyo.append(field[i][j])
                field[i][j] = '.'
        # 조사한 열 업데이트
        for i, v in enumerate(puyo):
            field[11 - i][j] = v
  ```

## :memo: Review

뿌요 터뜨리기, 뿌요 떨어뜨리기, 이 두가지 경우를 나누어 생각했고, 빠르게 해결법을 찾을 수 있었다.

맨 처음에는 가장 아래에 있는 뿌요만 조사하면 된다는 어리석은 생각으로 접근하기도 했다..

그리고 반복문을 많이 사용하여 시간초과가 나지 않을까 염려했지만, 어차피 12 * 6 반복이라 크게 시간을 잡아먹지는 않을 것이라 예상했다.

생각대로 시간초과가 나지 않아서 다행이었고 재밌었다.
