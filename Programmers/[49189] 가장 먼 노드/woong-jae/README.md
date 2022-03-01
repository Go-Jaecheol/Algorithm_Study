# [49189] 가장 먼 노드
## Algorithm
- BFS
## Logic
가장 먼 노드를 알기 위해 BFS로 마지막 깊이까지 간다.

BFS 스택이 비어지면 가장 먼 노드들에 도달한 것이기 때문에, 스택이 비어지기 전 스택의 사이즈가 가장 먼 노드들의 숫자다.

```js
function solution(n, edge) {
    let answer = 0;
    
    const visited = new Array(n + 1).fill(false);
    const adj_list = new Array(n + 1).fill(0).map(_ => []);
    edge.forEach(e => {
        adj_list[e[0]].push(e[1]);
        adj_list[e[1]].push(e[0]);
    });
    
    let stack = [1];
    let currentDepth = 1;
    visited[1] = true;
    while(1) {
        let size = stack.length
        let nextStack = [];
        stack.forEach(currentNode => {
            adj_list[currentNode].forEach(next => {
               if(!visited[next]) {
                   visited[next] = true;
                   nextStack.push(next);
               }
            });
        });
        currentDepth++;
        if(!nextStack.length) {
            answer = size;
            break;
        }
        stack = nextStack;
    }
    
    return answer;
}
```
## Review
쉽게 풀 수 있었던 문제. 마지막 테스트 케이스가 `25ms` 나오던데, 더 줄일 수 없나 고민된다.

> `pop`을 하지 않고 `forEach`로 변경해서 `21ms`로 줄였다.
