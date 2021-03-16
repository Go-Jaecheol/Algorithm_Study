
import sys

# 절댓값 max를 마지막에 방문
# 만약 절댓값까지 책 수가 M보다 작으면 노상관.

N,M = map(int,sys.stdin.readline().split())
arr = list(map(int,sys.stdin.readline().split()))
arr.append(0)
arr.sort()
res = []


if arr[-1] < -arr[0]:
    for i in range(len(arr)):
        arr[i] = -arr[i]
arr.sort()

# 음수 부분
while arr[0] != 0:
    zero = arr.index(0)
    if len(arr[:zero]) > M:
        res.append(arr[0])
        for i in range(M):
            arr.pop(0)
    else:
        res.append(arr[0])
        for i in range(0,zero):
            arr.pop(0)
        break
# 양수 부분
first_m = (len(arr)-1) % M
if first_m != 0 and len(arr) != first_m+1:
    res.append(arr[first_m])
    for i in range(first_m):
        arr.pop(1)

while len(arr) > M+1:
    res.append(arr[M])
    for i in range(M):
        arr.pop(1)

ans = 0

for i in range(len(res)):
    ans+=2*abs(res[i])

print(ans + arr[-1])
