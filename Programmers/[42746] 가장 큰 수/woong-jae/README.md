# [42746] 가장 큰 수
## Algorithm
- Sort
## Logic
정렬할 때 비교 함수가 핵심이다.

`a`와 `b`가 주어졌을 때, `a + b`와 `b + a` 중 크기가 더 큰 수의 앞쪽 수가 우선순위가 더 커야한다.
```js
function solution(numbers) {
    numbers.sort((a, b) => {
        [a, b] = [a.toString(), b.toString()];
        return (b + a) - (a + b);
    });
    if(numbers[0] === 0) return "0";
    return numbers.join("");
}
```
## Review
비교 함수 작성에서 애먹었다... 좀 헤매다가 아이디어가 떠올라서 바로 풀 수 있었다. 풀고나니까 '이걸 왜 못풀고 있었지...'하는 문제였다.

그래도 아름답게 푼 것 같아서 기분 좋다.
