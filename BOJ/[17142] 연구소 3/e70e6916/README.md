# [16234] 인구 이동 - Python

## :mag: Algorithm

**BFS**

**Brute Force**


## :round_pushpin: Logic
```python
virus, zero = [], 0
for i in range(N):
    for j in range(N):
        if lab[i][j] == 2:
            virus.append((i, j))
        elif lab[i][j] == 0:
            zero += 1
```
먼저 반복문을 통하여 ```virus```리스트와 ```zero```(0의 개수)를 설정한다. 
```python
min_second = MAX
comb = list(combinations(virus, M))
min_second = MAX
comb = list(combinations(virus, M))
for c in comb:
    spread_virus(c)
```
**combinations** 모듈을 이용하여 ```virus```리스트에서 M개를 뽑는 조합을 만들고
조합에서 한개씩 가져와 BFS로 보낸다.

```python
def spread_virus(act_virus):
    global min_second
    max_second, infected = 0, 0
    queue = deque(act_virus)
    second = list([-1] * N for _ in range(N))

    for start_x, start_y in act_virus:
        second[start_x][start_y] = 0

    while queue:
        now_x, now_y = queue.popleft()
        for d in direction:
            x, y = now_x + d[0], now_y + d[1]
            if 0 <= x < N and 0 <= y < N and lab[x][y] != 1:
                if second[x][y] == -1 and (x, y) not in act_virus:  # 0 or 2(비활성)
                    second[x][y] = second[now_x][now_y] + 1
                    if lab[x][y] == 0:
                        max_second = second[x][y]
                        infected += 1
                    queue.append((x, y))
    if zero == infected:
        min_second = min(min_second, max_second)
```
**'조합에서 가져온 원소 = M개의 튜플' 을 queue에 추가하여 BFS를 시작**한다. 즉, 
M개의 바이러스에서 각각 출발하여 BFS를 진행하는 것이다.

그렇게 하여 ```lab```이 0 또는 2(비활성)이며 아직 방문하지 않는 곳일 경우에 ```second```를 
업데이트 해주며 queue에 추가한다. ```lab```이 0이면 추가로 ```max_second```를 업데이트하고, 
```infected```(감염된 곳)을 +1 해준다.

BFS가 종료된 후, ```zero```와 ```infected```가 같으면(바이러스가 완전히 퍼졌으면) ```max_second```를 
이용하여 최소 시간을 업데이트한다.

```python
if min_second == MAX:
    print(-1)
else:
    print(min_second)
```
이를 M개를 뽑는 조합의 수만큼 반복하여 최종 업데이트 된 최소 시간을 출력한다. 단, 최소 시간이 최초 설정해 둔 
```MAX```일 경우(완전히 바이러스를 퍼뜨릴 수 없는 경우) -1을 출력한다.


## :memo: Review

지난번 '연구소' 문제에 활용했던 것처럼 combinations 모듈을 활용하여 쉽게 해결했다. 시간초과가 발생했었지만,
M개의 바이러스를 각각 출발시켜 BFS를 시작하니 해결할 수 있었다. 

