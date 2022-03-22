# [1013] Contact
## Algorithm
- String
## Logic
문제에서 나온대로 패턴을 매칭하면 되는데, `100+1+` 패턴을 매칭하고 끝부분이 관건이다.

`100+1+`를 매칭하고 뒤에 오는 문자가 `01`이면 상관없지만, `00`이면 다시 `100+1+` 패턴이 올 수 있는 가능성이 있다.
이것을 잘 처리해주어야 한다.
```js
function solution(signal) {
    let index = 0;
    while(1) {
        if(index >= signal.length) {
            console.log("YES");
            return;
        }
        if(signal[index++] === "1") {
            if(signal[index++] !== "0")  break;
            let start = index;
            while(signal[index] === "0") index++;
            if(start === index) break;
            start = index;
            while(signal[index] === "1") index++;
            if(start === index) break;
            if(signal[index + 1] === "0" && index - start > 1) index--;
        }
        else {
            if(signal[index++] !== "1") break;
        }
    }
    console.log("NO");
}
```
## Review
문자열이 쉬운듯 어렵다. 더 많이 풀어보자.
