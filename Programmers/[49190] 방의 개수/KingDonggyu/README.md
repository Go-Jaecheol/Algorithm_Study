# [49190] 방의 개수 - JS

## :mag: Algorithm

### JavaScript

## :round_pushpin: Logic

방이 생성되는 경우는 두가지이다.

**1. 이미 방문한 노드를 다시 방문하는 경우**

**2. 대각선이 서로 교차하는 경우** (ex. 모래시계 모양)

❗️ 단, 위 두 경우 모두 이미 이동한 간선을 이동하면 안된다.

```js
arrows.forEach(a => {
    for (let i=0;i<2;i++) {
        nextX += dx[a];
        nextY += dy[a];

        const nowStr = `${x},${y}`
        const nextStr = `${nextX},${nextY}`
        
        if (visited.has(nextStr) && !visited.get(nextStr).has(nowStr)) {
            answer++;
        } 
        
        if (!visited.has(nextStr)) {
            visited.set(nextStr, new Set())
        }
        
        visited.get(nextStr).add(nowStr)
        visited.get(nowStr).add(nextStr)

        x = nextX;
        y = nextY;
    }
});
```

**대각선이 서로 교차하여 방이 생기는 경우를 위해, 각 노드 사이에 하나의 노드를 더 추가한다.**

즉, 노드 사이를 이동할 때 두개의 간선을 거치도록 한다.

## :memo: Review

대각선의 경우를 간과하여 아이디어를 찾는데 시간을 소요했다.

원인을 알고 문제를 해결하긴 했지만 마지막 테스트 케이스의 시간이 948.74ms나 소요되었다..

시간을 줄이고 싶은 욕구가 차올라 고민해보다 **Object 자료구조**가 범인인 것 같았다.

구글링해본 결과, **빈번한 추가가 있거나 데이터의 크기가 클 때, Object보다 Map의 성능이 더 뛰어나다는 것을 알게 되었고,** Map을 사용한 코드로 변경하니 시간이 218.09ms로 대폭 줄었다!

시간을 꽤 투자하여 아쉽긴 하지만, JS에 대해 더 알게되어 유익했던 시간이었다.