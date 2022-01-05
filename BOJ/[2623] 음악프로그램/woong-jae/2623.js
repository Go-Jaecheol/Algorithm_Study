const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];
rl.on('line', function(line) {
    input.push(line.split(' '));
}).on('close', function() {
    solution();
    process.exit();
});

function solution() {
    let N = parseInt(input[0][0]);
    let M = parseInt(input[0][1]);
    
    // Set Up
    let adj_list = {};
    let degree = new Array(N + 1).fill(0);
    for (let i = 0; i <= N; i++) {
        adj_list[i] = [];
    }

    for (let i = 1; i <= M; i++) {
        for (let j = 1; j < input[i].length - 1; j++) {
            let a = parseInt(input[i][j]);
            let b = parseInt(input[i][j + 1]);
            adj_list[a].push(b);
            degree[b] = degree[b] + 1;
        }
    }

    // Logic
    let q = [] ;
    let res = [];
    for (let i = 1; i <= N; i++) {
        if (degree[i] === 0) q.push(i);
    }

    for (let i = 0; i < N; i++) {
        if (q.length === 0) {
            console.log(0);
            return;
        }
        let top = q.shift();
        res.push(top);
        if (adj_list[top]) {
            for (let j = 0; j < adj_list[top].length; j++) {
                let next = adj_list[top][j];
                if (--degree[next] == 0) q.push(next);
            }
        }
    }

    for (r of res) {
        console.log(r);
    }
}
