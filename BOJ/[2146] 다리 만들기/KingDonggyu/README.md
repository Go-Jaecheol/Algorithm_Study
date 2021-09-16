# [2146] 가장 큰 정사각형 - Python

## :mag: Algorithm

BFS

## :round_pushpin: Logic

- **입력 및 주요 변수 생성**

    ```python
    N = int(input())
    land = [[int(x) for x in input().split()] for _ in range(N)]
    visited = [[0] * N for _ in range(N)]
    direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # 상, 하, 좌, 우
    ```

    `visited` : 방문 여부와 다리의 길이를 나타내는 2차원 배열
    `direction` : BFS 시 상하좌우로 탐색을 하기 위한 배열

<br />

- **섬들을 구별하기 위한 BFS**

    ```python
    island_id = 2
    for i in range(N):
        for j in range(N):
            if land[i][j] == 1 and visited[i][j] == 0:
                find_island(i, j)
                island_id += 1
    ```

    ```python
    def find_island(start_x, start_y):
        queue = deque([(start_x, start_y)])
        visited[start_x][start_y] = 1
        while queue:
            i, j = queue.popleft()
            for d in direction:
                x, y = i + d[0], j + d[1]
                if 0 <= x < N and 0 <= y < N:
                    if visited[x][y] == 0 and land[x][y] == 1:
                        queue.append((x, y))
                        visited[x][y] = 1
                    elif land[x][y] == 0:
                        land[i][j] = island_id
    ```

    BFS 를 실시하여 각 섬마다 고유한 id `island_id` 를 부여한다. 이 때 후에 있을 BFS 시간을 줄이기 위해 상화좌우로 0이 있는 (바다와 근접해있는) 원소(육지)에만 id를 준다.

<br />

- **가장 짧은 다리를 찾는 BFS**

    ```python
    bridge = sys.maxsize
    for i in range(2, island_id):
        find_bridge(i)
    print(bridge)
    ```
    ```python
    def find_bridge(id):
        global bridge
        queue = deque()
        for i in range(N):
            for j in range(N):
                if land[i][j] == id: queue.append((i, j))
        visited = [[0] * N for _ in range(N)]
        while queue:
            i, j = queue.popleft()
            for d in direction:
                x, y = i + d[0], j + d[1]
                if 0 <= x < N and 0 <= y < N:
                    # 바다인 경우
                    if land[x][y] == 0 and visited[x][y] == 0:
                            visited[x][y] = visited[i][j] + 1
                            queue.append((x, y))
                    # 다른 섬인 경우
                    elif land[x][y] > 1 and land[x][y] != id:
                        bridge = min(bridge, visited[i][j])
                        return
    ```
    
    2중 반복문을 통해 출발하는 섬의 id를 가진 원소(육지)의 인덱스를 `queue`에 append한다. 이후 BFS 를 실시하여 위 코드와 같이 바다인 경우 `visited` 값을 업데이트하고, 다른 섬인 경우 `bridge` 값을 최소값으로 업데이트한다.

## :memo: Review

한번의 BFS로 문제를 해결하기 위한 아이디어를 구상하느라 시간이 오래 걸렸다.

결국 BFS를 두번 시행하는 것을 선택했고, 문제를 해결할 수 있었다.

**시간초과**가 한번 발생했는데 이를 해결하기 위해 두번째 BFS 에서 상하좌우에 다른 섬이 있을 경우 **return** 하는 코드를 추가했다.

그 이유는 가장 먼저 다른 섬에 도착하는 경우가 항상 가장 최소의 `bridge` 값이라 생각했기 때문이다.
