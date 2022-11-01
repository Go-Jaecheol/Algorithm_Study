const fs = require("fs");

let [a, b] = fs
    // .readFileSync("./input.txt")
    .readFileSync("./dev/stdin")
    .toString()
    .split("\n");

let LCS = Array.from({ length: a.length + 1 }, () => Array(b.length + 1).fill(""));

const getMaxStr = (arr1, arr2) => arr1.length > arr2.length ? arr1 : arr2;

for (let i = 0; i < a.length; i += 1) {
    for (let j = 0; j < b.length; j += 1) {
        if (a[i] === b[j]) {
            LCS[i + 1][j + 1] = LCS[i][j] + a[i];
        } else {
            LCS[i + 1][j + 1] = getMaxStr(LCS[i][j + 1], LCS[i + 1][j]);
        }
    }
}

const res = LCS[a.length][b.length];

console.log(res.length);
console.log(res);
