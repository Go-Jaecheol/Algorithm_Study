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

또, ```queue```에 존재했던 원소들을 ```union```에 추가한다.

```python
    if len(union) > 1:  # 인구이동이 일어남
        check = True
        for x, y in union:
            land[x][y] = sum_union // len(union)
```
BFS가 종료된 후 ```union```의 길이가 1보다 클 경우 (인구 이동이 발생한 경우) ```check```를 True로 설정하고,
```union```을 이용한 반복문으로 ```land```를 ```sum_union // len(temp)```(연합의 인구수 평균)로 업데이트한다.


반복문을 통한 모든 나라의 탐색이 종료된 후, 만약 ```check```가 True라면 ```move_cnt```를 +1 해주며, 
```check```가 False라면 while문에서 빠져나와 ```move_cnt```를 출력한다.


## :memo: Review

1. 시간초과의 늪에 빠졌다. 도저히 안되겠어서 백준의 질문검색을 참고하여 BFS가 종료된 후 곧바로 ```land```를 
업데이트하지 않고, 모든 나라의 탐색(BFS)가 종료되면 한꺼번에 ```land```를 업데이트하는 것으로
바꾸었더니 해결할 수 있었다. 온전히 내 힘으로 한 거 같지 않아 아쉽다.
   
    (그럼에도 **pypy3**으로 해결..)


2. 백준 질문검색을 참고한 내용이 아닌 1번에서 언급했던 내가 처음 시도했던 방법을 이용하여 최적화하니 
   코드길이와 약 1000ms의 시간(pypy3 기준)이 더 줄어들었다. 그래도 **python3**은 통과하지 못했다.
   더이상 시간초과를 해결할 방안이 떠오르지 않는다...
   

3. 아래 코드를 추가하니 약 1000ms의 시간(pypy3 기준)을 더 줄일 수 있었다.
    상하좌우로 인구 차이가 L명 이상, R명 이하인 나라가 없을 경우에도 ```move_population```
    함수를 호출하면 **불필요한 작업을 하게 되기 때문에** 함수를 호출하기 전, 상하좌우로 조건에 맞는 나라가 있는지
    먼저 확인한 후 함수를 호출하는 것으로 구현했다.

   (그럼에도 **python3**에서는 80%에서 시간초과가 난다ㅋ)
```python
            for d in direction:
                x, y = i + d[0], j + d[1]
                if 0 <= x < N and 0 <= y < N and not visited[x][y]:
                    if L <= abs(land[x][y] - land[i][j]) <= R:
                        test = True
                        break
            if test:
                union = []
                move_population(i, j)
``` 