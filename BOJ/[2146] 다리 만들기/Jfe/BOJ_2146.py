import sys
from collections import deque

N = int(sys.stdin.readline())
map = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
visited = [[False for _ in range(N)] for _ in range(N)]
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
label = 1

def divide_area(x, y, label):
    q = deque()
    visited[y][x] = True
    q.append((x, y))
    while q:
        cur_x, cur_y = q.popleft()
        for i in range(4):
            next_x = cur_x + dx[i]
            next_y = cur_y + dy[i]
            if 0 <= next_x <= N-1 and 0 <= next_y <= N-1:
                if not visited[next_y][next_x] and map[next_y][next_x]!=0:
                    visited[next_y][next_x] = True
                    q.append((next_x, next_y))
                elif map[next_y][next_x] == 0:
                    map[cur_y][cur_x] = label

def find_min(x, y, label):
    global result
    q = deque()
    visited = [[False for _ in range(N)] for _ in range(N)]
    count = 0
    visited[y][x] = True
    q.append((x, y, count))
    while q:
        cur_x, cur_y, count = q.popleft()
        for i in range(4):
            next_x = cur_x + dx[i]
            next_y = cur_y + dy[i]
            if 0 <= next_x <= N-1 and 0 <= next_y <= N-1 and not visited[next_y][next_x] and map[next_y][next_x] != 1 and map[next_y][next_x] != label:
                if map[next_y][next_x] == 0:
                    visited[next_y][next_x] = True
                    q.append((next_x, next_y, count+1))
                else:
                    result = min(result, count)

for y in range(N):
    for x in range(N):
        if not visited[y][x] and map[y][x] != 0:
            label += 1  # 섬 가장자리 label (2, 3, ...)
            divide_area(x, y, label)
result = sys.maxsize
for y in range(N):
    for x in range(N):
        if map[y][x] != 0 and map[y][x] != 1:
            find_min(x, y, map[y][x])
print(result)