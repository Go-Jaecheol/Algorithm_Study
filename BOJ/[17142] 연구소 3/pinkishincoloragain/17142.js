const input = require("fs")
	// .readFileSync("./dev/stdin")
	.readFileSync("./input.txt")
	.toString()
	.trim()
	.split("\n");

const [N, M] = input.shift().split(" ").map(Number);

const map = [];
input.forEach(line => map.push(line.split(" ").map(Number)));

const cand = [];
for (let i = 0; i < N; i++) {
	for (let j = 0; j < N; j++) {
		if (map[i][j] === 2) cand.push([i, j]);
	}
}

const move = [
	[0, 1],
	[0, -1],
	[1, 0],
	[-1, 0],
];

const getCombinations = (array, selectNumber) => {
	const results = [];
	if (selectNumber === 1) return array.map(element => [element]);

	array.forEach((fixed, index, origin) => {
		const rest = origin.slice(index + 1);
		const combinations = getCombinations(rest, selectNumber - 1);
		const attached = combinations.map(combination => [fixed, ...combination]);
		results.push(...attached);
	});
	return results;
};

const bfs = (start, targets) => {
	const visited = Array.from({ length: N }, () => Array(N).fill(10000));

	const [sx, sy] = start;
	const Q = [[sx, sy, 0]];

	while (Q.length) {
		const [x, y, dist] = Q.shift();
		for (let k = 0; k < 4; k++) {
			const nx = x + move[k][0];
			const ny = y + move[k][1];

			if (visited[i][j] !== 10000) continue;
			if (nx < 0 || ny < 0 || N - 1 < nx || N - 1 < ny) continue;

			visited[nx][ny] = dist + 1;
			Q.push([nx, ny, dist + 1]);
		}
	}

	return targets.map((x, y) => map[x][y]);
};

const activateCombinations = getCombinations(cand, M);
const minTimeArr = [];

activateCombinations.forEach(activeLocs => {
	const notActiveLocs = candid.filter(x => !activeLocs.includes(x));
	const reachingTimeArr = [];
	activeLocs.forEach(loc => {
		const reachingTime = bfs(loc, notActiveLocs);
	});

	reachingTimeArr.push(reachingTimeArr);
});
