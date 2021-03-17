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
