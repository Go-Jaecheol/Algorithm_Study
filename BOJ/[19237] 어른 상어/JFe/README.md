# [19237] 어른 상어 - Python

## 🔍 Algorithm
**시뮬레이션**

## 💻 Logic

```Python
def update_grid():
    for i in range(N):
        for j in range(N):
            if grid[i][j] != 0:
                # 시간 -1
                grid[i][j][1] -= 1
                # 시간이 0이면 해당 좌표 0으로 초기화
                if grid[i][j][1] == 0:
                    grid[i][j] = 0
```

- 냄새가 남아있는 시간 업데이트하는 함수  
  시간이 **0**이면 해당 좌표 값 **0**으로 초기화  
  아니면 좌표 값 **-1**  

---

```Python
def move_shark(copy_grid, n, x, y):
    check = False
    p = priority[n][cur_dir[n]-1]
    # 우선순위에 맞게 다음 위치 계산
    for p in priority[n][cur_dir[n]-1]:
        next_x = x + dx[p-1]
        next_y = y + dy[p-1]
        # 다음 위치가 boundary 안이고 0인지 확인
        if 0 <= next_x < N and 0 <= next_y < N:
            if copy_grid[next_y][next_x] == 0:
                # 실제 grid가 0일 때만 진행
                if grid[next_y][next_x] == 0:
                    grid[next_y][next_x] = [n+1, k+1]
                shark[n] = (next_x, next_y)
                cur_dir[n] = p
                check = True
                break
    # 주변에 0인 칸이 없는 경우
    if not check:
        for p in priority[n][cur_dir[n]-1]:
            next_x = x + dx[p-1]
            next_y = y + dy[p-1]
            if 0 <= next_x < N and 0 <= next_y < N:
                # 자기 냄새가 있는 곳으로 돌아감
                if copy_grid[next_y][next_x][0] == n+1:
                    if grid[next_y][next_x][0] == n+1:
                        grid[next_y][next_x] = [n+1, k+1]
                    shark[n] = (next_x, next_y)
                    cur_dir[n] = p
                    break
```

- 상어 이동 함수  
  - **우선순위에 맞게 다음 위치 계산**  
    다음 위치가 **boundary 안**이고 **0**인지 확인  
    실제 `grid`가 **0**일 때만 `grid`에 `[n+1, k+1]` 값 넣고, 현재 상어 위치, 방향 다시 설정  
  - **주변에 0인 칸이 없는 경우**  
    우선순위에 맞게 다시 다음 위치 계산  
    `grid`가 **n+1**인 경우, `grid`에 `[n+1, k+1]` 값 넣고, 현재 상어 위치, 방향 다시 설정  

---

```Python
def check_collision():
    global num
    for i in range(M):
        if shark[i] == -1:
            continue
        for j in range(i+1, M):
            # 중복되는 위치에 있으면, 숫자가 큰 상어의 위치를 -1로 초기화하고 num -1
            if shark[i] == shark[j]:
                shark[j] = -1
                num -= 1
```

- 상어 중복 처리 함수  
  중복되는 위치에 있으면, 숫자가 큰 상어의 위치를 **-1**로 초기화하고 `num` **-1**  

---

```Python
while(num > 1):
    if(count >= 1000 and num > 1):
        count = -1
        break
    count += 1
    copy_grid = copy.deepcopy(grid)
    for i in range(M):
        if shark[i] != -1:
            move_shark(copy_grid, i, shark[i][0], shark[i][1])
    update_grid()
    check_collision()
print(count)
```

- 상어가 1마리 남을 때까지 진행  
  `count`가 **1000 이상**이면서 `num`이 **1보다 크면** `count` **-1**로 설정하고 출력  
  상어 이동 독립적으로 하기 위해 `grid` **deepcopy**  
  남은 상어 수만큼 `move_shark` 함수 실행하고  
  `update_grid` , `check_collision` 함수 실행  
  `num`이 **1 이하**면 `count` 출력  

## 📝 Review

문제에서 주어진대로만 구현하면 돼서 구현에 크게 문제는 없었지만 시간이 조오금 걸렸다  
시간을 어떻게 줄이면서 풀지는 차근차근 문제 많이 풀어보면서 생각해봐야지,,
