# [5430] AC
## Algorithm
- Deque
## Logic
배열을 뒤집는 연산은 시간이 오래 걸린다. 배열을 뒤집고 앞에 것을 빼는 것은 뒤에 있는 것을 뺴는 것과 같다.
그렇기 떄문에 `reversed` 라는 플래그를 두어서 앞에서 뺄지 뒤에서 뺄지 결정하게 했다.

```js
function solution() {
    let p = input[inputIndex++];
    let n = input[inputIndex++];
    let arr = input[inputIndex].slice(1, input[inputIndex++].length - 1).split(",");
    if(!+n) arr = [];

    let reversed = false;
    for(funcIndex = 0; funcIndex < p.length; funcIndex++) {
        const func = p[funcIndex];
        if(func === "R") reversed = !reversed;
        else if(func === "D") {
            if(arr.length === 0) {
                console.log("error");
                return;
            }
            if(reversed) arr.pop();
            else arr.splice(0, 1);
        }
    }

    if(reversed) arr.reverse();
    console.log("[" + arr.join(",") + "]");
}
```
## Review
처음에 주어진 문자열을 배열로 바꾸는데 정규 표현식을 사용했었다. 하지만, 시간이 오래 걸려서 그냥 자르는 방식으로 바꿨다.

문자열 관련 문제를 풀 때 되도록이면 정규 표현식은 사용하지 않는 것이 좋겠다.
