# [2668] 숫자고르기 - Python

## :mag: Algorithm
**DFS**

## :computer: Logic
### `DFS`

```Python
def dfs(v, start):
    visited[v] = True
    next = second[v]
    if not(visited[next-1]):
        dfs(next-1, start)
    elif visited[next-1] and next-1 == start:
        result.append(next)
```
- **DFS로 사이클을 찾는 함수**  
  * 해당 인덱스의 **둘째줄에 있는 값**이 **next 값**이 됨
  * next-1 인덱스를 **방문하지 않았으면**  
  * 인자로 넘겨주면서 **재귀**  
  * next-1 인덱스를 **방문**했고, 처음 **start**랑 인덱스가 같으면  
  * **result** 리스트에 **append**
---

```Python
for i in range(N):
    visited = [False for x in range(N)]
    dfs(i, i)
```
- 문제의 조건을 만족시키면서 숫자를 **최대**로 뽑는 방법은  
- 존재하는 모든 **사이클**을 **result**에 **append** 한 다음 출력하면 된다.  
- 0~N-1까지 모든 인덱스를 **시작점**으로 해서  
- **사이클**이 존재하는지 `dfs()`로 확인하고 **존재하면** 그 **시작점**을 **result**에 **append** 하는 방식

## :memo: Review
이 문제 풀면서 느낀 점은  
지금까지 그래프 이론을 하나도 모르면서 풀고 있었단거고

이론부터 제대로 한 다음에  
다른 문제들도 풀어야겠다,,,
