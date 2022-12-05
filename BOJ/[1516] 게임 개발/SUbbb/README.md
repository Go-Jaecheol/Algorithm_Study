# [1516] 게임 개발

## :pushpin: **Algorithm**

위상 정렬, DP

## :round_pushpin: **Logic**

```java
Queue<Integer> orders = new LinkedList<>();
for (int index = 1; index <= n; index++) {
    if (inDegree[index] == 0) {
        orders.add(index);
        minTimes[index] = setupTime[index];
    }
}
```

- 진입 차수가 0인 정점들은 바로 건설이 가능하기에 건설 시간을 바로 저장한다.

```java
while(!orders.isEmpty()) {
    int now = orders.poll();

    for (int next : adjInfo.get(now)) {
        inDegree[next]--;
        if (inDegree[next] == 0) {
            orders.add(next);
        }
        minTimes[next] = Math.max(minTimes[now] + setupTime[next], minTimes[next]);
    }
}
```

- 큐를 탐색하면서, 진입 차수를 감소시킨다. 이때 0이 되는 정점들은 큐에 삽입한다.
- 건물 짓는 시간을 계속 갱신해준다. 선행 관계가 모두 끝난 건물에 대해서는 더이상 갱신되지 않고, 아직 선행 관계가 남아 있는 건물에 대해서는 최댓값으로 갱신되어야 한다.

## :black_nib: **Review**
- 반례 경우 하나만 고려하니 바로 해결되는 문제였다.
- 위상 정렬에 대한 감을 많이 잡는 중