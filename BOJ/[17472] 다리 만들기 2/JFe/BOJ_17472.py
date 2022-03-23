import sys, heapq
from collections import deque
from itertools import combinations

def number_island(x, y, cnt):
    q = deque()
    q.append((x, y))
    map_list[y][x] = cnt
    # BFS 탐색
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
    result = sys.maxsize
    # 방향 4군데
    for i in range(4):
        stack = []
        stack.append((x, y))
        length = 0
        # 그 방향으로 DFS 탐색
        while stack:
            cur_x, cur_y = stack.pop()
            next_x, next_y = cur_x + dx[i], cur_y + dy[i]
            # 범위 벗어나는 경우
            if not (0 <= next_x < M and 0 <= next_y < N):
                break
            # 바다인 경우
            elif map_list[next_y][next_x] == 0:
                length += 1
                stack.append((next_x, next_y))
            # 목적지인 경우
            elif map_list[next_y][next_x] == dest:
                if length >= 2:
                    result = min(result, length)
                break
            # 목적지가 아닌 땅인 경우
            else:
                break
    return result

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if(a < b):
        parent[b] = a
    else:
        parent[a] = b

def kruskal():
    result, cnt = 0, 0
    while h:
        l, a, b = heapq.heappop(h)
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)
            result += l
            cnt += 1
    # 모든 노드 방문했는지 확인
    if cnt != island_cnt-2:
        return -1
    return result

N, M = map(int, sys.stdin.readline().split())
map_list = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
visited = [[False for _ in range(M)] for _ in range(N)]
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
island_cnt, h = 1, []

for i in range(N):
    for j in range(M):
        if not visited[i][j] and map_list[i][j] == 1:
            number_island(j, i, island_cnt)
            island_cnt += 1

parent = [int(x) for x in range(island_cnt)]
# 섬 조합 쌍 생성
comb_list = combinations([int(x) for x in range(1, island_cnt)], 2)
for comb in comb_list:
    comb = list(comb)
    bridge_len = sys.maxsize
    for i in range(N):
        for j in range(M):
            # 해당 조합에 맞는 다리 만들고 길이 최솟값 저장
            if map_list[i][j] == comb[0]:
                result = make_bridge(j, i, comb[1])
                bridge_len = min(result, bridge_len)
    # 섬, 다리 조합 우선순위 큐에 저장
    if bridge_len != sys.maxsize:
        heapq.heappush(h, [bridge_len, comb[0], comb[1]])
# 크루스칼 알고리즘 수행
print(kruskal())