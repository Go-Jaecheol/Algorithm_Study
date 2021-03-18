import sys
import heapq
N = int(sys.stdin.readline())
cards = list(int(sys.stdin.readline()) for _ in range(N))
heapq.heapify(cards)
card_sum = 0

while len(cards) > 1:
    card_x = heapq.heappop(cards)
    card_y = heapq.heappop(cards)
    heapq.heappush(cards, card_x + card_y)
    card_sum += card_x + card_y
print(card_sum)
