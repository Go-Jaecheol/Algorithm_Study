import sys
N = int(sys.stdin.readline())
weight = [int(x) for x in sys.stdin.readline().split()]
sum = 0

weight.sort()
for i in range(N):
    if sum+1 >= weight[i]:
        sum += weight[i]
    else:
        break
print(sum+1)