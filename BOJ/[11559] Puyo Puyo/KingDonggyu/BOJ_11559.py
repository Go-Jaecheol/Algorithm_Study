from collections import deque


def puyo_drop():
    for j in range(6):
        puyo = []
        for i in reversed(range(12)):
            if field[i][j] != '.': 
                puyo.append(field[i][j])
                field[i][j] = '.'
        for i, v in enumerate(puyo):
            field[11 - i][j] = v


def puyo_pop(start_x, start_y):
    queue = deque([(start_x, start_y)])
    visited[start_x][start_y] = True
    puyo = [(start_x, start_y)]

    while queue:
        i, j = queue.popleft()
        for d in direction:
            x, y = i + d[0], j + d[1]
            if 0 <= x < 12 and 0 <= y < 6 and not visited[x][y]:
                if field[start_x][start_y] == field[x][y]:
                    queue.append((x, y))
                    puyo.append((x, y))
                    visited[x][y] = True
                    
    if len(puyo) >= 4:
        for i, j in puyo: field[i][j] = '.'
        return 1
    return 0


field = list(list(input()) for _ in range(12))
visited = [[False] * 6 for _ in range(12)]
direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]
chain = 0

while True:
    pop_count = 0
    for i in reversed(range(12)):
        for j in range(6):
            if field[i][j] != '.':
                pop_count += puyo_pop(i, j)

    if pop_count > 0:
        chain += 1
        puyo_drop()
        visited = [[False] * 6 for _ in range(12)]
    else: break

print(chain)
