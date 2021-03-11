import sys
import heapq
N = int(input())
lecture = list(list(map(int, sys.stdin.readline().split())) for _ in range(N))

lecture.sort(key=lambda x: x[0])
room = []  # priority queue
heapq.heappush(room, lecture[0][1])
for i in range(1, N):
    if room[0] <= lecture[i][0]:
        heapq.heappop(room)
    heapq.heappush(room, lecture[i][1])
print(len(room))
