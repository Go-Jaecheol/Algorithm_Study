import heapq

N = int(input())

card = list(int(input()) for _ in range(N))
heapq.heapify(card)
result = 0

while len(card) != 1:
    num1 = heapq.heappop(card)
    num2 = heapq.heappop(card)
    sum = num1 + num2
    result += sum
    heapq.heappush(card, sum)

print(result)