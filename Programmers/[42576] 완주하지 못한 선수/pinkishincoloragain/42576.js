function solution(participant, completion) {
	const map = new Map();

	participant.forEach(p => {
		map.has(p) ? (map[p] = map[p] + 1) : (map[p] = 1);
	});

	completion.forEach(c => {
		map[c] = map[c] - 1;
	});

	for (const p of participant) {
		if (map[p] === 0) return p;
	}
}

console.log(
	solution(["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"])
);
