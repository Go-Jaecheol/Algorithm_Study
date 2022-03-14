# [17135] 캐슬 디펜스 - Python

## 🔍 Algorithm
**Brute Force, Simulation**

## 💻 Logic

```Python
def attack(archer, enemy):
    global count
    target, new_enemy, min_i = [], [], -1
    for y, x in archer:
        distance = sys.maxsize
        # 거리 계산
        for i, (ey, ex) in enumerate(enemy):
            temp = abs(x - ex) + abs(y - ey)
            if temp <= D and distance > temp:
                distance = temp
                min_i = i
        if min_i > -1:
            target.append(min_i)
    # 집합으로 중복 제거
    target_set = set(target)
    count += len(target_set)
    for i, (y, x) in enumerate(enemy):
        if i not in target_set:
            new_enemy.append(enemy[i])
    return new_enemy
```

- 궁수가 가까운 적을 공격하는 함수  
  - **거리 계산**  
    각각 궁수마다 적과의 거리를 계산하고,  
    **D** 거리 이하의 가장 가까운 적의 **index**를 구해서 `min_i`에 저장  
    `min_i`가 초기값인 **-1**이 아니면 `target` 리스트에 **append**  
  - **집합으로 중복 제거**  
    중복을 제거하기 위해 **set**으로 변환해주고,  
    해당하는 **index**를 뺀 새로운 `new_enemy` 리스트를 만들어서 **return**  

---

```Python
def move_enemy(enemy):
    temp = []
    new_enemy = []
    # 아래로 한칸씩 이동
    for i, (y, x) in enumerate(enemy):
        if y == N-1: temp.append(i)
        else: enemy[i][0] = y+1
    # 집합으로 중복 제거
    temp_set = set(temp)
    for i, (y, x) in enumerate(enemy):
        if i not in temp_set:
            new_enemy.append(enemy[i])
    return new_enemy
```

- 적 위치를 아래로 한칸 이동하는 함수  
  - **아래로 한칸 이동**  
    위치 **y**가 **N-1**이면 제거하기 위해 `temp`에 **index**를 **append** 해주고,  
    아니면 **y** 값을 **+1**  
  - **집합으로 중복 제거**  
    중복을 제거하기 위해 **set**으로 변환해주고,  
    해당하는 **index**를 뺀 새로운 `new_enemy` 리스트를 만들어서 **return**  
    
---

```Python
N, M, D = map(int, sys.stdin.readline().split())
arr = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
comb_list = combinations([int(x) for x in range(M)], 3)
result = 0
# 궁수 배치 조합
for comb in comb_list:
    comb = list(comb)
    archer, enemy, count = [], [], 0
    # 궁수 배치
    for i in comb:
        archer.append([N, i])
    # 적 위치 저장
    for i in range(N):
        for j in range(M):
            if arr[i][j] == 1:
                enemy.append([i, j])
    # 적이 다 사라질 때까지 게임 진행
    while enemy:
        # 열 기준 정렬
        enemy.sort(key=lambda x:x[1])
        enemy = attack(archer, enemy)
        enemy = move_enemy(enemy)
    result = max(result, count)
print(result)
```

- 조합을 이용해 가능한 조합 경우의 수를 다 만들고,  
- 가능한 경우의 수마다 궁수를 배치하고 적 위치를 저장한 뒤에 적이 다 사라질 때까지 게임을 진행한다.    
- 거리가 같은 경우에는 가장 왼쪽에 있는 적을 공격하기 때문에 `enemy` 리스트를 열 기준으로 정렬해주고,  
- 각 게임마다 `attack()` 함수와 `move_enemy()` 함수를 실행한다.  
- 각 조합마다 **max** 값을 `result`에 저장하고 출력한다.  


## 📝 Review

생각보다 시간이 걸렸던 문제.  
구현 과정은 차근차근 진행하면 됐지만, combination, set, enumerate 등 파이썬 문법이 제대로 기억나지 않아서 찾아보고 하느라 시간이 조금 걸렸고  
거리가 같은 경우에는 가장 왼쪽에 있는 적을 공격한다는 문제 요소도 제대로 못읽어서 시간이 걸린 것 같다.  

천천히 빠르게 할 수 있도록 더 연습해야겠다,,
