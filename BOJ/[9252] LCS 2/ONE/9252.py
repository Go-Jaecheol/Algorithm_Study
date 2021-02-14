a = input()
b = input()
x = len(a)
y = len(b)
ans = ''
table = [[0] * (x + 1) for _ in range(y + 1)]
for i in range(1, y + 1):
    for j in range(1, x + 1):
        if a[j - 1] == b[i - 1]:
            table[i][j] = table[i - 1][j - 1] + 1
        else:
            table[i][j] = max(table[i - 1][j], table[i][j - 1])
print(table[y][x])
tmp = table[y][x]
k = y
n = x
while tmp != 0:
    if table[k][n - 1] == tmp - 1 and table[k - 1][n] == tmp - 1:
        ans = a[n - 1] + ans
        tmp -= 1
        k -= 1
        n -= 1
    else:
        if table[k - 1][n] > table[k][n - 1]:
            k -= 1
        else:
            n -= 1
print(ans)