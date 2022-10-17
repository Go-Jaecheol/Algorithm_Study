const fs = require("fs");

let [a, b] = fs
	// .readFileSync("./input.txt")
	.readFileSync("./dev/stdin")
	.toString()
	.split("\n");

const dp = Array.from({ length: 1001 }, () => Array(1001).fill(0));

for (let i = 0; i < a.length; i++) {
	for (let j = 0; j < b.length; j++) {
		if (a[i] === b[j]) {
			dp[i + 1][j + 1] = dp[i][j] + 1;
		} else {
			dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
		}
	}
}

console.log(dp[a.length][b.length]);
