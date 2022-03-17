# [9935] 문자열 폭발
## Algorithm
- Stack
## Logic
문자열을 처음부터 스택에 차례차례 집어넣는다.

하나 넣을 때마다 스택의 뒤가 폭발시킬 문자열과 같은지 확인한다. 더이상 폭발시킬 문자열이 스택 뒤에 없을 때까지 반복해서 없애주면 된다.

```js
function solution() {
    const [origin, target] = input.map(elem => elem.split(""));
    const stack = [];

    origin.forEach(char => {
        stack.push(char);
        while(1) {
            let explode = true;
            for(let targetIndex = 0; targetIndex < target.length; targetIndex++) {
                let compareIndex = stack.length - target.length + targetIndex;
                if(compareIndex < 0 || stack[compareIndex] !== target[targetIndex]) {
                    explode = false;
                    break;
                }
            }
            if(explode) stack.splice(stack.length - target.length, target.length);
            else break;
        }
    });

    console.log(stack.length ? stack.join("") : "FRULA");
}
```
## Review
스택을 사용하는 아이디어만 떠올리면 쉽게 풀 수 있는 문제다. 혹시 `String`으로만 풀 수 있나 시도해봤는데, 메모리 초과가 났다. 배열 썼을 때랑 속도 비교해보고 싶었는데... 아쉽다.
