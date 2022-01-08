# [17281] ⚾️
## Algorithm
- Permutation
## Logic
1. 4 번을 제외한 순열 구하기
2. 구한 순열들 각각에 대해 점수 계산
3. 최대 점수 구하기

### permutation
순열을 하나씩 구할 때마다 `getScore`를 통해 점수를 계산하지 않고, 순열을 전부 구한 후 점수를 계산하는 방식으로 구현했다.

`n` 길이의 순열을 일반화하면, `n-1` 길이의 순열에 1개의 숫자를 사이사이마다 끼워넣는 것으로 할 수 있다.
```js
function getPermutation(elements) {
    if (elements.length === 1) return [elements];

    const permutations = [];
    
    // 첫 번째 요소를 제외한 순열
    const smallerPerms = getPermutation(elements.slice(1));

    const first = elements[0];

    // 모든 작은 순열의 가능한 모든 곳에 첫 번째 요소를 넣어줌
    for (let permIndex = 0; permIndex < smallerPerms.length; permIndex++) {
        const smallerPerm = smallerPerms[permIndex];
        
        for (let positionIndex = 0; positionIndex <= smallerPerm.length; positionIndex++) {
            const permPrefix = smallerPerm.slice(0, positionIndex);
            const permSuffix = smallerPerm.slice(positionIndex);
            permutations.push(permPrefix.concat([first], permSuffix));
        }
    }

    return permutations;
}
```
## Review
순열을 어떻게 구현했는지 모르겠고, 못하겠어서 시간이 오래걸렸다. 감 다죽었다.
