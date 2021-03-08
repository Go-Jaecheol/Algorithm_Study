N, M = map(int, input().split())
lib = list(list(map(int, input().split())))

abs_lib, sum_step = [], 0
for i, step in enumerate(lib):
    abs_lib.append([abs(step), True])
    if step < 0:
        abs_lib[i][1] = False
abs_lib.sort(key=lambda x: x[0])

for i in reversed(range(N)):
    if abs_lib[i][0] == 0:
        continue
    complete, cnt = abs_lib[i][0], 1
    abs_lib[i][0] = 0
    for j in reversed(range(i)):
        if cnt == M:
            break
        if abs_lib[j][0] != 0 and abs_lib[i][1] == abs_lib[j][1]:
            abs_lib[j][0] = 0
            cnt += 1
    if i == N-1:
        sum_step += complete
    else:
        sum_step += complete * 2
print(sum_step)