# [42884] 단속카메라
## Algorithm
- Greedy
## Logic
카메라를 최소한으로 설치하려면 동선이 가장 많이 겹치는 곳에 설치해야 한다.

동선이 겹치는 곳은 어떤 차의 나간 지점보다 다른 차의 들어온 지점이 앞에 있는 곳이다. 따라서, 차량의 이동경로를 나간 순으로 정렬한 후 겹치는 차들을 처리해주면 답을 구할 수 있다.

```js
function solution(routes) {
    let answer = 0;
    routes.sort((a, b) => a[1] - b[1]);
    
    let currentEnd = null;
    for(let routeIndex = 0; routeIndex < routes.length; routeIndex++) {
        const route = routes[routeIndex];
        if(currentEnd === null || route[0] > currentEnd) {
            currentEnd = route[1];
            answer++;
        }
    }
    
    return answer;
}
```
## Review
겹치는 부분을 어떻게 처리할지 아이디어를 쉽게 찾을 수 있었던 문제. 금방 풀었다.
