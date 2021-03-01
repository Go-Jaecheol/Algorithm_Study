import sys 
from collections import deque 
T = int(input()) 
net = [list(map(int, sys.stdin.readline().split())) for _ in range(T)] 
visited = [[False]*T for _ in range(T)] 
res = [] 
cnt = 0 
exp = 2 
dx = [1, -1, 0, 0] 
dy = [0, 0, 1, -1] 
level = 2 
real_cnt = 0 

def bfs(s): 
    global level 
    if visited[s[0]][s[1]] == True: 
        return 
    visited[s[0]][s[1]] = True 
    for i in range(4): 
        rx = s[0] + dx[i] 
        ry = s[1] + dy[i] 
        if rx == T or rx == -1 or ry == -1 or ry ==T: 
            continue 
        if visited[rx][ry] == True: 
            continue 
        if level >= net[rx][ry]: 
            Q.append((rx,ry)) 
        if level > net[rx][ry] > 0: 
            res.append((rx,ry)) 

for i in range(T): 
    for j in range(T): 
        if net[i][j] == 9: 
            break 
    if net[i][j] == 9: 
        net[i][j] = 0 
        break 
Q = deque([(i,j)]) 
while Q: 
    for i in range(len(Q)): 
        bfs(Q.popleft()) 
    cnt += 1 
    if res: 
        res.sort() 
        Q = deque([res.pop(0)]) 
        net[Q[0][0]][Q[0][1]] = 0 
        res = [] 
        visited = [[False] * T for _ in range(T)] 
        exp -= 1 
        if exp == 0: 
            level += 1 
            exp = level 
        real_cnt = cnt 
        for i in range(T): 
            for j in range(T): 
                if level > net[i][j]: 
                    break 
            if level > net[i][j]: 
                break
        else: 
            break 
print(real_cnt)