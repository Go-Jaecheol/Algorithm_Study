import sys
from collections import deque

def topology_sort():
    global result
    q = deque()
    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)
    while q:
        num = q.popleft()
        result[num] += time[num]
        for i in graph[num]:
            # 먼저 지어져야 하는 건물들이 동시에 지어지는 경우 고려
            result[i] = max(result[i], result[num])
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)

N = int(sys.stdin.readline())
graph = [[] for _ in range(N+1)]
indegree = [0 for _ in range(N+1)]
time = [0 for _ in range(N+1)]
result = [0 for _ in range(N+1)]
for i in range(1, N+1):
    temp = [int(x) for x in sys.stdin.readline().split()]
    time[i] = temp[0]
    for j in range(1, len(temp)):
        if temp[j] == -1: break
        graph[temp[j]].append(i)
        indegree[i] += 1
     
topology_sort()
for i in range(1, N+1):
    print(result[i])