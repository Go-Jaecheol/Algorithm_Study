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
