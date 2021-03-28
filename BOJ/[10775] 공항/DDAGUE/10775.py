import sys
input = sys.stdin.readline
gate = int(input())
plane = int(input())

G_list = [i for i in range(gate + 1)]
arr = [int(input()) for _ in range(plane)]

def find(tmp):
    if G_list[tmp] == tmp:
        return tmp
    G_list[tmp] = find(G_list[tmp])
    return G_list[tmp]

def union(a, b):
    a = find(a)
    b = find(b)
    G_list[b] = a

res = 0
for gate in arr:
    plane = find(gate)
    if plane == 0:
        break
    res += 1
    union(plane - 1, plane)
print(res)