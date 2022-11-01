const fs = require("fs");

let [a, b] = fs
	.readFileSync("./input.txt")
	// .readFileSync("./dev/stdin")
	.toString()
	.split("\n");

const LCS = Array.from({ length: a.length + 1 }, () => Array(b.length + 1).fill(0));

for (let i = 0; i < a.length; i += 1) {
	for (let j = 0; j < b.length; j += 1) {
		if (a[i] === b[j]) {
			LCS[i + 1][j + 1] = LCS[i][j] + 1;
		} else {
			LCS[i + 1][j + 1] = Math.max(LCS[i + 1][j], LCS[i][j + 1]);
		}
	}
}

console.log(LCS[a.length][b.length]);