# [9466] 텀 프로젝트 - Python

## :mag: Algorithm
**DFS**

## :computer: Logic

```Python
def dfs(v):
    global selected
    visited[v] = True
    result.append(v)
    next = student[v] - 1
    if visited[next]:
        if result and next in result:
            selected += len(result[result.index(next):])
    else:
        dfs(next)
```

- DFS로 Cycle이 있는지 탐색  
  - 시작 노드의 `visited[v]`를 True로 설정  
  - 방문한 노드의 index를 저장하기 위한 `result` 리스트에 현재 노드의 index를 append  
  - 다음 노드로 이동하기 위해 `student[v] - 1`을 `next`에 저장  
  - next 노드를 방문한 적이 있으면 result 리스트에서 해당 노드가 있는 부분부터의 길이만큼 selected에 더함  
  - (Cycle이 생겨서 팀이 구성된 학생들의 수를 selected에 카운트)  
  - 방문을 한 적이 없으면 dfs함수 재귀    

---

```Python
for _ in range(T):
    n = int(input())
    student = [int(x) for x in sys.stdin.readline().split()]
    visited = [False for _ in range(n)]
    selected = 0

    for i in range(n):
        if visited[i]:
            continue
        result = []
        dfs(i)
    print(n - selected)
```

- 테스트 케이스 T만큼 실행  
  - 학생 수 n만큼 `dfs` 실행  
  - 방문한 노드의 경우에는 `dfs` 실행 x  
  - Cycle이 생기지 않은 노드의 수를 출력하기 위해 `n - selected` 출력  

## :memo: Review
Cycle이 생기는지 여부를 확인하면 되는 문제여서 쉽게 생각했지만  
pypy3로 하면 메모리 초과가 뜨고, python3로 하면 시간 초과가 떠서 계속 헤맸다..  

첫 시작 노드로 돌아와서 Cycle이 생기는 경우 말고도 중간에 Cycle이 생기는 경우도 처리해줘야  
시간을 더 줄일 수 있다는 사실을 알고 처리를 해줬지만  
여전히 시간 초과가 나서 다른 코드를 참고했다,,,,  
마음에 안든다.
