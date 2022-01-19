# [42885] 구명보트
## Algorithm
- Greedy
## Logic
요점은 '보트를 최대한 꽉 채우는 것'이라고 생각했다. 보트를 꽉 채우기 위해서는 현재 가장 몸무게가 큰 사람과 작은 사람을 넣으면 된다. 만약 두 사람이 안들어가면 가장 몸무게가 큰 사람만 보내면 된다.

가장 몸무게가 큰 사람을 기준으로 생각했기 때문에 내림차순으로 소팅을 한 후 위의 생각을 구현했다.

```js
function solution(people, limit) {
    let answer = 0;
    
    people.sort((a, b) => b - a);
    
    while(people.length) {
        const currentWeight = people.shift();
        if(currentWeight + people[people.length - 1] <= limit) {
            people.pop();
        }
        answer++;
    }
    
    return answer;
}
```
위처럼 구현하면 정확성은 맞지만, 효율성에서 탈락이 나온다. 그 이유는 `shift` 연산과 `pop` 연산 때문이다. 따라서 이를 인덱스로 바꿔주었다.

```js
function solution(people, limit) {
    let answer = 0;
    
    people.sort((a, b) => b - a);
    
    let left = 0, right = people.length - 1;
    while(left <= right) {
        if(people[left++] + people[right] <= limit) {
            right--;
        }
        answer++;
    }
    
    return answer;
}
```
## Review
그리디 문제는 무엇을 우선순위로 할 것인지 빠르게 파악하는 것이 중요하다. 이번 문제는 핵심을 쉽게 파악할 수 있는 문제였던것 같다.
