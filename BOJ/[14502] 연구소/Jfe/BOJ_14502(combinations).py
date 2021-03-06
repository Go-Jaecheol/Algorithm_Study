from collections import deque
from itertools import combinations

N, M = map(int, input().split())
lab = [[int(x) for x in input().split()]for y in range(N)]
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
virus = []
safe_area = []

def checkBlank(copy_lab):
    count = 0
    for i in range(N):
        for j in range(M):
            if copy_lab[i][j] == 0:
                count += 1
    safe_area.append(count)

def spreadVirus(copy_lab):
    visited = [[0 for x in range(M)]for y in range(N)]
    que = deque()

    for i, j in virus:
        que.append((i, j))
        visited[j][i] = 1
        while que:
            x, y = que.popleft()
            for k in range(4):
                next_x = x + dx[k]
                next_y = y + dy[k]
                if 0 <= next_x < M and 0 <= next_y < N:
                    if visited[next_y][next_x] == 0 and copy_lab[next_y][next_x] != 1:
                        copy_lab[next_y][next_x] = 2
                        visited[next_y][next_x] = 1
                        que.append((next_x, next_y))
    checkBlank(copy_lab)

def buildWall(wall_count):
    blank = []
    for i in range(N):
        for j in range(M):
            if lab[i][j] == 0:
                blank.append((i, j))

    comb = list(combinations(blank, 3))
    for c in comb:
        copy_lab = [lab[i][:] for i in range(N)]
        for i in range(3):
            copy_lab[c[i][0]][c[i][1]] = 1
        spreadVirus(copy_lab)

def checkVirus():
    for i in range(N):
        for j in range(M):
            if lab[i][j] == 2:
                virus.append((j, i))

checkVirus()
buildWall(0)
print(max(safe_area))