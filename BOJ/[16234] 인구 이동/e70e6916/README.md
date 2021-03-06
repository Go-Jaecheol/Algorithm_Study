# [16234] 인구 이동 - Python

## :mag: Algorithm

**BFS**


## :round_pushpin: Logic
```python
    while queue:
        i, j = queue.popleft()
        temp.append((i, j))
        for d in direction:
            x, y = i + d[0], j + d[1]
            if 0 <= x < N and 0 <= y < N and not visited[x][y]:
                if L <= abs(land[x][y] - land[i][j]) <= R:
                    visited[x][y] = True
                    sum_union += land[x][y]
                    queue.append((x, y))
```
BFS로 상, 하, 좌, 우 인접 나라들과의 인구 차이가 L명 이상, R명 이하인지 탐색하며 조건에 부합할 경우
```sum_union```에 해당 나라의 인구 수를 합한다.

```python
    if len(temp) > 1:  # 이동이 발생
        check = True
        union.append(temp)
        union_avg.append(sum_union // len(temp))
```
탐색하면서 queue에 추가했던 원소들을 ```temp```리스트에 저장해두었고, BFS가 종료될 경우 ```temp```가 
1보다 클 경우 (인구 이동이 발생한 경우) ```check```를 True로 설정하고, ```union```리스트에 ```temp```리스트를 추가하며 ```union_avg```리스트에
```sum_union // len(temp)```(연합의 인구수 평균)을 추가한다. 

```python
def change_population():
    for i, v in enumerate(union):
        for x, y in v:
            land[x][y] = union_avg[i]
```
반복문을 통한 모든 나라의 탐색이 종료된 후, 만약 ```check```가 True라면 나라의 최초 인구수를 저장해 둔
```land```리스트에 ```union```과 ```union_avg```를 이용한 반복문을 통해 ```land```를 업데이트 하며 ```move_cnt```를 +1 해준다.

만약, ```check```가 False라면 while문에서 빠져나와 ```move_cnt```를 출력한다.


## :memo: Review

시간초과의 늪에 빠졌다. 도저히 안되겠어서 백준의 질문검색을 참고하여 BFS가 종료된 후 곧바로 ```land```를 
업데이트하지 않고, 모든 나라의 탐색(BFS)가 종료되면 한꺼번에 ```land```를 업데이트하는 것으로
바꾸었더니 해결할 수 있었다. 온전히 내 힘으로 한 거 같지 않아 아쉽다.

(그럼에도 **pypy3**으로 해결..)