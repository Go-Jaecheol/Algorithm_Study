import sys, copy
from collections import deque
R, C, T = map(int, sys.stdin.readline().split())
A = []
purifier = []
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
for i in range(R):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(C):
        if temp[j] == -1:
            purifier.append((j, i))
    A.append(temp)

def spread():
    # A 리스트 deepcopy
    A_copy = copy.deepcopy(A)
    for i in range(R):
        for j in range(C):
            if A_copy[i][j] > 0:
                value = A_copy[i][j] // 5
                # 상하좌우 계산
                for k in range(4):
                    next_x = j + dx[k]
                    next_y = i + dy[k]
                    # boundary 체크 후, 확산
                    if 0 <= next_x < C and 0 <= next_y < R:
                        if A[next_y][next_x] != -1:
                            A[next_y][next_x] += value
                            A[i][j] -= value

def wind(x, y, d):
    # x, y : 공기청정기 위치 , d : 1이면 위로 확산, -1이면 아래로 확산
    temp = A[y][x+1]
    A[y][x+1] = 0
    # 공기청정기 위치한 행 확산
    for i in range(x+2, C): temp, A[y][i] = A[y][i], temp
    # 마지막 열 확산
    if d == 1:
        for i in range(y-1, -1, -1): temp, A[i][C-1] = A[i][C-1], temp
    else:
        for i in range(y+1, R): temp, A[i][C-1] = A[i][C-1], temp
    # 맨 위 or 맨 아래 행 확산
    for i in range(C-2, x-1, -1): 
        if d == 1: temp, A[0][i] = A[0][i], temp
        else: temp, A[R-1][i] = A[R-1][i], temp
    # 첫번째 열 확산
    if d == 1:
        for i in range(1, y): temp, A[i][0] = A[i][0], temp
    else:
        for i in range(R-2, y, -1): temp, A[i][0] = A[i][0], temp

def calculate():
    count = 0
    for i in range(R):
        for j in range(C):
            if A[i][j] > 0:
                count += A[i][j]
    return count

for _ in range(T):
    spread()
    wind(purifier[0][0], purifier[0][1], 1)
    wind(purifier[1][0], purifier[1][1], -1)
print(calculate())