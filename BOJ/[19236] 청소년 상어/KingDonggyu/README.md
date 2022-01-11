# [19236] 청소년 상어 - Python

## :mag: Algorithm

Simulation

Backtracking

## :round_pushpin: Logic

1. 해당 위치의 물고기를 먹는다.

2. 물고기를 이동시킨다.

3. 상어가 물고기를 먹기위해 이동할 수 있는 위치들을 파악한다.

4. 파악한 이동 가능한 모든 위치에 대해 **DFS**로 탐색(**재귀**)한다.

이러한 과정을 담은 핵심 코드는 아래와 같다. 

```python
def dfs(space, x, y, fish_sum):
    global result
    space = copy.deepcopy(space)

    # 물고기 먹기
    shark = [[x, y], space[x][y][1]]
    fish_sum += space[x][y][0]
    space[x][y] = [0, 0]

    # 물고기 이동
    for fish_num in range(1, 17):
        find_fish(space, shark, fish_num)
    
    # 상어가 이동할 수 있는 위치 파악
    food = find_food(space, shark)
    
    # 이동 가능한 모든 경우 탐색
    for x, y in food: dfs(space, x, y, fish_sum)
    if result < fish_sum: result = fish_sum
```

## :memo: Review

문제가 길어 처음에 겁을 조금 먹었지만, 막상 순서대로 수행하니 크게 어렵지 않은 문제였다.

하지만, 시뮬레이션 문제라 그런지 역시 코드가 길어졌고 그러다보니, 고려해야 할 것들이 더 많아져 코드를 깔끔히 정리하다 꽤 많은 시간이 소요되었다. 

짧은 시간 안에 문제를 해결하기 위해 계속해서 연습해야겠다.