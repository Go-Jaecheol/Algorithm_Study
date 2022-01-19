import sys
N, M, K = map(int, sys.stdin.readline().split())
fireball = [[int(x) for x in sys.stdin.readline().split()] for _ in range(M)]
grid = [[[] for _ in range(N+1)] for _ in range(N+1)]
dx = [0, 1, 1, 1, 0, -1, -1, -1]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]
result = 0

def move_fireball(count):
    # 파이어볼 수만큼 이동
    for _ in range(count):
        next_y, next_x, m, s, d = fireball.pop(0)
        # 방향과 속력에 맞게 다음 위치 계산
        for _ in range(s):
            next_x += dx[d]
            next_y += dy[d]
            # 행과 열은 1번과 N번이 연결되어 있음
            if next_x < 1: next_x = N
            elif next_x > N: next_x = 1
            if next_y < 1: next_y = N
            elif next_y > N: next_y = 1
        # 다음 파이어볼의 위치를 나타낼 grid에 append
        grid[next_y][next_x].append([m, s, d])
        
def check_collision():
    for i in range(1, N+1):
        for j in range(1, N+1):
            n = len(grid[i][j])
            # grid에 값이 있을 때까지 반복문 진행
            if n == 0:
                continue
            # grid 좌표 값이 하나만 있으면 바로 append
            elif n == 1:
                m, s, d = grid[i][j].pop(0)
                fireball.append([i, j, m, s, d])
            # 둘 이상이면 문제에 주어진대로 계산
            else:
                m_sum, s_sum, dir, last_d = 0, 0, True, -1
                while grid[i][j]:
                    m, s, d = grid[i][j].pop(0)
                    m_sum += m
                    s_sum += s
                    if last_d == -1:
                        last_d = d
                    # 하나라도 홀수, 짝수가 섞일 경우 False 저장
                    else:
                        if last_d%2 != d%2: dir = False
                # 질량이 0이하면 버림
                if m_sum//5 > 0:
                    if dir:
                        for k in range(4):
                            fireball.append([i, j, m_sum//5, s_sum//n, k*2])
                    else:
                        for k in range(4):
                            fireball.append([i, j, m_sum//5, s_sum//n, k*2+1])

for _ in range(K):
    move_fireball(len(fireball))
    check_collision()
for i in fireball:
    result += i[2]
print(result)