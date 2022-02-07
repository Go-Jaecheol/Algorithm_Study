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

def solution(n, costs):
    answer = 0
    mst = disjoint_set(n)
    
    for x, y, cost in sorted(costs, key=lambda x:x[2]):
        if mst.count == n-1: break
        x_parent, y_parent = mst.find(x), mst.find(y)
        if x_parent != y_parent:
            mst.union(x_parent, y_parent)
            answer += cost

    return answer