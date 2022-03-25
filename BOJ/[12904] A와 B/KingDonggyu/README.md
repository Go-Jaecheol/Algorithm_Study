# [12904] A와 B - JS

## :mag: Algorithm

### Greedy

## :round_pushpin: Logic

**S와 T가 주어졌을 때 T가 S가 될 수 있는지 확인한다.**

```js
while (S.length < end - start) {
    if (T[isReversed ? start : end - 1] === "A") {
        isReversed ? start += 1 : end -= 1;
        continue;
    }
    isReversed ? start += 1 : end -= 1;
    isReversed = !isReversed;
}

T = T.slice(start, end);
if (isReversed) T = T.split("").reverse().join("");
```

- `isReversed` 가 `true`이면 `start`(맨 앞 인덱스), `false`이면 `end`(맨 뒤 인덱스 + 1)를 타겟 인덱스로 정한다.

- T의 타겟 인덱스가 "A" 이면 타겟 인덱스를 업데이트 한다.

- T의 타겟 인덱스가 "B" 이면 타겟 인덱스를 압데이트하고, `isReversed`의 Boolean 값을 변경한다. 

- S의 길이와 업데이트 한 T의 길이(`end - start`)가 같아질 때까지 이를 반복한다.

- 반복문이 종료되면 `start`와 `end`를 통해 T를 슬라이싱하고, `isReversed`가 `true`일 시 T를 거꾸로 뒤집는다.

## :memo: Review

S를 T로 만드는 것이 아닌, T를 S로 만드는 방법을 바로 떠올려 쉽게 해결했다.

저번주에 이와 유사한 문자열 문제를 풀었을 때, `reverse()` 메서드와 `shift()` 메서드의 반복 사용이 매우 비효율적임을 알았기에, flag 변수와 슬라이싱을 이용했다.