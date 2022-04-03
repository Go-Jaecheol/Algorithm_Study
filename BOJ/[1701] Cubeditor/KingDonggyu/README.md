# [1701] Cubeditor - JS

## :mag: Algorithm

### KMP

## :round_pushpin: Logic

KMP 알고리즘에서 수행하는 **접두사와 접미사가 일치한 부분 문자열의 최대 길이를 저장하는 테이블**을 생성하여, 해당 테이블의 최대값을 구한다.

```js
function solution(text) {
  let patternTable;
  let maxLen = 0;
  
  for (let i = 0; i < text.length - 2; i++) {
    patternTable = buildPatternTable(text.slice(i));
    maxLen = Math.max(maxLen, ...patternTable);
  }

  return maxLen;
}
```

(접두사와 접미사가 일치한다는 것은 2개의 일치하는 부분 문자열이 있다는 것이므로, 문제에서 제시한 조건에 부합한다.)

- 반복문을 통해 접두사가 다른 경우의 부분문자열을 모두 확인한다.

- 전체 부분 문자열의 각 테이블 최대값 중 가장 큰 값을 리턴한다.

## :memo: Review

문제를 읽고 KMP를 사용해야 한다는 것을 바로 알아차릴 수 있었고, 

패턴테이블의 최대값이 곧 정답이 될 수 있을 것을 파악해 쉽게 해결할 수 있었다.

다만, 어리석게도 접두사가 다른 경우를 간과하여 몇번의 틀림이 있었다.