def bfs(N, size):
    global fishI
    global fishJ
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    minV = 0
    q = []
    visited = [[0]*N for _ in range(N)]
    checked = [[0]*N for _ in range(N)]
    q.append(fishI)
    q.append(fishJ)
    visited[fishI][fishJ] = 1
    while(len(q)!=0):
        i = q.pop(0)
        j = q.pop(0)
        if checked[i][j] == 0 and 0<sea[i][j]<size:
            if minV == 0:
                minV = visited[i][j]
                checked[i][j] = minV
            elif visited[i][j] == minV:
                checked[i][j] = minV
        for k in range(4):
            ni = i + dx[k]
            nj = j + dy[k]
            if 0<=ni<N and 0<=nj<N:
                if sea[ni][nj]<=size and visited[ni][nj]==0:
                    q.append(ni)
                    q.append(nj)
                    visited[ni][nj] = visited[i][j] + 1
    for i in range(N):
        for j in range(N):
            if checked[i][j] != 0:
                fishI = i
                fishJ = j
                sea[i][j] = 0
                return checked[i][j]-1
    return 0


N = int(input())
sea = [list(map(int, input().split())) for _ in range(N)]

size = 2
fishI = 0
fishJ = 0
for i in range(N):
    for j in range(N):
        if sea[i][j] == 9:
            fishI = i
            fishJ = j
            sea[i][j] = 0
r = 1
sec = 0
eatCnt = 0
while(r!=0):
    r = bfs(N, size)
    sec += r
    if r!=0:
        eatCnt += 1
        if eatCnt == size:
            size += 1
            eatCnt = 0
print(sec)