# [42583] 다리를 건너는 트럭

## :pushpin: **Algorithm**

큐

## :round_pushpin: **Logic**

```java
while(true) {
    // 다리 위에 트럭이 없는 경우
    if (bridge.isEmpty()) {
        bridge.add(truck);
        nowWeight += truck;
        answer++;
        break;
    }
    // 이미 다리가 가득 찬 경우 다리에서 트럭 하나 제외
    else if (bridge.size() == bridge_length) {
        nowWeight -= bridge.poll();
    }
    // 다리의 용량 제한으로 인해 새로운 트럭을 올리지 못하는 경우 0을 추가해서 다리에 있는 트럭 밀기
    else if (nowWeight + truck > weight) {
        bridge.add(0);
        answer++;
    }
    // 다리 용량 제한을 만족하는 경우 트럭을 올림
    else {
        bridge.add(truck);
        nowWeight += truck;
        answer++;
        break;
    }
}
```

- 현재 트럭을 올릴 때까지 반복한다.
- 다리 위에 트럭이 없는 경우, 이미 다리가 가득 찬 경우, 다리가 가득 차지 않았지만 용량 제한으로 올리지 못하는 경우, 다리가 가득 차지 않았고 용량 제한을 만족하는 경우로 나눠 시간을 계산한다.

## :black_nib: **Review**
- 큐를 사용하는 문제임을 바로 알 수 있었던 문제였다.
- 시간을 계속 1씩 더하면서 하는 방식이 아니라 한 번에 시간을 계산하고 다음 트럭을 탐색하는 방법을 사용하려 했는데, 생각대로 되질 않아 풀이를 참고했다.