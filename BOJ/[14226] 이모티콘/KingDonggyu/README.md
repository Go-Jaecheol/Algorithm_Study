# [14226] 이모티콘 - Python

## :mag: Algorithm

Dynamic Programming

BFS

## :round_pushpin: Logic

> 이 문제는 목적지까지 최단거리(시간)를 구해야 하므로 BFS를 이용해야 한다.

<br />

- collections 모듈의 deque를 이용해 queue형 자료구조 변수 `queue`를 선언하고, **(화면 이모티콘 개수, 클립보드 이모티콘 개수)** 를 뜻하는 (1, 0) 튜플을 append한다. 그리고 이미 계산한 경우의 중복을 없애기 위함과 더불어 시간 값을 저장하기 위한 딕셔너리 `visited`를 선언한다. `visited` 또한 마찬가지로 처음 상태인 (1, 0) 튜플을 key로 가진 값을 0으로 설정한다.
  ```python
  S = int(input())
  queue = deque()
  queue.append((1, 0))  # (화면 이모티콘 개수, 클립보드 이모티콘 개수)
  visited = dict()
  visited[(1, 0)] = 0
  ```

<br />

- **BFS** => 매 반복마다 `queue` 를 pop하여 `visited`에 (화면 이모티콘 개수, 클립보드 이모티콘 개수)가 key 값으로 존재하지 않은 경우 복사, 붙여넣기, 삭제 연산을 실시하고 `queue`에 해당 튜플을 append한다.

  ```python
  while queue:
    screen, clipboard = queue.popleft()
    if screen == S:
        print(visited[(screen, clipboard)])
        break

    # 복사
    if (screen, screen) not in visited.keys():
        visited[(screen, screen)] = visited[(screen, clipboard)] + 1
        queue.append((screen, screen))

    # 붙여넣기
    if (screen + clipboard, clipboard) not in visited.keys():
        visited[(screen + clipboard, clipboard)] = visited[(screen, clipboard)] + 1
        queue.append((screen + clipboard, clipboard))

    # 삭제
    if (screen - 1, clipboard) not in visited.keys():
        visited[(screen - 1, clipboard)] = visited[(screen, clipboard)] + 1
        queue.append((screen - 1, clipboard))
  ```

  만약 `screen`(화면 이모티콘 개수)이 입력 받은 `S` 와 값이 같을 경우 `visited[(screen, clipboard)]`(해당 시간)을 출력한다.

## :memo: Review

**첫번째 코드**

```python
from collections import deque

S = int(input())
visited = [[False] * 1001 for _ in range(1001)]
queue = deque([(2, 1, 2)])
temp = 0

while queue:
    value, dif, time = queue.popleft()
    if visited[value][dif]: continue
    if value == S: print(time); break
    visited[value][dif] = True

    if value + dif == S:
        if temp != 0 and temp < time + 1: print(temp)
        else: print(time + 1);
        break
    if value + dif > S and temp == 0:
        temp = value + dif -S + time +1
    queue.append((value + dif, dif, time+1))


    if value * 2 == S:
        if temp != 0 and temp < time + 2: print(temp)
        else: print(time + 2);
        break
    if value * 2 > S and temp == 0:
        temp = value * 2 - S + time + 2
    queue.append((value * 2, value, time+2))
```

내가 첫번째 작성한 코드는 위와 같다. 이 코드로는 자꾸만 **런타임 에러 - IndexError**가 생겼고, 이는 큰 수에서의 2차원 배열 `visited` 의 인덱스 범위를 벗어나는 것이 원인으로 추정된다. 이를 해결하기 위해서는 어마어마하게 큰 사이즈의 배열을 선언해야 하는데, 이는 메모리적으로 너무나 비효율적이다.

<br />

**최종 코드**

```python
from collections import deque

S = int(input())
queue = deque()
queue.append((1, 0))
visited = dict()
visited[(1, 0)] = 0

while queue:
    screen, clipboard = queue.popleft()
    if screen == S:
        print(visited[(screen, clipboard)])
        break
    if (screen, screen) not in visited.keys():
        visited[(screen, screen)] = visited[(screen, clipboard)] + 1
        queue.append((screen, screen))
    if (screen + clipboard, clipboard) not in visited.keys():
        visited[(screen + clipboard, clipboard)] = visited[(screen, clipboard)] + 1
        queue.append((screen + clipboard, clipboard))
    if (screen - 1, clipboard) not in visited.keys():
        visited[(screen - 1, clipboard)] = visited[(screen, clipboard)] + 1
        queue.append((screen - 1, clipboard))
```

결국 첫번째 코드를 완전 갈아엎었고, 위 최종 코드로 문제를 해결할 수 있었다. 첫번째 코드에 집착한 나머지 새로운 아이디어가 떠오르지 않아 웹 상의 한 고수님의 아이디어를 참조했다..

이번 문제는 그다지 어려운 난이도가 아니였던 것 같은데 많이 아쉽다.