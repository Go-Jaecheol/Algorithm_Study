const readline = require('readline');
const input = [];
let inputIndex = 1;

readline.createInterface({
    input: process.stdin,
    output: process.stdout
}).on('line', (line) => {
    input.push(line);
}).on('close', () => {
    for(let testCase = 0; testCase < input[0]; testCase++) {
        solution();
    }
    process.exit();
});

function solution() {
    let p = input[inputIndex++];
    let n = input[inputIndex++];
    let arr = input[inputIndex].slice(1, input[inputIndex++].length - 1).split(",");
    if(!+n) arr = [];

    let reversed = false;
    for(funcIndex = 0; funcIndex < p.length; funcIndex++) {
        const func = p[funcIndex];
        if(func === "R") reversed = !reversed;
        else if(func === "D") {
            if(arr.length === 0) {
                console.log("error");
                return;
            }
            if(reversed) arr.pop();
            else arr.splice(0, 1);
        }
    }

    if(reversed) arr.reverse();
    console.log("[" + arr.join(",") + "]");
}
