# [42567] 완주하지 못한 선수
## Algorithm
- Map
## Logic
완주한 선수들을 맵에 넣고, 참가자들이 맵에 있는지 확인한다.

이때, 동명이인이 있을 수 있으니 맵의 값에는 완주한 선수의 수를 두어서 처리한다.

```js
function solution(participant, completion) {
    const map = {};
    completion.forEach(elem => map[elem] ? map[elem]++ : map[elem] = 1);
    
    for(let i = 0; i < participant.length; i++) {
        let p = participant[i];
        if(!map[p]) return p;
        map[p]--;
    }
}
```
## Review
쉬운 문제. 왜인지는 모르겠는데, `new Map`을 프로그래머스에서는 못쓰는 것 같다. node 버전이 지원을 안해주는건가...
