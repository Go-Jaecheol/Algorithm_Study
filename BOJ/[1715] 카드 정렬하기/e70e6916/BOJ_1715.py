import sys
import heapq
N = int(sys.stdin.readline())
cards = list(int(sys.stdin.readline()) for _ in range(N))
heapq.heapify(cards)
final_sum = 0

while len(cards) > 1:
    card_sum = heapq.heappop(cards) + heapq.heappop(cards)
    heapq.heappush(cards, card_sum)
    final_sum += card_sum
print(final_sum)
