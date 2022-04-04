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
    const stack = [];

    for(let char of string) {
        stack.push(char);
        if(stack.length >= 4) {
            if(stack.slice(-4).join("") === "PPAP") {
                stack.pop();
                stack.pop();
                stack.pop();
            }
        }
    }

    console.log(stack.length === 1 && stack[0] === "P" ? "PPAP" : "NP");
}
