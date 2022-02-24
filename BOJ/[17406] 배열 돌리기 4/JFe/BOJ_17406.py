import sys, copy
from itertools import permutations

def rotate(r,c,s):
    start_y, start_x, last_y, last_x = r-s-1, c-s-1, r+s-1, c+s-1
    count = (last_x - start_x) // 2
    for i in range(count):
        rightup, rightdown, leftdown = copy_arr[start_y][last_x], copy_arr[last_y][last_x], copy_arr[last_y][start_x]
        # 윗줄 가로
        for j in reversed(range(start_x, last_x)):
            copy_arr[start_y][j+1] = copy_arr[start_y][j]
        # 오른쪽 세로
        for j in reversed(range(start_y, last_y)):
            copy_arr[j+1][last_x] = copy_arr[j][last_x]
        copy_arr[start_y+1][last_x] = rightup
        # 아랫줄 가로
        for j in range(start_x, last_x-1):
            copy_arr[last_y][j] = copy_arr[last_y][j+1]
        copy_arr[last_y][last_x-1] = rightdown
        # 왼쪽 세로
        for j in range(start_y, last_y-1):
            copy_arr[j][start_x] = copy_arr[j+1][start_x]
        copy_arr[last_y-1][start_x] = leftdown
        start_y, start_x, last_y, last_x = start_y+1, start_x+1, last_y-1, last_x-1
        
N, M, K = map(int, sys.stdin.readline().split())
arr = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
rot = [[int(x) for x in sys.stdin.readline().split()] for _ in range(K)]
rot_len = [int(x) for x in range(0, len(rot))]
order_list = permutations(rot_len, len(rot))
result = sys.maxsize

for order in order_list:
    order = list(order)
    copy_arr = copy.deepcopy(arr)
    for i in order:
        rotate(rot[i][0], rot[i][1], rot[i][2])
    for j in range(0, N):
        result = min(result, sum(copy_arr[j]))
print(result)