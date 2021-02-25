import sys
sys.setrecursionlimit(10**6)

N = int(input())
pict = [list(map(ord, input())) for _ in range(N)]
checked = [([0] * N) for _ in range(N)]
rgb_cnt = 0
none_rgb_cnt = 0
alpha = ''
dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

for i in range(N):
    for j in range(N):
        pict[i][j] = chr(pict[i][j])


def checking(a, b):
    checked[a][b] += 1
    for n in range(4):
        x, y = a + dx[n], b + dy[n]
        if 0 <= x < N and 0 <= y < N and checked[x][y] == 0 and pict[x][y] == alpha:
            checking(x, y)


for k in range(N):
    for j in range(N):
        if checked[k][j] == 0:
            alpha = pict[k][j]
            checking(k, j)
            rgb_cnt += 1
        if pict[k][j] == "G":
            pict[k][j] = "R"

checked = [([0] * N) for _ in range(N)]

for k in range(N):
    for j in range(N):
        if checked[k][j] == 0:
            alpha = pict[k][j]
            checking(k, j)
            none_rgb_cnt += 1

print(rgb_cnt, none_rgb_cnt)
