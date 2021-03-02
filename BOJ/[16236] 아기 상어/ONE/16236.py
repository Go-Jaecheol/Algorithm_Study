from heapq import heappop, heappush


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
q = []

def init():
    for y in range(N):
        for x in range(N):
            if arr[y][x] == 9:
                heappush(q, (0, y, x))
                arr[y][x] = 0
                return

def bfs():
    global q
    body, eat, distance = 2, 0, 0
    path = [[0]*N for _ in range(N)]
    while q:
        d, y, x = heappop(q)
        if 0 < arr[y][x] < body:
            eat += 1
            arr[y][x] = 0
            if eat == body:
                body += 1
                eat = 0
            distance += d
            d = 0
            q = []
            path = [[0]*N for _ in range(N)]

        for dx, dy in (0, -1), (-1, 0), (1, 0), (0, 1):
            nd, ny, nx = d+1, y+dy, x+dx
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if 0 < arr[ny][nx] > body or path[ny][nx]:
                continue
            path[ny][nx] = 1
            heappush(q, (nd, ny, nx))
    print(distance)

init()
bfs()