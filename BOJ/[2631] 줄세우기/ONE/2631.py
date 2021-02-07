from bisect import bisect_left

n = int(input())
line = [int(input()) for _ in range(n)]

lis = []

for i in range(n):
    if not lis or lis[-1] < line[i]:
        lis.append(line[i])
    elif lis[-1] > line[i]:
        lis[bisect_left(lis, line[i])] = line[i]
print(n-len(lis))
