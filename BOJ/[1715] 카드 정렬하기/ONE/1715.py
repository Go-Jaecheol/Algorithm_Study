from queue import PriorityQueue

N = int(input())
cardPack = PriorityQueue()

for _ in range(N):
    cardPack.put(int(input()))

ans = 0

while cardPack.qsize() > 1:
    tmp_1 = cardPack.get()
    tmp_2 = cardPack.get()

    ans += tmp_1 + tmp_2
    cardPack.put(tmp_1 + tmp_2)
print(ans)