N = int(input())
ary = [0]
ans = []
cnt = 0
tmp = 0
for _ in range(N):
    ary.append(int(input()))


def dfs(n):
    global N
    global cnt
    cnt += 1
    if cnt > N:
        cnt = 0
        return
    if tmp == ary[n]:
        ans.append(tmp)
        cnt = 0
        return
    dfs(ary[n])


for i in range(1, N + 1):
    tmp = i
    dfs(i)
print(len(ans))
for j in ans:
    print(j)
