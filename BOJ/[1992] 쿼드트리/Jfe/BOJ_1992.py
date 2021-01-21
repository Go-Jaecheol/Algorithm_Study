n = int(input())
video = [[int(x) for x in input()]for y in range(n)]
result = ""

def checkSame(row_sp, col_sp, index):
    first = video[col_sp][row_sp]
    for i in range(col_sp, col_sp+index):
        for j in range(row_sp, row_sp+index):
            if video[i][j] != first:
                return False
    return True

def divideVideo(row_sp, col_sp, index):
    global result
    if (checkSame(row_sp, col_sp, index)):
        result += str(video[col_sp][row_sp])
    else:
        index //= 2
        result += "("
        divideVideo(row_sp, col_sp, index)
        divideVideo(row_sp+index, col_sp, index)
        divideVideo(row_sp, col_sp+index, index)
        divideVideo(row_sp+index, col_sp+index, index)
        result += ")"

divideVideo(0, 0, n)
print(result)