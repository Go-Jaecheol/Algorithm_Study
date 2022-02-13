# [42587] 프린터 - Python

## :mag: Algorithm

### Queue

## :round_pushpin: Logic

**Problem: "다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다."**

💡 **큐**를 이용한다.

이때, **트럭이 다리를 건너는데 `bridge_length`초가 걸리는 것**을 명심해야 한다.

- 그러므로, **큐에 `bridge_length` 개의 0을 채워 넣는다.**

```python
while True:
    w -= q.pop(0)
    if truck_weights and truck_weights[0] + w <= weight:
        x = truck_weights.pop(0)
        q.append(x)
        w += x
    else:
        q.append(0)

    answer += 1
    if w == 0: break
```

- 매 반복마다 큐를 **pop**한다.

  - pop한 무게를 `w`(현재 다리 위의 총 트럭 무게)에 빼준다.

- 만약 `truck_weights` 첫번째 원소와 `w`의 합이 `weight`보다 작다면, `truck_weights`의 첫번째 원소를 큐에 **push**한다.

  - push한 무게는 `w`에 더해준다.

- 위 **pop-push**를 반복하다 `w`가 0이 되면 종료한다.

## :memo: Review

트럭이 다리를 건너는데 `bridge_length`초가 걸린다는 설명이 문제에 빠져있어 조금 당황스러웠다.

그래도 문제에서 제시하는 예시 설명을 보고 금방 알아차렸고, 큐를 이용하는 방법을 금방 떠올려 쉽게 해결할 수 있었다.
