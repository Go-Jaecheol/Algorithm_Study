const input = require("fs")
	.readFileSync("./dev/stdin")
	// .readFileSync("./input.txt")
	.toString()
	.trim()
	.split("\n");

const [N, L, R] = input
	.shift()
	.split(" ")
	.map(x => +x);

const map = [];

input.forEach(line => {
	map.push(line.split(" ").map(x => +x));
});

const move = [
	[0, 1],
	[1, 0],
	[0, -1],
	[-1, 0],
];

const dfs = (start, visited) => {
	const stack = [start];
	const union = [start];
	let population = map[start[0]][start[1]];
	visited[start[0]][start[1]] = true;
	while (stack.length) {
		const [x, y] = stack.pop();
		for (let k = 0; k < 4; k++) {
			const nx = x + move[k][0];
			const ny = y + move[k][1];

			if (nx < 0 || ny < 0 || N - 1 < nx || N - 1 < ny) continue;
			if (visited[nx][ny]) continue;

			const diff = Math.abs(map[x][y] - map[nx][ny]);

			if (L <= diff && diff <= R) {
				stack.push([nx, ny]);
				union.push([nx, ny]);
				population += map[nx][ny];
				visited[nx][ny] = true;
			}
		}
	}
	union.forEach(
		([x, y]) => (map[x][y] = Math.floor(population / union.length))
	);
	return union.length;
};

let cnt = 0;

while (true) {
	const visited = Array.from({ length: N }, () => Array(N).fill(false));
	let flag = false;
	for (let i = 0; i < N; i++) {
		for (let j = 0; j < N; j++) {
			if (visited[i][j]) continue;

			const unionCnt = dfs([i, j], visited);
			if (unionCnt > 1) flag = true;
		}
	}
	if (!flag) break;
	cnt++;
}

console.log(cnt);
