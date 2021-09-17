# [5014] 텀 프로젝트 - Python

## :mag: Algorithm

BFS

## :round_pushpin: Logic

- **입력 및 초기 변수 설정**

  ```python
  F, S, G, U, D = map(int, input().split())
  visited = [0] * (F + 1)
  direction = [U, -D]
  ```

  `visited` : 이미 방문한 층인지 구별하며, 다음 층으로 이동하는데 눌러야 하는 버튼의 수를 값으로 가지는 1차원 배열

  `direction` : `U` 와 `-D` 를 원소로 가지는 1차원 배열

<br />

- **BFS**

  ```python
  def bfs():
      if S == G: return 0
      visited[S] = 1
      queue = deque([S])
      while queue:
          current_layer = queue.popleft()
          for d in direction:
              next_layer = current_layer + d
              if 1 <= next_layer <= F and visited[next_layer] == 0:
                  if next_layer == G: return visited[current_layer]
                  visited[next_layer] = visited[current_layer] + 1
                  queue.append(next_layer)
      return "use the stairs"
  ```

  `U` 와 `D` 버튼을 눌러 이동하는 층 `next_layer` 이 건물에 포함되는 층(1보다 크고 F보다 작음)이며 아직 방문하지 않은 층(`visited` 의 값이 0)일 경우
  
  - 다음 층의 `visited` 값 `visited[next_layer]` 을 현재 층 `visited[current_layer]` + 1 로 설정하고,  `queue` 에 `next_layer` 을 append 한다.

  - 만약 `next_layer` 가 `G` 와 같을 경우 `visited[current_layer]` 을 return 한다. 

  - `next_layer` 와 `G` 가 같아지는 경우가 없을 경우, 즉 while이 종료될 경우 **"use the stairs"** 을 return 한다.


## :memo: Review

최근 푼 문제 중 가장 쉽게 접근한 문제였다.

하지만 한번의 틀림이 발생했는데 `S`와 `G`가 같을 경우를 고려하지 않은 것이 원인이었다.

방심하여 당연히 해야할 것을 놓친 것이다..