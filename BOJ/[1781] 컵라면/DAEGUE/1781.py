import heapq

n = int(input())
array = []
for _ in range(n):
    time, ramen = map(int, input().split())
    array.append((time, ramen))

array.sort()

queue = []

for i in array:
    heapq.heappush(queue, i[1])
    if i[0] < len(queue):
        heapq.heappop(queue)

print(sum(queue))