function solution(str, explosion) {
    const stack = [];
    const expSize = explosion.length;

    for (let i in str) {
        stack.push(str[i]);
        if (str[i] != explosion[expSize - 1]) {
            continue;
        }
        if (stack.slice(-expSize).join("") != explosion) {
            continue;
        }
        for (let i = 0; i < explosion.length; i++) {
            stack.pop()
        }
    }
    
    if (stack.length == 0) return "FRULA"
    return stack.join("")
}

const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const input = [];

rl.on("line", (line) => {
    input.push(line);
    if (input.length == 2) rl.close();
}).on("close", () => {
    console.log(solution(input[0], input[1])); 
    process.exit();
})