# [17471] 게리멘더링 - Python

## :mag: Algorithm

BFS

BruteForce

## :round_pushpin: Logic

- 입력

  - `popultaion`과 `area_info`의 맨 앞에 `False`를 추가하여 1부터 N까지의 인덱스를 이용하고, 인덱스 0의 값은 무시하도록 한다.

  ```python
  N = int(sys.stdin.readline())
  population = [int(x) for x in sys.stdin.readline().split()]
  population.insert(0, False)
  area_info = [[int(x) for x in sys.stdin.readline().split()] for _ in range(N)]
  area_info.insert(0, False)
  ```

<br />

- **BFS**

  ```python
  def bfs(area):
      visited[area[0]] = True
      queue = deque([area[0]])
      sum_population = population[area[0]]
      while queue:
          x = queue.popleft()
          for i, v in enumerate(area_info[x]):
              if i != 0 and v in area and not visited[v]:
                  visited[v] = True
                  queue.append(v)
                  sum_population += population[v]
      return sum_population
  ```

<br />

- 1부터 N까지의 값을 `combinations`을 이용한 조합 리스트를 `area1`, 조합 리스트에 포함되지 않은 값으로 이루어진 리스트를 `area2`로 설정하여 각각 **BFS**를 실시한다.

  - **중복된 리스트에 대해 불필요한 연산을 없애기 위해** 1부터 `N//2 + 1`만큼의 size를 가진 조합만을 이용한다.

  - `area1`과 `area2`에 대해 각각 **BFS** 후 받은 리턴값(선거구의 인구 수 합)의 합이 모든 구역의 인구 수 합과 같을 경우, 두 선거구의 인구 차이 최솟값을 업데이트한다.

  - 반복문을 잉요한 조합에 대한 연산을 모두 종료한 후 `min_diff`(최종 업데이트된 두 선거구의 인구 차이 최솟값)의 값이 `sys.maxsize`와 같다면(두 선거구로 나눌 수 없음) -1을 출력하고, 그렇지 않으면 `min_diff`를 출력한다.

  ```python
  total_population = sum(population)
  min_diff = sys.maxsize
  for i in range(N//2):
      for comb in combinations(range(1, N+1), i+1):
          visited = [False] * (N+1)
          area1 = list(comb)
          area2 = list(x for x in range(1, N+1) if not x in comb)
          sum1, sum2 = bfs(area1), bfs(area2)
          if sum1 + sum2 == total_population:
              min_diff = min(min_diff, abs(sum1 - sum2))

  print(-1 if min_diff == sys.maxsize else min_diff)
  ```

<br />

## :memo: Review

오랜만에 풀어본 알고리즘 문제라 그런지 아이디러를 떠올리는데 꽤 많은 시간을 소요했다.

백준에서 제공하는 해당 문제에 대한 알고리즘 분류에 '브루트포스 알고리즘'이 있는 것을 보고 '조합'을 이용한 아이디어를 떠올렸다.

알고리즘 분류가 어떤 것인지 보지 않고 문제를 해결하는 연습을 해야겠다.