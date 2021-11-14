import sys
from collections import deque

gear = [deque(list(map(int, input()))) for _ in range(4)]
K = int(sys.stdin.readline())
info = [[int(x) for x in sys.stdin.readline().split()] for _ in range(K)]
score = 0

def spin_gear(index, d):
    rotated[index] = True
    if index < 3 and not rotated[index+1] and gear[index][2] != gear[index+1][6]:
        # 오른쪽 확인
        rotated[index+1] = True
        spin_gear(index+1, -d)
        gear[index+1].rotate(-d)
    if index > 0 and not rotated[index-1] and gear[index][6] != gear[index-1][2]:
        # 왼쪽 확인
        rotated[index-1] = True
        spin_gear(index-1, -d)
        gear[index-1].rotate(-d)

for num, d in info:
    rotated = [False for _ in range(4)]
    spin_gear(num-1, d)
    gear[num-1].rotate(d)

for i in range(4):
    if gear[i][0] == 1:
        score += 2**i
print(score)