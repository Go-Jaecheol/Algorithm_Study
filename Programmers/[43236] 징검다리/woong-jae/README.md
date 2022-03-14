# [43236] 징검다리
## Algorithm
- Binary Search
## Logic
`n`개 제거했을 때 사이 거리의 최솟값의 가장 큰 값을 찾는 문제를 반대로 생각해보자.

`x`가 사이 거리의 최솟값의 가장 큰 값이면 **바위 몇 개를 제거**해야 할까?

예제에서 사이 거리를 구하면 `[2, 9, 3, 3, 4, 4]`다. 
여기서 `x`가 사이 거리의 최솟값의 가장 큰 값이라면, 모든 사이 거리가 `x`보다는 크거나 같아야한다.
사이 거리를 `x`보다 크게 만들기 위해 합치면, 이것이 바위를 제거하는 행위다.

따라서, 처음부터 시작해서 사이 거리를 합해주면서 제거한 바위를 세고, 사이 거리 합이 `x`보다 크거나 같아지면 합을 `0`으로 만들고 다시 더해주면 된다.

`x`는 최소 `0`에서 최대 `distance` 만큼 될 수 있다. 바로 여기서 이분 탐색을 사용해 원하는 값을 찾는다.
```js
function solution(distance, rocks, n) {
    let answer = 0;
    let between = [];

    rocks.sort((a, b) => a - b);
    between.push(rocks[0]);
    for(let i = 0; i < rocks.length - 1; i++) {
        between.push(rocks[i + 1] - rocks[i]);
    }
    between.push(distance - rocks[rocks.length - 1]);
    
    let left = 0, right = distance;
    while(left <= right) {
        let mid = Math.floor((left + right) / 2);
        let partialSum = 0, removed = 0;
        between.forEach(elem => {
            partialSum += elem; 
            if(partialSum < mid) removed++;
            else partialSum = 0;
        });
        if(removed > n) right = mid - 1;
        else left = mid + 1;
    }
    
    return right;
}
```
## Review
사이 거리를 이분 탐색하는 아이디어까지는 갈 수 있었지만, 값이 적합한지 평가하는 부분을 도저히 생각할 수 없었다.
이전 문제에 비해 발전은 했지만 아직 이분탐색 문제에 익숙하지 않은 것 같다. 하지만, 다음에는 진짜 풀 수 있을 것 같다.

아니면 사실 두 문제가 진짜 어려운건가,,,
