# [2252] 줄 세우기 - Python

## 🔍 Algorithm
**위상 정렬**

## 💻 Logic

```Python
def topology_sort():
    global result
    q = deque()
    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)
    while q:
        num = q.popleft()
        result.append(num)
        for i in graph[num]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)
```

- 위상 정렬 함수  
  - **진입 차수(`indegree`)** ***0***이면 `deque`에 **append**  
  - `deque`에서 **popleft**하고 `result`에 추가, 연결된 간선 제거(**진입차수 -1**)  


## 📝 Review

간단한 위상 정렬 문제  
예전에 위상 정렬 문제를 풀어본 적이 있지만 제대로 정리가 안되어있어서  
이코테에서 위상 정렬 관련 내용을 참고하여 위상 정렬 이론을 다시 정리하고 풀었다.
