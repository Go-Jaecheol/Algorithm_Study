num = int(input())
sheet_matrix = [[int(x) for x in input().split()] for _ in range(num)]
cnt = [0, 0, 0]  # -1, 0, 1 's count


def check_sheet(r, c, s):  # r:row_index,c:col_index,s:sheet_size
    global sheet_matrix
    global cnt
    if s == 1:
        cnt[sheet_matrix[r][c] + 1] += 1
        return 0
    check = sheet_matrix[r][c]
    for i in range(r, r + s):
        for j in range(c, c + s):
            if check != sheet_matrix[i][j]:
                tmp = int(s / 3)
                for k in range(0, 3):
                    for l in range(0, 3):
                        check_sheet(r + tmp * k, c + tmp * l, tmp)
                return 0
    cnt[check + 1] += 1
    return 0


check_sheet(0, 0, num)
for i in range(0, 3):
    print(cnt[i])
