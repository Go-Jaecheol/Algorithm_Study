# [1005] ACM Craft - Python

## :mag: Algorithm

### Topological Sort (위상 정렬)

## :round_pushpin: Logic

### Problem: <u>"건물 W를 건설완료 하는데 드는 최소 시간을 출력한다."</u>

큐에 있는 건물들 (진입차수가 0인 노드들) 중 건물을 짓는데 걸리는 시간이 작은 건물부터 pop 해야한다. **➡️ 우선순위 큐를 이용한다.**

```python
def topology_sort():
    heap = []
    for i in range(1, N+1):
        if indegree[i] == 0:
            heapq.heappush(heap, (build_time[i], i))

    while heap:
        time, number = heapq.heappop(heap)
        if number == W:
            result.append(time)
            break
        
        for next_number in graph[number]:
            indegree[next_number] -= 1
            if indegree[next_number] == 0:
                heapq.heappush(heap, (build_time[next_number] + time, next_number))
```

- `heapq` 모듈을 이용한 우선순위 큐를 구현한다.

  - `heap` 에 (건물을 짓는데 걸리는 시간, 건물 번호) 튜플을 push 및 pop 한다.

  - `build_time` (건물을 짓는데 걸리는 시간) 을 튜플의 첫번째 원소에 두어 시간이 적은 순으로 pop 되게 한다.

## :memo: Review

바로 이전에 푼 '[1516] 게임 개발' 문제와 거의 같기에 너무 쉬웠다. (그래서 README 도 그대로 가져와 썼다..ㅎ)

우선순위 큐를 이용하여 금방 해결했다.