from collections import deque
from itertools import combinations
N, M = map(int, input().split())
lab = list(list(map(int, input().split())) for _ in range(N))
direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]
MAX = 2500


def spread_virus(act_virus):
    global min_second
    max_second, infected = 0, 0
    queue = deque(act_virus)
    second = list([-1] * N for _ in range(N))

    for start_x, start_y in act_virus:
        second[start_x][start_y] = 0

    while queue:
        now_x, now_y = queue.popleft()
        for d in direction:
            x, y = now_x + d[0], now_y + d[1]
            if 0 <= x < N and 0 <= y < N and lab[x][y] != 1:
                if second[x][y] == -1 and (x, y) not in act_virus:  # 0 or 2(비활성)
                    second[x][y] = second[now_x][now_y] + 1
                    if lab[x][y] == 0:
                        max_second = second[x][y]
                        infected += 1
                    queue.append((x, y))
    if zero == infected:
        min_second = min(min_second, max_second)


virus, zero = [], 0
for i in range(N):
    for j in range(N):
        if lab[i][j] == 2:
            virus.append((i, j))
        elif lab[i][j] == 0:
            zero += 1

min_second = MAX
comb = list(combinations(virus, M))
for c in comb:
    spread_virus(c)
if min_second == MAX:
    print(-1)
else:
    print(min_second)
