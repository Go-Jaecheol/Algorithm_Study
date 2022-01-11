import copy


def find_food(space, shark):
    food = []
    x, y = shark[0][0], shark[0][1]
    while True:
        next_x, next_y = x + direction[shark[1]][0], y +direction[shark[1]][1]
        if 0 <= next_x < 4 and 0 <= next_y < 4:
            if space[next_x][next_y][0] != 0: food.append((next_x, next_y))
            x, y = next_x, next_y
        else: break
    return food


def fish_move(space, shark, x, y):
    while True:
        d = space[x][y][1]
        next_x, next_y = x + direction[d][0], y + direction[d][1]
        if [next_x, next_y] != shark[0]:
            if 0 <= next_x < 4 and 0 <= next_y < 4:
                space[x][y], space[next_x][next_y] = space[next_x][next_y], space[x][y]
                break
        if d == 8: space[x][y][1] = 1
        else: space[x][y][1] += 1


def find_fish(space, shark, fish_num):
    for i in range(4):
        for j in range(4):
            if space[i][j][0] == fish_num:
                fish_move(space, shark, i, j) 
                return


def dfs(space, x, y, fish_sum):
    global result
    space = copy.deepcopy(space)

    # 물고기 먹기
    shark = [[x, y], space[x][y][1]]
    fish_sum += space[x][y][0]
    space[x][y] = [0, 0]

    # 물고기 이동
    for fish_num in range(1, 17):
        find_fish(space, shark, fish_num)
    
    # 상어가 이동할 수 있는 위치 파악
    food = find_food(space, shark)
    
    # 이동 가능한 모든 경우 탐색
    for x, y in food: dfs(space, x, y, fish_sum)
    if result < fish_sum: result = fish_sum


fish_info = [[int(i) for i in input().split()] for _ in range(4)]
direction = {1: (-1, 0), 2: (-1, -1), 3: (0, -1), 4: (1, -1), 5: (1, 0), 6: (1, 1), 7: (0, 1), 8: (-1, 1)}
space = [[] for _ in range(4)]
for i in range(4):
    for j in range(0, 8, 2):
        space[i].append([fish_info[i][j], fish_info[i][j+1]])
        
result = 0
dfs(space, 0, 0, 0)
print(result)