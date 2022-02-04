import sys
from collections import deque
T = int(sys.stdin.readline())
def topology_sort():
    global result
    q = deque()
    for i in range(1, n+1):
        if indegree[i] == 0:
            q.append(i)
    while q:
        num = q.popleft()
        result.append(num)
        for i in graph[num]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)

# 테스트 케이스
for _ in range(T):
    n = int(sys.stdin.readline())
    graph = [[] for _ in range(n+1)]
    indegree = [0 for _ in range(n+1)]
    result = []
    # 그래프 정보 입력
    temp = [int(x) for x in sys.stdin.readline().split()]
    for i in range(n-1):
        last = temp[i]
        for j in range(i+1, n):
            graph[last].append(temp[j])
            indegree[temp[j]] += 1
    # 순위 변경
    m = int(sys.stdin.readline())
    for i in range(m):
        a, b = map(int, sys.stdin.readline().split())
        # 원래 a가 b보다 순위가 높은 경우
        if b in graph[a]:
            graph[a].remove(b)
            graph[b].append(a)
            indegree[b] -= 1
            indegree[a] += 1
        # 원래 b가 a보다 순위가 높은 경우
        elif a in graph[b]:
            graph[b].remove(a)
            graph[a].append(b)
            indegree[a] -= 1
            indegree[b] += 1
    topology_sort()
    if len(result) != n:
        print("IMPOSSIBLE")
    else:
        for i in result:
            print(i, end=' ')