const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];
let inputIndex = 1;
rl.on('line', function(line) {
    input.push(line.split(' '));
}).on('close', function() {
    let testcase = Number(input[0]);
    for (let t = 0; t < testcase; t++) {
        let res = solution();
        console.log(res);
    }
    process.exit();
});

function solution() {
    let N = Number(input[inputIndex++]);
    let prevRanking = input[inputIndex++].map(i => Number(i));
    let m = Number(input[inputIndex++]);
    let degree = {}, adjList = {};
    
    for (let i = 0; i < N; i++) {
        degree[prevRanking[i]] = i;
        adjList[prevRanking[i]] = [];
        for (let next = i + 1; next < N; next++) {
            adjList[prevRanking[i]].push(prevRanking[next]);
        }
    }

    for (let i = 1; i <= m; i++) {
        let a = +input[inputIndex][0];
        let b = +input[inputIndex++][1];
        if (adjList[b].find(element => element === a)) {
            degree[a]--;
            degree[b]++;
            adjList[a].push(b);
            adjList[b] = adjList[b].filter(next => next !== a);
        } else {
            degree[b]--;
            degree[a]++;
            adjList[b].push(a);
            adjList[a] = adjList[a].filter(next => next !== b);
        }
    }

    let q = [], res = [];
    for (let i = 1; i <= N; i++) {
        if (degree[i] === 0) q.push(i);
    }
    for (let i = 0; i < N; i++) {
        if (q.length === 0) return "IMPOSSIBLE";
        if (q.length > 1) return "?";
        let top = q.shift();
        res.push(top);
        for (let n = 0; n < adjList[top].length; n++) {
            let next = adjList[top][n];
            if (--degree[next] === 0) q.push(next);
        }
    }

    return res.join(' ');
}
