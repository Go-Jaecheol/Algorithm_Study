function solution(n, edge) {
    const graph = new Array(n+1).fill(null).map(_ => [])
    const visited = new Array(n+1).fill(false) 
    
    edge.forEach(node => {
        graph[node[0]].push(node[1])
        graph[node[1]].push(node[0])
    });

    const queue = [[1, 0]]
    const answer = [[1]]
    visited[1] = true

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

    return answer[answer.length-1].length
}