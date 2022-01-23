# [9466] 텀 프로젝트 - Java

## :pushpin: **Algorithm**

그래프 이론, 그래프 탐색, DFS

## :round_pushpin: **Logic**

```java
class Graph {
    final int[] graph;
    int[] discovered;
    boolean[] fin;
    int answer = 0;
    int graph_size;

    public Graph(int size) {
        graph_size = size + 1;
        this.graph = new int[graph_size];
        discovered = new int[graph_size];
        fin = new boolean[graph_size];
    }
}
```

- 그래프의 정보를 저장하기 위한 클래스

```java
public void search(int node) {
    if (discovered[node] == 1) return;

    discovered[node] = 1;
    int next = graph[node];

    if (discovered[next] == 0) search(graph[node]);
    else {
        if (!fin[next]) {
            answer++;
            for (int i=next; i!=node; i=graph[i]) {
                answer++;
            }
        }
    }
    fin[node] = true;
}
```

- 다음 방문할 정점이 방문하지 않은 경우는 `search()` 로 **DFS** 수행
- 다음 정점을 이미 방문한 경우, `fin[next]` 로 이미 사이클이 형성된 정점인지 확인
  - 그렇지 않은 경우, 다시 해당 정점으로 돌아오기 전까지 해당 정점과 연결된 정점의 수를 카운트
  - 카운트의 합이 곧 팀을 이루는 학생들이므로, **전체 학생 - 누적 카운트가 정답**

## :black_nib: **Review**

- 결국은 "사이클을 찾아야 한다" 라는 논리는 맞았지만, 최적화를 해내지 못해 **시간 초과**를 피할 수 없었다.
- 이제부터는 하루에 1문제는 풀어야하기 때문에 너무 시간을 잡아 먹지 않으려고 풀이를 참고했다.

## ❔ 참고
https://bcp0109.tistory.com/32