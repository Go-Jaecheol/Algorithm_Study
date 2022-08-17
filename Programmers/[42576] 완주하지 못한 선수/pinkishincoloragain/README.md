# [42567] 완주하지 못한 선수

## Algorithm

- Map

## Logic

```js
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
```

## Review

Map 사용하면 되는 문제..
