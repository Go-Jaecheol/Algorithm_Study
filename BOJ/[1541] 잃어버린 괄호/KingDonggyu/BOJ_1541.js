function solution(expression) {
    let x = 0;
    let answer = 0;
    let isMinus = false;

    while (x < expression.length) {
        if (expression[x] === "-") {
            isMinus = true;
            x += 1;
            continue;
        }

        let number = expression[x];   
        while (x < expression.length-1 && isFinite(expression[x+1])) {
            number += expression[++x];
        }
   
        answer += isMinus? -(+number) : +number;
        x += 1;
    }

    console.log(answer);
}


const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input;

rl.on("line", (line) => {
    input = line;
    rl.close();
}).on("close", () => {
    solution(input);
    process.exit();
})