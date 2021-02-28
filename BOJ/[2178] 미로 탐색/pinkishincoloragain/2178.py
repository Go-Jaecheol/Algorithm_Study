
import sys

m,n = map(int, sys.stdin.readline().split())
miro = []
visited = [[0]*n for _ in range(m)]

for i in range(m):
    line = list(map(int,list(input().strip())))
    miro.append(line)

# print(miro)

dx = [0,0,1,-1]
dy = [1,-1,0,0]

next_xy = [(0,0)]
visited[0][0] = 1

while next_xy:
    cur_x,cur_y = next_xy.pop(0)

    # print(temp_x,temp_y)

    if cur_x == m-1 and cur_y== n-1:
        print(visited[cur_x][cur_y])
        sys.exit(0)

    for i in range(4):
        next_x = cur_x + dx[i]
        next_y = cur_y + dy[i]
        if 0 <= next_x < m and 0 <= next_y < n:
            if visited[next_x][next_y] == 0 and miro[next_x][next_y] == 1:
                visited[next_x][next_y] = visited[cur_x][cur_y] + 1
                next_xy.append((next_x,next_y))

