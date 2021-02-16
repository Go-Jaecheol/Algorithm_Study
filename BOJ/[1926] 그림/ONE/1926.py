import sys
sys.setrecursionlimit(10**6)

n, m = map(int, input().split())
picture = [list(map(int, input().split())) for _ in range(n)]
checked_pict = [[-1] * m for _ in range(n)]
dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
max_width = 0
tmp_width = 0
cnt_pict = 0


def check(a, b):
    global tmp_width
    checked_pict[a][b] += 1
    tmp_width += 1
    for k in range(4):
        x, y = b + dx[k], a + dy[k]
        if 0 <= x < m and 0 <= y < n:
            if picture[y][x] == 1 and checked_pict[y][x] < 0:
                check(y, x)


for i in range(n):
    for j in range(m):
        if checked_pict[i][j] < 0 and picture[i][j] == 1:
            check(i, j)
            cnt_pict += 1
            if tmp_width > max_width:
                max_width = tmp_width
            tmp_width = 0
print(cnt_pict, max_width, sep="\n")
