import heapq

N = int(input())
study = [list(map(int, input().split())) for _ in range(N)]
study.sort(key=lambda x: x[0])

queue = []
heapq.heappush(queue, study[0][1])

for i in range(1, N):
    if queue[0] <= study[i][0]:
        heapq.heappop(queue)
    heapq.heappush(queue, study[i][1])

print(len(queue))