import sys
input = sys.stdin.readline
N, M, x, y, K = map(int, input().split())
Map = [[int(i) for i in input().split()] for _ in range(N)]
move = [int(i) for i in input().split()]  # 동쪽: 1, 서쪽: 2, 북쪽: 3, 남쪽: 4

dice = [0] * 7
direction = {1: (0, 1), 2: (0, -1), 3: (-1, 0), 4: (1, 0)}  # 동, 서, 북, 남
for m in move:
    temp = direction.get(m)
    x += temp[0]; y += temp[1]
    if x < 0 or x >= N or y < 0 or y >= M: 
        x -= temp[0]; y -= temp[1]
        continue

    if m == 1:
        dice[1], dice[4] = dice[4], dice[1]
        dice[3], dice[6] = dice[6], dice[3]
        dice[3], dice[4] = dice[4], dice[3]
    elif m == 2:
        dice[1], dice[3] = dice[3], dice[1]
        dice[4], dice[6] = dice[6], dice[4]
        dice[3], dice[4] = dice[4], dice[3]
    elif m == 3:
        dice[1], dice[2] = dice[2], dice[1]
        dice[5], dice[6] = dice[6], dice[5]
        dice[2], dice[5] = dice[5], dice[2]
    elif m == 4:
        dice[1], dice[5] = dice[5], dice[1]
        dice[2], dice[6] = dice[6], dice[2]
        dice[2], dice[5] = dice[5], dice[2]

    if Map[x][y] == 0: Map[x][y] = dice[6]
    else: dice[6] = Map[x][y]; Map[x][y] = 0
    print(dice[1])
