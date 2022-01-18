# [42883] 큰 수 만들기
## Algorithm
- Greedy
## Logic
정답에 접근하는 방법은 두가지 방법이 있다. 1) 주어진 수로부터 새로운 수를 만들거나, 2) 주어진 수에서 k개의 수를 빼는 방법이다.

2번 방법으로 문제를 풀게되면, 주어진 수를 k번 반복 순회해야 하기 때문에 시간이 오래걸린다(O(n * k)). 따라서, 1번 방법으로 접근했다(O(n)).

문제의 핵심을 '앞자리수 크게 만들기'라고 생각했다. 이것을 아래와 같이 구현했다.
1. 만들고 있는 수의 '가장 뒷자리 숫자가 들어오는 숫자보다 크다'면 현재까지 그 자리에 넣을 수 있는 가장 큰 자리수다.
2. 만들고 있는 수의 가장 뒷자리 숫자보다 '들어오는 숫자가 크다'면, 들어오는 숫자가 그 자리에 넣을 수 있는 가장 큰 자리수이기 때문에 가장 뒷자리 수를 빼고 들어오는 숫자를 넣는다.
```js
function solution(number, k) {
    let answer = '';
    
    for(let numberIndex = 0; numberIndex < number.length; numberIndex++) {
        if(k === 0 || answer.length === 0 || answer[answer.length - 1] > number[numberIndex]) {
            answer += number[numberIndex];
            continue;
        }

        while (k > 0 && answer[answer.length - 1] < number[numberIndex]) {
            answer = answer.slice(0, answer.length - 1);
            k--;
        }
        answer += number[numberIndex];
    }
    
    if (k > 0) answer = answer.slice(0, answer.length - k);

    return answer;
}
```
## Review
처음에 빼는 방법으로 했다가 시간초과가 나서 어지러웠던 문제. 앞으로 두가지 방법이 있다면 무지성으로 시작할게 아니라 뭐가 더 효율적인지 판단하고 해야겠다.
