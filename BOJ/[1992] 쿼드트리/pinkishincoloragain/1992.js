var input = require("fs")
	.readFileSync("./dev/stdin")
	.toString()
	.trim()
	.split("\n");
const N = parseInt(input[0]);
const M = parseInt(input[1]);
const INF = Infinity;
const dp = Array(N + 1).fill(INF);
const graph = Array.from(Array(N + 1), () => Array());
for (let i = 2; i < M + 2; i++) {
	const [start, end, weight] = input[i].split(" ").map(Number);
	graph[start].push([weight, end]);
}
const [A, B] = input[M + 2].split(" ").map(Number);

const Q = [[0, A]];

dp[A] = 0;
while (Q.length) {
	let [cost, cur] = Q.shift();
	if (dp[cur] < cost) continue;
	for (let [value, node] of graph[cur]) {
		if (dp[node] > dp[cur] + value) {
			dp[node] = dp[cur] + value;
			Q.push([dp[node], node]);
		}
	}
}
console.log(dp[B]);
