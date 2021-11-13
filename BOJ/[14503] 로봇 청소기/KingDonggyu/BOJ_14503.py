import sys
N, M = map(int, input().split())
r, c, d = map(int, input().split())
space = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]

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
