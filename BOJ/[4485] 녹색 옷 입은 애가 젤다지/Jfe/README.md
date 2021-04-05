# [4485] 녹색 옷 입은 애가 젤다지? - Python

## :mag: Algorithm
**Dijkstra Algorithm, Priority Queue**

## :computer: Logic
### `Dijkstra`

```Python
def dijkstra(N, cave):
    global distance, h
    distance = [float('inf') for _ in range(N*N)]
    h = []
    distance[0] = 0
    heapq.heappush(h, [distance[0], 0, 0])
    while h:
        cur_w, cur_y, cur_x = heapq.heappop(h)
        cur_v = N * cur_y + cur_x
        if distance[cur_v] < cur_w:
            continue
        for i in range(4):
            next_x, next_y = cur_x + dx[i], cur_y + dy[i]
            next_v = N * next_y + next_x
            if 0 <= next_x < N and 0 <= next_y < N:
                next_w = cur_w + cave[next_y][next_x]
                if next_w < distance[next_v]:
                    distance[next_v] = next_w
                    heapq.heappush(h, [next_w, next_y, next_x])
    return distance
```
- **우선순위 큐를 이용한 다익스트라 알고리즘 함수**  
  * 최단 거리를 저장하기 위한 리스트 `distance`는 `'inf'`로 초기화 되어있음  
  * `distance` 값을 ***0***으로 설정하고 **heappush**  
  * **heappop**을 해서 `cur_w`, `cur_y`, `cur_x`에 저장하고 `cur_v` 값 계산  
  * `cur_w`가 기존 `distance[cur_v]`보다 **크면** **continue**  
  * **작거나 같으면** 이 `cur_v`의 상하좌우를 다 확인하면서  
  * 더한 가중치가 기존 가중치보다 작으면 업데이트하고 **heappush**  
  * 이 과정을 **우선순위 큐가 비어있을 때까지** 반복  
---

```Python
while True:
    N = int(input())
    if N == 0:
        break
    cave = [[int(x) for x in sys.stdin.readline().split()] for y in range(N)]
    distance = dijkstra(N, cave)
    result = cave[0][0] + distance[N*N-1]
    print("Problem ", count, ": ", result, sep="")
    count += 1
```
- **테스트 케이스 반복**   
---

## :memo: Review
> 그래프가 연결되어있는 형태로 주어지지 않고  
> 상하좌우를 확인하면서 최단 경로를 찾아야 하는 점이 이전 문제들과 차이점  
> 
> 문제 자체는 비슷해서 빨리 풀었는데  
> 맥북이랑 파이썬 환경 설정 바꾸는게 시간 더 오래걸린듯,,
