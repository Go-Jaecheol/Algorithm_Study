import sys, copy

fish = []
fish_dir = [0 for _ in range(16)]
dx = [0, -1, -1, -1, 0, 1, 1, 1]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]
for _ in range(4):
    temp = []
    temp_input = [int(x) for x in sys.stdin.readline().split()]
    for i in range(4):
        # 인덱싱 편하게 하기 위해 물고기 번호-1로 저장, -1: 빈칸, -2: 상어
        temp.append(temp_input[i*2]-1)
        fish_dir[temp_input[i*2]-1] = temp_input[i*2+1]
    fish.append(temp)

def move_fish(fish, fish_dir):
    # 물고기 순서대로 이동
    for i in range(16):
        cur_x, cur_y = -1, -1
        # 현재 위치 인덱스 찾기
        for j in range(4):
            for k in range(4):
                if fish[j][k] == i:
                    cur_x, cur_y = k, j
        if cur_x == -1 and cur_y == -1 : continue
        # 이동 가능한 방향 확인
        for _ in range(8):
            next_x = cur_x + dx[fish_dir[i] - 1]
            next_y = cur_y + dy[fish_dir[i] - 1]
            if 0 <= next_x < 4 and 0 <= next_y < 4:
                if fish[next_y][next_x] == -2:
                    if fish_dir[i] == 8: fish_dir[i] = 1
                    else: fish_dir[i] += 1
                else:
                    fish[cur_y][cur_x], fish[next_y][next_x] = fish[next_y][next_x], fish[cur_y][cur_x]
                    break
            else:
                if fish_dir[i] == 8: fish_dir[i] = 1
                else: fish_dir[i] += 1

def move_shark(x, y, cur_shark, fish, fish_dir, sum):
    global result
    shark_location = []
    next_x, next_y = x, y
    move_fish(fish, fish_dir)
    result = max(result, sum)
    # 상어 이동 가능한 위치 확인 후, 저장
    for _ in range(4):
        next_x += dx[fish_dir[cur_shark] - 1]
        next_y += dy[fish_dir[cur_shark] - 1]
        if 0 <= next_x < 4 and 0 <= next_y < 4 and fish[next_y][next_x] >= 0:
            shark_location.append((next_x, next_y))
    # 이동 가능한 위치 없을 때까지 재귀
    while(shark_location):
        next_x, next_y = shark_location.pop()
        temp_fish = copy.deepcopy(fish)
        temp_dir = copy.deepcopy(fish_dir)
        temp_shark = temp_fish[next_y][next_x]
        temp_sum = sum + temp_fish[next_y][next_x] + 1
        temp_fish[y][x] = -1
        temp_fish[next_y][next_x] = -2
        move_shark(next_x, next_y, temp_shark, temp_fish, temp_dir, temp_sum)

cur_shark = fish[0][0]
fish[0][0] = -2
result = cur_shark + 1
move_shark(0, 0, cur_shark, fish, fish_dir, result)
print(result)