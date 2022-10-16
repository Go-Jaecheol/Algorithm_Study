const fs = require("fs");
let [num, ...arr] = fs
	.readFileSync("./input.txt")
	// .readFileSync("/dev/stdin")
	.toString()
	.trim()
	.split("\n");

let N = +num;
let answer = 0;
let count = 0;
let temp = [];

for (let i = 0; i < N; i++) {
	let [start, end] = arr[i].split(" ").map(el => +el);
	temp.push({ t: start, isStart: 1 });
	temp.push({ t: end, isStart: 0 });
}

temp
	.sort((a, b) => a.t - b.t || a.isStart - b.isStart)
	.forEach(el => {
		el.isStart ? count++ : count--;
		answer = Math.max(answer, count);
	});

console.log(temp);
