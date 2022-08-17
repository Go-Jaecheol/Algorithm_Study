# [42578] 완주하지 못한 선수

## Algorithm

- Map
- 조합..?

## Logic

Map으로 각 옷 type 별로 정리함.
그리고 갯수 +1 해 주고 전체 곱해주고 -1
(아무 것도 안 입는 경우 제외)

```js
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
```

## Review

쉽고 맛있다..
