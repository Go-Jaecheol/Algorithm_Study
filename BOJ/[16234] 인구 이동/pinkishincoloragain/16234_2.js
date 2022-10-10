const input = require("fs")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");
const [N, L, R] = input.shift().split(" ").map(Number);
const land = input.map(v => v.split(" ").map(Number));

const offset = [
	[0, 1],
	[1, 0],
	[0, -1],
	[-1, 0],
];
const dfs = (start, visited) => {
	const stack = [start];
	const union = [start];
	const [sx, sy] = start;
	visited[sx][sy] = true;
	let population = land[sx][sy];
	while (stack.length) {
		const [x, y] = stack.pop();
		for (let i = 0; i < 4; i++) {
			const nx = x + offset[i][0];
			const ny = y + offset[i][1];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
				const diff = Math.abs(land[x][y] - land[nx][ny]);
				if (diff >= L && diff <= R) {
					stack.push([nx, ny]);
					population += land[nx][ny];
					visited[nx][ny] = true;
					union.push([nx, ny]);
				}
			}
		}
	}
	union.forEach(
		([x, y]) => (land[x][y] = Math.floor(population / union.length))
	);
	return union.length;
};

let day = 0;
while (true) {
	const visited = [...Array(N)].map(() => Array(N).fill(false));
	let flag = false;
	for (let i = 0; i < N; i++) {
		for (let j = 0; j < N; j++) {
			if (!visited[i][j]) {
				const unionCount = dfs([i, j], visited);
				if (unionCount > 1) {
					flag = true;
				}
			}
		}
	}
	if (!flag) {
		break;
	}
	day++;
}

console.log(day);
