N, M = map(int, input().split())
ary = [[] for _ in range(N)]
check = [False for _ in range(N)]
ans = 0

for _ in range(M):
    a, b = map(int, input().split())
    ary[a].append(b)
    ary[b].append(a)


def dfs(n, cnt):
    global ans
    if cnt >= 4:
        ans = 1
        return
    for i in ary[n]:
        if not check[i]:
            check[i] = True
            dfs(i, cnt + 1)
            check[i] = False


for j in range(N):
    check[j] = True
    dfs(j, 0)
    check[j] = False
    if ans == 1:
        break
print(ans)