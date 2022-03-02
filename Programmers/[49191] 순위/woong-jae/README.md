# [49191] 순위
## Algorithm
- Graph
## Logic
각 노드에서 BFS를 해서 노드들의 방문 횟수를 `rank`에 기록한다. 이 기록은 패배후 기록과 같다.
BFS 할 때, 노드 방문 횟수를 세어서 시작한 노드의 승리 횟수를 `wins`에 기록한다.

정확하게 순위를 매길 수 있는 선수는 될 수 있는 최소 순위인 `n - wins[node]`가 될 수 있는 최대 순위 `rank[node]`와 같은 선수다.

```js
function solution(n, results) {
    let answer = 0;
    
    const rank = new Array(n + 1).fill(0);
    const wins = new Array(n + 1).fill(0);
    const adj_list = new Array(n + 1).fill(0).map(_ => []);
    results.forEach(result => adj_list[result[0]].push(result[1]));
    
    for(let node = 1; node <= n; node++) {
        const visited = new Array(n + 1).fill(false);
        visited[node] = true;
        rank[node]++;
        let current = [node];
        while(current.length) {
            let next = [];
            current.forEach(currentNode => {
                adj_list[currentNode].forEach(nextNode => {
                   if(!visited[nextNode]) {
                    next.push(nextNode);
                    visited[nextNode] = true;
                    rank[nextNode]++;
                    wins[node]++;
                } 
                });
            });
            current = next;

        }
    }
    
    for(let node = 1; node <= n; node++) {
        if(n - wins[node] === rank[node]) answer++;
    }
    
    return answer;
}
```
## Review
방문 횟수를 세는 아이디어는 쉽게 떠올렸지만, 정확하게 순위를 매길 수 있는 선수를 찾는 아이디어를 빨리 떠올릴 수 없었다.

단순 방문 문제가 아닌 게 처음이라 그런 것 같다.
