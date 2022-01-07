import sys
input = sys.stdin.readline

# 네 꼭짓점이 모두 드래곤 커브인 정사각형 찾기
def find_square():
    count = 0
    for i in range(100):
        for j in range(100):
            if grid[i][j] == 1 and grid[i][j+1] == 1 and grid[i+1][j] == 1 and grid[i+1][j+1] == 1:
                count += 1
    return count

# 드래곤 커브가 놓인 칸을 1로 설정
def set_dragon_curve():
    direction = {0: (0, 1), 1: (-1, 0), 2: (0, -1), 3: (1, 0)}  # 우, 상, 좌, 하
    for x, y, start_d, g in dragon_curve:
        grid[y][x] = 1
        d_info = [[start_d]]
        for i in range(g+1):
            d_temp = []
            for d in reversed(d_info[i]):
                y += direction[d][0]
                x += direction[d][1]
                grid[y][x] = 1
                if d == 3: d = 0
                else: d += 1
                d_temp.append(d)
            if i != 0: d_temp = d_info[i] + d_temp
            d_info.append(d_temp)
    print(find_square())

N = int(input())
dragon_curve = [[int(i) for i in input().split()] for _ in range(N)]
grid = [[0 for _ in range(101)] for _ in range(101)]
set_dragon_curve()