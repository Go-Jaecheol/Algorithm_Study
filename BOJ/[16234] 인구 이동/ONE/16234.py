import sys
sys.setrecursionlimit(10**5)

N, L, R = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
cnt = 0
ans = []


def bfs(a, b):
    for i in range(4):
        x, y = a + dx[i], b + dy[i]
        if 0 <= x < N and 0 <= y < N and not check_A[x][y] and L <= abs(A[a][b] - A[x][y]) <= R:
            check_A[x][y] = True
            ans.append([x, y])
            bfs(x, y)


while True:
    check_A = [([False] * N) for _ in range(N)]
    check = False
    for j in range(N):
        for k in range(N):
            ans.clear()
            if not check_A[j][k]:
                ans.append([j, k])
                check_A[j][k] = True
                bfs(j, k)
                if len(ans) > 1:
                    check = True
                    pop_avrg = int(sum(A[m][n] for m, n in ans) / len(ans))
                    for m, n in ans:
                        A[m][n] = pop_avrg
    if not check:
        break
    cnt += 1
print(cnt)