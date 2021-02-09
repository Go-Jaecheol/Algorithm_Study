s1 = ' ' + input()
s2 = ' ' + input()
dp = [[0] * (len(s2)) for _ in range(len(s1))]

for i in range(1, len(s1)):
    for j in range(1, len(s2)):
        if s1[i] == s2[j]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i][j-1], dp[i-1][j])
print(dp[-1][-1])

lcs = []
temp = {'len': dp[-1][-1], 'row': -1, 'col': -1}
for i in reversed(range(1, len(s1))):
    for j in reversed(range(1, len(s2))):
        if s1[i] == s2[j] and temp['len'] == dp[i][j] and temp['row'] != i and temp['col'] != j:
            lcs.append(s1[i])
            temp['len'] -= 1
            temp['row'], temp['col'] = i, j
            break
    if temp['len'] == 0: break
lcs.reverse()
print(''.join(lcs))