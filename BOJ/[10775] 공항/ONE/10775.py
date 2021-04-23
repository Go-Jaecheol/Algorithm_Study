G = int(input())
P = int(input())
parent = [0]

for i in range(1, G + 1):
    parent.append(i);


def find(n):
    if n == parent[n]:
        return n
    p = find(parent[n])
    parent[n] = p
    return parent[n]


def union(x, y):
    x = find(x)
    y = find(y)
    parent[x] = y


cnt = 0
for _ in range(P):
    g = int(input())
    emptyGate = find(g)

    if emptyGate == 0:
        break
    cnt += 1
    union(emptyGate, emptyGate - 1)

print(cnt)
