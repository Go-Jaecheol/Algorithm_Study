
import sys

n = int(sys.stdin.readline())
arr = [i for i in range(n)]
res = []

for i in range(n):
    arr[i] = int(sys.stdin.readline())-1

stack = []
visited = [-1] * n

for i in range(n):
    target = i

    while visited[target] != 1:
        visited[target] = 1
        stack.append(target)
        target = arr[target]

    if target == i:
        for item in stack:
            if item not in res:
                res.append(item)

    else:
        stack = []
        for j in range(n):
            visited[j] = -1

res.sort()
print(len(res))
for i in res:
    print(i+1)



