import sys, heapq
N = int(sys.stdin.readline())
hw = [[int(x) for x in sys.stdin.readline().split()] for y in range(N)]
h = []

hw.sort()
for deadline, ramen in hw:
    if len(h) < deadline:
        heapq.heappush(h, ramen)
    else:
        temp = heapq.heappop(h)
        heapq.heappush(h, max(temp, ramen))
print(sum(h))