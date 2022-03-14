function solution(n, results) {
    const visited = new Array(n+1).fill(false)
    const graph = new Array(2).fill(null).map(_ => 
        new Array(n+1).fill(null).map(_ => []))

    results.forEach(node => {
        graph[0][node[0]].push(node[1])
        graph[1][node[1]].push(node[0])
    });

    const queue = []
    let count = answer = 0
    for (let i=1; i<n+1; i++) {
        for (let j=0; j<2; j++) {
            queue.push(i)
            while (queue.length > 0) {
                const next = queue.shift()
                graph[j][next].forEach(node => {
                    if (!visited[node]) {
                        queue.push(node)
                        visited[node] = true
                    }
                })
                count += 1
            }
            visited.fill(false)
        }
        if (count == n+1) answer += 1
        count = 0
    }

    return answer
}