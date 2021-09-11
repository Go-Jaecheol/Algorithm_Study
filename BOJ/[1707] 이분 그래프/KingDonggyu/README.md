# [1707] 이분 그래프 - Python

## :mag: Algorithm

BFS

## :round_pushpin: Logic

아래 코드와 같이 인접한 두 정점 `x`, `y`를 서로 자신과 인접한 정점 group `graph`에 append한다.

```python
 for _ in range(E):
        x, y = map(int, input().split())
        graph[x].append(y)  # x와 인접한 정점 group
        graph[y].append(x)  # y와 인접한 정점 group
```

<br />

위 과정을 마친 후, 아래 코드와 같이 **BFS** 를 통해 자신과 인접한 정점의 `visited` 값이 0일 경우 자신의 `visited` 값 * -1 한 값을 넣는다. 이를 `range(1, V+1)`만큼 반복해 `visited` 값이 0이 아니며 자신의 값과 같은 경우가 생기면 즉시 반복문을 break하여 "NO"를 출력한다. 반복문을 마칠 동안 그러한 경우가 생기지 않을 경우 "YES"를 출력한다.

```python
def bfs(start):
    visited[start] = 1
    queue = deque([start])
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if visited[i] == 0:
                visited[i] = -visited[v]
                queue.append(i)
            else:
                if visited[i] == visited[v]:
                    return False
    return True
```

## :memo: Review

오랜만의 그래프 탐색 문제라 접근하는데 꽤 오랜 시간이 걸렸다. 

그래도 이분 그래프가 무엇인지 잘 파악하고 나니 해결법에 어느정도 감이 잡힌거 같다. 
