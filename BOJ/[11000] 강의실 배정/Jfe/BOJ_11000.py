import heapq

N = int(input())
lecture = [[int(x) for x in input().split()]for y in range(N)]
h = []

def allocateRoom():
    lecture.sort()
    heapq.heappush(h, lecture[0][1])
    for i in range(1, N):
        if h[0] > lecture[i][0]:
            heapq.heappush(h, lecture[i][1])
        else:
            heapq.heappop(h)
            heapq.heappush(h, lecture[i][1])

allocateRoom()
print(len(h))