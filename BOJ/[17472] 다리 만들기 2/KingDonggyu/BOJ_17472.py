import sys
from collections import deque
from itertools import combinations
MAX = sys.maxsize

# 다리 만들기 - dfs
def create_bridge(x, y, d, To):
    global bridge_cnt
    next_x = x + dx[d]
    next_y = y + dy[d]
    if not (0 <= next_x < N and 0 <= next_y < M):
        bridge_cnt = MAX
        return
    # 목적지 섬에 다리 연결
    if Map[next_x][next_y] == To:
        return
    # 바다에 다리 건설
    if Map[next_x][next_y] == 0:
        bridge_cnt += 1
        create_bridge(next_x, next_y, d, To)
    else:
        bridge_cnt = MAX
        return
    return 

# 섬 번호 매기기 - bfs
def find_island(start_x, start_y):
    q = deque([(start_x, start_y)])
    while q:
        x, y = q.popleft()
        visited[x][y] = True
        Map[x][y] = island_cnt + 1
        for d in range(4):
            next_x = x + dx[d]
            next_y = y + dy[d]
            if 0 <= next_x < N and 0 <= next_y < M:
                if Map[next_x][next_y] == 1 and not visited[next_x][next_y]:
                    q.append((next_x, next_y))


class disjoint_set:
    def __init__(self, n):
        self.parent = [-1 for _ in range(n)]
        self.count = 0

    def find(self, i):
        if self.parent[i] < 0:
            return i
        self.parent[i] = self.find(self.parent[i])
        return self.parent[i]

    def union(self, x, y):
        self.parent[y] = x
        self.count += 1


N, M = map(int, input().split())
Map = [[int(i) for i in input().split()] for _ in range(N)]

visited = [[False for _ in range(M)] for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

island_cnt = 0
for i in range(N):
    for j in range(M):
        if Map[i][j] == 1 and not visited[i][j]:
            find_island(i, j)
            island_cnt += 1

# 그래프 생성
graph = []
island_num = [i for i in range(1, island_cnt+1)]
for From, To in list(combinations(island_num, 2)):
    w = MAX
    for i in range(N):
        for j in range(M):
            if Map[i][j] == From:
                for d in range(4):
                    bridge_cnt = 0
                    create_bridge(i, j, d, To)
                    if bridge_cnt < 2: bridge_cnt = MAX
                    w = min(w, bridge_cnt)

    graph.append([From, To, w])

# 모든 섬을 연결하는 최소 다리 길이 찾기 - Kruskal
graph.sort(key=lambda x:x[2])
mst = disjoint_set(island_cnt+1)
mst_cost = 0
for u, v, w in graph:
    if mst.count == island_cnt-1:
        break
    u_parent, v_parent = mst.find(u), mst.find(v)
    if u_parent != v_parent:
        mst.union(u_parent, v_parent)
        mst_cost += w
        if mst_cost >= MAX:
            mst_cost = -1
            break

print(mst_cost)