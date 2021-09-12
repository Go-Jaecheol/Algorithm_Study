import sys
from collections import deque
sys.setrecursionlimit(1000000)
input = sys.stdin.readline


def dfs(x):
    global success
    visited[x] = True
    student = students[x]
    team.append(x)
    if visited[student]:
        if student in team:
            success += len(team) - team.index(student)
    else:
        dfs(student)


T = int(input())
for _ in range(T):
    n = int(input())
    students = [0] + list(map(int, input().split()))
    visited = [False] * (n + 1)
    success = 0
    for i in range(1, n+1):
        if not visited[i]:
            team = []
            dfs(i)
    print(n - success)
