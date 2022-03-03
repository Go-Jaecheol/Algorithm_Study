# [49189] 가장 먼 노드 - Python

## :mag: Algorithm

### BFS

## :round_pushpin: Logic

주어진 입력을 통해 양방향 그래프를 만든다.

```js
edge.forEach(node => {
    graph[node[0]].push(node[1])
    graph[node[1]].push(node[0])
});
```

<br />

BFS를 통해 그래프를 탐색하며, 가장 먼 노드(최단 경로의 간선의 개수가 가장 많은 노드)를 찾는다.

```js
while (queue.length > 0) {
    const next= queue.shift()
    const edgeCnt = next[1]+1
    
    graph[next[0]].forEach(node => {
        if (!visited[node]) {
            queue.push([node, edgeCnt])
            visited[node] = true
            if (answer.length <= edgeCnt) {
                answer.push([])
            }
            answer[edgeCnt].push(node)
        }
    })
}
```

## :memo: Review

최단 경로를 찾는 BFS의 기본 성질을 반영한 문제다.

처음으로 자바스크립트로 풀어보아 IDE를 사용하지 않을 수 없었다..

자바스크립트를 좀 더 손에 익도록 연습해야겠다.