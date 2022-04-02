# [16916] 부분 문자열 - JS

## :mag: Algorithm

### KMP

## :round_pushpin: Logic

**KMP** 알고리즘을 사용하여 부분 문자열이 있는지 확인한다.

<br />

**1.** 먼저, P(`word`)에 속하는 **각 부분 문자열의 접두사와 접미사가 일치하는 최대 길이를 저장하는 테이블**을 생성한다.

```js
function buildPatternTable(word) {
  let prefixIndex = 0;
  let suffixindex = 1;

  const patternTable = new Array(word.length).fill(0);

  while (suffixindex < word.length) {
    if (word[prefixIndex] === word[suffixindex]) {
      patternTable[suffixindex] = prefixIndex + 1;
      prefixIndex += 1;
      suffixindex += 1;
    } else if (prefixIndex === 0) {
      patternTable[suffixindex] = 0;
      suffixindex += 1;
    } else {
      prefixIndex = patternTable[prefixIndex - 1];
    }
  }

  return patternTable;
}
```

<br />

**2.** S(`text`), P(`word`)를 `textIndex`와 `wordIndex`를 통해 비교한다.

```js
function solution(text, word) {
  let textIndex = 0;
  let wordIndex = 0;

  const patternTable = buildPatternTable(word);

  while (textIndex < text.length) {
    if (text[textIndex] === word[wordIndex]) {
      if (wordIndex === word.length - 1) {
        return 1;
      }
      textIndex += 1;
      wordIndex += 1;
    } else if (wordIndex > 0) {
      wordIndex = patternTable[wordIndex - 1];
    } else {
      textIndex += 1;
    }
  }

  return 0;
}
```

- `wordIndex`가 `word`의 마지막 인덱스가 될 때까지 문자가 같으면(`text[textIndex] === word[wordIndex]`) `word`가 `text`에 부분 문자열로 속하는 것으로 판단한다.

- 만약 각 인덱스의 위치에 있는 문자가 같지 않으며 `wordIndex`가 `0`보다 클 시, **생성한 `patternTable`을 통해 검색을 새로이 해야하는 지점을 얻는다.**

## :memo: Review

처음엔 텍스트에 문자가 속해 있는지 차례대로 순회하면서 비교했다.

그러자 '메모리 초과'가 발생했고, 생각해보니 시간복잡도 또한 높을 것 같았다.

아무리 고민해도 다른 방법이 떠오르지 않자, 알고리즘 분류를 보니 'KMP'가 있었다.

결국 KMP 알고리즘에 대해 학습하고, 이를 활용하여 문제를 해결할 수 있었다.

KMP 알고리즘은 다른 기법들에 비해 꽤 어려운거 같다..