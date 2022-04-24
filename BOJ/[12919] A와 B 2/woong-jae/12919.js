const readline = require('readline');
const input = [];

readline.createInterface({
    input: process.stdin,
    output: process.stdout
}).on('line', (line) => {
    input.push(line);
}).on('close', () => {
    solution(input);
    process.exit();
});

function solution([S, T]) {
    const count = { A: 0, B: 0 };
    T.split("").forEach(c => count[c]++);
    S.split("").forEach(c => count[c]--);
    
    function isPossible(string, swapped) {
        if(string.length === S.length) {
            return (swapped ? string.split("").reverse().join("") : string) === S;
        }
        const end = swapped ? 0 : string.length - 1, front = swapped ? string.length - 1 : 0;
        if(count.A > 0 && string[end] === "A") {
            count.A--;
            if(isPossible(swapped ? string.slice(1) : string.slice(0, string.length - 1), swapped)) return true;
            count.A++;
        }
        if(count.B > 0 && string[front] === "B") {
            count.B--;
            if(isPossible(swapped ? string.slice(0, string.length - 1) : string.slice(1), !swapped)) return true;
            count.B++;
        }

        return false;
    }
    
    console.log(isPossible(T, false) ? 1 : 0);
}
