# [3665] 최종 순위

## :pushpin: **Algorithm**

위상 정렬

## :round_pushpin: **Logic**

```java
private static void fillAdj(int from, int idx) {
    for (int index = idx + 1; index < n; index++) {
        adjInfo.get(from).add(prevInfo[index]);
    }
}
```

- 인접 정보를 저장할 때, 1등은 다른 등수로의 인접 정보를 가진다. 따라서 위와 같은 형태로 자기보다 낮은 등수의 정점에 대한 인접 정보를 저장한다.

```java
for (int count = 0; count < newInfo; count++) {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int from = Integer.parseInt(st.nextToken());
    int to = Integer.parseInt(st.nextToken());

    if (adjInfo.get(from).contains(to)) {
        updateInfo(from, to);
    } else if (adjInfo.get(to).contains(from)) {
        updateInfo(to, from);
    }
}
```

- 본부 발표 정보를 읽어서 인접 정보와 진입 차수 정보를 갱신한다.
- 이미 선행 관계가 있는 정점들에 대해 이를 뒤바꿔주는 동작을 수행한다.

```java
// 0인 정점이 2개 이상이면 순위를 정할 수 없는 경우
if (orders.size() > 1) {
    answers.append(CANNOT_FIND);
    continue;
}

int count = 0;
StringBuilder order = new StringBuilder();
while(!orders.isEmpty()) {
    int now = orders.poll();
    order.append(now).append(" ");
    count++;

    for (int next : adjInfo.get(now)) {
        inDegree[next]--;
        if (inDegree[next] == 0) {
            orders.add(next);
        }
    }
}
```

- 진입 차수가 0인 정점을 큐에 넣고, 위상 정렬 연산을 수행한다.
  - 만약 큐의 크기가 1보다 크다면, 진입 차수가 0인 정점이 2개 이상임을 의미하고, 이는 확실한 순위를 정할 수 없음을 의미한다.
- 위상 정렬을 수행한다.

```java
if (count != n) {
    answers.append(NO_CONSISTENCY);
} else {
    answers.append(order);
}
```

- 위상 정렬의 결과가 주어진 정점의 수와 다르다면, 일관성이 없는 정보로 인해 순위가 정상적으로 만들어지지 않은 경우이다.

## :black_nib: **Review**
- 위상 정렬을 상당히 맛없게 응용한 문제였다.
- 진입 차수만으로 구현하려 했는데, 인접 정보가 필요했어서 시간이 좀 걸렸다.