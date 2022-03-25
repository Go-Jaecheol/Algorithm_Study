function solution(S, T) {
    let start = 0;
    let end = T.length;
    let isReversed = false;

    while (S.length < end - start) {
        if (T[isReversed ? start : end - 1] === "A") {
            isReversed ? start += 1 : end -= 1;
            continue;
        }
        isReversed ? start += 1 : end -= 1;
        isReversed = !isReversed;
    }
    
    T = T.slice(start, end);
    if (isReversed) T = T.split("").reverse().join("");

    if (S === T) return 1;
    return 0;
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
});