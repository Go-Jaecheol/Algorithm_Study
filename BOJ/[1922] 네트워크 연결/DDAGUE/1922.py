
N = int(input())
M = int(input())
res = 0
cost = [list(map(int, input().split())) for _ in range(M)]

cost.sort(key=lambda x:x[2])
k = {cost[0][0]}

while True:
    if len(k) == N:
        break
    for index, node in enumerate(cost):
        if node[0] in k and node[1] in k:
            continue
        if node[0] in k or node[1] in k:
            res += node[2]
            k.update([node[0], node[1]])
            cost[index] = [-1, -1, -1]
            break

print(res)