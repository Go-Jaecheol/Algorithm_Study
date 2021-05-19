import sys, heapq
N, M, K = map(int, sys.stdin.readline().split())
elec = [int(x) for x in sys.stdin.readline().split()]
parent = [int(x) for x in range(N+1)]
h= []
result = 0

def find(x):
    if parent[x] == -1:
        return -1
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a = find(a)
    b = find(b)
    if (a == -1):
        parent[b] = -1
    elif (b == -1):
        parent[a] = -1
    elif (a < b):
        parent[b] = a
    else:
        parent[a] = b

for _ in range(M):
    A, B, C = map(int, sys.stdin.readline().split())
    heapq.heappush(h, [C, A, B])
for i in elec:
    parent[i] = -1

while h:
    C, A, B = heapq.heappop(h)
    if find(A) != find(B):
        union(A, B)
        result += C
print(result)