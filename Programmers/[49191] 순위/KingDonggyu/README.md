# [49191] 순위 - JS

## :mag: Algorithm

### BFS

## :round_pushpin: Logic

자신을 **이긴 선수를 가리키는 단방향 그래프**와 자신에게 **패배한 선수를 가리키는 단방향 그래프**를 생성한다.

```js
const graph = new Array(2).fill(null).map(_ => 
    new Array(n+1).fill(null).map(_ => []))

results.forEach(node => {
    graph[0][node[0]].push(node[1])
    graph[1][node[1]].push(node[0])
});
```

<br />

두 그래프 모두 **모든 선수를 각각 시작으로 하는** **BFS**을 실시하여 **두 방문횟수의 합이 `n+1`과 같을 시** 정확하게 순위를 매길 수 있는 선수로 판별한다.

```js
for (let i=1; i<n+1; i++) {
    for (let j=0; j<2; j++) {
        queue.push(i)
        while (queue.length > 0) {
            const next = queue.shift()
            graph[j][next].forEach(node => {
                if (!visited[node]) {
                    queue.push(node)
                    visited[node] = true
                }
            })
            count += 1
        }
        visited.fill(false)
    }
    if (count == n+1) answer += 1
    count = 0
}
```

## :memo: Review

두 단방향 그래프를 각각 BFS하는 방법을 금방 떠올려 쉽게 해결할 수 있었다.