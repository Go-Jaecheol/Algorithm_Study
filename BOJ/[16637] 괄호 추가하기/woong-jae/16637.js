const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function(line) {
    input.push(line.split(' '));
}).on('close', function() {
    solution();
    process.exit();
});

function solution() {
    const N = +input.shift();
    const formula = input.shift()[0];

    const allChoices = getAllChoices(formula, 1);

    let result = -Infinity;
    for (let choiceIndex = 0; choiceIndex < allChoices.length; choiceIndex++) {
        const choice = allChoices[choiceIndex];
        result = Math.max(result, calculate(choice, formula));
    }
    console.log(result);
}

function getAllChoices(pickOption, currentIndex) {
    if (currentIndex >= pickOption.length - 1) return [[]];
    
    const allChoices = [];
    // Pick current index
    const pickChoices = getAllChoices(pickOption, currentIndex + 4);
    pickChoices.forEach(choice => allChoices.push([currentIndex].concat(choice)));
    // Not pick current index
    const notPickChoices = getAllChoices(pickOption, currentIndex + 2);
    notPickChoices.forEach(choice => allChoices.push(choice));

    return allChoices;
}

function calculate(choice, formulaString) {
    const picked = {};
    const formula = formulaString.split('');
    
    choice.forEach(pick => picked[pick] = true);

    const stack = [];
    for (let formulaIndex = 0; formulaIndex < formula.length; formulaIndex++) {
        const element = formula[formulaIndex];
        if ("+-*".includes(element)) {
            if (picked[formulaIndex]) {
                const partialCalc = operation(stack.pop(), +formula[++formulaIndex], element);
                stack.push(partialCalc);
            } else {
                stack.push(element);    
            }
        } else {
            stack.push(+element);
        }
    }
    
    let res = stack.shift();
    while (stack.length) {
        const operator = stack.shift();
        const b = stack.shift();

        res = operation(res, b, operator);
    }

    return res;
}

function operation(a, b, operator) {
    switch (operator) {
        case "+":
            return a + b;
            break;
        case "-":
            return a - b;
        case "*":
            return a * b;
        default:
            return 0;
    }
}
