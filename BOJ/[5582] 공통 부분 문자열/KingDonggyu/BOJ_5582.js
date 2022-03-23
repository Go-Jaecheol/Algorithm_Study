function solution(str1, str2) {
    const rowSize = str1.length + 1;
    const colSize = str2.length + 1;
    const dp = new Array(rowSize).fill(null).map(
        _ => new Array(colSize).fill(0));

    let answer = 0;

    for (let x = 1; x < rowSize; x++) {
        for (let y = 1; y < colSize; y++) {
            if (str1[x - 1] !== str2[y - 1]) continue;
            dp[x][y] = dp[x -1][y - 1] + 1;
            answer = Math.max(answer, dp[x][y]);
        }
    }
    return answer;
}

const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

const input = [];

rl.on("line", (line) => {
    input.push(line);
    if (input.length === 2) rl.close();
}).on("close", () => {
    console.log(solution(input[0], input[1]));
    process.exit();
})