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
    let [S, P] = input;
    let pi = getPartialMatch(P);
    let begin = 0, matched = 0;
    while(begin <= S.length - P.length) {
        if(matched < P.length && S[begin + matched] === P[matched]) {
            if(++matched === P.length) {
                console.log(1);
                return;
            }
        }
        else {
            if(matched === 0) begin++;
            else {
                begin += matched - pi[matched - 1];
                matched = pi[matched - 1];
            }
        }
    }
    console.log(0);
}

function getPartialMatch(N) {
    const pi = new Array(N.length).fill(0);
    let begin = 1, matched = 0;
    while(begin + matched < N.length) {
        if(N[begin + matched] === N[matched]) {
            matched++;
            pi[begin + matched - 1] = matched;
        } 
        else {
            if(matched === 0) begin++;
            else {
               begin += matched - pi[matched - 1];
               matched = pi[matched - 1]; 
            }
        }
    }
    return pi;
}
