import sys
N = int(sys.stdin.readline())
curve_info = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
map = [[0 for _ in range(101)] for _ in range(101)]
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def draw_curve(x, y, d, g):
    # 0세대 드래곤 커브 그리기
    dir_list = [d]
    map[y][x] = 1
    next_x = x + dx[d]
    next_y = y + dy[d]
    map[next_y][next_x] = 1
    cur = [(next_x, next_y)]

    # g세대 드래곤 커브 그리기
    for _ in range(g):
        # 이전 세대 선분 방향 리스트 복사
        temp = dir_list.copy()
        for _ in range(len(dir_list)):
            x, y = cur.pop()
            d = dir_list.pop()
            # 방향 90도 회전 후 다음 위치 계산
            if d == 3: next_d = 0
            else: next_d = d + 1
            next_x = x + dx[next_d]
            next_y = y + dy[next_d]
            temp.append(next_d)
            map[next_y][next_x] = 1
            cur.append((next_x, next_y))
        # 현재 세대 선분 방향 리스트 저장
        dir_list = temp.copy()

# 주어진 정보에 맞게 드래곤 커브 그리기
for x, y, d, g in curve_info:
    draw_curve(x, y, d, g)

# 네 꼭짓점이 모두 드래곤 커브의 일부인 정사각형 개수 구한 후, 출력
count = 0
for i in range(100):
        for j in range(100):
            if map[i][j] == 1 and map[i][j+1] == 1 and map[i+1][j] == 1 and map[i+1][j+1] == 1:
                count += 1
print(count)