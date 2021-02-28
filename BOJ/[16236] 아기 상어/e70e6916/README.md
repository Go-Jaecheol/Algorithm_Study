# [16236] 아기 상어 - Python

## :mag: Algorithm

**BFS**

## :round_pushpin: Logic
```python
    if 0 <= x < N and 0 <= y < N and (x, y) != (start_x, start_y):
        if visited[x][y] == 0 and shark >= sea[x][y]:
```
BFS로 상하좌우로 이동하며 위 조건과 같이 아기 상어의 현재 위치를 제외시키며, 
```visited```가 0인 경우 (방문을 한번도 하지 않은 경우)와 아기상어의 크기보다
크지 않는 경우 이동한다.

위 조건에 부합하여 이동하는 경우 ```visited```에 이동위치와 아기상어 간의 거리를 
업데이트한다. (```visited[x][y] = visited[i][j] + 1```) 


```python
    if 0 < sea[x][y] < shark:  # eat
        if not fish:
            fish = {'visited': visited[x][y], 'x': x, 'y': y}
        else:
            if fish['x'] == x:
                if fish['y'] > y:
                    fish['x'], fish['y'] = x, y
            else:
                if fish['x'] > x:
                    fish['x'], fish['y'] = x, y
```
이동하다가 아기상어의 크기```shark```보다 작으며 0보다 큰 경우가 발생 시 ```fish```
딕셔너리에 ```visited```(거리), ```x```, ```y```(위치) 로 초기화한다.

만약, 이미 ```fish```에 다른 먹이가 존재 할 경우 더 위에 있으며 왼쪽에 있는 (x가 더 작고, x가 같을 시 y가 더 작은) 
먹이로 선정한다.


```python
    if fish and fish['visited'] < visited[x][y]:
        eat_fish(fish['x'], fish['y'])
        fish = {}
        break
```
먹이가 ```fish```에 있고, ```fish```의 key```visited```보다 이동 거리가 커지게 되면 
```fish```에 담겨있는 먹이를 먹는다. (```eat_fish()``` 를 호출한다.)


```python
    def eat_fish(x, y):
        global start_x, start_y
        global shark, eat, second, visited
    
        eat += 1
        if eat == shark:
            shark += 1
            eat = 0
    
        sea[start_x][start_y], sea[x][y] = 0, 9
        start_x, start_y = x, y
        second += visited[x][y]
        visited = list([0] * N for _ in range(N))
```
먹이를 먹을 시 위 코드와 같은 함수를 호출하게 되어, 아기 상어의 크기 ```shark```와 
```sea```, ```start_x, start_y```(아기상어의 위치), ```second```(먹이를 먹기위해 이동하는 시간)를 모두 업데이트한다.

그리고 아기 상어의 위치가 변경되었으니 ```visited```리스트를 다시 0으로 모두 초기화한다.

```python
    if fish and not queue:
        eat_fish(fish['x'], fish['y'])
        fish = {}
```
만약 ```fish```에 먹이는 존재하지만 더이상 ```visited```가 변동되지 않는, 
즉 BFS를 위한 ```queue```에 원소가 없을 시에도 ```eat_fish()```를 호출하여 
```fish```에 저장된 먹이를 먹는다.

지금까지의 과정을 아기상어가 더이상 먹을 수 있는 먹이가 없을 때까지 (```fish```, ```queue```가 모두 빌 때까지)
반복하여 최종 업데이트 된 ```second```를 출력한다.


## :memo: Review

```direction```을 ```[[-1, 0], [0, -1], [0, 1], [1, 0]]```로 두어 
상, 좌, 우, 하 순으로 탐색하며 먹이가 생길 시 바로 ```braek```하는 방법으로 
접근했는데 너무도 많은 반례가 생겼다.

그래서 상, 좌, 우, 하 모두 탐색하며 먹이를 저장해 두었다가 이동거리가 증가하게 되는 경우
저장된 먹이를 먹는 방법으로 구현하게 되었다.

처음 시도한 방법의 반례를 해결하기 위해 시간을 들였지만,
문제의 긴 글에 비해 크게 어렵지 않은 문제였던거 같다.

아기상어~ 뚜루뚜뚜뚜~