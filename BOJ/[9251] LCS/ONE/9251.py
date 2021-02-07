a = input()
b = input()
x = len(a)
y = len(b)
table = [[0]*(y+1) for _ in range(x+1)]

for i in range(1, x+1):
    for j in range(1, y+1):
        if a[i-1] == b[j-1]:
           table[i][j] = table[i-1][j-1] + 1
        else:
            table[i][j] = max(table[i][j-1], table[i-1][j])
print(table[x][y])