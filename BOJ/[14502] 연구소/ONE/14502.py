from collections import deque

N, M = map(int, input().split())
lab = [list(map(int, input().split())) for _ in range(N)]
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
virus = []
cnt = 0
for i in range(N):
    for j in range(M):
        if lab[i][j] == 2:   # virus 검사
            virus.append((i, j))


def check(wall_num):
    global cnt
    if wall_num == 3:  # 벽 3개를 다 세운 후, 바이러스 확산
        visited = [[False] * M for _ in range(N)]
        queue = deque(virus)
        for qi, qj in queue:
            visited[qi][qj] = True
        while queue:
            qi, qj = queue.popleft()
            for k in range(4):
                x, y = qi + dx[k], qj + dy[k]
                if 0 <= x < N and 0 <= y < M and not visited[x][y] and lab[x][y] == 0:
                    visited[x][y] = True
                    queue.append((x, y))
        tmp = 0
        for a in range(N):
            for b in range(M):
                if lab[a][b] == 0 and not visited[a][b]:
                    tmp += 1
        cnt = max(tmp, cnt)
        return

    for c in range(N):
        for d in range(M):
            if lab[c][d] == 0:
                lab[c][d] = 1
                check(wall_num + 1)
                lab[c][d] = 0


check(0)
print(cnt)
