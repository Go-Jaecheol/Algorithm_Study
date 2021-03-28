import sys
G = int(sys.stdin.readline())
P = int(sys.stdin.readline())
gi = [int(sys.stdin.readline()) for _ in range(P)]
parent = [int(x) for x in range(G+1)]
count = 0

def find(num):
    if num == parent[num]:
        return num
    parent[num] = find(parent[num])
    return parent[num]

def union(n1, n2):
    p1 = find(n1)
    p2 = find(n2)
    if p1 < p2:
        parent[p2] = p1
    else:
        parent[p1] = p2

for i in range(P):
    num = find(gi[i])
    if not num:
        break
    union(num, num-1)
    count += 1
print(count)