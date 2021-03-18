import sys, heapq
N = int(sys.stdin.readline())
card = [int(sys.stdin.readline()) for _ in range(N)]
result = 0

def combineCard():
    sum = heapq.heappop(card) + heapq.heappop(card)
    heapq.heappush(card, sum)
    return sum

heapq.heapify(card)
while len(card) > 1:
    result += combineCard()
print(result)