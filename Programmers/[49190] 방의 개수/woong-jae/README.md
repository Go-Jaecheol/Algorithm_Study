# [49190] 방의 개수
## Algorithm
- Graph
## Logic
새로운 방은 간선과 간선이 만날 때 생긴다. 간선과 간선이 만나는 경우는 두 가지다.
- 새로운 간선으로 방문한 노드로 돌아왔을 때
- 새로운 간선과 간선이 교차할 때(X 형태)

각각 경우가 발생하면 `answer++` 해줘서 총 방의 개수를 센다.

```js
function solution(arrows) {
    var answer = 0;
    
    const dr = [-1, -1, 0, 1, 1, 1, 0, -1];
    const dc = [0, 1, 1, 1, 0, -1, -1, -1];
    
    let cur = { r: 0, c: 0 };
    let adj_list = new Map();
    adj_list.set("0,0", new Set());
    
    arrows.forEach(direction => {
        let current = String(cur.r) + "," + cur.c;
        let next = String(cur.r + dr[direction]) + "," + (cur.c + dc[direction]);
        let diag1 = String(cur.r + dr[direction]) + "," + cur.c;
        let diag2 = String(cur.r) + "," + (cur.c + dc[direction]);
        
        if(!adj_list.get(current).has(next)) {
            if(adj_list.has(next)) answer++;
            if(direction % 2 && adj_list.has(diag1) && adj_list.get(diag1).has(diag2)) answer++;   
        }
        
        if(!adj_list.has(next)) adj_list.set(next, new Set());
        adj_list.get(current).add(next);
        adj_list.get(next).add(current);
        cur.r += dr[direction];
        cur.c += dc[direction];
    });
    
    return answer;
}
```
## Review
아이디어를 쉽게 떠올릴 수 있었던 문제. 구현만 좀 빠르게 할 수 있도록 연습하자.
