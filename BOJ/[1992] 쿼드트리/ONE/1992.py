num = int(input())
matrix = [[int(x) for x in input()] for _ in range(num)]
res_str = []
cnt = 0


def check_square(r, c, s):  # r:row_index,c:col_index,s:sheet_size
    global matrix
    global res_str
    global cnt
    if s == 1:
        res_str.append(matrix[r][c])
        cnt += 1
        return 0
    check = matrix[r][c]
    for i in range(r, r + s):
        for j in range(c, c + s):
            if check != matrix[i][j]:
                res_str.append('(')
                cnt += 1
                tmp = int(s / 2)
                for k in range(0, 2):
                    for l in range(0, 2):
                        check_square(r + tmp * k, c + tmp * l, tmp)
                res_str.append(')')
                cnt += 1
                return 0
    res_str.append(matrix[r][c])
    cnt += 1
    return 0


check_square(0, 0, num)
for m in range(0, cnt):
    print(res_str[m], end='')
