from collections import deque
from itertools import combinations

N, M = map(int, input().split())
lab = list(list(map(int, input().split())) for _ in range(N))
direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]
safe = 0

def check_safe():
    global safe
    cnt = 0
    for i in range(N):
        for j in range(M):
            if copy_lab[i][j] == 0:
                cnt += 1
    if safe < cnt:
        safe = cnt

def spread_virus():
    visited = list([0] * M for _ in range(N))
    queue = deque([])

    for vi in virus:
        queue.append(vi)
        while queue:
            i, j = queue.popleft()
            for d in direction:
                x, y = i + d[0], j + d[1]
                if 0 <= x < N and 0 <= y < M:
                    if visited[x][y] == 0 and copy_lab[x][y] == 0:
                        copy_lab[x][y] = 2
                        queue.append((x, y))
                        visited[x][y] = 1
    check_safe()

def build_wall():
    zero = []
    for i in range(N):
        for j in range(M):
            if lab[i][j] == 0:
                zero.append((i, j))

    global copy_lab
    combi = list(combinations(zero, 3))
    for c in combi:
        copy_lab = [lab[x][:] for x in range(N)]
        for i in range(3):
            copy_lab[c[i][0]][c[i][1]] = 1
        spread_virus()

virus = []
for i in range(N):
    for j in range(M):
        if lab[i][j] == 2:
            virus.append((i, j))

build_wall()
print(safe)