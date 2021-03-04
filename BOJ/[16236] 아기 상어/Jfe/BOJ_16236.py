from collections import deque
import heapq

N = int(input())
space = [[int(x) for x in input().split()]for y in range(N)]
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
size = 2
time = 0
exp = 0
h = []

def bfs(x, y, result):
    visited = [[0 for x in range(N)]for y in range(N)]
    que = deque()
    visited[y][x] = 1
    que.append((x, y, result))
    eat_cnt = 0
    max_size = 401
    h.clear()

    while que:
        x, y, result = que.popleft()
        if result >= max_size:
            break
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if 0 <= next_x < N and 0 <= next_y < N and visited[next_y][next_x] == 0:
                if space[next_y][next_x] == 0 or space[next_y][next_x] == size:
                    next_result = result + 1
                    visited[next_y][next_x] = 1
                    que.append((next_x, next_y, next_result))
                elif 0 < space[next_y][next_x] < size:
                    next_result = result + 1
                    visited[next_y][next_x] = 1
                    max_size = next_result
                    heapq.heappush(h, (next_y, next_x, next_result))
                    eat_cnt += 1
    if eat_cnt == 0:
        return False
    else:
        return True

for i in range(N):
    for j in range(N):
        if space[i][j] == 9:
            location_y = i
            location_x = j
            space[i][j] = 0
            break

while True:
    finish = bfs(location_x, location_y, 0)
    if finish == 0:
        print(time)
        break
    else:
        location_y, location_x, result = heapq.heappop(h)
        space[location_y][location_x] = 0
        time += result
        exp += 1
        if exp == size:
            size += 1
            exp = 0