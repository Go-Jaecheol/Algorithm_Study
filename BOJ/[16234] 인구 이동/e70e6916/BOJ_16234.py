from collections import deque
N, L, R = map(int, input().split())
land = list(list(map(int, input().split())) for _ in range(N))
direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]  # 상, 하, 좌, 우


def move_population(start_x, start_y):
    global check
    visited[start_x][start_y] = True
    sum_union = land[start_x][start_y]
    queue = deque([(start_x, start_y)])

    while queue:
        i, j = queue.popleft()
        union.append((i, j))
        for d in direction:
            x, y = i + d[0], j + d[1]
            if 0 <= x < N and 0 <= y < N and not visited[x][y]:
                if L <= abs(land[x][y] - land[i][j]) <= R:
                    visited[x][y] = True
                    sum_union += land[x][y]
                    queue.append((x, y))

    if len(union) > 1:  # 인구이동이 일어남
        check = True
        for x, y in union:
            land[x][y] = sum_union // len(union)


check = True
move_cnt = 0
while check:
    check = False
    visited = list([False] * N for _ in range(N))
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                union = []
                move_population(i, j)
    if check:
        move_cnt += 1

print(move_cnt)