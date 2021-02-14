import sys
sys.setrecursionlimit(10**6)

N, M = map(int, input().split())
load = [list(map(int, input().split())) for _ in range(N)]
visited = [[-1] * M for _ in range(N)]
move_x, move_y = [0, -1, 0, 1], [1, 0, -1, 0]  # 각각 우, 하, 좌, 상 를 나타냄


def find_load(x, y):
    if x == N - 1 and y == M - 1:  # 맨 끝 원소
        return 1
    res = 0
    for k in range(4):  # 우, 하, 좌, 상을 검사
        i, j = x + move_x[k], y + move_y[k]
        if 0 <= i < N and 0 <= j < M and load[i][j] < load[x][y]: # 현재 수보다 작을 때
            if visited[i][j] >= 0:       # 이미 방문했다면 값을 그대로 가져와 더한다
                res += visited[i][j]
            else:                        # 방문한 적이 없다면 새로운 길을 찾아서 더한다
                res += find_load(i, j)
    visited[x][y] = res
    return res


visited[0][0] = 0
print(find_load(0, 0))
