import sys
from itertools import combinations

def attack(archer, enemy):
    global count
    target, new_enemy, min_i = [], [], -1
    for y, x in archer:
        distance = sys.maxsize
        # 거리 계산
        for i, (ey, ex) in enumerate(enemy):
            temp = abs(x - ex) + abs(y - ey)
            if temp <= D and distance > temp:
                distance = temp
                min_i = i
        if min_i > -1:
            target.append(min_i)
    # 집합으로 중복 제거
    target_set = set(target)
    count += len(target_set)
    for i, (y, x) in enumerate(enemy):
        if i not in target_set:
            new_enemy.append(enemy[i])
    return new_enemy

def move_enemy(enemy):
    temp = []
    new_enemy = []
    # 아래로 한칸씩 이동
    for i, (y, x) in enumerate(enemy):
        if y == N-1: temp.append(i)
        else: enemy[i][0] = y+1
    # 집합으로 중복 제거
    temp_set = set(temp)
    for i, (y, x) in enumerate(enemy):
        if i not in temp_set:
            new_enemy.append(enemy[i])
    return new_enemy

N, M, D = map(int, sys.stdin.readline().split())
arr = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
comb_list = combinations([int(x) for x in range(M)], 3)
result = 0
# 궁수 배치 조합
for comb in comb_list:
    comb = list(comb)
    archer, enemy, count = [], [], 0
    # 궁수 배치
    for i in comb:
        archer.append([N, i])
    # 적 위치 저장
    for i in range(N):
        for j in range(M):
            if arr[i][j] == 1:
                enemy.append([i, j])
    # 적이 다 사라질 때까지 게임 진행
    while enemy:
        # 열 기준 정렬
        enemy.sort(key=lambda x:x[1])
        enemy = attack(archer, enemy)
        enemy = move_enemy(enemy)
    result = max(result, count)
print(result)