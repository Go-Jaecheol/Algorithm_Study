from collections import deque
from itertools import combinations

def bfs(virus_list):
    dist = [[-1] * N for _ in range(N)]
    dq=deque()
    for pos in virus_list:
        dq.append(pos)
        dist[pos[0]][pos[1]] = 0
    max_dist=0
    while dq:
        x,y=dq.popleft()
        for k in range(4):
            nx= x + direc[k][0]
            ny= y + direc[k][1]

            if 0<=nx<N and 0<=ny<N and map_list[nx][ny]!=1 and dist[nx][ny]==-1:
                dist[nx][ny]=dist[x][y]+1
                if map_list[nx][ny]==0:
                    max_dist=max(max_dist,dist[nx][ny])
                dq.append([nx,ny])

    a = list(sum(dist,[]))
    if a.count(-1)==list(sum(map_list, [])).count(1):
        ans.append(max_dist)

N,M = map(int,input().split())
map_list = [list(map(int, input().split())) for _ in range(N)]
direc = [[1, 0], [0, 1], [-1, 0], [0, -1]]

virus_pos=deque()
ans=[]
for i in range(N):
    for j in range(N):
        if map_list[i][j]==2:
            virus_pos.append([i,j])

for now_virus_list in combinations(virus_pos,M):
    bfs(now_virus_list)

print(min(ans) if ans else -1)