# [43164] 여행경로
## Algorithm
- Map
- DFS
## Logic
주어진 티켓들을 사용해서 인접 리스트를 만들었다. 이때, `Map` 자료구조를 이용해서 노드에 빠르게 접근할 수 있게 했다.

일반적인 DFS와는 다르게 이 문제에서는 *한 번 갔던 곳에 다시 갈 수 있기* 때문에, 맵의 값으로 숫자를 줬다.

만든 인접 리스트를 바탕으로 "ICN"부터 시작해서 끝까지 가는 경로를 찾았다.
모든 경로를 방문할 수 없는 경우는 주어지지 않기 때문에, 만약 더 갈 수 없는 노드에 도착하면 다시 뒤돌아 가야한다.
DFS의 깊이가 주어진 티켓의 길이와 같아지면 모든 티켓을 사용한 것이기 때문에 정답을 찾은 것이다.

```js
function solution(tickets) {
    let answer = ["ICN"];
    
    const adj = new Map();
    tickets.forEach(ticket => {
        let [from, to] = ticket;
        if(adj.has(from)) {
            let list = adj.get(from);
            if(list[to]) list[to]++;
            else list[to] = 1;
        }
        else adj.set(from, { [to]: 1 });
    });
    
    function dfs(cur, depth) {
        if(depth === tickets.length) return true;
        if(!adj.has(cur)) return false;
        let nextList = adj.get(cur);
        let visited = new Set();
        
        while(1) {
            let next = null;
            for(let key in nextList) {
                if(nextList[key] && !visited.has(key) && (!next || next.localeCompare(key) > 0)) {
                    next = key;
                }
            }
            if(!next) return false;
            visited.add(next);
            
            answer.push(next);
            nextList[next]--;
            if(dfs(next, depth + 1)) return true;
            nextList[next]++;
            answer.pop();
        }
    }
    
    dfs("ICN", 0);
    
    return answer;
}
```
## Review
일반적인 DFS 문제와 달라서 좀 당황했었다. 특히, 다시 갔던 곳에 가는 것이랑 막히는 경우가 생기는 것을 고려하지 못해 살짝 해맸었다. 좋은 문제인 것 같다.
