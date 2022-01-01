import sys
N, M, x, y, K = map(int, sys.stdin.readline().split())
map = [[int(x) for x in sys.stdin.readline().split()]for _ in range(N)]
order = [int(x) for x in sys.stdin.readline().split()]
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

class Dice:
    top, front, right, left, back, bottom = 0, 1, 2, 3, 4, 5
    value = [0 for _ in range(6)]
    def move_dice(self, d):
        if d == 1:
            temp = self.top
            self.top = self.left
            self.left = self.bottom
            self.bottom = self.right
            self.right = temp
        elif d == 2:
            temp = self.top
            self.top = self.right
            self.right = self.bottom
            self.bottom = self.left
            self.left = temp
        elif d == 3:
            temp = self.top
            self.top = self.back
            self.back = self.bottom
            self.bottom = self.front
            self.front = temp
        elif d == 4:
            temp = self.top
            self.top = self.front
            self.front = self.bottom
            self.bottom = self.back
            self.back = temp

dice = Dice()
cur = [(y, x)]
while order:
    d = order[0]
    del order[0]
    cur_x, cur_y = cur.pop()
    
    next_x = cur_x + dx[d-1]
    next_y = cur_y + dy[d-1]
    if 0 <= next_x < M and 0 <= next_y < N:
        dice.move_dice(d)
        print(dice.value[dice.top])
        if map[next_y][next_x] == 0:
            map[next_y][next_x] = dice.value[dice.bottom]
        else:
            dice.value[dice.bottom] = map[next_y][next_x]
            map[next_y][next_x] = 0
        cur.append((next_x, next_y))
    else:
        cur.append((cur_x, cur_y))