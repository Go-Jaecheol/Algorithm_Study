import sys
N = int(sys.stdin.readline())
population = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]

def divide_area(x, y, d1, d2):
    sum = [0 for _ in range(5)]
    isFiveArea = [[False for _ in range(N)]for _ in range(N)]

    # 5번 선거구 경계선 채우기
    for i in range(d1+1): isFiveArea[x+i][y-i] = True
    for i in range(d2+1): isFiveArea[x+i][y+i] = True
    for i in range(d1+1): isFiveArea[x+d2+i][y+d2-i] = True
    for i in range(d2+1): isFiveArea[x+d1+i][y-d1+i] = True

    # 5번 선거구 경계선 안쪽 채우기
    for i in range(x+1, x+d1+d2):
        check = 0   # 0: default, 1: 5구역 경계 시작, 2: 5구역 경계 끝
        for j in range(N):
            if isFiveArea[i][j]: check += 1
            if check == 1: isFiveArea[i][j] = True
            elif check == 2: break
    
    # 선거구 인구 계산
    for i in range(N):
        for j in range(N):
            if isFiveArea[i][j]:
                sum[4] += population[i][j]
            else:
                if 0 <= j <= y and 0 <= i < x+d1:
                    sum[0] += population[i][j]
                elif y < j < N and 0 <= i <= x+d2:
                    sum[1] += population[i][j]
                elif 0 <= j < y-d1+d2 and x+d1 <= i < N:
                    sum[2] += population[i][j]
                elif y-d1+d2 <= j < N and x+d2 < i < N:
                    sum[3] += population[i][j]
    return max(sum) - min(sum)

result = sys.maxsize
for x in range(1, N+1):
    for y in range(1, N+1):
        for d1 in range(1, N+1):
            for d2 in range(1, N+1):
                if 1 <= x < x+d1+d2 <= N and 1 <= y-d1 < y < y+d2 <= N:
                    result = min(result, divide_area(x-1, y-1, d1, d2))
print(result)