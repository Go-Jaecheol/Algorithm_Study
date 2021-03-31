# [1753] 최단경로 - Python

## :mag: Algorithm

**Dijkstra**


## :round_pushpin: Logic

```python
    SP = [INF for _ in range(V+1)]
    SP[start_v] = 0
    queue = [(0, start_v)]

    while queue:
        current_w, current_v = heapq.heappop(queue)
        if SP[current_v] < current_w: continue
        for new_w, new_v in graph[current_v]:
            distance = current_w + new_w
            if distance < SP[new_v]:
                SP[new_v] = distance
                heapq.heappush(queue, (distance, new_v))
```

1. **priority queue**에 ```(0, strat_v)```=(거리, 시작지점)를 저장한다. (**가장 작은 거리의 vertex는 지속적으로 업데이트되기 때문에 priority queue를 이용한다.**)

2. queue에서 **가장 거리가 작은** tuple을  **heappop**하여 현재 지점까지의 최소거리```current_w```와 현재 지점```current_v```을 얻는다.

3. 현재 vertex에 **연결된 다른 vertex를 전부 탐색**하여 시작지점```start_v```에서 목적 지점```new_v```으로 가는 값과 현재 지점```current_v```을 거쳐 목적지점```new_v```으로 가는 것 중 **더 작은 것**을 ```SP[new_v]```에 업데이트한다. 

4. queue에 tuple```(SP[new_v], new_v)```를 **heappush**한다.

5. 1~4를 반복하여 이동할 수 있는 모든 vertex를 탐색한다. (queue에 원소가 존재하지 않을 때까지 탐색)


## :memo: Review

이번 문제는 아이디어를 구상하고 문제를 해결하는 것이 아닌 Dijkstra 알고리즘을 학습하는 데 활용했다. Dijkstra 알고리즘에 대해 어느정도 감을 잡은 것 같으니 다음 문제부터 잘 이용해 보겠다.
