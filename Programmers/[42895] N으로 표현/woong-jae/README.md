# [42895] N으로 표현
## Algorithm
- DP
## Logic
숫자 6개로 만들 수 있는 경우의 수는 아래와 같다.
- 숫자 1개로 만든 모든 경우의 수 * 숫자 5개로 만든 모든 경우의 수
- 숫자 2개로 만든 모든 경우의 수 * 숫자 4개로 만든 모든 경우의 수
- 숫자 3개로 만든 모든 경우의 수 * 숫자 3개로 만든 모든 경우의 수

이것을 일반화해서 구현하면 아래와 같다.
```js
function solution(N, number) {
    const cand = [];
    
    let used = 0;
    while(used < 9) {
        let next = new Set();
        for(let i = 0; i < used; i++) {
            cand[i].forEach(num1 => {
                cand[used - i - 1].forEach(num2 => {
                    next.add(num1 + num2);
                    next.add(num1 * num2);
                    next.add(num1 - num2);
                    next.add(Math.floor(num1 / num2));
                });
            });
        }
        let combined = +String(N).repeat(used + 1);
        next.add(combined);
        cand.push(next);
        if(cand[used++].has(number)) return used;
    }
    
    return -1;
}
```
## Review
분명 맞게 푼 것 같은데 틀려서 한참 보고있다가, 0 이하로 가는지 확인하고 넣는 부분을 지우니까 성공했다...

물론 이런 형식의 DP문제를 처음봐서 아이디어 생각하는 것도 오래걸리긴 했는데,,, 억울하다,,,
