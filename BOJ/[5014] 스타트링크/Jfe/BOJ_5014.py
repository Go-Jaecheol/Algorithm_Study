import sys
from collections import deque
F, S, G, U, D = map(int, sys.stdin.readline().split())
visited = [False for _ in range(F+1)]

def bfs(S):
    q = deque()
    visited[S] = True
    q.append((S, 0))

    while q:
        cur, time = q.popleft()
        if cur == G:
            return time
        if cur+U <= F and not visited[cur+U]:
            visited[cur+U] = True
            q.append((cur+U, time+1))
        if cur-D >= 1 and not visited[cur-D]:
            visited[cur-D] = True
            q.append((cur-D, time+1))
    return -1

result = bfs(S)
if result == -1:
    print("use the stairs")
else:
    print(result)