# [43165] 타겟 넘버
## Algorithm
- DFS
## Logic
DFS로 마지막 깊이까지 탐색했을 때 `target`과 계산한 결과가 같다면 카운팅한다.
```js
function solution(numbers, target) {
    let answer = 0;

    function dfs(depth, currentNumber) {
        if(depth === numbers.length) {
            if(currentNumber === target) answer++;
            return;
        }
        dfs(depth + 1, currentNumber + numbers[depth]);
        dfs(depth + 1, currentNumber - numbers[depth]);
    }

    dfs(0, 0);

    return answer;
}
```
## Review
쩝... 쉽다.
