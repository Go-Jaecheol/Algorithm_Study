class Heap {
	constructor() {
		this.list = [undefined];
		this.length = 0;
	}

	push(val) {
		this.list.push(0);
		this.length++;
		let i;
		for (i = this.length; i > 1 && val > this.list[i >> 1]; i = i >> 1)
			this.list[i] = this.list[i >> 1];
		this.list[i] = val;
	}

	pop() {
		let del = this.list[1];
		let val = this.list.pop();
		this.length--;

		let i = 1;
		while (i << 1 <= this.length) {
			let child = i << 1;
			if (child + 1 <= this.length && this.list[child] < this.list[child + 1])
				child++;

			if (val > this.list[child]) break;

			this.list[i] = this.list[child];
			i = child;
		}

		if (this.length > 0) this.list[i] = val;

		return del;
	}
}

// input
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs")
	.readFileSync(inputFile)
	.toString()
	.trim()
	.split("\n");

const N = Number(input[0]);
const problems = input.slice(1).map(x => x.trim().split(" ").map(Number));

problems.sort((a, b) => b[0] - a[0]);

const heap = new Heap();
let sol = 0;
let i = 0;

for (let time = N; time > 0; time--) {
	while (i < N && problems[i][0] == time) heap.push(problems[i++][1]);

	if (heap.length > 0) sol += heap.pop();
}

// output
console.log(sol);
