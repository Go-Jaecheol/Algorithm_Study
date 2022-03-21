# [5562] 공통 부분 문자열
## Algorithm
- DP
## Logic
긴 문자열에 짧은 문자열과 비교해서 제일 긴 공통 부분 문자열을 구한다.

짧은 문자열의 시작 인덱스를 `0`부터 `short.length - 1`로 바꾸면서 공통 부분 문자열의 길이를 구한다.
이때 짧은 문자열의 인덱스 `start`와 긴 문자열의 인덱스 `i`에서 공통 부분 문자열 길이를 구하는 것이 중복으로 일어날 수 있다.
이 중복 계산을 메모이제이션으로 없애준다. 

그리고 남은 짧은 문자열의 길이가 제일 긴 공통 부분 문자열과 같거나 작아지면 탐색을 종료해도 된다.

```js
function solution() {
    const [long, short] = input[0].length > input[1].length ? input: [input[1], input[0]];

    let longest = 0;
    const cache = new Array(4001).fill(0).map(() => new Array(4001).fill(0));
    for(let start = 0; start < short.length; start++) {
        for(let i = 0; i < long.length; i++) {
            if(short[start] === long[i] && !cache[start][i]) {
                let length = 1, offset = 1; 
                cache[start][i] = length;
                while(start + offset < short.length && i + offset < long.length && short[start + offset] === long[i + offset]) {
                    cache[start + offset][i + offset++] = ++length;
                }
                longest = Math.max(longest, length);
            }
        }
    }
    console.log(longest);
}
```
## Review
메모이제이션도 중요하지만, 남은 짧은 문자열의 길이가 제일 긴 공통 부분 문자열과 같거나 작아지면 탐색을 종료해주는 부분도 중요한 것 같다. 

이 코드를 적용해서 396ms나 줄일 수 있었다. 불필요한 계산을 최대한 줄여주자.
