# [17144] 미세먼지 안녕! - Python

## 🔍 Algorithm
**시뮬레이션**

## 💻 Logic

```Python
def spread():
    # A 리스트 deepcopy
    A_copy = copy.deepcopy(A)
    for i in range(R):
        for j in range(C):
            if A_copy[i][j] > 0:
                value = A_copy[i][j] // 5
                # 상하좌우 계산
                for k in range(4):
                    next_x = j + dx[k]
                    next_y = i + dy[k]
                    # boundary 체크 후, 확산
                    if 0 <= next_x < C and 0 <= next_y < R:
                        if A[next_y][next_x] != -1:
                            A[next_y][next_x] += value
                            A[i][j] -= value
```

- 미세먼지 확산시키는 함수  
  - **A 리스트 deepcopy**  
    반복문을 도는 중에 확산시키기 전의 상태를 사용해야 하기 때문에  
    기존 리스트 `A`를 **deepcopy** 해서 저장한 후 사용  
  - **상하좌우 계산**  
    미세먼지가 있으면 확산시킬 `value` 계산한 후, 상하좌우 계산  
  - **boundary 체크 후, 확산**  
    **boundary** 안에 위치하는지 확인하고 다음 값이 **-1**이 아니면 `value`를 더해서 확산  

---

```Python
def wind(x, y, d):
    # x, y : 공기청정기 위치 , d : 1이면 위로 확산, -1이면 아래로 확산
    temp = A[y][x+1]
    A[y][x+1] = 0
    # 공기청정기 위치한 행 확산
    for i in range(x+2, C): temp, A[y][i] = A[y][i], temp
    # 마지막 열 확산
    if d == 1:
        for i in range(y-1, -1, -1): temp, A[i][C-1] = A[i][C-1], temp
    else:
        for i in range(y+1, R): temp, A[i][C-1] = A[i][C-1], temp
    # 맨 위 or 맨 아래 행 확산
    for i in range(C-2, x-1, -1): 
        if d == 1: temp, A[0][i] = A[0][i], temp
        else: temp, A[R-1][i] = A[R-1][i], temp
    # 첫번째 열 확산
    if d == 1:
        for i in range(1, y): temp, A[i][0] = A[i][0], temp
    else:
        for i in range(R-2, y, -1): temp, A[i][0] = A[i][0], temp
```

- 공기청정기 작동 함수  
  - **x, y, d 를 인자로 받음**  
    `x, y` : 공기청정기 위치 , `d` : **1**이면 위로 확산, **-1**이면 아래로 확산  
  - **각 행과 열에 맞춰 한칸씩 이동하는 코드 작성**  
    **마지막 열**과 **첫번째 열**은 `d`에 따라 방향이 다름  

---

```Python
def calculate():
    count = 0
    for i in range(R):
        for j in range(C):
            if A[i][j] > 0:
                count += A[i][j]
    return count
```

- 남아있는 미세먼지 양 계산하는 함수  


## 📝 Review

전형적인 시뮬레이션 문제  

공기청정기 작동시키고 바람에 따라 한칸씩 이동하는 방법을 어떻게 효율적이게 할까 고민하다가  
일단 그냥 편한대로 풀었다..  더 효율적인 방법이 있는지 찾아봐야 할 듯  
