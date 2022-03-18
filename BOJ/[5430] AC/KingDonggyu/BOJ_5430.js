function solution(p, n, str) {
    let isReverse = false;
    const arr = str.slice(1, str.length-1).split(",");
    let start = 0, end = arr.length;

    for (let c of p) {
        if (c === "R") {
            isReverse = !isReverse;
            continue
        }
        if (n === "0" || start >= end) return "error";
        isReverse ? end -= 1 : start += 1;
    }

    const slicedArr = arr.slice(start, end);
    if (isReverse) slicedArr.reverse()

    return `[${slicedArr.join(",")}]`;
}

const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on("line", (line) => {
    input.push(line)
}).on("close", () => {
    for (var t = 1; t < +input[0] * 3 + 1; t += 3) {
        console.log(solution(input[t], input[t+1], input[t+2]));
    }
    process.exit();
})