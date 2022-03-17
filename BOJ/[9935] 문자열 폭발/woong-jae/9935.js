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
    const [origin, target] = input.map(elem => elem.split(""));
    const stack = [];

    origin.forEach(char => {
        stack.push(char);
        while(1) {
            let explode = true;
            for(let targetIndex = 0; targetIndex < target.length; targetIndex++) {
                let compareIndex = stack.length - target.length + targetIndex;
                if(compareIndex < 0 || stack[compareIndex] !== target[targetIndex]) {
                    explode = false;
                    break;
                }
            }
            if(explode) stack.splice(stack.length - target.length, target.length);
            else break;
        }
    });

    console.log(stack.length ? stack.join("") : "FRULA");
}
