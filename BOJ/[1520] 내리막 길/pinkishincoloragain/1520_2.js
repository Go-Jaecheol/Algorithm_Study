const input = require("fs")
	// .readFileSync("./dev/stdin")
	.readFileSync("./input.txt")
	.toString()
	.trim()
	.split("\n");
const [M, N] = input.shift().split(" ").map(Number);
const map = input.map(v => v.split(" ").map(Number));
const offset = [
	[0, 1],
	[1, 0],
	[0, -1],
	[-1, 0],
];
const dp = [...Array(M)].map(() => Array(N).fill(-1));
dp[M - 1][N - 1] = 1;

const dfs = (x, y) => {
	if (dp[x][y] !== -1) {
		return dp[x][y];
	}
	let count = 0;

	for (let i = 0; i < 4; i++) {
		const nx = x + offset[i][0];
		const ny = y + offset[i][1];
		if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[x][y] > map[nx][ny]) {
			count += dfs(nx, ny);
		}
	}

	dp[x][y] = count;
	return count;
};

console.log(dfs(0, 0));
