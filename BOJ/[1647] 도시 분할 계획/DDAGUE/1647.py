N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(M)]
U = [0] * (N + 1)
edge = []
ans = 0

graph.sort(key=lambda x:x[2])
for i in range(1, N + 1):
    U[i] = i

def find(x):
    if U[x] != x:
        U[x] = find(U[x])
    return U[x]

def merge(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        U[b] = a
    else:
        U[a] = b

for a, b, c in graph:
    if find(a) != find(b):
        merge(a, b)
        ans += c
        edge.append(c)

ans -= edge.pop()

print(ans)