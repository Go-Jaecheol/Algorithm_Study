# [1516] 게임 개발 - Python

## 🔍 Algorithm
**위상 정렬, Dynamic Programming**

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
        result[num] += time[num]
        for i in graph[num]:
            # 먼저 지어져야 하는 건물들이 동시에 지어지는 경우 고려
            result[i] = max(result[i], result[num])
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)
```

- 위상 정렬 함수  
  - **진입 차수(`indegree`)** ***0***이면 `deque`에 **append**  
  - `deque`에서 **popleft**하고 `result`값 변경, 연결된 간선 제거(**진입차수 -1**)  
  - `result`값은 먼저 지어져야 하는 건물들이 동시에 지어지는 경우를 고려하기 위해  
    `result[i]` 와 `result[num]` 중 **max** 값을 `result[i]` 에 저장

---


```Python
N = int(sys.stdin.readline())
graph = [[] for _ in range(N+1)]
indegree = [0 for _ in range(N+1)]
time = [0 for _ in range(N+1)]
result = [0 for _ in range(N+1)]
for i in range(1, N+1):
    temp = [int(x) for x in sys.stdin.readline().split()]
    time[i] = temp[0]
    for j in range(1, len(temp)):
        if temp[j] == -1: break
        graph[temp[j]].append(i)
        indegree[i] += 1
     
topology_sort()
for i in range(1, N+1):
    print(result[i])
```

- 그래프 정보 저장 후, `topology_sort` 함수 실행


## 📝 Review

처음에는 그냥 위상정렬 문제 풀 듯이 풀면 되겠다고 생각하고 접근해서 풀었는데 `"여러 개의 건물을 동시에 지을 수 있다."` 이 부분을 생각 못하고 있었다.  
저 문장이 의미하는 바를 바로 파악하지 못했고, 그래서 이 부분을 처리하는데 시간이 걸렸었다.
