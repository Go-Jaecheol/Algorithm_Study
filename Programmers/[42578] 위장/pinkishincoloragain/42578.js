function solution(clothes) {
	const map = new Map();
	clothes.forEach(([, type]) => {
		map.has(type) ? map.set(type, map.get(type) + 1) : map.set(type, 1);
	});

	const total = [...map]
		.map(([type, cnt]) => (type, cnt))
		.reduce((prev, cur) => prev * (cur + 1), 1);

	return total - 1;
}

console.log(
	solution([
		["yellow_hat", "headgear"],
		["blue_sunglasses", "eyewear"],
		["green_turban", "headgear"],
	])
);
