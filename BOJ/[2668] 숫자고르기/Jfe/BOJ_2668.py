import sys
sys.setrecursionlimit(10**8)

N = int(input())
second = [int(input()) for x in range(N)]
result = []

def dfs(v, start):
    visited[v] = True
    next = second[v]
    if not(visited[next-1]):
        dfs(next-1, start)
    elif visited[next-1] and next-1 == start:
        result.append(next)

for i in range(N):
    visited = [False for x in range(N)]
    dfs(i, i)

print(len(result))
for i in range(len(result)):
    print(result[i])