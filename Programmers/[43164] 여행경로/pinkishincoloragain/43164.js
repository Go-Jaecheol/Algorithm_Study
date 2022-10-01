function solution(tickets) {
	const adjList = new Map();
	const start = "ICN";
	const res = [];

	tickets.forEach(t => {
		console.log(t);
		adjList.set(
			t[0],
			adjList.get(t[0]) ? [...adjList.get(t[0]), t[1]] : [t[1]]
		);
	});

	for (let [key, value] of adjList) {
		adjList.set(key, value.sort());
	}

	dfs(start, visited);
}

console.log(
	solution([
		["ICN", "SFO"],
		["ICN", "ATL"],
		["SFO", "ATL"],
		["ATL", "ICN"],
		["ATL", "SFO"],
	])
);
