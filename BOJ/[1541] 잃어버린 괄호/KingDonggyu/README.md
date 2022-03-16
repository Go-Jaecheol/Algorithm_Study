# [1541] 잃어버린 괄호 - JS

## :mag: Algorithm

### Greedy

## :round_pushpin: Logic

```
a + b - c + d + e - f
```

위의 식이 있을 때, 아래와 같이 괄호를 추가하면 항상 최소가 된다.

```
a + b - (c + d + e) - f
```

즉 `"-"` 뒤의 연속된 더하기 식은 결국 뺄셈이 되므로,

**`"-"`가 처음으로 나타난 뒤의 모든 수를 부호에 관계없이 모두 빼면된다.**

```js
while (x < expression.length) {
    if (expression[x] === "-") {
        isMinus = true;
        x += 1;
        continue;
    }

    let number = expression[x];   
    while (x < expression.length-1 && isFinite(expression[x+1])) {
        number += expression[++x];
    }

    answer += isMinus? -(+number) : +number;
    x += 1;
}
```

- 문자열을 한 문자씩 확인한다.

- 만약, 해당 문자가 피연산자라면 `while`을 통해 연산자가 나오기 전까지의 수를 이어붙인다.

- 문자가 연산자이며 `"-"` 부호일 경우 `isMinus`를 `true`로 설정해, 이후 나오는 모든 피연산자를 뺀다.

## :memo: Review

아이디어를 금방 떠올려 쉽게 해결할 수 있었다.

그리고 최근에 학습한 `isFinite()`를 적용해 코드를 더 간결하게 표현할 수 있었다.

> `isFinite()`는 인수를 숫자로 변환하고 변환한 숫자가 `NaN / Infinity / -Infinity`가 아닌 일반 숫자인 경우 `true`를 반환하므로, **문자열이 일반 숫자인지 검증하는 데 사용되곤 한다.**