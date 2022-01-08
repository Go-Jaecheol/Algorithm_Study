import sys
R, C, T = map(int, sys.stdin.readline().split())
A = [[int(i) for i in sys.stdin.readline().split()] for _ in range(R)]

def work_cleanner():
    next_A = [[0 for _ in range(C)] for _ in range(R)]
    # 공기 청정기가 위치한 행 이동
    for i in range(1, C-1): 
        next_A[top][i+1], next_A[bottom][i+1] = A[top][i], A[bottom][i]
    # 마지막 열 이동
    for i in range(top, 0, -1): next_A[i-1][C-1] = A[i][C-1]
    for i in range(bottom, R-1): next_A[i+1][C-1] = A[i][C-1]
    # 첫번째 행 && 마지막 행 이동
    for i in range(C-1, 0, -1):
        next_A[0][i-1], next_A[R-1][i-1] = A[0][i], A[R-1][i]
    # 첫번째 열 이동
    for i in range(0, top): next_A[i+1][0] = A[i][0]
    for i in range(R-1, bottom, -1): next_A[i-1][0] = A[i][0]
    # 공기 청정기로 들어간 미세 먼지 제거
    next_A[top][0], next_A[bottom][0] = -1, -1
    # 공기 청정기가 지나 가지 않은 구역의 미세 먼지의 양 copy
    for i in range(1, R-1):
        if i == top or i == bottom: continue
        for j in range(1, C-1): next_A[i][j] = A[i][j]
    return next_A

def speread_dust():
    next_A = [[0 for _ in range(C)] for _ in range(R)]
    next_A[top][0], next_A[bottom][0] = -1, -1
    for i in range(R):
        for j in range(C):
            if A[i][j] <= 0: continue 
            count = 0
            for d in direction:
                x, y = i + d[0], j + d[1]
                if 0 <= x < R and 0 <= y < C and A[x][y] >= 0:
                    next_A[x][y] += A[i][j] // 5; count += 1
            next_A[i][j] += A[i][j] - A[i][j] // 5 * count
    return next_A

top, bottom = 0, 0
direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]
for i in range(R):
    if A[i][0] == -1:
        top, bottom = i, i+1; break
for _ in range(T):
    A = speread_dust()
    A = work_cleanner()
remainder_dust = 2
for i in range(R): remainder_dust += sum(A[i])
print(remainder_dust)