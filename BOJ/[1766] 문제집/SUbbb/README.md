# [1766] 문제집

## :pushpin: **Algorithm**

위상 정렬, 우선순위 큐

## :round_pushpin: **Logic**

```java
for (int index = 1; index <= N; index++) {
    if (inDegree[index] == 0) {
        problems.add(index);
    }
}

StringBuilder answer = new StringBuilder();
while (!problems.isEmpty()) {
    int problem = problems.poll();
    lookAdjacent(problem);
    answer.append(problem).append(" ");
}
```

- 정점으로의 진입 갯수를 구하고, 진입 갯수가 0인 정점을 우선순위 큐에 삽입한다.
  - 진입 갯수가 0이라는 말은, 해당 번호의 문제를 다른 특정 문제보다 먼저 풀어야 할 수도 있다는 의미를 가진다.
  - 혹은, 다른 어떤 문제와도 선후 관계를 가지지 않는다는 의미도 가질 수 있다.
  - 따라서 우선순위 큐에 삽입해 번호가 작은 문제가 먼저 오도록 한다.

```java
private static void lookAdjacent(int problem) {
    for (int next : adjs.get(problem)) {
        if (inDegree[next] > 0) {
            inDegree[next]--;
        }
        if (inDegree[next] == 0) {
            problems.add(next);
        }
    }
}
```

- 큐에서 한 문제씩 꺼내면서, 해당 문제와 선행 관계가 있는 문제들의 진입 갯수를 감소시킨다.
- 이때, 진입 갯수가 0이 되는 문제가 있다면 큐에 삽입한다.

## :black_nib: **Review**
- 위상 정렬을 사용하는 문제임을 바로 알 수 있었고, 바로 이전에 풀었던 줄 세우기와 같은 방식으로 접근했다.
  - DFS를 수행하는 것은 동일하나, 문제 번호가 작은 것이 먼저 와야 하므로, DFS 순회를 번호가 큰 문제부터 수행하도록 했다.
- 게시판에 있는 대부분의 반례를 수행해보아도 잘못된 것을 찾을 수 없었는데도 불구하고 8%에서 틀렸습니다라고 떠서.. 다른 풀이를 보니 DFS로 한 사람을 찾을 수 없었다.
- 위상 정렬은 사실 2가지가 풀이가 있다.
  - 진입 차수를 계산하면서 풀이
  - DFS를 사용한 풀이
- 이 문제는 진입 차수에 대해 생각해봤어야 하는 문제였던 것 같다...