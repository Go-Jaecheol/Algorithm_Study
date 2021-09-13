# [14226] 이모티콘 - Python

## :mag: Algorithm
**Dynamic Programming, BFS**

## :computer: Logic

```Python
def bfs(screen, clip):
    time = 0
    q = deque()
    visited[screen][clip] = True
    q.append((screen, clip, time))

    while q:
        screen, clip, time = q.popleft()
        time += 1
        for i in range(3):
            if i == 0 and not visited[screen][screen]:
                visited[screen][screen] = True
                q.append((screen, screen, time))
            elif i == 1 and 0 <= screen+clip < 1001 and not visited[screen+clip][screen]:
                    visited[screen+clip][clip] = True
                    q.append((screen+clip, clip, time))
                    if screen+clip == S:
                        return time
            elif i == 2 and 0 <= screen-1 and not visited[screen-1][screen]:
                visited[screen-1][clip] = True
                q.append((screen-1, clip, time))
                if screen-1 == S:
                    return time
```

- BFS로 탐색하면서 주어진 연산 3가지 수행  
  - screen = 화면에 있는 이모티콘 수, clip = 클립보드에 있는 이모티콘 수, time = 총 걸린 시간  
  - deque를 이용해서 주어진 연산 수행 후 append  
  - 연산 수행 후 화면에 있는 이모티콘 수가 S와 같아지면 time을 return  

## :memo: Review
오랜만에 BFS로 풀려고 하니까 기억이 하나도 안남ㅎ..
예전에 풀었던 문제들 참고해서 deque 사용해서 해결  

