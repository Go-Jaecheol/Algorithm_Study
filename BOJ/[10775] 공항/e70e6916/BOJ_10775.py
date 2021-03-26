import sys
sys.setrecursionlimit(100000)
G, P = int(sys.stdin.readline()), int(sys.stdin.readline())
g = list(int(sys.stdin.readline()) for _ in range(P))


class disjoint_set:
    def __init__(self, n):
        self.parent = [-1 for _ in range(n)]
        self.count = 0


    def find(self, i): 
        if self.parent[i] < 0:
            return i
        self.parent[i] = self.find(self.parent[i])
        return self.parent[i]
        

    def union(self, i):
        self.parent[i] = i-1
        self.count += 1


gate = disjoint_set(G+1)
for i in range(P):
    docking = gate.find(g[i])
    if docking == 0: break
    gate.union(docking)
print(gate.count)
