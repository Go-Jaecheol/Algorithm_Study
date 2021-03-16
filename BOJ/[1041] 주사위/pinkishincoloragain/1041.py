
import sys
import copy

N = int(sys.stdin.readline())
dice = list(map(int,sys.stdin.readline().split()))
res = 0

# idx -> 0:5 1:4 2:3
# 합 =  꼭짓점 4개 + 평면 :(N-2)*(N-2)*5 + 모서리: 4*(N-1)+4*(N-2)

if N == 1:
    print(sum(dice) - max(dice))
    exit(0)

# 평
if N > 2:
    # print(min(dice))
    res+=min(dice)*(N-2)*(N-2) + min(dice)*4*(N-2)*(N-1)

# 모
if N > 1:
    sum = 2000000
    for i in range(6):
        new_dice = copy.deepcopy(dice)
        new_sum = new_dice[i]
        new_dice[i] = 1000001
        new_dice[5-i] = 1000001
        new_sum += min(new_dice)
        if sum > new_sum:

            sum = new_sum

    # print(sum)
    res += sum*4*(N-1)+sum*4*(N-2)

# 꼭
sum = 2000000
for i in range(6):
    new_dice = copy.deepcopy(dice)
    new_sum = new_dice[i]
    new_dice[i] = 1000001
    new_dice[5-i] = 1000001
    new_sum += min(new_dice)
    p = new_dice.index(min(new_dice))
    new_dice[p] = 1000001
    new_dice[5-p] = 1000001
    new_sum += min(new_dice)
    if sum > new_sum:
        sum = new_sum

res += sum*4
# print(sum)

print(res)
