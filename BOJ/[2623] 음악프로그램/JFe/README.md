# [2623] 음악프로그램 - Python

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

---


```Python
for i in range(M):
    temp = [int(x) for x in sys.stdin.readline().split()]
    count, last = temp[0], temp[1]
    del temp[0]
    for j in range(1, count):
        graph[last].append(temp[j])
        indegree[temp[j]] += 1
        last = temp[j]
        
topology_sort()
if len(result) != N:
    print(0)
else:
    for i in result:
        print(i, end=' ')
```

- 입력된 정보를 이용해 `graph` 와 `indegree` 리스트 작성  
- `topology_sort` 함수 실행하고,  
  `result`의 길이가 **N이 아니면** **0** 출력, **N이면** `result` 값 출력  


## 📝 Review

입력된 정보를 가지고 graph를 그리는 과정과 순서 정할 수 없는 경우에 처리하는 부분만 추가되었고,  
나머지는 일반적인 위상 정렬 문제와 크게 다르지 않은 문제.
