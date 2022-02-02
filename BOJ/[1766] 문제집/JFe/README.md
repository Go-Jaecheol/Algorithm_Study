# [1766] 문제집 - Python

## 🔍 Algorithm
**위상 정렬, 우선순위 큐**

## 💻 Logic

```Python
def topology_sort():
    global result
    heap = []
    for i in range(1, N+1):
        if indegree[i] == 0:
            heapq.heappush(heap, i)
    while heap:
        num = heapq.heappop(heap)
        result.append(num)
        for i in graph[num]:
            indegree[i] -= 1
            if indegree[i] == 0:
                heapq.heappush(heap, i)
```

- 우선순위 큐를 이용한 위상 정렬 함수  
  - **진입 차수(`indegree`)** ***0***이면 **우선순위 큐**에 **heappush**  
  - **우선순위 큐**에서 **heappop**하고 `result`에 추가, 연결된 간선 제거(**진입차수 -1**)  


## 📝 Review

일반적인 위상 정렬 문제에서 우선순위 큐를 사용하도록 변형된 문제  
이전 문제에서 우선순위 큐만 사용하도록 바꾸면 돼서 크게 시간이 걸리지 않았다.
