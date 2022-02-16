# [42628] 이중우선순위큐
## Algorithm
- Priority Queue
## Logic
우선은 최대값에 해당하는 연산만 바로바로 실행해주고, 최소값을 빼는 연산은 몇 번하는지 카운트했다가 마지막에 빼준다.

```js
function solution(operations) {
    let maxQ = new Heap();
    let minDeleteCount = 0;
    
    operations.forEach(op => {
        const [command, number] = op.split(" ");
        if(command === "D" && maxQ.heap.length) {
            if(number === "1") maxQ.pop();
            else minDeleteCount++;
        } 
        else {
            maxQ.push(+number);
        }
    });
    
    let arr = [...maxQ.heap];
    arr.sort((a, b) => b - a);
    while(arr.length && minDeleteCount--) arr.pop();
    
    let answer = [arr[0] ? arr[0] : 0, arr[arr.length - 1] ? arr[arr.length - 1] : 0];
    
    return answer;
}
```
## Review
별로 어렵지 않았던 문제. 이전 문제가 더 어려웠던 것 같다.
