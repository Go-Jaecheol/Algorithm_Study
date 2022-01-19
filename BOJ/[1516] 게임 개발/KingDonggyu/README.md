# [1516] 게임 개발 - Python

## :mag: Algorithm

### Topological Sort (위상 정렬)

## :round_pushpin: Logic

### Problem: <u>"N개의 각 건물이 완성되기까지 걸리는 최소 시간을 출력한다."</u>

큐에 있는 건물들 (진입차수가 0인 노드들) 중 건물을 짓는데 걸리는 시간이 작은 건물부터 pop 해야한다. **➡️ 우선순위 큐를 이용한다.**

```python
def topology_sort():
    heap = []
    for i in range(1, N+1):
        if indegree[i] == 0:
            heapq.heappush(heap, (build_time[i], i))
    
    while heap:
        time, node = heapq.heappop(heap)

        for next_node in graph[node]:
            indegree[next_node] -= 1
            if indegree[next_node] == 0:
                heapq.heappush(heap, (build_time[next_node] + time, next_node))

        build_time[node] = time
```

- `heapq` 모듈을 이용한 우선순위 큐를 구현한다.

  - `heap` 에 (건물을 짓는데 걸리는 시간, 건물 번호) 튜플을 push 및 pop 한다.

  - `build_time` (건물을 짓는데 걸리는 시간) 을 튜플의 첫번째 원소에 두어 시간이 적은 순으로 pop 되게 한다.

## :memo: Review

**우선순위 큐**를 쉽게 떠올려 금방 해결할 수 있었다. 

해결 후 맞힌 사람들의 코드를 보니 대부분 **DP** 를 이용하여 문제를 푼 것을 확인할 수 있었다.

만약 문제를 풀기 전 알고리즘 분류를 먼저 보고 시작했다면 나도 DP 를 이용했을 것 같다.

알고리즘 분류를 보지 않고 내가 생각한 다른 방법으로 해결했기에 기분이 좋다.