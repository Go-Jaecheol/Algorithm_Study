import sys
N = int(input())
graph = []
planet_x, planet_y, planet_z = [], [], []
for i in range(N):
    x, y, z = map(int, sys.stdin.readline().split())
    planet_x.append((x, i))
    planet_y.append((y, i))
    planet_z.append((z, i))

planet_x.sort()
planet_y.sort()
planet_z.sort()
for i in range(N-1):
    graph.append([planet_x[i][1], planet_x[i + 1][1], abs(planet_x[i][0] - planet_x[i + 1][0])])
    graph.append([planet_y[i][1], planet_y[i + 1][1], abs(planet_y[i][0] - planet_y[i + 1][0])])
    graph.append([planet_z[i][1], planet_z[i + 1][1], abs(planet_z[i][0] - planet_z[i + 1][0])])
graph.sort(key=lambda x: x[2])


class DisjointSet:
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


mst = DisjointSet(N+1)
mst_cost = 0
for u, v, w in graph:
    if mst.count == N-1:
        break
    u_parent, v_parent = mst.find(u), mst.find(v)
    if u_parent != v_parent :
        mst.union(u_parent, v_parent)
        mst_cost += w
print(mst_cost)