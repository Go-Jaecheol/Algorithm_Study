# [1926] 그림 - Python

## :mag: Algorithm
**DFS**

## :computer: Logic
### `DFS`

- **next_x, next_y** 값을 **dx, dy** 값과 더하면서  
해당 위치에서 **상하좌우** 전부 확인

- **next_x, next_y**가 **범위에 해당**하는지 확인하고  
```Python
if (0 <= next_x < m) and (0 <= next_y < n):
```

- **paper**의 값이 ***1***이고 **방문하지 않았**으면 **재귀**
```Python
if paper[next_y][next_x] and visited[next_y][next_x]==0:
  area = dfs(next_y, next_x, area)
```

- 재귀해서 다음 위치에 들어가면  
해당 위치의 **visited를 업데이트** 해주고 **area++ 해줌**
 
```Python
def dfs(y, x, area):
  visited[y][x] = True
  area += 1
  for i in range(4):
    next_x = x + dx[i]
    next_y = y + dy[i]
    if (0 <= next_x < m) and (0 <= next_y < n):
      if paper[next_y][next_x] and visited[next_y][next_x]==0:
        area = dfs(next_y, next_x, area)
  return area
```
- 이렇게 한 다음 dfs 함수는 **area 값을 반환**

- **main**에서는  
**paper** 값이 ***1***이고 **visited**가 ***0***일 때만 **dfs 함수 호출**하고  
**area 값을 반환** 받아서 **max값**을 구하고 **전체 그림수**를 카운트함  
```Python
for i in range(n):
  for j in range(m):
    if paper[i][j] and visited[i][j]==0:
      max_result = max(max_result, dfs(i, j, 0))
      count += 1
print(count)
print(max_result)
```

## :memo: Review
그래프의 모든 정점을 방문하는 것이 중요하기 때문에
DFS, BFS 두 가지 방법이 다 가능하다.

저번 문제를 DFS로 풀어서 DFS로 풀긴 했는데  
BFS로 하는게 더 괜찮았을 거라는 생각이 들 정도로  
코드를 마음에 안들게 짠거 같다ㅣ;;;
