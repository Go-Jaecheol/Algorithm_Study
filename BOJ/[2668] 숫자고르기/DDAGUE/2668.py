import sys
input = sys.stdin.readline

number = {}
n = int(input())
for i in range(1, n + 1):
    number[i] = int(input())
first = set(number.keys())
down = set(number.values())
while first != down:
    cnt = 0
    for tmp in first:
        if tmp not in down:
            cnt += 1
            del number[tmp]
    first = set(number.keys())
    down = set(number.values())
    n -= cnt
print(n)
first = list(first)
first.sort()
for tmp in first:
    print(tmp)

