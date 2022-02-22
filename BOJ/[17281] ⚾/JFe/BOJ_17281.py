import sys
from itertools import permutations

def hit_result(batter):
    global out, run, b1, b2, b3
    hit = inning[cur_inning][batter]
    
    if hit == 0:
        out += 1
        return
    if hit == 4:
        run += b1 + b2 + b3 + 1
        b1, b2, b3 = 0, 0, 0
        return

    if b3 == 1:
        b3 = 0
        run += 1
    if b2 == 1:
        b2 = 0
        if hit > 1: run += 1
        else: b3 = 1
    if b1 == 1:
        b1 = 0
        if hit > 2: run += 1
        elif hit == 2: b3 = 1
        else: b2 = 1
    if hit == 1: b1 = 1
    elif hit == 2: b2 = 1
    elif hit == 3: b3 = 1

N = int(sys.stdin.readline())
inning = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
order_list = permutations([1,2,3,4,5,6,7,8], 8)

result = 0

for order in order_list:
    order = list(order)
    order.insert(3, 0)
    cur_inning, run, out = 0, 0, 0
    b1, b2, b3 = 0, 0, 0
    while cur_inning < N:
        for batter in order:
            hit_result(batter)
            if out == 3: 
                cur_inning += 1
                out = 0
                b1, b2, b3 = 0, 0, 0
            if cur_inning == N: break
    result = max(result, run)

print(result)