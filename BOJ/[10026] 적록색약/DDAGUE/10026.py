import sys
from collections import deque
input = sys.stdin.readline

def bfs(array,y,x,val):
    dx = [0,1,0,-1]
    dy = [-1,0,1,0]
    q = deque()
    q.append((y,x))
    while q:
        now = q.popleft()
        for i in range(4):
            h = now[0] + dx[i]
            w = now[1] + dy[i]
            if 0 <= h < n and 0 <= w < n:
                if array[h][w] == val:
                    array[h][w] = 0
                    q.append((h,w))


n = int(input())
board = [list(input()) for _ in range(n)]
RGB_board = [[0] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if board[i][j] == 'R' or board[i][j] == 'G':
            RGB_board[i][j] = 1
        else:
            RGB_board[i][j] = 2
cnt = 0
RGB_cnt = 0
for i in range(n):
    for j in range(n):
        if board[i][j] != 0:
            cnt += 1
            bfs(board,i,j,board[i][j])
        if RGB_board[i][j] != 0:
            RGB_cnt += 1
            bfs(RGB_board, i, j, RGB_board[i][j])
print(cnt, RGB_cnt)