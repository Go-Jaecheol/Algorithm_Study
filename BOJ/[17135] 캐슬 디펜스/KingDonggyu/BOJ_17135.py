import sys
from itertools import combinations
input = sys.stdin.readline


def move_enemy(target):
    new_enemy = []
    while enemy:
        x, y = enemy.pop()
        if x + 1 < N and [x, y] not in target:
           new_enemy.append([x+1, y])
    
    return new_enemy


def archer_attack():
    global kill
    target = [[N, M, D], [N, M, D], [N, M, D]]

    for i, j in enemy:
        for n, (x, y) in enumerate(archer):
            d = abs(i-x) + abs(j-y)

            if d < target[n][2]:
                target[n] = [i, j, d]
            elif d == target[n][2] and j < target[n][1]:
                target[n] = [i, j, d]

    new_target = []
    for x, y, d in target:
        if [x, y] not in new_target:
            new_target.append([x, y])
            if x != N: kill += 1
    
    return move_enemy(new_target)


def find_enemy():
    for i in range(N):
        for j in range(M):
            if Map[i][j] == 1:
                enemy.append([i, j])


N, M, D = map(int, input().split())
Map = [[int(i) for i in input().split()] for _ in range(N)]


result = 0
for comb in list(combinations([i for i in range(M)], 3)):
    # 적 위치 파악
    enemy = []
    find_enemy()
    # 궁수 배치
    archer = []
    for i in comb:
        archer.append([N, i])
    # 게임 시작
    kill = 0
    while enemy:
        enemy = archer_attack()
       
    result = max(result, kill)

print(result)