# [42860] 조이스틱
## Algorithm
- Bruteforce
## Logic
- 어딜 먼저 갈지 결정하는 것과 문자를 돌려서 원하는 것으로 만들어 주는 것은 서로 영향을 주지않기 때문에 분리해서 계산할 수 있다.
- 먼저 숫자를 돌리는데 필요한 조작횟수를 구한다.
```js
answer = nameArray.reduce((acc, cur, i) => {
  let charCode = cur.charCodeAt(0) - 65;
  if (cur !== "A" && i !== 0) charToChange.push(i);
  return (charCode < (26 - charCode) ? acc + charCode : acc + (26 - charCode));
}, 0);
```
- 좌우 움직임에 필요한 최소 조작횟수를 모든 경우의 수를 확인해 구한다.
```js
function calcMinMove(cur, charToChange, length) {
    if (charToChange.length === 0) return 0;
    
    let minMove = Infinity;
    
    // 왼쪽
    let next = charToChange.pop();
    let nextCost = cur < next ? length - next + cur : cur - next;
    minMove = Math.min(minMove, calcMinMove(next, charToChange, length) + nextCost);
    charToChange.push(next);
    // 오른쪽
    next = charToChange.shift();
    nextCost = cur < next ? next - cur : length - cur + next;
    minMove = Math.min(minMove, calcMinMove(next, charToChange, length) + nextCost);
    charToChange.unshift(next);
    
    return minMove;
}
```
## Review
'그리디'로 분류돼있길래 그리디로 이걸 어떻게 풀지... 하다가 시간 다 쓴 문제다. 결국 그리디로 푸는 방법을 도저히 알 수가 없어서 완전탐색으로 풀었다.
