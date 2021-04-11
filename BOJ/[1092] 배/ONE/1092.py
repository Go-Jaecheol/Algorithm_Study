N = int(input())
crane = list(map(int, input().split()))
M = int(input())
box = list(map(int, input().split()))

crane.sort(reverse=True)
box.sort(reverse=True)

if crane[0] < box[0]:
    print(-1)
else:
    cnt = 0
    while len(box) != 0:
        idx = 0
        tmp = 0
        while idx < N:
            if tmp == len(box):
                break
            if box[tmp] <= crane[idx]:
                del box[tmp]
                idx += 1
            elif box[tmp] > crane[idx]:
                tmp += 1
        cnt += 1
    print(cnt)
