N = int(input())
dice = [int(x) for x in input().split()]
dice_sorted = [min(dice[0], dice[5]), min(dice[1], dice[4]), min(dice[2], dice[3])]
dice_sorted.sort()
result = 0

def baseFloor():
    global result
    result += (N*4-4) * dice_sorted[0]
    result += 4 * dice_sorted[1]

def topFloor():
    global result
    result += 4 * dice_sorted[2]
    result += (N-2)*4 * dice_sorted[1]
    result += (N-2)*(N-2) * dice_sorted[0]

for i in range(N):
    baseFloor()
topFloor()

if N == 1:
    dice.sort()
    result = 0
    for i in range(5):
        result += dice[i]
print(result)