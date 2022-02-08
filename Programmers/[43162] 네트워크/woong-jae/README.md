# [43162] 네트워크
## Algorithm
- DFS
## Logic
노드들을 순회하면서 dfs가 몇번 동작하는지 세면 된다.
```js
function solution(n, computers) {
    let answer = 0;
    
    const visited = new Array(n).fill(false);
    
    computers.forEach((_, node) => {
        if(!visited[node]) {
            dfs(node);
            answer++;
        }
    });
    
    function dfs(current) {
        visited[current] = true;
        computers[current].forEach((connected, node) => {
            if(connected && !visited[node]) dfs(node);
        });
    }
    
    return answer;
}
```
## Review
쉽다.
