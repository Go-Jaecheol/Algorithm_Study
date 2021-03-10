N, M = map(int, input().split())
book = [int(x) for x in input().split()]
book.sort()
location = -1
result = 0
gt_cnt = 0
lt_cnt = 0
mid = N

def checkMid():
    global mid, gt_cnt, lt_cnt
    for i in range(N):
        if book[i] > 0:
            mid = i
            break
    gt_cnt = N - mid
    lt_cnt = N - gt_cnt

def moveGt(gt_mod):
    global result, location
    if gt_mod != 0:
        location = gt_mod+mid-1
        result += abs(book[location])
    else:
        location = mid+M-1
        result += abs(book[location])
    while location < N - 1:
        result += abs(book[location])
        location += M
        result += abs(book[location])

def moveLt(lt_mod):
    global result, location
    if lt_mod != 0:
        location = mid-lt_mod
        result += abs(book[location])
    else:
        location = mid-M
        result += abs(book[location])
    while location > 0:
        result += abs(book[location])
        location -= M
        result += abs(book[location])

def replaceBook():
    global result, location
    gt_mod = gt_cnt % M
    lt_mod = lt_cnt % M

    if abs(book[0]) > book[N-1]:
        if gt_cnt:
            moveGt(gt_mod)
            result += abs(book[location])
        if lt_cnt:
            moveLt(lt_mod)
    else:
        if lt_cnt:
            moveLt(lt_mod)
            result += abs(book[location])
        if gt_cnt:
            moveGt(gt_mod)

checkMid()
replaceBook()
print(result)