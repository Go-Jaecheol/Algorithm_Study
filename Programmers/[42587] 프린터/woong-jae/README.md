# [42587] 프린터
## Algorithm
- Deque
## Logic
최대 우선순위를 가장 앞의 문서를 꺼낼 때마다 계산하지 않고, 미리 정렬해두어서 가장 앞의 문서와 비교했다.

나머지는 문제에서 시키는대로 구현했다.
```js
function solution(priorities, location) {
    let answer = 0;
    
    let pending = new Array(priorities.length).fill(0).map((_,i) => i);
    let maxVal = priorities.slice(0).sort((a, b) => a - b);
    
    while(1) {
        let current = pending.shift();

        if(priorities[current] === maxVal[maxVal.length - 1]) {
            answer++;
            maxVal.pop();
            if(location === current) break;
        }
        else pending.push(current);
    }
    
    return answer;
}
```
## Review
쉬운 문제. 처음에는 가장 앞의 문서를 꺼낼 때마다 최대 우선순위를 구해서 통과는 했는데, 성능이 아쉬워서 수정했다.
