# [2623] 음악프로그램

## :pushpin: **Algorithm**

위상 정렬

## :round_pushpin: **Logic**

```java
for (int index = 1; index <= N; index++) {
    if (inDegree[index] == 0) {
        problems.add(index);
    }
}

List<Integer> answer = new ArrayList<>();
while (!problems.isEmpty()) {
    int problem = problems.poll();
    lookAdjacent(problem);
    answer.add(problem);
}
```

- 정점별 진입 갯수를 구해놓고, 0인 정점만을 큐에 삽입한다.
- 진입 갯수가 0이라면, 다른 가수보다 먼저 와야 한다는 것을 의미한다. 혹은, 다른 가수와의 선후 관계가 없음을 의미한다.
- 이후, 큐에서 한 정점씩 뽑아서 탐색한다.

```java
private static void lookAdjacent(int problem) {
    for (int next : adjs.get(problem)) {
        inDegree[next]--;
        if (inDegree[next] == 0) {
            problems.add(next);
        }
    }
}
```

- 주어진 정점에서 갈 수 있는 정점들에 대해 진입 갯수를 감소시킨다.
- 이때 진입 갯수가 0이 되면 큐에 삽입한다.
  
```java
if (answer.size() != N) {
    System.out.println(0);
    return;
}

answer.forEach(System.out::println);
```

- 다른 위상 정렬문제와 달랐던 점이다.
- 남일이가 순서를 못 정하는 경우는 사이클이 생기는 경우라고 판단했다.
- 그리고 이 사이클 감지를 위해서는 만들어진 순서가 N개로 이뤄지지 않은 경우일 것이다.

## :black_nib: **Review**
- 위상 정렬을 사용하는 문제임은 명백했다.
- 다만 순서를 정하지 못하는 경우라는 것이 추가되어 예제를 따라가보니, 사이클이 생기는 경우가 해당되는 것 같았다.
- 따라서 사이클을 어떻게 감지할까 하다가, 만들어진 순서가 N개가 아닌 경우인지 확인하는 것으로 판단했다.
- 이를 DFS로 해결해볼까도 했지만, 사이클 감지 로직에서 좀 어려울 것 같아 진입 차수 계산으로 해결했다.