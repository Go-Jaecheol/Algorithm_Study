const input = require("fs")
	.readFileSync("./dev/stdin")
	// .readFileSync("./input.txt")
	.toString()
	.trim()
	.split("\n");

const N = +input.shift();

const pic = input.map(line => [...line]);
let visited = Array.from({ length: N }, () => Array(N).fill(0));
const answer = [];

const bfs = (x, y, color) => {
	const move = [
		[0, 1],
		[1, 0],
		[0, -1],
		[-1, 0],
	];

	const queue = [[x, y]];
	visited[x][y] = 1;

	while (queue.length) {
		const [x, y] = queue.shift();

		for (let i = 0; i < 4; i++) {
			const nx = x + move[i][0];
			const ny = y + move[i][1];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (visited[nx][ny] || pic[nx][ny] !== color) continue;

			visited[nx][ny] = 1;
			queue.push([nx, ny]);
		}
	}
};

let cnt = 0;

for (let i = 0; i < N; i++) {
	for (let j = 0; j < N; j++) {
		if (!visited[i][j]) {
			bfs(i, j, pic[i][j]);
			cnt++;
		}
	}
}

answer.push(cnt);
cnt = 0;
visited = Array.from({ length: N }, () => Array(N).fill(0));

for (let i = 0; i < N; i++) {
	for (let j = 0; j < N; j++) {
		if (pic[i][j] === "G") pic[i][j] = "R";
	}
}

for (let i = 0; i < N; i++) {
	for (let j = 0; j < N; j++) {
		if (!visited[i][j]) {
			bfs(i, j, pic[i][j]);
			cnt++;
		}
	}
}

answer.push(cnt);

console.log(answer.join(" "));
