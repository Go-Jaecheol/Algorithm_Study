import sys
from collections import deque
from itertools import combinations

N, M = map(int, sys.stdin.readline().split())
map_list = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
visited = [[False for _ in range(M)] for _ in range(N)]
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def number_island(x, y, cnt):
    q = deque()
    q.append((x, y))
    map_list[y][x] = cnt
    while q:
        x, y = q.popleft()
        for i in range(4):
            next_x, next_y = x + dx[i], y + dy[i]
            if 0 <= next_x < M and 0 <= next_y < N:
                if not visited[next_y][next_x] and map_list[next_y][next_x] == 1:
                    map_list[next_y][next_x] = cnt
                    q.append((next_x, next_y))
                    visited[next_y][next_x] = True

def make_bridge(x, y, dest):
    stack = []
    result = sys.maxsize
    for i in range(4):
        stack.append((x, y))
        bridge_len = 0
        while stack:
            x, y = stack.pop()
            next_x, next_y = x + dx[i], y + dy[i]
            if not (0 <= next_x < M and 0 <= next_y < N):
                break
            elif map_list[next_y][next_x] == 0:
                bridge_len += 1
                stack.append((next_x, next_y))
            elif map_list[next_y][next_x] == dest:
                if bridge_len >= 2:
                    result = min(result, bridge_len)
                break
    return result

island_cnt = 1
for i in range(N):
    for j in range(M):
        if not visited[i][j] and map_list[i][j] == 1:
            number_island(j, i, island_cnt)
            island_cnt += 1

graph = []
comb_list = combinations([int(x) for x in range(1, island_cnt)], 2)
for comb in comb_list:
    comb = list(comb)
    bridge_len = sys.maxsize
    for i in range(N):
        for j in range(M):
            if map_list[i][j] == comb[0]:
                result = make_bridge(j, i, comb[1])
                bridge_len = min(result, bridge_len)
    if bridge_len != sys.maxsize:
        graph.append((comb[0], comb[1], bridge_len))


print()