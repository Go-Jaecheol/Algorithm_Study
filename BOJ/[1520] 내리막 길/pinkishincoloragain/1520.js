const input = require("fs")
	.readFileSync("./dev/stdin")
	// .readFileSync("./input.txt")
	.toString()
	.trim()
	.split("\n");

const [M, N] = input
	.shift()
	.split(" ")
	.map(x => +x);

const offset = [
	[0, 1],
	[1, 0],
	[0, -1],
	[-1, 0],
];

const map = input.map(line => line.split(" ").map(x => +x));

const dp = Array.from({ length: M }, () => Array(N).fill(-1));
dp[M - 1][N - 1] = 1;

const find = (x, y) => {
	if (dp[x][y] !== -1) {
		return dp[x][y];
	}
	let count = 0;

	for (let i = 0; i < 4; i++) {
		const nx = x + offset[i][0];
		const ny = y + offset[i][1];
		if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[x][y] > map[nx][ny]) {
			count += find(nx, ny);
		}
	}

	dp[x][y] = count;
	return count;
};

find(0, 0);
console.log(dp[0][0]);
