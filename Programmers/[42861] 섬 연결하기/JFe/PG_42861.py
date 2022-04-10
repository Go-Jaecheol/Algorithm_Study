import heapq
def solution(n, costs):
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
        result = 0
        while h:
            l, (a, b) = heapq.heappop(h)
            if find_parent(parent, a) != find_parent(parent, b):
                union_parent(parent, a, b)
                result += l
        return result
    
    answer, h = 0, []
    parent = [int(x) for x in range(n)]
    for i in range(len(costs)):
        heapq.heappush(h, (costs[i][2], (costs[i][0], costs[i][1])))
    answer = kruskal()
    return answer