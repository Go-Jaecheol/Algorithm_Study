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
    const [long, short] = input[0].length > input[1].length ? input: [input[1], input[0]];

    let longest = 0;
    const cache = new Array(4001).fill(0).map(() => new Array(4001).fill(0));
    for(let start = 0; start < short.length; start++) {
        if(short.length - start <= longest) break;
        for(let i = 0; i < long.length; i++) {
            if(short[start] === long[i] && !cache[start][i]) {
                let length = 1, offset = 1; 
                cache[start][i] = length;
                while(start + offset < short.length && i + offset < long.length && short[start + offset] === long[i + offset]) {
                    cache[start + offset][i + offset++] = ++length;
                }
                longest = Math.max(longest, length);
            }
        }
    }
    console.log(longest);
}
