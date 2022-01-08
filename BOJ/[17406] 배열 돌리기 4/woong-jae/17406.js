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
    const N = +input[0][0];
    const M = +input[0][1];
    const K = +input[0][2];
    const matrix = [], spinOperations = [];

    for (let rowIndex = 1; rowIndex <= N; rowIndex++) {
        matrix.push(input[rowIndex].map(elem => + elem));
    }

    for (let spinOpIndex = N + 1; spinOpIndex <= N + K; spinOpIndex++) {
        spinOperations.push(input[spinOpIndex].map(elem => +elem));
    }

    const orderOption = [];
    orderOption.length = K;
    orderOption.fill(0);
    const possibleOrders = getPermutation(orderOption.map((_, index) => index));

    let res = Infinity;
    for (let orderIndex = 0; orderIndex < possibleOrders.length; orderIndex++) {
        const changedMatrix = JSON.parse(JSON.stringify(matrix));
        for (let k = 0; k < K; k++) {
            const leftTop = {
                r: spinOperations[possibleOrders[orderIndex][k]][0] - spinOperations[possibleOrders[orderIndex][k]][2] - 1,
                c: spinOperations[possibleOrders[orderIndex][k]][1] - spinOperations[possibleOrders[orderIndex][k]][2] - 1
            }
            const rightBottom = {
                r: spinOperations[possibleOrders[orderIndex][k]][0] + spinOperations[possibleOrders[orderIndex][k]][2] - 1,
                c: spinOperations[possibleOrders[orderIndex][k]][1] + spinOperations[possibleOrders[orderIndex][k]][2] - 1
            }
    
            // 회전 연산 수행
            while (leftTop.r !== rightBottom.r) {
                let prev = null;
                for (let colIndex = leftTop.c; colIndex <= rightBottom.c; colIndex++) {
                    let temp = changedMatrix[leftTop.r][colIndex];
                    changedMatrix[leftTop.r][colIndex] = prev;
                    prev = temp;
                }
                for (let rowIndex = leftTop.r + 1; rowIndex <= rightBottom.r; rowIndex++) {
                    let temp = changedMatrix[rowIndex][rightBottom.c];
                    changedMatrix[rowIndex][rightBottom.c] = prev;
                    prev = temp;
                }
                for (let colIndex = rightBottom.c - 1; colIndex >= leftTop.c; colIndex--) {
                    let temp = changedMatrix[rightBottom.r][colIndex];
                    changedMatrix[rightBottom.r][colIndex] = prev;
                    prev = temp;
                }
                for (let rowIndex = rightBottom.r - 1; rowIndex >= leftTop.r; rowIndex--) {
                    let temp = changedMatrix[rowIndex][leftTop.c];
                    changedMatrix[rowIndex][leftTop.c] = prev;
                    prev = temp;
                }
                leftTop.r++;
                leftTop.c++;
                rightBottom.r--;
                rightBottom.c--;
            }
        }

        let operationRes = Infinity;
        for (let rowIndex = 0; rowIndex < N; rowIndex++) {
            let rowSum = changedMatrix[rowIndex].reduce((p, c) => p + c);
            operationRes = Math.min(operationRes, rowSum);
        }

        res = Math.min(operationRes, res);
    }

    console.log(res);
}

function getPermutation(elements) {
    if (elements.length === 1) return [elements];

    const permutations = [];

    const smallPermutations = getPermutation(elements.slice(1));

    const firstElem = elements[0];

    for (let permIndex = 0; permIndex < smallPermutations.length; permIndex++) {
        const smallPermutation = smallPermutations[permIndex];
        for (let positionIndex = 0; positionIndex <= smallPermutation.length; positionIndex++) {
            const permPrefix = smallPermutation.slice(0, positionIndex);
            const permSuffix = smallPermutation.slice(positionIndex);
            permutations.push(permPrefix.concat([firstElem], permSuffix));
        }
    }

    return permutations;
}
