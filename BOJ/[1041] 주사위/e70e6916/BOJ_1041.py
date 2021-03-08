N = int(input())
dice = list(map(int, input().split()))


def create_cube(height):
    _sum, add = 0, 0
    if height == N-1: add = 1
    _sum += 4 * sum(min_list[i] for i in range(2+add))
    _sum += (N-2) * 4 * sum(min_list[i] for i in range(1+add))
    _sum += (N-2)**2 * sum(min_list[i] for i in range(0+add))
    return _sum


min_list = [min(dice[0], dice[5]), min(dice[1], dice[4]), min(dice[2], dice[3])]
min_list.sort()
min_sum = 0
if N == 1:
    min_sum = sum(dice) - max(dice)
else:
    min_sum += create_cube(0) * (N-1)
    min_sum += create_cube(N-1)
print(min_sum)