<<<<<<< Updated upstream
import sys
import heapq
N = int(sys.stdin.readline())
cranes = [int(x) for x in sys.stdin.readline().split()]
M = int(sys.stdin.readline())
boxes = [int(x) for x in sys.stdin.readline().split()]


def move_box():
    crane_heap = []
    for i in range(M):
        while cranes and cranes[-1] >= boxes[i]:
            heapq.heappush(crane_heap, (0, cranes.pop()))
        time, crane = heapq.heappop(crane_heap)
        heapq.heappush(crane_heap, (time+1, crane))
    return max(crane_heap)[0]


cranes.sort()
boxes.sort(reverse=True)
if cranes[-1] < boxes[0]:
    print(-1)
else:
    print(move_box())
=======
N = int(input())
crane = list(map(int, input().split()))
M = int(input())
box = list(map(int, input().split()))

crane.sort()
box.sort(reverse=True)
if crane[N-1] < box[0]:
    print(-1)
    quit()

time, move = 0, 0
while move != M:
    for i in range(N):
        if not crane[i]: continue
        for j in range(M):
            if box[j] and crane[i] >= box[j]:
                box[j] = 0
                move += 1
                break
            if j == M-1:
                crane[i] = 0
    time += 1
print(time)
>>>>>>> Stashed changes
