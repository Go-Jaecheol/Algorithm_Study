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
    let [S, T] = input.map(elem => elem.split(""));
    
    let reversed = false;
    while(T.length !== S.length) {
        let removed;
        if(reversed) removed = T.shift();
        else removed = T.pop();
        if(removed === "B") reversed = !reversed;
    }
    let reduced = reversed ? T.reverse().join("") : T.join("");
    console.log(reduced === S.join("") ? "1" : "0");
}
