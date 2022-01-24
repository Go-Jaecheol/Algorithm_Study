# [42578] 위장
## Algorithm
- Map
## Logic
'현재 옷 종류로 만들 수 있는 모든 조합'은 '이전 옷들로 만들 수 있었던 조합'에 현재 옷 종류의 개수를 곱한 후 현재 옷 종류의 개수를 더한 것이다.

'이전 옷들로 만들 수 있었던 조합'에 현재 옷 종류의 개수를 곱하는 것은 이전 옷들의 조합에 현재 옷들을 하나씩 더해주는 것이다.

현재 옷 종류를 더하는 것은 이것을 개별로 하나씩 입을 수 있기 때문이다.

```js
function solution(clothes) {
    let answer = 0;
    const map = {};
    
    clothes.forEach(clothe => map[clothe[1]] ? map[clothe[1]].push(clothe[0]) : map[clothe[1]] = [clothe[0]]);
              
    for(let clothe in map) {
        let combination = answer * map[clothe].length + map[clothe].length;
        answer += combination;
    }
    
    return answer;
}
```
## Review
쉬운 문제.
