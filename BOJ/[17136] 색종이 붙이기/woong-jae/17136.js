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
    let paper = [];
    input.forEach(line => paper.push(line.map(elem => +elem)));

    let res = getMinColoredPapers({1: 5, 2: 5, 3: 5, 4: 5, 5: 5}, paper);
    
    console.log(res === Infinity ? -1 : res);
}

function getMinColoredPapers(coloredPapers, paper) {
    let res = Infinity;

    let found = false;
    outer: for (let rowIndex = 0; rowIndex < 10; rowIndex++) {
        for (let colIndex = 0; colIndex < 10; colIndex++) {
            const element = paper[rowIndex][colIndex];
            if (element) {
                found = {r: rowIndex, c: colIndex};
                break outer;
            }
        }
    }
    if (!found) return 0;

    for (let coloredPaperSize = 1; coloredPaperSize <= 5; coloredPaperSize++) {
        if (possibleToUse(paper, coloredPapers, coloredPaperSize, found)) {
            coloredPapers[coloredPaperSize]--;
            updatePaper(paper, coloredPaperSize, found, 0);
            res = Math.min(res, getMinColoredPapers(coloredPapers, paper) + 1);
            updatePaper(paper, coloredPaperSize, found, 1);
            coloredPapers[coloredPaperSize]++;
        }
    }

    return res;
}

function possibleToUse(paper, coloredPapers, coloredPaperSize, curIndex) {
    if (coloredPapers[coloredPaperSize] === 0) return false;
    if (curIndex.r + coloredPaperSize > 10 || curIndex.c + coloredPaperSize > 10) return false;
    for (let rowIndex = curIndex.r; rowIndex < curIndex.r + coloredPaperSize; rowIndex++) {
        for (let colIndex = curIndex.c; colIndex < curIndex.c + coloredPaperSize; colIndex++) {
            const element = paper[rowIndex][colIndex];
            if (!element) return false;
        }
    }
    return true;
}

function updatePaper(paper, coloredPaperSize, curIndex, flag) {
    for (let rowIndex = curIndex.r; rowIndex < curIndex.r + coloredPaperSize; rowIndex++) {
        for (let colIndex = curIndex.c; colIndex < curIndex.c + coloredPaperSize; colIndex++) {
            paper[rowIndex][colIndex] = flag;
        }
    }
}
