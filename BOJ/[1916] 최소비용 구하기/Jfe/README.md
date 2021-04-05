# [1916] 최소비용 구하기 - Python

## :mag: Algorithm
**Dijkstra Algorithm, Priority Queue**

## :computer: Logic
### `Dijkstra`

```Python
def inputGraph():
    for _ in range(E):
        u, v, w = map(int, sys.stdin.readline().split())
        graph[u].append([v, w])
    start, end = map(int, sys.stdin.readline().split())
    return start, end
```
- **그래프 **인접리스트** 만드는 함수**  
  * 입력받은 `u, v, w`를 이용해서 인접 리스트 `graph` 생성  
  * **출발점**과 **도착점**도 입력받아서 **return**  
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
> 기본적인 다익스트라 알고리즘 문제  
> 
> 출발점과 도착점을 입력받는거 빼고는  
> [[1753] 최단경로](https://github.com/Go-Jaecheol/Algorithm_Study/tree/main/BOJ/%5B1753%5D%20%EC%B5%9C%EB%8B%A8%EA%B2%BD%EB%A1%9C/Jfe) 문제와 같음  
