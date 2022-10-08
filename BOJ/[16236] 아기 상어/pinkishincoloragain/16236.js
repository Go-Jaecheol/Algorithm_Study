const input = require("fs")
	// .readFileSync("./dev/stdin")
	.readFileSync("./input2.txt")
	.toString()
	.trim()
	.split("\n");

const N = +input.shift();
const map = input.map(line => line.split(" ").map(v => +v));

let size = 2;
let curLoc;

for (let i = 0; i < N; i++) {
	for (let j = 0; j < N; j++) {
		if (map[i][j] === 9) {
			curLoc = [i, j];
			break;
		}
	}
}
const moveType = [
	[0, 1],
	[-1, 0],
	[0, -1],
	[1, 0],
];

const findNext = (curX, curY) => {
	const visited = Array.from({ length: N }, () => Array(N).fill(false));
	const q = [[curX, curY, 0]];

	while (q.length != 0) {
		const [x, y, mv] = q.shift();
		visited[x][y] = true;

		if (map[x][y] <= size && map[x][y] !== 0) {
			return [x, y, mv];
		}

		for (let i = 0; i < 4; i++) {
			const nx = x + moveType[i][0];
			const ny = y + moveType[i][1];
			if (
				0 <= nx &&
				nx <= N - 1 &&
				0 <= ny &&
				ny <= N - 1 &&
				visited[nx][ny] === false &&
				map[nx][ny] !== 0
			) {
				q.push([nx, ny, mv + 1]);
			}
		}
	}

	return [-1, -1, 0];
};

let eatCount = 0;
path = [];

while (true) {
	const [targetX, targetY, moved] = findNext(curLoc[0], curLoc[1]);
	if (moved === 0) break;

	console.log([targetX, targetY, moved]);

	if (eatCount + 1 === size) {
		size++;
		eatCount = 0;
	} else {
		eatCount++;
	}

	map[targetX][targetY] = 0;
	curLoc = [targetX, targetY];
}
