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
