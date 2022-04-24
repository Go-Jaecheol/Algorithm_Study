# [2866] 문자열 잘라내기
## Algorithm
- Set
## Logic
가장 위에 열을 하나씩 지워가며 중복되는 문자열이 있는지 체크하는 것은 너무 오래걸릴 것 같다고 생각했다.

그래서 밑에서부터 시작해서 **중복되는 문자열이 있는 최대 길이**를 찾았다.

```js
const colStr = new Array(C).fill("");
let sameCount = 0;
while(table.length) {
    const curRow = table.pop();
    const strSet = new Set();

    curRow.forEach((char, i) => {
        const str = char + colStr[i];
        strSet.add(str);
        colStr[i] = str;
    });

    if(strSet.size === C) break;
    sameCount++;
}
```
이때 중복되는 문자열이 있는지 확인하기 위해 `Set`을 사용했다.
모든 문자열을 `Set`에 넣었을 때, 셋의 크기가 열의 길이(`C`)가 같다면 중복이 없다는 의미기 때문에 반복을 멈춘다.

'count' 값은 `R - sameCount - 1`이다.

## Review
아이디어는 쉽게 생각할 수 있었다.
왜인지는 모르겠지만 구현하는데 좀 오래걸린 문제... 문자열 문제가 제일 빡센 것 같다.
