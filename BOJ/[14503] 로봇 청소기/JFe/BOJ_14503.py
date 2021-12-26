import sys
N, M = map(int, sys.stdin.readline().split())
r, c, d = map(int, sys.stdin.readline().split())
area = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
result = 0

cur = [(c, r, d)]
while cur:
    cur_x, cur_y, d = cur.pop()
    if area[cur_y][cur_x] == 0:
        area[cur_y][cur_x] = 2
        result += 1
    for i in range(4):
        if d == 0: d = 3
        else: d -= 1
        next_x = cur_x + dx[d]
        next_y = cur_y + dy[d]
        if area[next_y][next_x] <= 0:
            cur.append((next_x, next_y, d))
            break
    if i == 3 and not cur:
        next_x = cur_x + -dx[d]
        next_y = cur_y + -dy[d]
        if area[next_y][next_x] == 1:
            break
        else:
            cur.append((next_x, next_y, d))
print(result)