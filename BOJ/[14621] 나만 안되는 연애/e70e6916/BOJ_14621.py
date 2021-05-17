import sys
V, E = map(int, input().split())
sex = list(sys.stdin.readline().split())
graph = list(list(map(int, sys.stdin.readline().split())) for _ in range(E))
graph.sort(key=lambda x: x[2])


class disjoint_set:
    def __init__(self, n):
        self.parent = [-1 for x in range(n)]
        self.count = 0

    def find(self, i):
        if self.parent[i] < 0:
            return i
        self.parent[i] = self.find(self.parent[i])
        return self.parent[i]

    def union(self, x, y):
        self.parent[y] = x
        self.count += 1


mst = disjoint_set(V+1)
mst_cost = 0
check = [0] * V
for u, v, w in graph:
    if mst.count == V-1:
        break
    u_parent, v_parent = mst.find(u), mst.find(v)
    if u_parent != v_parent and sex[u-1] != sex[v-1]:
        check[u-1], check[v-1] = 1, 1
        mst.union(u_parent, v_parent)
        mst_cost += w
if sum(check) != V:
    print(-1)
else:
    print(mst_cost)
