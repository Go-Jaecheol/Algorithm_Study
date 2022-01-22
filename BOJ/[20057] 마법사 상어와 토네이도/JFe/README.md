# [20057] 마법사 상어와 토네이도 - Python

## 🔍 Algorithm
**시뮬레이션**

## 💻 Logic

```Python
def move_tornado():
    x, y = N//2, N//2
    count = 0
    while True:
        # 좌, 하, 우, 상 순서로 반복
        for d in range(4):
            # 좌 or 우 경우에는 count +1
            if d%2 == 0:
                count += 1
            # count 만큼 해당 방향으로 이동 반복
            for _ in range(count):
                x, y = x+dx[d], y+dy[d]
                move_sand(x, y, d)
                # 0, 0 에서 멈춤
                if x == 0 and y == 0: return
```

- 토네이도 이동 함수  

---

```Python
def move_sand(x, y, d):
    global result
    sand = A[y][x]
    # 주어진 규칙대로 모래 흩날림
    A[y][x] -= cal_moved_sand(x+dx[d]*2, y+dy[d]*2, 0.05, sand)
    A[y][x] -= cal_moved_sand(x+dx[d]+dx[(d+3)%4], y+dy[d]+dy[(d+3)%4], 0.1, sand)
    A[y][x] -= cal_moved_sand(x+dx[d]+dx[(d+1)%4], y+dy[d]+dy[(d+1)%4], 0.1, sand)
    A[y][x] -= cal_moved_sand(x+dx[(d+3)%4]*2, y+dy[(d+3)%4]*2, 0.02, sand)
    A[y][x] -= cal_moved_sand(x+dx[(d+3)%4], y+dy[(d+3)%4], 0.07, sand)
    A[y][x] -= cal_moved_sand(x+dx[(d+1)%4], y+dy[(d+1)%4], 0.07, sand)
    A[y][x] -= cal_moved_sand(x+dx[(d+1)%4]*2, y+dy[(d+1)%4]*2, 0.02, sand)
    A[y][x] -= cal_moved_sand(x+dx[(d+2)%4]+dx[(d+3)%4], y+dy[(d+2)%4]+dy[(d+3)%4], 0.01, sand)
    A[y][x] -= cal_moved_sand(x+dx[(d+2)%4]+dx[(d+1)%4], y+dy[(d+2)%4]+dy[(d+1)%4], 0.01, sand)
    # 알파 계산
    if 0 <= x+dx[d] < N and 0 <= y+dy[d] < N:
        A[y+dy[d]][x+dx[d]] += A[y][x]
    else:
        result += A[y][x]
    A[y][x] = 0
```

- 모래 이동 함수  

---

```Python
def cal_moved_sand(next_x, next_y, percent, sand):
    global result
    # boundary 안인지 밖인지 확인
    if 0 <= next_x < N and 0 <= next_y < N:
        A[next_y][next_x] += int(percent * sand)
    else:
        result += int(percent * sand)
    return int(percent * sand)
```

- 이동한 모래 계산 함수  


## 📝 Review

