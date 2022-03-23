function solution(testCase) {
    let idx = 0;
  
    while (idx < testCase.length) {
        // 1로 시작할 경우
        if (testCase[idx] === "1") {
            // 연속된 0 탐색
            let temp = idx;
            while (testCase[idx + 1] === "0") idx++;
            if (idx - temp < 2) return "NO";
            
            // 연속된 1 탐색
            temp = idx;
            while (testCase[idx + 1] === "1") idx++;
            if (temp === idx) return "NO";

            // 연속된 1이 둘 이상일 시 연속된 0 확인
            if (idx - temp > 1) {
                temp = idx;
                while (testCase[idx + 1] === "0") idx++;
                idx = (idx - temp > 1) ? temp : temp + 1;
                continue;
            } 

            idx++;
            continue;
        }

        // 0으로 시작할 경우
        if (testCase[++idx] !== "1") return "NO";
        idx++;
    }

    return "YES";
}

const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

const input = [];

rl.on("line", (line) => {
    input.push(line);
    if (input.length === +input[0] + 1) rl.close();
}).on("close", () => {
    for (let x = 1; x < input.length; x++) {
        console.log(solution(input[x]));
    }
    process.exit();
})