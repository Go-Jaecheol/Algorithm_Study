# [1013] Contact - JS

## :mag: Algorithm

### String

## :round_pushpin: Logic

```js
while (idx < testCase.length) {
    // 1로 시작할 경우
    if (testCase[idx] === "1") {
        // 연속된 0 탐색
        let temp = idx;
        while (testCase[idx + 1] === "0") idx++;
        if (idx - temp < 2) return "NO";
        
        // 연속된 1 탐색
        temp = idx;
        while (testCase[idx + 1] === "1") idx++;
        if (temp === idx) return "NO";

        // 연속된 1이 둘 이상일 시 연속된 0 확인
        if (idx - temp > 1) {
            temp = idx;
            while (testCase[idx + 1] === "0") idx++;
            idx = (idx - temp > 1) ? temp : temp + 1;
            continue;
        } 

        idx++;
        continue;
    }

    // 0으로 시작할 경우
    if (testCase[++idx] !== "1") return "NO";
    idx++;
}

return "YES";
```

`"1"`로 시작할 경우와 `"0"`으로 시작할 경우를 나누어 문자 탐색을 실시한다.

- `"1"`로 시작한 경우 둘 이상의 연속된 `"0"`과 하나 이상의 연속된 `"1"`이 있어야 한다.

  - **만약, 연속된 `"1"`이 둘 이상일 경우, 다음 문자열로 `100...1`이 나오는 경우를 고려해야 한다.**

    이와 같은 경우, 연속된 `"1"` 이후 연속된 `"0"`의 개수를 확인하여, 다음 시작 문자를 선정한다.

- `"0"`으로 시작한 경우 다음 문자가 `"1"`이어야 한다.

## :memo: Review

문자열이 `"1"`로 시작한 경우를 처리 할때, 이후 다음 문자열로 `100...1`이 나오는 경우를 고려하지 못해 틀렸었다.

반례를 고민하느라 시간이 소요되었지만, 원인을 알고나서는 조건 사항을 추가해 금방 해결했다. 