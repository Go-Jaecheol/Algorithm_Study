# [1753] 최단경로 - Python

## :mag: Algorithm
**Dijkstra Algorithm, Priority Queue**

## :computer: Logic
### `Dijkstra`

```Python
def inputGraph():
    for _ in range(E):
        u, v, w = map(int, sys.stdin.readline().split())
        graph[u-1].append([v-1, w])
```
- **그래프 **인접리스트** 만드는 함수**  
  * 입력받은 `u, v, w`를 이용해서 인접 리스트 `graph` 생성  
---

```Python
def dijkstra(start):
    h = []
    distance[start] = 0
    heapq.heappush(h, [distance[start], start])
    while h:
        cur_value, cur_state = heapq.heappop(h)
        if distance[cur_state] < cur_value:
            continue
        for new_state, new_value in graph[cur_state]:
            value = cur_value + new_value
            if value < distance[new_state]:
                distance[new_state] = value
                heapq.heappush(h, [value, new_state])
```
- **우선순위 큐를 이용한 다익스트라 알고리즘 함수**  
  * 최단 거리를 저장하기 위한 리스트 `distance`는 `'inf'`로 초기화 되어있음  
  * 시작점 `start`의 `distance` 값을 ***0***으로 설정하고 **heappush**  
  * **heappop**을 해서 `cur_value`, `cur_state`에 저장하고  
  * `cur_value`가 기존 `distance[cur_state]`보다 **크면** **continue**  
  * **작거나 같으면** 이 `cur_state`에 연결된 **정점**과 **간선 값**을 받아서  
  * 더한 가중치가 기존 가중치보다 작으면 업데이트하고 **heappush**  
  * 이 과정을 **우선순위 큐가 비어있을 때까지** 반복  
---

## :memo: Review
> 다익스트라 알고리즘에 대해서 공부하고 적용한 문제  
> 인접행렬로 만들었다가 메모리 초과나고  
> 인접리스트로 만드는 김에 딕셔너리 자료형을 쓰려고 했는데  
> 복잡해서 일단 그냥 리스트 자료형 써서 만들었음,,,  
> 
> 알고리즘 자체는 빨리 이해했는데  
> 코드 구성을 내 방식대로 짜려다가 시간이 걸렸다.  
> 더 공부해봐야 알듯
