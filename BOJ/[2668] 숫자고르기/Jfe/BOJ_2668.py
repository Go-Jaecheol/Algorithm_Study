import sys
sys.setrecursionlimit(10**8)

N = int(input())
second = [int(input()) for x in range(N)]
first = [int(x) for x in range(1,N+1)]
visited = [False for x in range(N)]
result = [False for x in range(N)]

def dfs(v):
    visited[v] = True
    result[v] = True
    next = second[v]
    if visited[next-1] == False and dfs(next-1):
        return True
    elif result[next-1]:
        return True
    result[v] = False
    return False

def checkOverlap():
    for i in range(N):
        if result[i] == False and second[i] == i+1:
            result[i] = True

def printResult():
    num = []
    for i in range(N):
        if result[i] == True:
            num.append(i+1)
    print(len(num))
    num.sort()
    for i in range(len(num)):
        print(num[i])

dfs(0)
checkOverlap()
printResult()