const readline = require('readline');
const input = [];

readline.createInterface({
    input: process.stdin,
    output: process.stdout
}).on('line', (line) => {
    input.push(line);
}).on('close', () => {
    solution();
    process.exit();
});

function solution() {
    const string = input[0];
    let res = 0, begin = 0;
    while(string.length - begin > res) {
        res = Math.max(res, getPartialMax(string.slice(begin++)));
    }
    console.log(res);
}

function getPartialMax(N) {
    const pi = new Array(N.length).fill(0);
    let res = 0;
    let begin = 1, matched = 0;
    while(begin + matched < N.length) {
        if(N[matched] === N[begin + matched]) {
            pi[begin + matched] = ++matched;
            res = Math.max(matched, res);
        }
        else {
            if(matched === 0) begin++;
            else {
                begin += matched - pi[matched - 1];
                matched = pi[matched - 1];
            }
        }
    }
    return res
}
