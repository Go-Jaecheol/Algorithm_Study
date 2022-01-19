# [20056] 마법사 상어와 파이어볼 - Python

## 🔍 Algorithm
**시뮬레이션**

## 💻 Logic

```Python
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
```

- 파이어볼 이동 함수  
  - **파이어볼 수만큼 이동**  
    `fireball` 리스트에 있는 값 수만큼 **pop**하면서 반복문 실행  
  - **방향과 속력에 맞게 다음 위치 계산**  
    행과 열은 **1번**과 **N번**이 연결되어 있으므로 범위 안넘어가게 다음 위치 계산  
    그 다음, 다음 파이어볼의 위치를 나타내는 리스트인 `grid`에 **append**  

---

```Python
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
```

- 중복 처리 함수  
  - **grid에 값이 있을 때까지 반복문 진행**  
    `grid` 좌표 값이 하나만 있으면 바로 **append**  
    둘 이상이면 문제에 주어진대로 계산  


## 📝 Review

처음에 문제를 제대로 이해하기가 약간 어려웠지만 주어진 예제를 손으로 풀어보니까 이해됐다  
그 다음 구현하는 과정은 문제에서 주어진대로만 하면 돼서 나름 쉽게 해결  
