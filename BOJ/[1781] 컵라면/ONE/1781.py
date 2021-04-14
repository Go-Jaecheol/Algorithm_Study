import heapq

N = int(input())
homework = [list(map(int, input().split())) for _ in range(N)]

homework.sort()

queue = []
for ramen in homework:
    heapq.heappush(queue, ramen[1])
    if ramen[0] < len(queue):
        heapq.heappop(queue)

print(sum(queue))