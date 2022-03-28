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
    let string = input[0];
    let index = 0;

    while(1) {
        if(index >= string.length) {
            console.log("SUBMARINE");
            return;
        }
        if(string.substring(index, index + 2) === "01") {
            index += 2;
        }
        else if(string.substring(index, index + 2) === "10") {
            index += 2;
            let start = index;
            while(index < string.length && string[index] === "0") index++;
            if(start === index) break;
            start = index;
            while(index < string.length && string[index] === "1") index++;
            if(start === index) break;
            if(index - start > 1 && string.substring(index, index + 2) === "00") index--;
        }
        else break;
    }
    console.log("NOISE");
}
