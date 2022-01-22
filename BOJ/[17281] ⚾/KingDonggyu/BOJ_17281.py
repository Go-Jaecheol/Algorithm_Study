import sys
from itertools import permutations
input = sys.stdin.readline


def hit(run):
    global score, b1, b2, b3
    
    # 홈런
    if run == 4:
        score += b1 + b2 + b3 + 1
        b1, b2, b3 = 0, 0, 0
        return

    # 진루타
    if b3 == 1:
        b3 = 0
        score += 1
    if b2 == 1:
        b2 = 0
        if run > 1: score += 1
        else: b3 = 1
    if b1 == 1:
        b1 = 0
        if run > 2: score += 1
        elif run == 2: b3 = 1
        else: b2 = 1
    
    if run == 1: b1 = 1
    elif run == 2: b2 = 1
    else: b3 = 1


N = int(input())
innings = [[int(i) for i in input().split()] for _ in range(N)]
max_score = 0

# 타순 정하기
for order in list(permutations([1, 2, 3, 4, 5, 6, 7, 8], 8)):

    # 4번타자 설정
    order = list(order)
    order.insert(3, 0)

    # 경기 시작
    score, player = 0, 0
    for inning in innings:
        
        # 이닝 시작
        out = 0
        b1, b2, b3 = 0, 0, 0
        while out < 3:
            if inning[order[player]] != 0:
                hit(inning[order[player]])
            else: out += 1
            
            if player+1 == 9: player = 0
            else: player += 1

    max_score = max(max_score, score)

print(max_score)