import sys
from collections import deque
def topology_sort():
    q = deque()
    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)
    while q:
        num = q.popleft()
        result[num] += time[num]
        for i in graph[num]:
            indegree[i] -= 1
            result[i] = max(result[i], result[num])
            if indegree[i] == 0:
                q.append(i)
        
T = int(sys.stdin.readline())
for _ in range(T):
    N, K = map(int, sys.stdin.readline().split())
    time = [0]
    for x in sys.stdin.readline().split():
        time.append(int(x))
    graph = [[] for _ in range(N+1)]
    indegree = [0 for _ in range(N+1)]
    result = [0 for _ in range(N+1)]
    for i in range(K):
        a, b = map(int, sys.stdin.readline().split())
        graph[a].append(b)
        indegree[b] += 1
    W = int(sys.stdin.readline())
    topology_sort()
    print(result[W])