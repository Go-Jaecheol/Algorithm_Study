const readline = require('readline');
const { brotliCompress } = require('zlib');
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
    const [N, M, D] = input.shift().map(elem => +elem);
    const board = [];
    board.length = N;
    for (let rowIndex = 0; rowIndex < N; rowIndex++) {
        board[rowIndex] = input.shift().map(elem => +elem);
    }

    let archerOption = [];
    archerOption.length = M;
    archerOption.fill(0);

    let res = 0;
    let archerPositions = getCombination(archerOption.map((_, i) => i), 3);
    for (let positionIndex = 0; positionIndex < archerPositions.length; positionIndex++) {
        let killedEnemy = getKilledEnemy({N, M, D}, board, archerPositions[positionIndex]);
        res = Math.max(res, killedEnemy);
    }
    console.log(res);
}

function getKilledEnemy(options, initialBoard, archerPosition) {
    const {N, M, D} = options;
    let board = [];
    for (let rowIndex = 0; rowIndex < N; rowIndex++) { // Create new board to simulate
        board[rowIndex] = [];
        for (let colIndex = 0; colIndex < M; colIndex++) {
            let element = initialBoard[rowIndex][colIndex];
            board[rowIndex][colIndex] = element;
        }
    }

    let res = 0;
    let enemyExists = true;
    while(enemyExists) {
        let chosenEnemy = [];
        for (let archerIndex = 0; archerIndex < archerPosition.length; archerIndex++) {
            let chosenEnemyInfo = {r: null, c: null, d: null};
            for (let rowIndex = N - 1; rowIndex >= 0; rowIndex--) { 
                for (let colIndex = 0; colIndex < M; colIndex++) {
                    if (board[rowIndex][colIndex] === 1) {
                        let distance = Math.abs(N - rowIndex) + Math.abs(archerPosition[archerIndex] - colIndex);
                        if (D >= distance) {
                            if (chosenEnemyInfo.d === null) {
                                chosenEnemyInfo = {r: rowIndex, c: colIndex, d: distance};
                            } else if (chosenEnemyInfo.d > distance) {
                                chosenEnemyInfo = {r: rowIndex, c: colIndex, d: distance};
                            } else if (chosenEnemyInfo.d == distance && chosenEnemyInfo.c > colIndex) {
                                chosenEnemyInfo = {r: rowIndex, c: colIndex, d: distance};
                            }
                        }
                    }
                }
            }
            if (chosenEnemyInfo.d !== null) chosenEnemy.push(chosenEnemyInfo);
        }
        for (let enemyIndex = 0; enemyIndex < chosenEnemy.length; enemyIndex++) {
            let {r, c} = chosenEnemy[enemyIndex];
            if (board[r][c] === 1) {
                board[r][c] = 0;
                res++;
            }
        }
        
        enemyExists = false;
        for (let rowIndex = N - 1; rowIndex >= 0; rowIndex--) { 
            for (let colIndex = 0; colIndex < M; colIndex++) {
                if (board[rowIndex][colIndex] === 1) {
                    board[rowIndex][colIndex] = 0;
                    if (rowIndex + 1 < N) {
                        board[rowIndex + 1][colIndex] = 1;
                        enemyExists = true;
                    }
                }
            }
        }
    }

    return res;
}

function getCombination(elements, length) {
    if (length === 1) return elements.map(elem => [elem]);

    const combinations = [];

    elements.forEach((element, elementIndex) => {
        const smallerCombinations = getCombination(elements.slice(elementIndex + 1), length - 1);

        smallerCombinations.forEach(smallerCombination => combinations.push([element].concat(smallerCombination)));
    });

    return combinations;
}
