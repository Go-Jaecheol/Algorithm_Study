# [49189] N으로 표현 - JS

## :mag: Algorithm

### Dynamic Programming

## :round_pushpin: Logic

❗️ **주의사항**: 교환법칙이 성립하지 않는다.

<br />

아래와 같이 전체 코드에 대한 주석을 통해 로직을 설명하도록 하겠다.

```js
function solution(N, number) {
    // 인덱스 값이 N의 갯수를 뜻하는 배열 dp을 생성한다.
    const dp = [null];

    // 배열 dp를 인덱스 8까지만 업데이트한다. 
    // (문제의 조건에 따라 8보다 크면 -1 리턴)
    for (let x = 1; x < 9; x++) {
        // N을 x번 사용하는 모든 경우의 연산을 담을 배열을 생성한다.
        const calc = [];
        for (let y = 1; y < x; y ++) {
            // 2차원 반복문을 통해 N을 x번 사용하는 모든 경우를 탐색한다.
            for (const op1 of dp[y]) {
                for (const op2 of dp[x - y]) { 
                    // 사칙연산의 결과를 삽입한다.
                    calc.push(op1 + op2);
                    if (op1 - op2 >= 0) {
                        calc.push(op1 - op2);
                    }
                    calc.push(op1 * op2);
                    if (op1 !== 0 && op2 !== 0) {
                        calc.push(Math.floor(op1 / op2));
                    }
                }
            }
        }
        // N을 x만큼 반복하여 이어붙인 수를 삽입한다.
        calc.push(Number(String(N).repeat(x)));
        // 불필요한 연산을 줄이기 위해 중복된 값을 제거한다.
        const set = new Set(calc);
        // number가 있으면 x를 리턴한다.
        if (set.has(number)) {
            return x;
        }
        // dp 배열에 x 인덱스에 대한 배열(중복 제거한 calc)을 삽입한다.
        dp.push([...set]);
    }
    
    return -1;
}
```

## :memo: Review

정말 오랜만에 풀어본 dp 문제라 그런지 어려웠다..

바보처럼 교환법칙이 성립하지 않는 것을 간과하여 많은 실패가 있었다 😂

또, 효율성을 고려하여 깊은 중첩 반복문에 대한 걱정으로 인해 고민하느라 시간을 많이 소요했다.

(시간초과 뜰 줄 알았는데 통과했네..)