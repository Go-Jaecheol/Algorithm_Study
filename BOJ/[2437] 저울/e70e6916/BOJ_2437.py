import sys
N = int(sys.stdin.readline())
weight = list(map(int, sys.stdin.readline().split()))
weight.sort()
_sum = 1

for i in range(N):
    if _sum < weight[i]:
        break
    else:
        _sum += weight[i]
print(_sum)
