import sys
from collections import deque
gear = [list(map(int, input())) for _ in range(4)]
gear.insert(0, False)
K = int(input())
rotaion_info = [[int(x) for x in sys.stdin.readline().split()]
                for _ in range(K)]


def rotaion_gear(start, direction):
    rotated[start] = True
    queue = deque([[start, direction]])
    while queue:
        i, d = queue.popleft()
        rotated[i] = True
        if i != 4 and not rotated[i+1] and gear[i][R] != gear[i+1][L]:
            queue.append([i+1, d*-1])
        if i != 1 and not rotated[i-1] and gear[i][L] != gear[i-1][R]:
            queue.append([i-1, d*-1])

        if d == -1:
            temp = gear[i].pop(0)
            gear[i].append(temp)
        else:
            temp = gear[i].pop(7)
            gear[i].insert(0, temp)


R, L = 2, 6
for i, d in rotaion_info:
    rotated = [False] * 5
    rotaion_gear(i, d)

print(gear[1][0] + 2 * gear[2][0] + 4 * gear[3][0] + 8 * gear[4][0])
