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
    const [R, C] = input[0].split(" ").map(e => +e);
    const table = [];
    for(let i = 1; i < input.length; i++) {
        table.push(input[i].split(""));
    }

    const colStr = new Array(C).fill("");
    let sameCount = 0;
    while(table.length) {
        const curRow = table.pop();
        const strSet = new Set();

        curRow.forEach((char, i) => {
            const str = char + colStr[i];
            strSet.add(str);
            colStr[i] = str;
        });

        if(strSet.size === C) break;
        sameCount++;
    }

    console.log(R - sameCount - 1);
}
