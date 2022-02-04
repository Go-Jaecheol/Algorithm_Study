# [42586] 기능개발
## Algorithm
- Stack
## Logic
주어진 데이터를 이용해서 각 기능 개발에 걸리는 시간을 계산했다. 계산한 값으로 답을 구했다.

```js
function solution(progresses, speeds) {
    let answer = [];

    let neededDays = new Array(progresses.length);
    progresses.forEach((progress, i) => {
        let leftProgress = 100 - progress;
        let neededDay = Math.ceil(leftProgress / speeds[i]);
        neededDays[i] = neededDay;
    });

    neededDays.reverse();
    while(neededDays.length) {
        let nextRelease = neededDays.pop();
        answer.push(1);
        while(neededDays.length && neededDays[neededDays.length - 1] <= nextRelease) {
            answer[answer.length - 1]++;
            neededDays.pop();
        }
    }

    return answer;
}
```

## Review
쉬운 문제였다.
