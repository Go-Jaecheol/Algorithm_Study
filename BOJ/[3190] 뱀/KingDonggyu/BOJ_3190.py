import sys
from collections import deque
input = sys.stdin.readline

N, K = int(input()), int(input())
apple_position = [[int(x) for x in input().split()] for _ in range(K)]
L = int(input())
snake_direction_info = [input().split() for _ in range(L)]
for i in range(L): snake_direction_info[i][0] = int(snake_direction_info[i][0])

second = 0; d = 1
board = [[0 for _ in range(N)] for _ in range(N)]   # 1: apple, 2: snake
direction = [(-1, 0), (0, 1), (1, 0), (0, -1)]  # 상, 우, 하, 좌

for x, y in apple_position: board[x-1][y-1] = 1
board[0][0] = 2
snake = deque([(0, 0)])
now_x, now_y = 0, 0
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

print(second)

