from collections import deque

N = int(input())
sea = list(list(map(int, input().split())) for _ in range(N))
direction = [[-1, 0], [0, -1], [0, 1], [1, 0]]  # 상, 좌, 우, 하
shark, eat, second = 2, 0, 0
visited = list([0] * N for _ in range(N))


def eat_fish(x, y):
    global start_x, start_y
    global shark, eat, second, visited

    eat += 1
    if eat == shark:
        shark += 1
        eat = 0

    sea[start_x][start_y], sea[x][y] = 0, 9
    start_x, start_y = x, y
    second += visited[x][y]
    visited = list([0] * N for _ in range(N))


# BFS
def shark_move():
    fish = {}
    start = (start_x, start_y)
    queue = deque([(start_x, start_y)])

    while queue:
        i, j = queue.popleft()
        for d in direction:
            x, y = i + d[0], j + d[1]
            if 0 <= x < N and 0 <= y < N and (x, y) != (start_x, start_y):
                if visited[x][y] == 0 and shark >= sea[x][y]:  # move
                    visited[x][y] = visited[i][j] + 1

                    if fish and fish['visited'] < visited[x][y]:
                        eat_fish(fish['x'], fish['y'])
                        fish = {}
                        break

                    if 0 < sea[x][y] < shark:  # eat
                        if not fish:
                            fish = {'visited': visited[x][y], 'x': x, 'y': y}
                        else:
                            if fish['x'] == x:
                                if fish['y'] > y:
                                    fish['x'], fish['y'] = x, y
                            else:
                                if fish['x'] > x:
                                    fish['x'], fish['y'] = x, y

                    queue.append((x, y))

        if fish and not queue:
            eat_fish(fish['x'], fish['y'])
            fish = {}

        if start != (start_x, start_y):  # 출발 지점이 변동 된 경우
            start = (start_x, start_y)
            queue = deque([(start_x, start_y)])

    print(second)


start_x, start_y = 0, 0
check = False
for i in range(N):
    for j in range(N):
        if sea[i][j] == 9:
            start_x, start_y, check = i, j, True
            shark_move()
            break
    if check: break
