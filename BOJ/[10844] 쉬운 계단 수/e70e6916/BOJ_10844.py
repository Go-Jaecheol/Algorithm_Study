N = int(input())
step = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]

for _ in range(N-1):
    temp = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    for i in range(10):
        if i == 0: temp[i] = step[1]
        elif i == 9: temp[i] = step[8]
        else: temp[i] = step[i-1] + step[i+1]
    step = temp
print(sum(step) % 1000000000)