const fs = require("fs");
let input = fs.readFileSync("./input.txt").toString();
// let input = fs.readFileSync("/dev/stdin").toString();

const paper = input.split("\n").map(line => line.split(" ").map(el => +el));

const size = paper.shift();
const answer = [0, 0, 0];

const cut = (size, x, y) => {
	// console.log(x, y);
	const initValue = paper[y][x];
	let flag = false;

	for (let i = y; i < y + size; i++) {
		for (let j = x; j < x + size; j++) {
			if (paper[i][j] !== initValue) flag = true;
			// console.log(i, j, paper[i][j], size);

			if (flag === true) break;
		}
		if (flag === true) break;
	}

	if (flag === false) answer[initValue + 1]++;
	else {
		size /= 3;
		cut(size, x, y);
		cut(size, x, y + size);
		cut(size, x, y + 2 * size);
		cut(size, x + size, y);
		cut(size, x + size, y + size);
		cut(size, x + size, y + 2 * size);
		cut(size, x + 2 * size, y);
		cut(size, x + 2 * size, y + size);
		cut(size, x + 2 * size, y + 2 * size);
	}
};

cut(size, 0, 0);

answer.forEach(a => console.log(a));
