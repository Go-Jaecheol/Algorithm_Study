N, M = map(int, input().split())
distance = list(map(int, input().split()))

plus = []
minus = []
max_res = 0

for i in distance:
    if i > 0:
        plus.append(i)
    else:
        minus.append(i)
plus.sort(reverse=True)
minus.sort()

for i in distance:
    if abs(i) > abs(max_res):
        max_res = i

res = []
for i in range(0, len(plus), M):
    if plus[i] != max_res:
        res.append(plus[i])

for i in range(0, len(minus), M):
    if minus[i] != max_res:
        res.append(minus[i])

final_res = 0
for i in res:
    final_res += abs(i * 2)
final_res += abs(max_res)

print(final_res)

