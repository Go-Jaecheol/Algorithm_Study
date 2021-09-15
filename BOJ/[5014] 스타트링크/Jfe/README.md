# [5014] 스타트링크 - Python

## :mag: Algorithm
**BFS**

## :computer: Logic

```Python
def bfs(S):
    q = deque()
    visited[S] = True
    q.append((S, 0))

    while q:
        cur, time = q.popleft()
        if cur == G:
            return time
        if cur+U <= F and not visited[cur+U]:
            visited[cur+U] = True
            q.append((cur+U, time+1))
        if cur-D >= 1 and not visited[cur-D]:
            visited[cur-D] = True
            q.append((cur-D, time+1))
    return -1

result = bfs(S)
if result == -1:
    print("use the stairs")
else:
    print(result)
```

- BFS로 위로 갈지 밑으로 갈지 탐색  
  - cur = 현재 층, time = 총 걸린 횟수  
  - deque를 이용해서 U, D 탐색 후 append  
  - cur이 G와 같아지면 time을 return하고 출력  
  - 위, 아래 중 갈 수 없으면 -1을 return 하고 "use the stairs" 출력  

## :memo: Review
역시 DP 보다는 그래프 탐색이 더 쉬운듯ㅎ  
그래도 BFS로 풀어야 된다는 걸 알고 풀어서 쉬운 것 같고  
그냥 많이 풀어봐야겠다,,
