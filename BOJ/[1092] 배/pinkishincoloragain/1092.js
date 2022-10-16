const fs = require("fs");
let input = fs
	// .readFileSync("./input.txt")
	.readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

const C = +input[0]; //Crane length
const B = +input[2]; //Box length
let crane = input[1].split(" ").map(Number);
let box = input[3].split(" ").map(Number);

crane.sort((a, b) => b - a);
box.sort((a, b) => b - a);

let time = 0;

if (crane[0] < box[0]) {
	console.log(-1);
} else {
	while (box.length) {
		let ci = 0;
		for (let bi = 0; bi < box.length; bi++) {
			if (ci === crane.length) break;
			if (crane[ci] >= box[bi]) {
				box.splice(bi, 1);
				bi--;
				ci++;
			}
		}
		time += 1;
	}

	console.log(time);
}
