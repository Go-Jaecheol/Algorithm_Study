# [16120] PPAP
## Algorithm
- Stack
## Logic
스택에 한 단어씩 넣어주다가 끝 부분이 "PPAP"가 되면 `pop`으로 "P"만 남기고 제거해준다.

마지막에 스택에 "P"만 존재한다면 "PPAP" 문자열이다.

```js
function solution() {
    const string = input[0];
    const stack = [];

    for(let char of string) {
        stack.push(char);
        if(stack.length >= 4) {
            if(stack.slice(-4).join("") === "PPAP") {
                stack.pop();
                stack.pop();
                stack.pop();
            }
        }
    }

    console.log(stack.length === 1 && stack[0] === "P" ? "PPAP" : "NP");
}
```
## Review
처음에 KMP 알고리즘을 응용해서 코드를 작성했는데 시간초과가 떴다. 원인을 분석해보니 문자열에서 "PPAP"를 제거할 때 사용한 `splice` 메서드가 시간을 엄청 오래 잡아먹었다.
다른 글을 참조해보니 `shift`보다도 오래 걸리는 연산이였다.

그래서 다른 방법으로 바꿨는데, 이번에는 메모리 초과가 떴다. 결론은 스택을 사용해 풀었다. 코드도 훨씬 간단하고 시간도 빨랐다.
