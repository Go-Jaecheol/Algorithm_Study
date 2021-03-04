from collections import deque
N, L, R = map(int, input().split())
land = list(list(map(int, input().split())) for _ in range(N))
direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]  # 상, 하, 좌, 우


def change_population():
    for i, v in enumerate(union):
        for x, y in v:
            land[x][y] = union_avg[i]


def move_population(start_x, start_y):
    global check
    visited[start_x][start_y] = True
    sum_union = land[start_x][start_y]
    temp = []
    queue = deque([(start_x, start_y)])
    while queue:
        i, j = queue.popleft()
        temp.append((i, j))
        for d in direction:
            x, y = i + d[0], j + d[1]
            if 0 <= x < N and 0 <= y < N and not visited[x][y]:
                if L <= abs(land[x][y] - land[i][j]) <= R:
                    visited[x][y] = True
                    sum_union += land[x][y]
                    queue.append((x, y))

    if len(temp) > 1:  # 이동이 발생
        check = True
        union.append(temp)
        union_avg.append(sum_union // len(temp))


check = True
move_cnt = 0
while check:
    check = False
    union, union_avg = [], []
    visited = list([False] * N for _ in range(N))
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                move_population(i, j)
    if check:
        change_population()
        move_cnt += 1

print(move_cnt)
