# [2866] 문자열 잘라내기 - JS

## :mag: Algorithm

### Hash

## :round_pushpin: Logic

```js
while (isDuplicate && table.length) {
  const row = table.pop();
  const map = new Map();

  isDuplicate = false;

  for (let x = 0; x < C; x++) {
    const str = strList[x] + row[x];

    if (!map.has(str)) {
    map.set(str, true);
    } else {
    isDuplicate = true;
    }
    strList[x] = str;
  }

  if (isDuplicate) count -= 1;
}
```

- `pop()`을 이용하여 테이블의 마지막 행부터 역순으로 탐색한다.

- 만약 탐색 대상인 행에 중복된 단어가 있을시, `strList`에 저장된 문자에 이어 붙인다. 그리고 다음 행을 탐색한다.

- 중복된 단어가 없을시, 루프를 종료한다.

## :memo: Review

진~짜 오래 걸렸다.

처음에는 테이블의 첫번째 행부터 탐색하는 바람에 **메모리 초과**가 나왔다.

그래도 역순으로 탐색해야 하는 것을 금방 깨닫고, 진행했지만.. **런타임 에러**..?

어느 부분이 문제인지 찾기 위해 런타임 에러가 발생하는 반례를 찾느라 시간이 엄청 오래 걸렸다 😅

결국 역시나 인덱스 문제..

원인을 찾았지만 이번엔.. **틀렸습니다**..?

지금 코드와 달리 `strList`에 문자를 이어붙이는 작업을 안했다. 중복된 문자가 있는 인덱스를 Set에 저장했고, 그 다음 탐색 때 Set에 저장된 인덱스에 해당되는 열만 조사했다. 아직도 이 방법이 왜 틀린 것인지 모르겠다..

고민하다 Set을 사용하지 않고 `strList` 배열을 만들어 문자를 이어붙이도록 했다.

이번엔 `const str = strList[x] + row[x];` 부분을 `const str = row[x] + strList[x];`로 하여 또 틀렸다 🤣

그래도 이 원인은 금방 찾아 결국 문제를 해결할 수 있었다..

그렇게 어려운 문제는 아닌데, 중간 중간에 실수들이 잦았던거 같다. 이 때문에 디버깅하느라 시간을 다 썼다.