from collections import deque

N, L, R = map(int, input().split())
nations = [[int(x) for x in input().split()]for y in range(N)]
alliance = []
count = 0
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y):
    global alliance
    que = deque()
    que.append((y, x))
    while que:
        y, x = que.popleft()
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if 0 <= next_x < N and 0 <= next_y < N and visited[next_y][next_x] == 0:
                if L <= abs(nations[next_y][next_x] - nations[y][x]) <= R:
                    visited[next_y][next_x] = 1
                    que.append((next_y, next_x))
                    alliance.append((y, x))
                    alliance.append((next_y, next_x))
    my_set = set(alliance)
    alliance = list(my_set)

    if len(alliance) == 0:
        return 0
    else:
        return 1

def movePopulation():
    temp = []
    population_sum = 0
    length = len(alliance)
    for _ in range(length):
        y, x = alliance.pop()
        population_sum += nations[y][x]
        temp.append((y, x))
    for _ in range(length):
        y, x = temp.pop()
        nations[y][x] = int(population_sum / length)

while True:
    change = False
    visited = [[0 for x in range(N)]for y in range(N)]
    for i in range(N):
        for j in range(N):
            if visited[i][j] == 0:
                visited[i][j] = 1
                if bfs(j, i):
                    change = True
                    movePopulation()
    if not change:
        print(count)
        break
    count += 1