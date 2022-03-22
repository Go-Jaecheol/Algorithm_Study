const readline = require('readline');
const input = [];

readline.createInterface({
    input: process.stdin,
    output: process.stdout
}).on('line', (line) => {
    input.push(line);
}).on('close', () => {
    for(let t = 1; t < input.length; t++) {
        solution(input[t]);
    }
    process.exit();
});

function solution(signal) {
    let index = 0;
    while(1) {
        if(index >= signal.length) {
            console.log("YES");
            return;
        }
        if(signal[index++] === "1") {
            if(signal[index++] !== "0")  break;
            let start = index;
            while(signal[index] === "0") index++;
            if(start === index) break;
            start = index;
            while(signal[index] === "1") index++;
            if(start === index) break;
            if(signal[index + 1] === "0" && index - start > 1) index--;
        }
        else {
            if(signal[index++] !== "1") break;
        }
    }
    console.log("NO");
}
