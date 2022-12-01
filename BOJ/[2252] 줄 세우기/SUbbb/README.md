# [2252] 줄 세우기

## :pushpin: **Algorithm**

위상 정렬

## :round_pushpin: **Logic**

```java
private static void dfs(int start) {
    visited[start] = true;

    for (int next : adjs[start]) {
        if (!visited[next]) {
            dfs(next);
        }
    }

    studentOrder.add(start);
}
```

- 만들어진 인접 리스트를 이용해 각 정점마다 DFS를 수행한다.
- 방문 여부를 표시하고, 해당 정점에서 갈 수 있는 모든 정점까지 방문한 후, 해당 정점을 줄 세운다!
- 재귀 호출하면서, 더 이상 갈 곳이 없는 정점부터 앞에 세워지게 될 것이고, 마지막에 reverse()한다.

```java
private static void print() {
    StringJoiner sj = new StringJoiner(" ");
    studentOrder.forEach(student -> sj.add(String.valueOf(student)));
    System.out.println(sj);
}
```

- `List<Integer> studentOrder`에 세워진 학생 순서를 출력할 때 사용한다.
- 이번에 처음 사용해본 `StringJoiner`를 통해 구분자를 추가해서 출력할 수 있었다.

## :black_nib: **Review**
- 위상 정렬을 사용하는 문제임을 바로 알 수 있었다.
- 정점 inbound를 구하는 방식과 DFS를 사용하는 방식 중 DFS 방식이 더 쉽게 구현할 것 같아서 이를 사용했다.
- 결국 "특정 정점이 더 이상 갈 곳이 없다면 순서에 추가해야 한다" 라는 점이 주요했던 것 같다.