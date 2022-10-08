const input = require("fs")
	// .readFileSync("./dev/stdin")
	.readFileSync("./input2.txt")
	.toString()
	.trim()
	.split("\n");

const N = +input.shift();
const map = input.map(line => line.split(" ").map(v => +v));

let size = 2;
let totalMove = 0;
let curLoc;

for (let i = 0; i < N; i++) {
	for (let j = 0; j < N; j++) {
		if (map[i][j] === 9) {
			curLoc = [i, j];
			break;
		}
	}
}
const mv = [
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
		if (map[x][y] <= size && map[x][y] !== 0) return [x, y, mv];

		visited[x][y] = true;

		for (let i = 0; i < 4; i++) {
			const nx = x + mv[i][0];
			const ny = y + mv[i][1];

			console.log(x, y, nx, ny);

			if (
				0 > nx ||
				N - 1 < nx ||
				0 > ny ||
				N - 1 < ny ||
				visited[nx][ny] ||
				map[nx][ny] > size
			)
				continue;
			else q.push([nx, ny, mv + 1]);
		}
	}

	return [, 0];
};

let eatCount = 0;

while (true) {
	console.log(curLoc);
	const [targetX, targetY, moved] = findNext(curLoc[0], curLoc[1]);
	if (moved === 0) break;

	totalMove += moved;

	if (eatCount + 1 === size) {
		size++;
		eatCount = 0;
	} else {
		eatCount++;
	}

	console.log(targetX, targetY);
	map[targetX][targetY] = 0;
	curLoc = [targetX, targetY];
}

console.log(totalMove);
