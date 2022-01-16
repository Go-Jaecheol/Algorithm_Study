import sys, copy

N, M, k = map(int, sys.stdin.readline().split())
grid = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
cur_dir = [int(x) for x in sys.stdin.readline().split()]
priority = [[[int(x) for x in sys.stdin.readline().split()] for _ in range(4)] for _ in range(M)]
shark = [0 for _ in range(M)]
num = M
count = 0
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def update_grid():
    for i in range(N):
        for j in range(N):
            if grid[i][j] != 0:
                # 시간 -1
                grid[i][j][1] -= 1
                # 시간이 0이면 해당 좌표 0으로 초기화
                if grid[i][j][1] == 0:
                    grid[i][j] = 0

def move_shark(copy_grid, n, x, y):
    check = False
    p = priority[n][cur_dir[n]-1]
    # 우선순위에 맞게 다음 위치 계산
    for p in priority[n][cur_dir[n]-1]:
        next_x = x + dx[p-1]
        next_y = y + dy[p-1]
        # 다음 위치가 boundary 안이고 0인지 확인
        if 0 <= next_x < N and 0 <= next_y < N:
            if copy_grid[next_y][next_x] == 0:
                # 실제 grid가 0일 때만 진행
                if grid[next_y][next_x] == 0:
                    grid[next_y][next_x] = [n+1, k+1]
                shark[n] = (next_x, next_y)
                cur_dir[n] = p
                check = True
                break
    # 주변에 0인 칸이 없는 경우
    if not check:
        for p in priority[n][cur_dir[n]-1]:
            next_x = x + dx[p-1]
            next_y = y + dy[p-1]
            if 0 <= next_x < N and 0 <= next_y < N:
                # 자기 냄새가 있는 곳으로 돌아감
                if copy_grid[next_y][next_x][0] == n+1:
                    if grid[next_y][next_x][0] == n+1:
                        grid[next_y][next_x] = [n+1, k+1]
                    shark[n] = (next_x, next_y)
                    cur_dir[n] = p
                    break

def check_collision():
    global num
    for i in range(M):
        if shark[i] == -1:
            continue
        for j in range(i+1, M):
            # 중복되는 위치에 있으면, 숫자가 큰 상어의 위치를 -1로 초기화하고 num -1
            if shark[i] == shark[j]:
                shark[j] = -1
                num -= 1

for i in range(N):
    for j in range(N):
        if grid[i][j] != 0:
            grid[i][j] = [grid[i][j], k]
            shark[grid[i][j][0]-1] = (j, i)

while(num > 1):
    if(count >= 1000 and num > 1):
        count = -1
        break
    count += 1
    copy_grid = copy.deepcopy(grid)
    for i in range(M):
        if shark[i] != -1:
            move_shark(copy_grid, i, shark[i][0], shark[i][1])
    update_grid()
    check_collision()
print(count)