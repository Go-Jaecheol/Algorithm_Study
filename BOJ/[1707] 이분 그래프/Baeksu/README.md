# [1707] 이분 그래프 - Java

## :pushpin: **Algorithm**

그래프 이론, 그래프 탐색, DFS, BFS

## :round_pushpin: **Logic**

```java
class Graph {
    final List<Integer>[] graph;
    final int[] Binary = { -1, 1 };
    int[] discovered;
    boolean isBinaryGraph = true;
    int toggle = 0;

    public Graph(int size) {
        this.graph = new ArrayList[size+1];
        discovered = new int[size+1];

        for (int i = 0; i <= size; i++) {
            graph[i] = new ArrayList<>();
        }
    }
}
```

- 그래프의 정보를 저장하기 위한 클래스

```java
public boolean solution() {
    for (int i=1; i < graph.length; i++) {
        if (graph[i].size() > 0 & discovered[i] == 0) {
            isBinaryGraph = this.bfs(i);
            if (!isBinaryGraph)
                break;
        }
    }
    return this.isBinaryGraph;
}
```

- 인접 정점 정보가 있고, 아직 방문하지 않은 정점에 대해 *BFS* 를 수행
  - 정점의 방문 여부는 (0: 미방문), (-1: 1그룹), (1: 2그룹)
- 이분 그래프인지를 저장하는 `isBinaryGraph` 에 `false` 가 나오면 더 이상의 탐색을 종료하고 이를 반환
- `false` 가 계속 나오지 않으면 이분 그래프이므로 초기값인 `true` 가 반환
  
```java
public boolean bfs(int parent) {
    Queue<Integer> q = new LinkedList<>();
    q.add(parent);
    while (!q.isEmpty()) {
        int now = q.poll();
        if (discovered[now] == 0) { discovered[now] = Binary[toggle]; }
        toggle = (discovered[now] == -1 ? 1 : 0);
        for (int tmp : graph[now]) {
            if (discovered[tmp] == 0) {
                q.add(tmp);
                discovered[tmp] = Binary[toggle];
            } else if (discovered[tmp] == discovered[now])
                return false;
        }
    }
    return true;
}
```

- `Queue` 를 이용하여 **BFS** 수행
- 방문하지 않은 정점은 방문 여부 값을 가지고 있는 `Binary` 배열과 `toggle` 변수로 **setting**
- **BFS 단계별 서로 다른 방문 값 저장**
- 다음 방문할 정점이 **이미 방문**했고, 현재 방문 정점과 **같은 방문 값**을 가진다면 **이분 그래프 불가**

## :black_nib: **Review**

- 논리는 "DFS를 이용해 **홀수개의 정점끼리 사이클**을 이루는 경우 **이분그래프가 될 수 없다**" 였고, 반례를 통해 확인했을때 얼추 맞는 것 같으나, 계속 `런타임 에러 (IndexOutOfBounds)` 가 떠서 진전이 없었다.
- 10번 이상의 에러로 정신이 나가버릴 것 같아 BFS를 이용하는 방법으로 바꿔보기로 했다.
  - BFS를 이용하는 경우, 방문 순서로는 해결할 수 없을 것 같아 다른 방법을 고안해야 했다.
- DFS, BFS를 확실하게 이해할 수 있었던 것 같다.

```java
String str = sc.nextLine();
int a = str.charAt(0) - '0';
int b = str.charAt(2) - '0';
```

- 위 방식으로 `1 2` 형식의 숫자를 입력받으니 `10 12` 와 같은 경우 당연히 틀릴 수 밖에 없었다 ...