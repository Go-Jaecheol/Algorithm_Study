# [2146] 다리 만들기 - Java

## :pushpin: **Algorithm**

그래프 이론, 그래프 탐색, BFS

## :round_pushpin: **Logic**

```java
class Loc {
  int x;
  int y;
  int cnt;

  public Loc(int x, int y, int cnt) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
  }

  public int getX() {
      return x;
  }

  public int getY() {
      return y;
  }

  public int getCnt() {
      return cnt;
  }
}
```

- 각 정점별 좌표 및 현재 정점까지 오는데 필요한 다리 수를 저장하기 위해 사용하는 클래스

```java
class Graph {
  final int[][] graph;
  boolean[][] discovered;
  Queue<Loc> q = new LinkedList<>();
  int[] w_way = { 1, 0, -1, 0 };
  int[] y_way = { 0, 1, 0, -1 };
  int bridge = Integer.MAX_VALUE;
  int graph_size;
  ...
}
```

- 그래프의 정보를 저장하기 위해 사용하는 클래스

```java
private int buildBridge(int x, int y) {
  discovered = new boolean[graph_size][graph_size];
  q = new LinkedList<>();
  q.add(new Loc(x, y, 0));
  int cur_land = graph[x][y];
  discovered[x][y] = true;

  while(!q.isEmpty()) {
    Loc loc = q.poll();
    int cur_x = loc.getX();
    int cur_y = loc.getY();
    int cnt = loc.getCnt();

    if (graph[cur_x][cur_y] != 0 && graph[cur_x][cur_y] != cur_land) return cnt;

    for (int i = 0; i < 4; i++) {
      int nextX = cur_x + w_way[i], nextY = cur_y + y_way[i];

      if (nextX < 0 || nextX >= graph_size || nextY < 0 || nextY >= graph_size) continue;
      if (discovered[nextX][nextY] || graph[nextX][nextY] == cur_land) continue;

      discovered[nextX][nextY] = true;
      q.add(new Loc(nextX, nextY, cnt+1));
    }
  }
  return -1;
}
```

- 구분된 대륙 정보를 가지고, 서로 다른 대륙을 잇는 다리를 놓아보는 메소드
- `if (graph[cur_x][cur_y] != 0 && graph[cur_x][cur_y] != cur_land) return cnt;` 을 통해 서로 다른 대륙을 이은 경우 사용된 `다리 길이 + 1` 이 반환
- 방문하지 않은 `0` , 즉 바다의 경우에만 계속 `Queue` 에 추가 

## :black_nib: **Review**

- `Queue` 에 데이터 추가, 삭제, 검색 시 사용하는 메소드들 중 유사한 기능을 하는 메소드들의 차이를 아래 참고 블로그에서 확인할 수 있었다.
- 섬을 구분하여 저장하고, 이후 다리를 건설할 때 섬의 가장자리부터 탐색을 시작하면 어떨까라는 생각을 했다.
  - 섬의 가장자리를 구분해 저장해놓고 탐색하려니, 섬의 가장자리를 구분하는 것이 문제였다.
- 섬의 가장자리를 구분하지 않고, `브루트 포스` 처럼 모든 섬의 좌표에서 탐색하는 방식으로 변경했고, **메모리 초과**가 발생했다.

```java
graph[nowX][nowY] = land;
discovered[nowX][nowY] = true;

for (int i = 0; i < 4; i++) {
  int nextX = nowX + w_way[i], nextY = nowY + y_way[i];
  if (nextX >= 0 && nextX < graph_size && nextY >= 0 && nextY < graph_size && graph[nextX][nextY] == 1 && !discovered[nextX][nextY]) {
      q.add(new Loc(nextX, nextY, 0));
  }
}

// 위 코드를 아래와 같이 변경, 메모리 초과가 발생하지 않음

if (nextX < 0 || nextX >= graph_size || nextY < 0 || nextY >= graph_size) continue;
if (discovered[nextX][nextY]) continue;

if (graph[nextX][nextY] == 1) {
  graph[nextX][nextY] = land;
  discovered[nextX][nextY] = true;
  q.add(new Loc(nextX, nextY, 0));
}
```

- 블로그를 참고하여 위의 코드 수정으로 메모리초과를 피할 수 있었는데, 논리적으로 이해가 가지 않는다...