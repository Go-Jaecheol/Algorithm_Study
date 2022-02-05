# [3665] 최종 순위 - Python

## 🔍 Algorithm
**위상 정렬**

## 💻 Logic

```Python
def topology_sort():
    global result
    q = deque()
    for i in range(1, n+1):
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

---


```Python
# 테스트 케이스
for _ in range(T):
    n = int(sys.stdin.readline())
    graph = [[] for _ in range(n+1)]
    indegree = [0 for _ in range(n+1)]
    result = []
    # 그래프 정보 입력
    temp = [int(x) for x in sys.stdin.readline().split()]
    for i in range(n-1):
        last = temp[i]
        for j in range(i+1, n):
            graph[last].append(temp[j])
            indegree[temp[j]] += 1
    # 순위 변경
    m = int(sys.stdin.readline())
    for i in range(m):
        a, b = map(int, sys.stdin.readline().split())
        # 원래 a가 b보다 순위가 높은 경우
        if b in graph[a]:
            graph[a].remove(b)
            graph[b].append(a)
            indegree[b] -= 1
            indegree[a] += 1
        # 원래 b가 a보다 순위가 높은 경우
        elif a in graph[b]:
            graph[b].remove(a)
            graph[a].append(b)
            indegree[a] -= 1
            indegree[b] += 1
    topology_sort()
    if len(result) != n:
        print("IMPOSSIBLE")
    else:
        for i in result:
            print(i, end=' ')
```

- 테스트케이스  
  - 그래프 정보 입력  
  - 순위 변경  
    원래 a가 b보다 순위가 높은 경우와 b가 a보다 순위가 높은 경우로 나눠서 계산  


## 📝 Review

?를 출력하는 경우 때문에 고민을 많이 했지만 ?인 경우가 나올 수 없다는 걸 깨닫고 허무했던 문제..  
나머지는 전형적인 위상정렬 문제랑 다를 게 없어서 크게 어렵지 않았음.
