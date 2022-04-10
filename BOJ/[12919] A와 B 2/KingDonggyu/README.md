# [12919] A와 B 2 - JS

## :mag: Algorithm

### BruteForce

## :round_pushpin: Logic

**S -> T 가 아닌 T -> S 로 문제를 해결한다.**

아래는 T의 **맨 앞 문자**와 **맨 뒤 문자**가 다른 모든 경우이다.

**1. A ~ A :**

- 문자열 맨 뒤에 A를 추가한 결과이다.

**2. B ~ A :**

- 문자열 맨 뒤에 A를 추가한 결과이거나,

- 문자열 맨 뒤에 B를 추가하고 문자열을 뒤집은 결과이다.

**3. A ~ B :**

- 해당 결과는 나올 수 없다.

**4. B ~ B :**

- 문자열 맨 뒤에 B를 추가하고 문자열을 뒤집은 결과이다.

<br />

```js
if (T[end] === 'A') {
  // 1번 경우
  result = isReverse
    ? recursion(startIndex + 1, endIndex, isReverse)
    : recursion(startIndex, endIndex - 1, isReverse);

  if (!result && T[start] === 'B') {
    // 2번 경우
    result = isReverse
      ? recursion(startIndex, endIndex - 1, !isReverse)
      : recursion(startIndex + 1, endIndex, !isReverse);
  }
} else if (T[start] === 'B') {
  // 4번 경우
  result = isReverse
    ? recursion(startIndex, endIndex - 1, !isReverse)
    : recursion(startIndex + 1, endIndex, !isReverse);
}
```

- 위 1, 2, 4번 의 경우를 고려하여 (3번 경우는 나올 수 없다) T의 맨 앞 또는 맨 뒤 문자를 하나씩 없애주었다.

- 만약, 2번 또는 4번 경우에 해당할 경우, `isReverse` Boolean 플래그를 반대 값으로 변경한다.

  - `isReverse`가 `true`이면, 문자열이 뒤집힘을 의미한다.

- 잦은 문자열 슬라이싱은 보다 낮은 성능을 초래할 수 있으므로, `startIndex`와 `endIndex`를 이용해 시작 인덱스와 마지막 인덱스를 저장/업데이트 해주었다. 

## :memo: Review

처음엔 S -> T 방법으로 완전탐색을 시행했지만 시간초과가 발생했다.

생각해보니 T -> S 방법이 보다 적은 재귀를 수행할 것임이 확실했고, 수정하여 해결할 수 있었다.

근래 풀었던 문제들 대부분 빠르게 안풀린다..