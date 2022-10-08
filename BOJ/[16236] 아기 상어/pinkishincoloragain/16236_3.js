const input = require("fs")
	.readFileSync("./dev/stdin")
	// .readFileSync("./input2.txt")
	.toString()
	.trim()
	.split("\n");

const N = +input.shift();

const map = input.map(line => line.split(" ").map(v => +v));
const dy = [-1, 0, 0, 1];
const dx = [0, -1, 1, 0];

const eats = new Array(7).fill(0);

function bfs() {
	// 시작 위치 찾기.
	let cur = [];
	let lv = 2;
	let totalMove = 0;

	for (let i = 0; i < N; i++) {
		for (let j = 0; j < N; j++) {
			if (map[i][j] === 9) {
				cur = [i, j];
				map[i][j] = 0;
			}
		}
	}

	while (true) {
		const q = [[...cur, 0]];
		const baitQ = [];
		const visited = Array.from({ length: N }, () => new Array(N).fill(false));

		let move = 0;

		while (q.length) {
			const [y, x, moved] = q.shift();

			if (map[y][x] < lv && map[y][x] !== 0) {
				baitQ.push([y, x, moved]);
			}

			for (let i = 0; i < 4; i++) {
				const ny = y + dy[i];
				const nx = x + dx[i];

				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				if (map[ny][nx] > lv || visited[ny][nx]) continue;

				q.push([ny, nx, moved + 1]);
				visited[ny][nx] = true;
			}
		}

		if (baitQ.length) {
			baitQ.sort((a, b) => {
				// 거리비교
				if (a[2] !== b[2]) {
					return a[2] - b[2];
				} else {
					// 상하비교
					if (a[0] !== b[0]) {
						return a[0] - b[0];
					}

					// 좌우비교
					else {
						return a[1] - b[1];
					}
				}
			});

			const [targetY, targetX, targetMove] = baitQ[0];

			map[targetY][targetX] = 0;
			eats[lv]++;

			if (eats[lv] === lv) {
				lv++;
			}
			cur = [targetY, targetX];
			move = targetMove;
		} else {
			return totalMove;
		}

		totalMove += move;
	}
}

console.log(bfs());
