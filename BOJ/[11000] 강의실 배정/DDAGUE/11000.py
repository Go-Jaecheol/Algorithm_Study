import heapq
import sys

N = int(input())
input = sys.stdin.readline
class_list = [list(map(int, input().split())) for _ in range(N)]

class_list.sort(key=lambda x:x[0])

res_q = []
heapq.heappush(res_q, class_list[0][1])
for i in range(1, N):
    if res_q[0] > class_list[i][0]:
        heapq.heappush(res_q, class_list[i][1])
    else:
        heapq.heappop(res_q)
        heapq.heappush(res_q, class_list[i][1])

print(len(res_q))