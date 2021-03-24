import sys, heapq
N = int(sys.stdin.readline())
problems = list(list(map(int, sys.stdin.readline().split())) for _ in range(N))
heap = []

for deadline, cup_noodle in sorted(problems):
    heapq.heappush(heap, cup_noodle)
    if len(heap) > deadline:
        heapq.heappop(heap)
print(sum(heap))
