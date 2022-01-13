import sys, copy
input = sys.stdin.readline


def update_smell():
    for i in range(N):
        for j in range(N):
            if isinstance(grid[i][j], list):
                grid[i][j][1] -= 1
                if grid[i][j][1] == 0: grid[i][j] = 0


def update_grid_shark(x, y, next_x, next_y, number, di):
    grid[next_x][next_y] = number
    grid[x][y] = [number, k]
    d[number] = di
    sharks[number] = (next_x, next_y)


def release_shark(x, y, next_x, next_y, number, di):
    if grid[next_x][next_y] > number:
        update_grid_shark(x, y, next_x, next_y, number, di)
    else:
        grid[x][y] = [number, k]
        sharks[number] = False


def move_shark(x, y, number, copy_grid):
    current = d[number]
    temp = []

    # 냄새가 없는 칸으로 이동
    for di in d_info[number][current]:
        next_x, next_y = x + direction[di][0], y + direction[di][1]
        if 0 <= next_x < N and 0 <= next_y < N:
            next = copy_grid[next_x][next_y]
            if next == 0:
                if grid[next_x][next_y] != 0: release_shark(x, y, next_x, next_y, number, di)
                else: update_grid_shark(x, y, next_x, next_y, number, di)
                return 
            elif not temp and isinstance(next, list) and next[0] == number:
                temp = [next_x, next_y, di]

    # 자신의 냄새가 있는 칸으로 이동
    update_grid_shark(x, y, temp[0], temp[1], number, temp[2])


def start():
    second = 0
    while second <= 1000:
        count = 0
        copy_grid = copy.deepcopy(grid)
        for number, shark in enumerate(sharks):
            if not shark: continue
            move_shark(shark[0], shark[1], number, copy_grid)
            count += 1
        if count == 1: return second
        update_smell()
        second += 1
    return -1


N, M, k = map(int, input().split())
grid = [[int(i) for i in input().split()] for _ in range(N)]  # 격자
d = [0] + [int(i) for i in input().split()]  # 상어의 현재 방향
d_info = [0] + [[0] + [[int(i) for i in input().split()] for _ in range(4)] for _ in range(M)]

direction = {1: (-1, 0), 2: (1, 0), 3: (0, -1), 4: (0, 1)}  # 상, 하, 좌, 우
sharks = [False for _ in range(M+1)]
for i in range(N):
    for j in range(N):
        if grid[i][j] != 0: sharks[grid[i][j]] = (i, j)
print(start())