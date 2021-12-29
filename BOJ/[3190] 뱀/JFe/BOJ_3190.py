import sys
from collections import deque
N = int(sys.stdin.readline())
K = int(sys.stdin.readline())
apple = [[int(x) for x in sys.stdin.readline().split()]for _ in range(K)]
L = int(sys.stdin.readline())
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def move(r, c):
    time = 0
    cur_dir = 0
    q = deque()
    q.append((r, c))
    while q:
        time += 1
        r, c = q.popleft()
        # 다음 위치 계산
        next_c = c + dx[cur_dir]
        next_r = r + dy[cur_dir]
        q.appendleft((r, c))

        # 벽에 부딪히는지 체크
        if next_r < 1 or next_r > N or next_c < 1 or next_c > N : return time
        # 자기 자신과 부딪히는지 체크
        if (next_r, next_c) in q : return time
        # 이동
        q.appendleft((next_r, next_c))
        if [next_r, next_c] in apple : apple.remove([next_r, next_c])
        else : q.pop()
        # 방향 변환
        if time in direction_info.keys():
            if direction_info[time] == 'D':
                if cur_dir == 3 : cur_dir = 0
                else : cur_dir += 1
            elif direction_info[time] == 'L':
                if cur_dir == 0 : cur_dir = 3
                else : cur_dir -= 1

direction_info = {}
for _ in range(L):
    X, C = sys.stdin.readline().split()
    direction_info[int(X)] = C
print(move(1, 1))