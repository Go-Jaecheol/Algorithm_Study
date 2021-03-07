N , M = map(int, input().split())
friend = [[] for _ in range(N)]
result = 0

def dfs(v, depth):
    global result
    visited[v] = True
    if depth == 4:
        result = 1
        return
    for i in range(len(friend[v])):
        next = friend[v][i]        
        if not(visited[next]):
            dfs(next, depth+1)
            visited[next] = False

for i in range(M):
    first, second = map(int, input().split())
    friend[first].append(second)
    friend[second].append(first)

for i in range(N):
    if result == 1:
        print(1)
        break
    visited = [False for _ in range(N)]
    dfs(i, 0)
if result == 0:
    print(0)