# [2252] 줄 세우기 - Python

## :mag: Algorithm

### Topological Sort (위상 정렬)

## :round_pushpin: Logic

**1. 그래프 구현**

```python
for _ in range(M):
    A, B = map(int, sys.stdin.readline().split())
    graph[A].append(B)
```

**2. 진입차수 구현**

```python
for A in range(1, N+1):
    for B in graph[A]:
        indegree_cnt[B] += 1
```

**3. 위상정렬 구현**

```python
def topology_sort():
    result = []
    queue = deque()

    for i in range(1, N+1):
        if indegree_cnt[i] == 0:
            queue.append(i)
    
    while queue:
        node = queue.popleft()
        result.append(node)

        for next_node in graph[node]:
            indegree_cnt[next_node] -= 1
            if indegree_cnt[next_node] == 0:
                queue.append(next_node)

    for res in result:
        print(res, end=" ")
```

- 진입차수가 0 일 때 큐에 해당 노드를 추가한다.

- 큐에서 빠져 나오는 순서대로 노드를 출력한다.

## :memo: Review

다시금 위상정렬이 무엇인지 개념을 다졌다.

개념을 알고 위상정렬 문제를 푸니 너무 쉬웠다. (이번 문제가 매우 쉬운 문제이기도 했다.)
