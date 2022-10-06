# [42583] 베스트 앨범

## Algorithm

- Map

## Logic

Play 수랑 장르 수 Map에 저장하고 sort!

```js
function solution(genres, plays) {
	const genreMap = new Map();
	const playMap = new Map();
	let ans = [];

	genres.forEach((genre, idx) => {
		if (genreMap.has(genre, idx)) {
			genreMap.set(genre, genreMap.get(genre) + plays[idx]);
			playMap.set(genre, [...playMap.get(genre), idx]);
		} else {
			genreMap.set(genre, plays[idx]);
			playMap.set(genre, [idx]);
		}
	});

	genres.forEach(genre => [
		playMap.get(genre).sort((a, b) => plays[b] - plays[a]),
	]);

	const sortedGenreMap = new Map(
		[...genreMap.entries()].sort((a, b) => b[1] - a[1])
	);

	[...sortedGenreMap.keys()].forEach(genre => {
		ans = ans.concat(playMap.get(genre).slice(0, 2));
	});
	return ans;
}
```

## Review

쉽고 맛있다..
