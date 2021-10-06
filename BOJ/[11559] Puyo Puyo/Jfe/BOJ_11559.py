import sys
from collections import deque

field = list(list(sys.stdin.readline()) for _ in range(12))
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
is_pop = 0
result = 0

def bfs(x, y):
    q = deque()
    visited[y][x] = True
    temp = [(x, y)]
    q.append((x, y, field[y][x]))
    count = 1

    while q:
        x, y, color = q.popleft()
        for i in range(4):
            cur_x = x + dx[i]
            cur_y = y + dy[i]
            if 0 <= cur_x < 6 and 0 <= cur_y < 12 and not visited[cur_y][cur_x]:
                if field[cur_y][cur_x] == color:
                    count += 1
                    visited[cur_y][cur_x] = True
                    q.append((cur_x, cur_y, field[cur_y][cur_x]))
                    temp.append((cur_x, cur_y))
    if count >= 4:
        for x, y in temp:
            field[y][x] = '.'
        return 1
    return 0

def update():
    for x in range(6):
        cnt = 0
        for y in range(11, -1, -1):
            if field[y][x] != '.' and cnt > 0:
                field[y+cnt][x] = field[y][x]
                field[y][x] = '.'
            elif field[y][x] == '.':
                cnt += 1

while is_pop != -1:
    is_pop = 0
    for i in range(11, 0, -1):
        for j in range(6):
            if field[i][j] != '.':
                visited = [[False for _ in range(6)]for _ in range(12)]
                is_pop += bfs(j, i)
                
    if is_pop > 0:
        result += 1
        update()
    else:
        is_pop = -1
print(result)