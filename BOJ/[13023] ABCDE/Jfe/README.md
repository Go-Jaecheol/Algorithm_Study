# [13023] ABCDE - Python

## :mag: Algorithm
**DFS**

## :computer: Logic
### `DFS`

```Python
for i in range(M):
    first, second = map(int, input().split())
    friend[first].append(second)
    friend[second].append(first)
```
- **노드마다 연결 관계를 저장**  
  * `input()`으로 입력받은 값을 **노드별 리스트**(`friend[]`)를 만들어서  
  * 각 **노드**마다의 **연결 관계**로 저장  
---

```Python
def dfs(v, depth):
    global result
    visited[v] = True
    if depth == 4:
        result = 1
        return
    for i in range(len(friend[v])):
        next = friend[v][i]        
        if not(visited[next]):
            dfs(next, depth+1)
            visited[next] = False
```
- **DFS로 깊이를 확인하는 함수**  
  * `friend[v]`에 저장된 **연결 관계**를 바탕으로  
  * 다음 연결된 노드를 **next**에 저장하고 `dfs()`에 인자로 넘겨서 **재귀**  
  * 이 때 **깊이**를 확인하기 위해 **depth**도 ***1*** 증가시켜서 **재귀**  
  * **depth**가 ***4***가 되면 **result** 값을 ***1***로 바꿔주고 **return**  
---
```Python
for i in range(N):
    if result == 1:
        print(1)
        break
    visited = [False for _ in range(N)]
    dfs(i, 0)
if result == 0:
    print(0)
```
- **result가 1이 되거나 모든 경우를 다 볼 때까지 반복**  
  * **result**가 ***1***이 되면 ***1***을 **출력**하고 끝  
  * ***0 ~ N*** 노드까지 모든 경우를 `dfs(i,0)`을 통해 확인  
  * 끝날 때까지 **result** 값이 안바뀌면 ***0***을 **출력**  
---

## :memo: Review
> 문제 이해하는데 시간이 오래 걸렸다,,,
> 
> 이해한 후에도 작은 실수들이 많았고  
> 특히 dfs() 함수에서 재귀를 한 후에 
> visited를 다시 False로 안바꿨던게 제일 문제였고  
> 마지막 for문에서 result가 1이면 break 하도록 바꿔서 시간 초과를 없앴다.  
> 
> 이 부분은 dfs() 함수내에서 return이 아닌  
> 바로 1을 출력하고 quit() 하는 방법도 있는데  
> 뭔가 이 방법으로 하기가 그냥 싫었다ㅎ..
> 
> 역시 난 아직도 BFS 보다는 DFS가 더 어려운거 같다ㅜ
