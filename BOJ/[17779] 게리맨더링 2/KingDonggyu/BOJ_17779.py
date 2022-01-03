import sys
N = int(sys.stdin.readline())
A = [False]+[[False]+[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]


def set_area(x, y, d1, d2):
    population_sum = [0] * 5
    check_five = [[False] * (N+1) for _ in range(N+1)]
    for i in range(0, d1+1): check_five[x+i][y-i] = True
    for i in range(1, d2+1): check_five[x+i][y+i] = True
    for i in range(1, d2+1): check_five[x+d1+i][y-d1+i] = True
    for i in range(1, d1+1): check_five[x+d2+i][y+d2-i] = True
    
    # 1번 선거구
    for r in range(1, x+d1):
        for c in range(1, y+1): 
            if check_five[r][c]: break
            population_sum[0] += A[r][c]
    # 2번 선거구
    for r in range(1, x+d2+1):
        for c in reversed(range(y+1, N+1)):
            if check_five[r][c]: break
            population_sum[1] += A[r][c]
    # 3번 선거구
    for r in range(x+d1, N+1):
        for c in range(1, y-d1+d2):
            if check_five[r][c]: break
            population_sum[2] += A[r][c]
    # 4번 선거구
    for r in range(x+d2+1, N+1):
        for c in reversed(range(y-d1+d2, N+1)):
            if check_five[r][c]: break
            population_sum[3] += A[r][c]
    # 5번 선거구
    population_sum[4] = population_total - sum(population_sum)

    return max(population_sum) - min(population_sum)

population_total = 0
for i in range(1, N+1):
    population_total += sum(A[i])

population_diff = sys.maxsize
for x in range(1, N+1):
    for y in range(1, N+1):
        for d1 in range(1, N+1):
            for d2 in range(1, N+1):
                if 1 <= x < x+d1+d2 <= N and 1 <= y-d1 < y < y+d2 <= N:
                    population_diff = min(population_diff, set_area(x, y, d1, d2))
print(population_diff)