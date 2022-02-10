# [1005] ACM Craft - Python

## 🔍 Algorithm
**위상 정렬, Dynamic Programming**

## 💻 Logic

```Python
def topology_sort():
    q = deque()
    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)
    while q:
        num = q.popleft()
        result[num] += time[num]
        for i in graph[num]:
            indegree[i] -= 1
            result[i] = max(result[i], result[num])
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
T = int(sys.stdin.readline())
for _ in range(T):
    N, K = map(int, sys.stdin.readline().split())
    time = [0]
    for x in sys.stdin.readline().split():
        time.append(int(x))
    graph = [[] for _ in range(N+1)]
    indegree = [0 for _ in range(N+1)]
    result = [0 for _ in range(N+1)]
    for i in range(K):
        a, b = map(int, sys.stdin.readline().split())
        graph[a].append(b)
        indegree[b] += 1
    W = int(sys.stdin.readline())
    topology_sort()
    print(result[W])
```

- 그래프 정보 저장 후, `topology_sort` 함수 실행  
- 테스트케이스 수 **T**만큼 반복  


## 📝 Review

바로 이전에 풀었던 [[1516]게임 개발](https://github.com/Go-Jaecheol/Algorithm_Study/tree/main/BOJ/%5B1516%5D%20%EA%B2%8C%EC%9E%84%20%EA%B0%9C%EB%B0%9C/JFe) 문제와 거의 유사한 문제.
