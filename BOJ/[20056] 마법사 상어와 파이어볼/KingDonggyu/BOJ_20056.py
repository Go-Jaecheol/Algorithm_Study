import sys

N, M, K = map(int, input().split())
grid = [[[] for _ in range(N)] for _ in range(N)]
dx = (-1, -1, 0, 1, 1, 1, 0, -1)
dy = (0, 1, 1, 1, 0, -1, -1, -1)
fireball = []

# 초기 파이어볼 정보 셋팅
for _ in range(M):
    r, c, m, s, d = map(int, sys.stdin.readline().split())
    fireball.append([r-1, c-1, m, s, d])

for _ in range(K):
    # 파이어볼 이동
    while fireball:
        r, c, m, s, d = fireball.pop(0)
        next_r = (r + dx[d] * s) % N
        next_c = (c + dy[d] * s) % N
        grid[next_r][next_c].append([m, s, d])

    # 한 칸에 파이어볼 2개 이상일 경우 분할
    for x in range(N):
        for y in range(N):
            n = len(grid[x][y])
            # 파이어볼 2개 이상
            if n > 1:
                sum_m, sum_s, is_odd, is_even = 0, 0, 0, 0
                while grid[x][y]:
                    m, s, d = grid[x][y].pop(0)
                    sum_m += m; sum_s += s
                    if d % 2 == 0: is_even += 1
                    else: is_odd += 1
                # 파이어볼 4개로 분할
                start_d = 0 if is_odd == 0 or is_even == 0 else 1
                if sum_m // 5:  # 질량 0이 아닌 경우만 파이어볼 정보 저장
                    for d in range(start_d, start_d+7, 2):
                        fireball.append([x, y, sum_m//5, sum_s//n, d])
            # 파이어볼 1개
            elif n == 1: fireball.append([x, y] + grid[x][y].pop())

print(sum([f[2] for f in fireball]))