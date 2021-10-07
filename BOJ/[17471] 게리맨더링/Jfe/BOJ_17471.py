import sys
from collections import deque
from itertools import combinations

N = int(sys.stdin.readline())
population = [int(x) for x in sys.stdin.readline().split()]
relation = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
visited = [False for _ in range(N)]
result = -1

def bfs(area):
    global visited
    q = deque()
    q.append(area[0])
    visited[area[0]] = True
    sum = population[area[0]]
    while q:
        num = q.popleft()
        for i in range(1, len(relation[num])):
            next = relation[num][i] - 1
            if not visited[next] and next in area:
                visited[next] = True
                q.append(next)
                sum += population[next]
    return sum

for i in range(1, N//2 + 1):
    for combi in combinations(range(N), i):
        visited = [False for _ in range(N)]
        area1 = list(combi)
        area2 = list(int(x) for x in range(N) if x not in combi)
        sum1 = bfs(area1)
        sum2 = bfs(area2)
        if False not in visited:
            if result == -1:
                result = abs(sum1 - sum2)
            else:
                result = min(result, abs(sum1 - sum2))

print(result)