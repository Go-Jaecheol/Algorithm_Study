# [1766] 문제집 - Python

## :mag: Algorithm

### Topological Sort (위상 정렬)

## :round_pushpin: Logic

### Problem: <u>"먼저 푸는 것이 좋은 문제가 있는 문제는 먼저 풀되, 가능하면 쉬운 문제부터 풀어야 한다."</u>

- "먼저 푸는 것이 좋은 문제가 있는 문제는, 먼저 푼다"

  = 진입 차수가 0인 노드의 번호를 큐에 넣는다.

- "가능하면 쉬운 문제부터 풀어야 한다."

  = 큐에 있는 노드의 번호를 오름차순으로 정렬한다.

➡️ **Priority Queue를 이용한다.**

아래는 우선순위 큐(`heapq`)를 이용한 위상정렬 코드이다.

```python
def topology_sort():
    heap, result = [], []

    for i in range(1, N+1):
        if indegree[i] == 0:
            heapq.heappush(heap, i)

    while heap:
        node = heapq.heappop(heap)
        result.append(node)

        for next_node in graph[node]:
            indegree[next_node] -= 1
            if indegree[next_node] == 0:
                heapq.heappush(heap, next_node)

    for res in result:
        print(res, end=" ")
```

## :memo: Review

문제를 읽자마자 우선순위 큐를 이용해야 된다는 것을 알아차릴 수 있었고, 파이썬 모듈 `heapq` 를 이용하여 금방 해결할 수 있었다.