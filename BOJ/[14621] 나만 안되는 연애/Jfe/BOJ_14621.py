import sys, heapq
N, M = map(int, sys.stdin.readline().split())
school = sys.stdin.readline().split()
parent = [int(x) for x in range(N+1)]
check = [0 for _ in range(N)]
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
    if school[A-1] != school[B-1]:
        heapq.heappush(h, [C, A, B])

while h:
    C, A, B = heapq.heappop(h)
    if find(A) != find(B):
        check[A - 1] = check[B - 1] = 1
        union(A, B)
        result += C
for i in range(N):
    if not check[i]:
        result = -1
print(result)