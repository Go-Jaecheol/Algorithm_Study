# [1541] 잃어버린 괄호
## Algorithm
- Greedy
## Logic
식의 값을 최소한으로 만들기 위해서는 빼는 값을 크게 만들어야 한다.

즉 `-` 뒤에 수 들을 다 더한 후 빼주면 된다. 이것을 다르게 생각해보면, `-` 뒤의 수들은 어차피 뺄 것이기 때문에 그냥 빼주면 된다. 그리고 한 번 `-`가 나오면 다시는 더할 일이 없어진다.

따라서 `-`가 나오기 전까지는 전부 더해주다가, `-`가 나온 이후 수는 다 빼준다.

```js
function solution() {
    let answer = 0;
    let equation = input[0].split(""), index = 0, cur = "", isPlus = true;

    while(equation.length > index && isPlus) {
        const char = equation[index++];
        if(+char >= 0) cur += char;
        else {
            answer += +cur;
            cur = "";
            if(char === "-") isPlus = false;
        }
    }
    while(equation.length > index) {
        const char = equation[index++];
        if(+char >= 0) cur += char;
        else {
            answer -= +cur;
            cur = "";
        }
    }
    answer = isPlus ? answer + +cur : answer - +cur;

    console.log(answer);
}
```
## Review
전에 한 번 풀어본 문제다. 저번에 풀었을 때보다 빨리 풀고, 코드의 속도도 더 빨라졌다.
