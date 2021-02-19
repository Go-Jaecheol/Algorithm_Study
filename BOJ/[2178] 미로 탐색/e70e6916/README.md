# [2178] 미로 탐색 - Python

## :mag: Algorithm

**BFS**

## :round_pushpin: Logic

아래의 BFS를 통해 주어진 0으로 초기화 된 N x M 크기의 리스트```route```를 미로의 도착위치로
이동하기 까지 계속해서 업데이트한다.
```angular2html
route[0][0] = 1
queue = deque([(0, 0)])
while queue:
    i, j = queue.popleft()
    for d in direction:
        x, y = i + d[0], j + d[1]
        if 0 <= x < N and 0 <= y < M and route[x][y] == 0 and maze[x][y] == 1:
            route[x][y] = route[i][j] + 1
            queue.append((x, y))
```

최종 업데이트 된 ```route```의 ```route[-1][-1]```가 결국 미로의 최단거리가 된다.

## :memo: Review

조금 생각하니 금방 풀린 문제였다. BFS 짱