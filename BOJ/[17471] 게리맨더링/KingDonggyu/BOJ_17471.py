import sys
from collections import deque
from itertools import combinations

N = int(sys.stdin.readline())
population = [int(x) for x in sys.stdin.readline().split()]
population.insert(0, False)
area_info = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
area_info.insert(0, False)


def bfs(area):
    visited[area[0]] = True
    queue = deque([area[0]])
    sum_population = population[area[0]]
    while queue:
        x = queue.popleft()
        for i, v in enumerate(area_info[x]):
            if i != 0 and v in area and not visited[v]:
                visited[v] = True
                queue.append(v)
                sum_population += population[v]
    return sum_population


total_population = sum(population)
min_diff = sys.maxsize
for i in range(N//2):
    for comb in combinations(range(1, N+1), i+1):
        visited = [False] * (N+1)
        area1 = list(comb)
        area2 = list(x for x in range(1, N+1) if not x in comb)
        sum1, sum2 = bfs(area1), bfs(area2)
        if sum1 + sum2 == total_population:
            min_diff = min(min_diff, abs(sum1 - sum2))

print(-1 if min_diff == sys.maxsize else min_diff)
