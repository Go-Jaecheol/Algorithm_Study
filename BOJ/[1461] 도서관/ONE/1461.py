N, M = map(int, input().split())
ary = list(map(int, input().split()))
plus = []
minus = []
max_num = 0
ans = 0

for i in range(N):
    if ary[i] < 0:
        minus.append(abs(ary[i]))
        if max_num < abs(ary[i]):
            max_num = abs(ary[i])
    else:
        plus.append(ary[i])
        if max_num < ary[i]:
            max_num = ary[i]

minus.sort()
plus.sort()

cnt = len(plus) - 1
while cnt >= 0:
    ans += plus[cnt]
    cnt -= M

cnt = len(minus) - 1
while cnt >= 0:
    ans += minus[cnt]
    cnt -= M

print(ans * 2 - max_num)