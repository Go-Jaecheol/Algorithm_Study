# [17471] 게리맨더링 - Python

## :mag: Algorithm
**BFS**

## :computer: Logic

```Python
def bfs(area):
    global visited
    q = deque()
    q.append(area[0])
    visited[area[0]] = True
    sum = population[area[0]]
    while q:
        num = q.popleft()
        for i in range(1, len(relation[num])):
            next = relation[num][i] - 1
            if not visited[next] and next in area:
                visited[next] = True
                q.append(next)
                sum += population[next]
    return sum
```

- 조합으로 나눠진 현재 선거구에 대해 BFS 탐색  
  - area[0]부터 시작해서  
  - relation에 저장된 인접 구역에 대해서 area에 속하고 방문하지 않았는지 확인한 후,    
  - 조건에 해당되면 visited를 True로 변경하고 append, sum에 인구수 저장  
  - 저장한 sum 인구수 return  

---

```Python
for i in range(1, N//2 + 1):
    for combi in combinations(range(N), i):
        visited = [False for _ in range(N)]
        area1 = list(combi)
        area2 = list(int(x) for x in range(N) if x not in combi)
        sum1 = bfs(area1)
        sum2 = bfs(area2)
        if False not in visited:
            if result == -1:
                result = abs(sum1 - sum2)
            else:
                result = min(result, abs(sum1 - sum2))
print(result)
```

- 조합으로 선거구를 나눈 뒤, bfs 함수로 인구수 계산  
  - combinations를 이용해서 가능한 전체 조합 생성  
  - area1과 area2로 두 가지 선거구로 나누고 각각 bfs함수 실행, return값들은 sum1, sum2에 저장  
  - bfs 둘 다 실행 후, visited에 False가 하나라도 있으면 다시 combinations for문 실행  
  - visited에 False가 하나도 없으면 sum1과 sum2의 인구수 차이를 result에 저장(이전 result값보다 작을 때만 저장)  

## :memo: Review
```Python
from itertools import combinations
```
선거구를 어떻게 두 개로 나눌지 고민하다가 조합이라는 힌트를 얻고 combinations 사용  

아직 어떤 문제에서 어떤 알고리즘을 사용할지에 대해서는 태그를 안보면 잘 모른다..  
이건 천천히 공부하다보면 되겠지만 아직도 파이썬에 익숙하지 않은 건 마음에 안든다  
익숙해지자,,
