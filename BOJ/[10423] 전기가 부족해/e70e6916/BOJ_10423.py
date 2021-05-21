import sys
N, M, K = map(int, input().split())
power_plant = list(map(int, input().split()))
graph = list(list(map(int, sys.stdin.readline().split())) for _ in range(M))
graph.sort(key=lambda x: x[2])


class disjoint_set:
    def __init__(self, n):
        self.parent = [x for x in range(n)]
        self.count = 0

    def find(self, i):
        if self.parent[i] == i:
            return i
        if self.parent[i] == -1:
            return -1
        self.parent[i] = self.find(self.parent[i])
        return self.parent[i]

    def union(self, x, y):
        if self.parent[x] == -1:
            self.parent[y] = -1
        elif self.parent[y] == -1:
            self.parent[x] = -1
        elif x < y:
            self.parent[y] = x
        else:
            self.parent[x] = y
        self.count += 1


mst = disjoint_set(N+1)
mst_cost = 0
for i in power_plant:
    mst.parent[i] = -1

for u, v, w in graph:
    u_parent, v_parent = mst.find(u), mst.find(v)
    if u_parent != v_parent:
        mst.union(u_parent, v_parent)
        mst_cost += w
print(mst_cost)