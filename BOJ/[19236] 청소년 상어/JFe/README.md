# [19236] 청소년 상어 - Python

## 🔍 Algorithm
**시뮬레이션, Backtracking**

## 💻 Logic

```Python
fish = []
fish_dir = [0 for _ in range(16)]
dx = [0, -1, -1, -1, 0, 1, 1, 1]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]
for _ in range(4):
    temp = []
    temp_input = [int(x) for x in sys.stdin.readline().split()]
    for i in range(4):
        # 인덱싱 편하게 하기 위해 물고기 번호-1로 저장, -1: 빈칸, -2: 상어
        temp.append(temp_input[i*2]-1)
        fish_dir[temp_input[i*2]-1] = temp_input[i*2+1]
    fish.append(temp)
```

- 물고기 위치와 물고기 방향 저장  
  인덱싱 편하게 하기 위해 **물고기 번호-1**로 저장, **-1: 빈칸**, **-2: 상어**  

---

```Python
def move_fish(fish, fish_dir):
    # 물고기 순서대로 이동
    for i in range(16):
        cur_x, cur_y = -1, -1
        # 현재 위치 인덱스 찾기
        for j in range(4):
            for k in range(4):
                if fish[j][k] == i:
                    cur_x, cur_y = k, j
        if cur_x == -1 and cur_y == -1 : continue
        # 이동 가능한 방향 확인
        for _ in range(8):
            next_x = cur_x + dx[fish_dir[i] - 1]
            next_y = cur_y + dy[fish_dir[i] - 1]
            if 0 <= next_x < 4 and 0 <= next_y < 4:
                if fish[next_y][next_x] == -2:
                    if fish_dir[i] == 8: fish_dir[i] = 1
                    else: fish_dir[i] += 1
                else:
                    fish[cur_y][cur_x], fish[next_y][next_x] = fish[next_y][next_x], fish[cur_y][cur_x]
                    break
            else:
                if fish_dir[i] == 8: fish_dir[i] = 1
                else: fish_dir[i] += 1
```

- 물고기 이동 함수  
  - **물고기 순서대로 이동**  
    주어진 조건에 맞게 첫번째부터 16번째까지 순서대로 이동  
  - **이동 가능한 방향 확인**  
    `fish_dir`을 참고하여 다음 이동할 위치 계산하고 이동 불가능하면 방향을 바꾸면서 다음 위치 계산  
    8개 방향 전부 다 이동 불가능하면 이동하지 않고 진행  

---

```Python
def move_shark(x, y, cur_shark, fish, fish_dir, sum):
    global result
    shark_location = []
    next_x, next_y = x, y
    move_fish(fish, fish_dir)
    result = max(result, sum)
    # 상어 이동 가능한 위치 확인 후, 저장
    for _ in range(4):
        next_x += dx[fish_dir[cur_shark] - 1]
        next_y += dy[fish_dir[cur_shark] - 1]
        if 0 <= next_x < 4 and 0 <= next_y < 4 and fish[next_y][next_x] >= 0:
            shark_location.append((next_x, next_y))
    # 이동 가능한 위치 없을 때까지 재귀
    while(shark_location):
        next_x, next_y = shark_location.pop()
        temp_fish = copy.deepcopy(fish)
        temp_dir = copy.deepcopy(fish_dir)
        temp_shark = temp_fish[next_y][next_x]
        temp_sum = sum + temp_fish[next_y][next_x] + 1
        temp_fish[y][x] = -1
        temp_fish[next_y][next_x] = -2
        move_shark(next_x, next_y, temp_shark, temp_fish, temp_dir, temp_sum)
```

- 상어 이동 재귀함수  
  - **상어 이동 가능한 위치 확인 후, 저장**  
    현재 방향으로 이동 가능한 위치가 있으면 `shark_location`에 **append**  
  - **이동 가능한 위치 없을 때까지 재귀**  
    shark_location에 저장되어 있는 값 **pop** 해서 그 위치로 이동 계산하고  
    `move_shark` 함수 **재귀**  
    이렇게 재귀하면서 제일 큰 `sum` 값 `result`에 **max** 계산해서 저장  


## 📝 Review

처음 값을 어떤 식으로 저장하는 것이 더 효율적일지 생각하다가 잘못 생각해서 시간이 걸렸고, 전체 이동할 때 재귀로 짜야한다는 건 쉽게 알 수 있었지만 역시나 재귀는 어렵다...  
일단 지금은 얼마나 더 빨리 효율적으로 풀지 생각하는 것보단 그냥 많이 풀어봐야겠다,
