# [3190] 뱀 - Python

## :mag: Algorithm

Simulation

## :round_pushpin: Logic

```python
while True:
    second += 1
    next_x, next_y = now_x + direction[d][0], now_y + direction[d][1]
    # 게임 종료
    if next_x < 0 or next_x >= N or next_y < 0 or next_y >= N: break
    if board[next_x][next_y] == 2: break
    # 사과가 없는 칸으로 이동
    if board[next_x][next_y] == 0:
        temp_x, temp_y = snake.popleft()
        board[temp_x][temp_y] = 0
    # 뱀의 머리 위치 변경
    board[next_x][next_y] = 2
    snake.append((next_x, next_y))
    now_x, now_y = next_x, next_y
    # 뱀의 방향 변환
    if snake_direction_info and  second == snake_direction_info[0][0]:
        x, c = snake_direction_info.pop(0)
        if c == 'D':
            if d == 3: d = 0
            else: d += 1
        else:
            if d == 0: d = 3
            else: d -= 1
```

- N \* N 사이즈의 2차원 리스트 `board` 를 생성하여 사과가 없는 칸은 0, 사과가 있는 칸은 1, 뱀의 몸이 있는 칸은 2로 표현했다.

- `board` 에 뱀이 새로 이동한 칸의 값을 2로 업데이트하되, **게임 종료 조건에 해당할 경우** `break` 하고, **사과가 없는 칸(`board` 값이 0)일 경우** queue로 생성한 `snake` 를 `popleft()` 한다(몸 길이를 줄여서 꼬리가 위치한 칸을 비워준다).

- 만약 뱀의 방향 변환 정보(`snake_direction_info`)의 가장 빠른 초(`snake_direction_info[0][0]`)가 되었다면, 해당 초의 정보를 `pop` 하고 뱀의 방향(`d`)을 변환한다.

## :memo: Review

다른 시뮬레이션 문제와 같이 문제에서 제시한 조건을 차근차근 구현하니 쉽게 해결할 수 있었다.

하지만, 구현하는데 만족하지 못할 만큼의 긴 시간을 소요하여 아쉽다.
