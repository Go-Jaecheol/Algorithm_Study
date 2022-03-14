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
    let answer = 0;
    let equation = input[0].split(""), index = 0, cur = "", isPlus = true;

    while(equation.length > index && isPlus) {
        const char = equation[index++];
        if(+char >= 0) cur += char;
        else {
            answer += +cur;
            cur = "";
            if(char === "-") isPlus = false;
        }
    }
    while(equation.length > index) {
        const char = equation[index++];
        if(+char >= 0) cur += char;
        else {
            answer -= +cur;
            cur = "";
        }
    }
    answer = isPlus ? answer + +cur : answer - +cur;

    console.log(answer);
}
