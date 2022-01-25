# [17135] ⚾ - Python

## :mag: Algorithm

BruteForce

## :round_pushpin: Logic

### Problem: <u>"격자판의 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수를 계산해보자."</u>

**조합을 이용**하여 3명의 궁수를 배치할 수 있는 경우의 수를 모두 수행한다.

```python
for comb in list(combinations([i for i in range(M)], 3)):
    # 적 위치 파악
    enemy = []
    find_enemy()
    # 궁수 배치
    archer = []
    for i in comb:
        archer.append([N, i])
    # 게임 시작
    kill = 0
    while enemy:
        enemy = archer_attack()
       
    result = max(result, kill)
```

<br />

### Problem: <u>"궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고, 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다."</u>

**미리 생성한 적들의 위치를 담은 리스트**를 통한 반복문을 이용한다.

- 아래 코드와 같이 `target` 리스트를 생성해 공격하려는 적의 위치와 거리를 업데이트한다.

```python
target = [[N, M, D], [N, M, D], [N, M, D]]

for i, j in enemy:
    for n, (x, y) in enumerate(archer):
        d = abs(i-x) + abs(j-y)

        if d < target[n][2]:
            target[n] = [i, j, d]
        elif d == target[n][2] and j < target[n][1]:
            target[n] = [i, j, d]
```

## :memo: Review

가장 거리가 작으면서 왼쪽에 있는 적의 위치를 파악하기 위한 효율적인 아이디어를 떠올리는데 시간을 많이 소요했다.

입력 받은 격자(2차원 리스트)를 매번 반복문을 통해 탐색하는 것은 비효율적이라 생각하여 **적들의 위치를 담은 리스트를 따로 생성하여 이를 업데이트하는 방법**을 떠올려 해결했다.

시간이 많이 소요되어 아쉽다..