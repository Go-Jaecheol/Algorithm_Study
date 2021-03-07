import sys

n, m = map(int, input().split())
arr = [[] for i in range(n)]
graph = [False] * n

for _ in range(m):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    arr[a].append(b)
    arr[b].append(a)

def dfs(idx, number):
    if number == 4:
        print(1)
        exit()
    for i in arr[idx]:
        if not graph[i]:
            graph[i] = True
            dfs(i, number + 1)
            graph[i] = False

for i in range(n):
    graph[i] = True
    dfs(i, 0)
    graph[i] = False

print(0)