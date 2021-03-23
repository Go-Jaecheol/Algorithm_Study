N = int(input())
crane = list(map(int, input().split()))
M = int(input())
box = list(map(int, input().split()))
time = 0
check = [0 for _ in range(M)]
cnt = 0

crane.sort(reverse = True)
box.sort(reverse = True)

place = [0] * N

if max(box) <= max(crane):
    while cnt < len(box):
        for i in range(N): # 크레인에 대하여
            while place[i] < len(box):
                if not check[place[i]] and crane[i] >= box[place[i]]:
                    check[place[i]] = True
                    place[i] += 1
                    cnt += 1
                    break
                place[i] += 1
        time += 1
    print(time)
else:
    print(-1)