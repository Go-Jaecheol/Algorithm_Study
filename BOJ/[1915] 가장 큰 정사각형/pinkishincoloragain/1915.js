// input
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs")
	.readFileSync(inputFile)
	.toString()
	.trim()
	.split("\n");

const [m, n] = input
	.shift()
	.split(" ")
	.map(x => +x);

const dp = Array.from({ length: m }, () => Array(n).fill(0));
const square = input.map(line => line.split("").map(x => +x));

for (let i = 0; i < m; i++) {
	for (let j = 0; j < n; j++) {
		if (square[i][j] === 1) {
			if (i === 0 || j === 0) dp[i][j] = 1;
			else
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
		}
	}
}

console.log(Math.max(...dp.flat()) ** 2);
