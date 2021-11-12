import sys
sys.setrecursionlimit(10**8)
T = int(input())

def dfs(v):
    global selected
    visited[v] = True
    result.append(v)
    next = student[v] - 1
    if visited[next]:
        if result and next in result:
            selected += len(result[result.index(next):])
    else:
        dfs(next)

for _ in range(T):
    n = int(input())
    student = [int(x) for x in sys.stdin.readline().split()]
    visited = [False for _ in range(n)]
    selected = 0

    for i in range(n):
        if visited[i]:
            continue
        result = []
        dfs(i)
    print(n - selected)