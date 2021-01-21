n = int(input())
paper = [[int(x) for x in input().split()]for y in range(n)]
count = [0,0,0] # -1, 0, 1 의 개수

def checkSame(row_sp, col_sp, index):
    first = paper[col_sp][row_sp]
    for i in range(col_sp, col_sp+index):
        for j in range(row_sp, row_sp+index):
            if paper[i][j] != first:
                return False
    return True

def dividePaper(row_sp, col_sp, index):
    if(checkSame(row_sp, col_sp, index)):
        count[paper[col_sp][row_sp] + 1] += 1
    else:
        index //= 3
        dividePaper(row_sp, col_sp, index)
        dividePaper(row_sp+index, col_sp, index)
        dividePaper(row_sp+index*2, col_sp, index)
        dividePaper(row_sp, col_sp+index, index)
        dividePaper(row_sp+index, col_sp+index, index)
        dividePaper(row_sp+index*2, col_sp+index, index)
        dividePaper(row_sp, col_sp+index*2, index)
        dividePaper(row_sp+index, col_sp+index*2, index)
        dividePaper(row_sp+index*2, col_sp+index*2, index)

dividePaper(0, 0, n)
for i in range(3):
    print(count[i])