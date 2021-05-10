import sys, heapq
N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
parent = [int(x) for x in range(N+1)]
h= []
result = 0

def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a = find(a)
    b = find(b)
    if(a < b):
        parent[b] = a
    else:
        parent[a] = b

for _ in range(M):
    A, B, C = map(int, sys.stdin.readline().split())
    heapq.heappush(h, [C, A, B])

while h:
    C, A, B = heapq.heappop(h)
    if find(A) != find(B):
        union(A, B)
        result += C
print(result)