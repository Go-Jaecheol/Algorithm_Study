import sys

def check_attach(y, x):
    arr = []
    for k in range(1, 6):
        for i in range(k):
            for j in range(k):
                if y+i >= 10 or x+j >= 10 or field[y+i][x+j] == 0:
                    return arr
        arr.append(k)
    return arr

def search(one_cnt, cnt):
    global result, paper_cnt
    if one_cnt == 0:
        result = min(result, cnt)
        return
    for i in range(10):
        for j in range(10):
            if field[i][j] == 1:
                arr = check_attach(i, j)
                for n in arr:
                    if paper_cnt[n-1] > 0:
                        paper_cnt[n-1] -= 1
                        for y in range(n):
                            for x in range(n):
                                field[i+y][j+x] = 0
                        search(one_cnt - (n ** 2), cnt + 1)
                        paper_cnt[n-1] += 1
                        for y in range(n):
                            for x in range(n):
                                field[i+y][j+x] = 1
                return

field = [[int(x) for x in sys.stdin.readline().split()]for _ in range(10)]
paper_cnt = [5, 5, 5, 5, 5]
one_cnt, result = 0, sys.maxsize

for i in range(10):
    for j in range(10):
        if field[i][j] == 1:
            one_cnt += 1
search(one_cnt, 0)
if result == sys.maxsize:
    result = -1
print(result)