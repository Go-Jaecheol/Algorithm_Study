import sys, heapq
N = int(sys.stdin.readline())
parent = [int(x) for x in range(N)]
h= []
dx = []
dy = []
dz = []
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

for i in range(N):
    x, y, z = map(int, sys.stdin.readline().split())
    dx.append((x, i)), dy.append((y, i)), dz.append((z,i))
dx.sort(), dy.sort(), dz.sort()
for i in range(N-1):
    heapq.heappush(h, [abs(dx[i+1][0] - dx[i][0]), dx[i][1], dx[i+1][1]])
    heapq.heappush(h, [abs(dy[i+1][0] - dy[i][0]), dy[i][1], dy[i+1][1]])
    heapq.heappush(h, [abs(dz[i+1][0] - dz[i][0]), dz[i][1], dz[i+1][1]])

while h:
    C, A, B = heapq.heappop(h)
    if find(A) != find(B):
        union(A, B)
        result += C
print(result)