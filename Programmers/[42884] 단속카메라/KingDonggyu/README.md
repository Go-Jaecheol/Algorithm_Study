# [42884] 단속카메라 - Python

## :mag: Algorithm

### Greedy

## :round_pushpin: Logic

**Problem: "모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야 하는지를 return"**

💡 각 차량의 진입/진출 지점이 **겹치는 구간을 파악**하여 카메라를 최소화한다.

```python
if x <= routes[i][0] <= y:
    y = min(y, routes[i][1])
else:
    y = routes[i][1]
    answer += 1
x = routes[i][0]
```

- `routes`를 진입 지점을 기준으로 **정렬**하여 수행한다.

- 겹치는 구간인지 여부를 결정하기 위한 기준이 되는 진입 지점(`x`)과 진출 지점(`y`)를 **업데이트**하며 카메라 수(`answer`)의 증가 여부를 결정한다.

## :memo: Review

문제를 읽자마자 겹치는 구간을 파악하면 되겠다고 확신했고,

이에 대해 깊게 생각하며 코드를 구현해 쉽게 해결할 수 있었다.