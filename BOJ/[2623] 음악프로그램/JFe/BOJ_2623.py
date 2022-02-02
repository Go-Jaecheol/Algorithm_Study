import sys
from collections import deque
N, M = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N+1)]
indegree = [0 for _ in range(N+1)]
result = []
for i in range(M):
    temp = [int(x) for x in sys.stdin.readline().split()]
    count, last = temp[0], temp[1]
    del temp[0]
    for j in range(1, count):
        graph[last].append(temp[j])
        indegree[temp[j]] += 1
        last = temp[j]

def topology_sort():
    global result
    q = deque()
    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)
    while q:
        num = q.popleft()
        result.append(num)
        for i in graph[num]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)
topology_sort()
if len(result) != N:
    print(0)
else:
    for i in result:
        print(i, end=' ')