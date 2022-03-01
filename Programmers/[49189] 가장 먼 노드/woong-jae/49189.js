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
